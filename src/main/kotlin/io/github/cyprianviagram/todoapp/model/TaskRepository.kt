package io.github.cyprianviagram.todoapp.model

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.core.annotation.RestResource
import java.util.*

@RepositoryRestResource
interface TaskRepository : JpaRepository<Task, Int>{
    @RestResource(exported = false)
    override fun deleteById(id: Int) {
    }
    @RestResource(exported = false)
    override fun delete(entity: Task) {
    }
@RestResource(path = "done", rel = "done")
    fun findByDone(@Param("state") done: Boolean): List<Task>
}