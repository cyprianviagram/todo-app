package io.github.cyprianviagram.todoapp.controller

import io.github.cyprianviagram.todoapp.model.Task
import io.github.cyprianviagram.todoapp.model.TaskRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import javax.validation.Valid

@RestController
class TaskController (
    private val repository: TaskRepository
) {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/tasks", params = ["!sort", "!page", "!size"])
    fun readAllTasks(): ResponseEntity<List<Task>> {
        logger.warn("Exposing all the tasks!")
        return ResponseEntity.ok(repository.findAll())
    }

    @GetMapping("/tasks")
    fun readAllTasks(page: Pageable): ResponseEntity<List<Task>> {
        logger.info("Custom pageable")
        return ResponseEntity.ok(repository.findAll(page).content)
    }

    @GetMapping("/tasks/{id}")
    fun readTaskById(@PathVariable id: Int): ResponseEntity<Task> {
        val response = repository.findById(id)
        return if (response != null) {
            ResponseEntity.ok(response)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping("/tasks")
    fun createTask(@RequestBody @Valid toCreate: Task): ResponseEntity<Task> {
        repository.save(toCreate)
        val location: URI = URI.create("/tasks/${toCreate.id}")
        return ResponseEntity.created(location).body(toCreate)
    }

    @PutMapping("/tasks/{id}")
    fun updateTask(@PathVariable id: Int, @RequestBody @Valid toUpdate: Task): ResponseEntity<Any?> {
        if (!repository.existsById(id)){
            return ResponseEntity.notFound().build()
        }
        toUpdate.id = id
        repository.save(toUpdate)
        return ResponseEntity.noContent().build()
    }

}