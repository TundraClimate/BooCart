package io.github.tundraclimate.bc.cart.command

import io.github.tundraclimate.bc.BooCart
import io.github.tundraclimate.bc.cart.CartHandle
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabExecutor
import org.bukkit.entity.Player

class HandleGetCommand : TabExecutor {
    private val commandName = "boohandle"

    init {
        BooCart.plugin.getCommand(commandName)?.setExecutor(this)
    }

    override fun onTabComplete(sender: CommandSender, command: Command, label: String, args: Array<out String>): MutableList<String>? {
        return null
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (command.name != commandName) return true
        if (sender !is Player) {
            sender.sendMessage("§aThis Command is Player Only.")
            return true
        }
        sender.inventory.addItem(CartHandle.getHandle())
        return true
    }
}