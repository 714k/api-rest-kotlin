package com.victorzamudio.restfulapi.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Entity(name = "verbs")
data class Verb(
 @Id @GeneratedValue(
  strategy = GenerationType.IDENTITY)
 val verb_id: Long = 0,
 @get: NotBlank val verb_meaning: String = "",
 @get: NotBlank val verb_level: Long = 0,
 @get: NotBlank val verb_path_img: String = "",
 @get: NotBlank val verb_infinitive: String = "",
 @get: NotBlank val verb_simple_past: String = "",
 @get: NotBlank val verb_past_participle: String = "",
 @get: NotBlank val verb_category: String = "",
 @get: NotBlank val verb_types: String = "",
 @get: NotBlank val verb_examples: String = ""
)
{}