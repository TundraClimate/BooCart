package io.github.tundraclimate.bc.cart

import BooCart
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
        CartFactory.spawn(e.player.world, e.blockFace.direction.toLocation(e.player.world), e.player)
    }
}