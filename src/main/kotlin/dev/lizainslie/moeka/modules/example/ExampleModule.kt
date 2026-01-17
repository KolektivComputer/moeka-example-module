package dev.lizainslie.moeka.modules.example

import dev.lizainslie.moeka.core.modules.AbstractModule
import dev.lizainslie.moeka.core.modules.ModuleVisibility
import dev.lizainslie.moeka.core.platforms.SupportPlatforms
import dev.lizainslie.moeka.modules.example.commands.ExampleCommand
import dev.lizainslie.moeka.modules.example.config.ExampleConfig
import dev.lizainslie.moeka.platforms.discord.Discord

@Suppress("unused")
@SupportPlatforms(Discord::class)
object ExampleModule : AbstractModule(
    name = "example",
    optional = false,
    visibility = ModuleVisibility.DEVELOPER,
    description = "An example module to show off pitohui's engine features",
    commands =
        setOf(
            ExampleCommand,
        ),
    tables = setOf(),
) {
    val config by config<ExampleConfig>()
}
