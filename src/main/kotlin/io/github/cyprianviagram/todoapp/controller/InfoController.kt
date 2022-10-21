package io.github.cyprianviagram.todoapp.controller

import io.github.cyprianviagram.todoapp.TaskConfigurationProperties
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@EnableConfigurationProperties(TaskConfigurationProperties::class)
class InfoController (
    val dataSource: DataSourceProperties,
    val myProp: TaskConfigurationProperties
) {

    @GetMapping("/info/url")
    fun url(): String? {
        return dataSource.url
    }

    @GetMapping("/info/prop")
    fun myProp(): Boolean? {
        return myProp.allowMultipleTasksFromTemplate
    }
}