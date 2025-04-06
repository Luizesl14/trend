package br.com.trend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TrendApplication

fun main(args: Array<String>) {
	runApplication<TrendApplication>(*args)
}
