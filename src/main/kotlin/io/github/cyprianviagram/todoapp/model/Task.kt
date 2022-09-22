package io.github.cyprianviagram.todoapp.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "tasks")
class Task (
    @field:NotBlank(message = "Task's description must not be empty!")
    var description: String,
    var done: Boolean,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int
)
