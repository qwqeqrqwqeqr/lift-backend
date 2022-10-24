package com.gradation.lift

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LiftApplication

fun main(args: Array<String>) {
	runApplication<LiftApplication>(*args)
}
