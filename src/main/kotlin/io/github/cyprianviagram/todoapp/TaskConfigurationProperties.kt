package io.github.cyprianviagram.todoapp

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("task")
class TaskConfigurationProperties {
    val allowMultipleTasksFromTemplate: Boolean? = null
}