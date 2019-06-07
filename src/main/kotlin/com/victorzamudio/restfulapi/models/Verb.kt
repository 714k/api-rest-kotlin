package com.victorzamudio.restfulapi.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity(name = "verbs")
data class Verb(
 @Id @GeneratedValue(
  strategy = GenerationType.IDENTITY)
 val id: Long = 0,
 @get: NotBlank val meaning: String = "",
 @get: NotBlank val level: Int = 0,
 @get: NotBlank val path_img: String = "",
 @get: NotBlank val infinitive: String = "",
 @get: NotBlank val simple_past: String = "",
 @get: NotBlank val past_participle: String = "",
 @get: NotBlank val category: String = "",
 @get: NotBlank val types: String = "",
 @get: NotBlank val examples: String = ""
)
{}