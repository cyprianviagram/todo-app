package io.github.cyprianviagram.todoapp.model

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
private interface SqlTaskRepository : JpaRepository<Task, Int>, TaskRepository {
}