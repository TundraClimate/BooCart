package io.github.tundraclimate.bc.cart

import io.github.tundraclimate.bc.BooCart
import io.github.tundraclimate.bc.config.NamespaceKeys
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

object CartSpawnEgg {
    fun getEgg(amount: Int = 1): ItemStack {
        val egg = ItemStack(Material.PIG_SPAWN_EGG, amount)
        egg.addUnsafeEnchantment(Enchantment.DEPTH_STRIDER, 1)
        val eggMeta = egg.itemMeta?.also {
            it.setDisplayName("BooCart")
            it.addItemFlags(ItemFlag.HIDE_ENCHANTS)
            it.persistentDataContainer.set(NamespacedKey(BooCart.plugin, NamespaceKeys.EGG), PersistentDataType.BYTE, 0)
        }
        egg.itemMeta = eggMeta
        return egg
    }
}