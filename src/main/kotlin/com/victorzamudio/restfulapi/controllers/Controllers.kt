package com.victorzamudio.restfulapi.controllers

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.beans.factory.annotation.Autowired
import com.victorzamudio.restfulapi.repository.VerbsRepository
import org.springframework.web.bind.annotation.GetMapping
import com.victorzamudio.restfulapi.models.Verb
import org.springframework.web.bind.annotation.PostMapping
import javax.validation.Valid
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.http.HttpStatus

@RestController
@RequestMapping("/api")
class VerbsController(@Autowired private val VerbsRepository: VerbsRepository) {
	// gets all verbs
	@GetMapping("/verbs")
	fun getAllVerbs() : List<Verb> = VerbsRepository.findAll()

	// Creates a Verb (in case of need)
	@PostMapping("/verbs")
	fun createVerb(@Valid @RequestBody verb: Verb) : Verb = VerbsRepository.save(verb)

	// Gets a single Verb
	@GetMapping("/verbs/{verbId}")
	fun getVerbById(@PathVariable verbId: Long) : ResponseEntity<Verb> = VerbsRepository.findById(verbId)
	 .map{
		 ResponseEntity.ok(it)
	 }.orElse(ResponseEntity.notFound().build())

	// Updates a Verb (in case of need)
	@PutMapping("/verbs/{verbId}")
	fun updateVerb(@PathVariable verbId : Long, @Valid @RequestBody updatedVerb: Verb)
	 : ResponseEntity<Verb> = VerbsRepository.findById(verbId)
	 .map{
		 val updatedVerb = it.copy(title = updatedVerb.title, content = updatedVerb.content)
		 ResponseEntity.ok().body(VerbsRepository.save(updatedVerb))
	 }.orElse(ResponseEntity.notFound().build())

	// Deletes a Verb
	@DeleteMapping("/verbs/{verbId}")
	fun deleteVerb(@PathVariable verbId : Long) : ResponseEntity<Void> =
	 VerbsRepository.findById(verbId).map{
		 VerbsRepository.delete(it)
		 ResponseEntity<Void>(HttpStatus.OK)
	 }.orElse(ResponseEntity.notFound().build())
}