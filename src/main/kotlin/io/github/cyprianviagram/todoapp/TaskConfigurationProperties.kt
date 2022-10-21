package io.github.cyprianviagram.todoapp

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("task")
data class TaskConfigurationProperties(
    var allowMultipleTasksFromTemplate: Boolean? = null
)