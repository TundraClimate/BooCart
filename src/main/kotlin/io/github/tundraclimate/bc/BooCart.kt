package io.github.tundraclimate.bc

import io.github.tundraclimate.bc.cart.CartEffect
import io.github.tundraclimate.bc.config.Config
import io.github.tundraclimate.bc.cart.CartExchanger
import io.github.tundraclimate.bc.cart.CartHandleApply
import io.github.tundraclimate.bc.cart.command.CartGetCommand
import io.github.tundraclimate.bc.cart.control.HandleInteraction
import org.bukkit.plugin.java.JavaPlugin

class BooCart: JavaPlugin() {
    companion object {
        private lateinit var plu: JavaPlugin
        val conf = Config()
        val plugin
            get() = plu
    }

    override fun onEnable() {
        plu = this
        CartExchanger()
        CartGetCommand()
        CartEffect()
        CartHandleApply()
        HandleInteraction()
    }
}