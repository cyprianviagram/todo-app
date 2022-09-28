package io.github.cyprianviagram.todoapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
import javax.validation.Validator

@SpringBootApplication
class TodoAppApplication {
	@Bean
	fun validator(): Validator {
		return LocalValidatorFactoryBean()
	}
}

fun main(args: Array<String>) {
	runApplication<TodoAppApplication>(*args)
}
