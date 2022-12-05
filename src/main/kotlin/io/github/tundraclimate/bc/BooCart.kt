package io.github.tundraclimate.bc

import io.github.tundraclimate.bc.cart.CartEffect
import io.github.tundraclimate.bc.config.Config
import io.github.tundraclimate.bc.cart.CartExchanger
import io.github.tundraclimate.bc.cart.CartHandleApply
import io.github.tundraclimate.bc.cart.command.CartGetCommand
import io.github.tundraclimate.bc.cart.command.HandleGetCommand
import io.github.tundraclimate.bc.cart.control.HandleInteraction
import io.github.tundraclimate.bc.cart.control.HandleMap
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin

class BooCart: JavaPlugin(), Listener {
    companion object {
        private lateinit var plu: JavaPlugin
        val conf = Config()
        val plugin
            get() = plu
    }

    override fun onEnable() {
        plu = this
        server.pluginManager.registerEvents(this, this)
        CartExchanger()
        CartGetCommand()
        HandleGetCommand()
        CartEffect()
        CartHandleApply()
        HandleInteraction()
    }

    @EventHandler
    private fun initJoinPlayer(e: PlayerJoinEvent) {
        HandleMap.init(e.player.uniqueId)
    }
}