package io.github.cyprianviagram.todoapp.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tasks")
class Task (
    val description: String,
    val done: Boolean,
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int
)