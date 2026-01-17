package dev.lizainslie.moeka.modules.example.commands

import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
import dev.lizainslie.moeka.core.commands.argument.ArgumentTypes
import dev.lizainslie.moeka.core.commands.defineCommand
import dev.lizainslie.moeka.core.validation.hexColor
import dev.lizainslie.moeka.core.validation.isIn
import dev.lizainslie.moeka.core.validation.validators.composite.CompositeValidationMode
import dev.lizainslie.moeka.platforms.discord.Discord

val subOptions =
    listOf("my", "balls", "itch")

val ExampleCommand = defineCommand("example", "An example command") {
    platform(Discord) {
        nsfw = true // >:3
        dmPermission = false // fuck you, watch your porn in public
        defaultMemberPermissions = Permissions {
            +Permission.ViewChannel
        }
    }

    communityOnly = true // dmPermission only tells discord about this constraint

    subCommand("sub", "An example subcommand") {
        val stringArg = argument("string", "an example argument", ArgumentTypes.STRING) {
            required = true
            defaultValue = ""

            complete { subOptions }

            validate {
                // allow any of these checks to validate
                composite(CompositeValidationMode.ANY) {
                    validator {
                        // for example purposes I'll use the hexColor validator
                        // since it's one of the few I have implemented.
                        hexColor(allowAlpha = false)
                    }

                    validator {
                        isIn(subOptions)
                    }
                }
            }
        }

        handle {
            val myStr by stringArg.require()

            val response = respond("You entered: $myStr")
            response.edit("But now you will never remember it!!")

            response.createPrivateFollowup("MUAHAHAHAHAHA!!")
        }
    }
}