package io.github.cyprianviagram.todoapp.controller

import io.github.cyprianviagram.todoapp.model.TaskRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Pageable
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping

@RepositoryRestController
class TaskController (
    private val repository: TaskRepository
) {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/tasks", params = ["!sort", "!page", "!size"])
    fun readAllTasks(): ResponseEntity<Any?>{
        logger.warn("Exposing all the tasks!")
        return ResponseEntity.ok(repository.findAll())
    }

    @GetMapping("/tasks")
    fun readAllTasks(page: Pageable): ResponseEntity<Any?>{
        logger.info("Custom pageable")
        return ResponseEntity.ok(repository.findAll(page))
    }
}