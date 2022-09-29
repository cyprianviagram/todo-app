package io.github.cyprianviagram.todoapp.model

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.query.Param

interface TaskRepository {
    fun findAll(): List<Task>
    fun findById(id: Int): Task?

    fun existsById(id: Int): Boolean

    fun save(entity: Task): Task

    fun findAll(page: Pageable): Page<Task>

    fun findByDone(@Param("state") done: Boolean): List<Task>
}