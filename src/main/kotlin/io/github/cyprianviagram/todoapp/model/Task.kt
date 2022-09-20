package io.github.cyprianviagram.todoapp.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tasks")
class Task {
    @get:Id
    private var id: Int
        get() {
            return id
        }
        set(id: Int) {
            this.id = id
        }
    private var description: String
        get() {
            return description
        }
        set(description: String) {
            this.description = description
        }
    private var done: Boolean
        get() {
            return done
        }
        set(done: Boolean) {
            this.done = done
        }
}