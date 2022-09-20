package io.github.cyprianviagram.todoapp.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tasks")
class Task (
    var description: String? = null,
    var done: Boolean? = null,
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null
)