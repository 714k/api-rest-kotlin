package com.victorzamudio.restfulapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class RestfulapiApplication

fun main(args: Array<String>) {
	runApplication<RestfulapiApplication>(*args)
}
