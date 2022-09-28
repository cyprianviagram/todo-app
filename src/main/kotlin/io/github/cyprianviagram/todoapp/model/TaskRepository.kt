package io.github.cyprianviagram.todoapp.model

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RestResource
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TaskRepository : JpaRepository<Task, Int>{
@RestResource(path = "done", rel = "done")
    fun findByDone(@Param("state") done: Boolean): List<Task>
}