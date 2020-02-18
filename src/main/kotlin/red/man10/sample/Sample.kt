package red.man10.sample

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class Sample : JavaPlugin(), Listener {
    var prefix = "[§5Man10Sample§f]"

    override fun onEnable() { // Plugin startup logic
        logger.info("hello kotlin2")
        server.pluginManager.registerEvents(this, this)
        saveResource("config.yml", false)

    }

    override fun onDisable() { // Plugin shutdown logic
    }

    fun broadcast(message: String) {
        Bukkit.broadcastMessage("$prefix $message")
    }
    fun sendMessage(player: Player, message: String) {
        player.sendMessage("$prefix $message")
    }
    @EventHandler
    fun onPlayerJoin(e: PlayerJoinEvent) {
        this.broadcast("${e.player.displayName} is joined.")
    }

}