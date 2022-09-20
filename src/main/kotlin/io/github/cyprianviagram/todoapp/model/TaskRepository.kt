package io.github.cyprianviagram.todoapp.model

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface TaskRepository : JpaRepository<Task, Int>{
}