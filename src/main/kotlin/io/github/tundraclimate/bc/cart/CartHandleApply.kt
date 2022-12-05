package io.github.tundraclimate.bc.cart

import io.github.tundraclimate.bc.BooCart
import io.github.tundraclimate.bc.cart.control.HandleMap
import io.github.tundraclimate.bc.config.NamespaceKeys
import org.bukkit.NamespacedKey
import org.bukkit.attribute.Attribute
import org.bukkit.entity.LivingEntity
import org.bukkit.persistence.PersistentDataType
import org.bukkit.scheduler.BukkitRunnable
import java.util.*

class CartHandleApply {
    private val applyRunnable = object : BukkitRunnable() {
        override fun run() {
            BooCart.plugin.server.worlds.forEach {
                applySpeedByEntities(it.livingEntities)
            }
        }
    }

    private fun applySpeedByEntities(entities: List<LivingEntity>) = entities.forEach { applySpeed(it) }

    private fun applySpeed(entity: LivingEntity) {
        val container = entity.persistentDataContainer
        if (container.has(NamespacedKey(BooCart.plugin, NamespaceKeys.IS_CART), PersistentDataType.BYTE)) {
            val own = container.get(NamespacedKey(BooCart.plugin, NamespaceKeys.OWNER), PersistentDataType.STRING)
                    ?: return
            val (uuid, _) = own.split(":")
            entity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)?.baseValue = HandleMap.getSpeed(UUID.fromString(uuid))
            HandleMap.speedDown(UUID.fromString(uuid))
        }
    }

    init {
        applyRunnable.runTaskTimer(BooCart.plugin, 0, 10L)
    }
}