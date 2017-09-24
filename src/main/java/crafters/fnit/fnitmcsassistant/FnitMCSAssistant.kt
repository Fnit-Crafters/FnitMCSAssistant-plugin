package crafters.fnit.fnitmcsassistant
import crafters.fnit.fnitmcsassistant.Listeners.PlayerJoinEvent
import crafters.fnit.fnitmcsassistant.Listeners.PlayerQuitEvent
import org.bukkit.configuration.file.FileConfiguration

import org.bukkit.plugin.java.JavaPlugin
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.StandardCharsets

var userConfig: FileConfiguration? = null

class FnitMCSAssistant : JavaPlugin() {


    override fun onEnable() {
        setConfig()
        userConfig = config

        // Plugin startup logic
        server.pluginManager.registerEvents(PlayerJoinEvent(), this)
        server.pluginManager.registerEvents(PlayerQuitEvent(), this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    fun setConfig() {
        val defaultConfig = config
        defaultConfig.addDefault("url", "https://post-url-you-want-is-here")
        defaultConfig.options().copyDefaults(true)
        saveConfig()
    }
}
