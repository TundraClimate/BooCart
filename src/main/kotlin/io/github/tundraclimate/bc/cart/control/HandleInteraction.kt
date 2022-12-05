package io.github.tundraclimate.bc.cart.control

import io.github.tundraclimate.bc.BooCart
import io.github.tundraclimate.bc.config.NamespaceKeys
import org.bukkit.NamespacedKey
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.persistence.PersistentDataType

class HandleInteraction: Listener {
    init {
        BooCart.plugin.let {
            it.server.pluginManager.registerEvents(this, it)
        }
    }

    @EventHandler
    private fun onClick(e: PlayerInteractEvent) {
        if (e.action != Action.RIGHT_CLICK_AIR) return
        val clickedItem = e.item ?: return
        val container = clickedItem.itemMeta?.persistentDataContainer ?: return
        if (!container.has(NamespacedKey(BooCart.plugin, NamespaceKeys.HANDLE), PersistentDataType.BYTE)) return
        HandleMap.speedUp(e.player.uniqueId)
    }
}