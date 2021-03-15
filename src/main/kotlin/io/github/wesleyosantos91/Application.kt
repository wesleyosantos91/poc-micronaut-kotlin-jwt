package io.github.wesleyosantos91

import io.micronaut.runtime.Micronaut.build

fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("io.github.wesleyosantos9")
		.start()
}

