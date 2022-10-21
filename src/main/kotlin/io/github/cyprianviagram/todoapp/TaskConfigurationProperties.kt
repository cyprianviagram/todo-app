package io.github.cyprianviagram.todoapp

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import java.awt.GraphicsConfigTemplate
import kotlin.properties.Delegates

@Component
@ConfigurationProperties("task")
class TaskConfigurationProperties {
    var template = Template()

    class Template {
        var allowMultipleTasksFromTemplate by Delegates.notNull<Boolean>()
    }
}