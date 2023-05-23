package com.microservicio.home

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MicroservicioApplication

fun main(args: Array<String>) {
	runApplication<MicroservicioApplication>(*args)
}
