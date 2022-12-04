package io.github.tundraclimate.bc.cart

import io.github.tundraclimate.bc.BooCart
import io.github.tundraclimate.bc.config.NamespaceKeys
import org.bukkit.Location
import org.bukkit.NamespacedKey
import org.bukkit.World
import org.bukkit.entity.EntityType
import org.bukkit.entity.Pig
import org.bukkit.entity.Player
import org.bukkit.persistence.PersistentDataType

object CartFactory {
    fun spawn(world: World, loc: Location, owner: Player) {
        val cart = world.spawnEntity(loc, EntityType.PIG)
        val own = "${owner.uniqueId}:${owner.name}"
        cart.persistentDataContainer.let {
            it.set(NamespacedKey(BooCart.plugin, NamespaceKeys.IS_CART), PersistentDataType.BYTE, 0)
            it.set(NamespacedKey(BooCart.plugin, NamespaceKeys.OWNER), PersistentDataType.STRING, own)
        }
        (cart as Pig).setSaddle(true);
    }
}