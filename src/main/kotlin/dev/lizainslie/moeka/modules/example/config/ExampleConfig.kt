package dev.lizainslie.moeka.modules.example.config

import dev.lizainslie.moeka.core.config.ConfigBase
import dev.lizainslie.moeka.core.config.ConfigFile
import dev.lizainslie.moeka.core.config.ConfigType
import kotlinx.serialization.Serializable

@ConfigFile(name = "example.json", "example:example", ConfigType.MODULE)
@Serializable
data class ExampleConfig(
    // fuck you, this is all you're getting. if you're here you should know how
    // kotlinx.serialization works.
    val someInt: Int
) : ConfigBase {
    override fun validate(): Boolean {
        return someInt > 20
    }
}
