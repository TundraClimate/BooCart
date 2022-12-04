package io.github.tundraclimate.bc.cart

import io.github.tundraclimate.bc.BooCart
import org.bukkit.Location
import org.bukkit.NamespacedKey
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.persistence.PersistentDataType

class CartExchanger : Listener {
    init {
        BooCart.plugin.let {
            it.server.pluginManager.registerEvents(this, it)
        }
    }

    @EventHandler
    private fun onSpawn(e: PlayerInteractEvent) {
        if (e.action != Action.RIGHT_CLICK_BLOCK) return
        if (!e.hasItem()) return
        e.item?.itemMeta?.persistentDataContainer?.let {
            if (!it.has(NamespacedKey(BooCart.plugin, "spawn_egg"), PersistentDataType.BYTE)) return
        }
        e.isCancelled = true
        CartFactory.spawn(e.player.world, e.blockFace.let {
            val clicked = e.clickedBlock!!.location
            val mod = 0.5
            Location(
                    e.player.world,
                    clicked.x + it.modX.toDouble() + mod,
                    clicked.y + it.modY.toDouble(),
                    clicked.z + it.modZ.toDouble() + mod
            )
        }, e.player)
    }
}