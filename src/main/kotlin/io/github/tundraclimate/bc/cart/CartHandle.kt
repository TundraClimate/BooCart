package io.github.tundraclimate.bc.cart

import io.github.tundraclimate.bc.BooCart
import io.github.tundraclimate.bc.config.NamespaceKeys
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

object CartHandle {
    fun getHandle(amount: Int = 1): ItemStack {
        val handle = ItemStack(Material.CARROT_ON_A_STICK, amount)
        handle.addUnsafeEnchantment(Enchantment.DEPTH_STRIDER, 1)
        val handleMeta = handle.itemMeta?.also {
            it.setDisplayName("CartHandle")
            it.addItemFlags(ItemFlag.HIDE_ENCHANTS)
            it.persistentDataContainer.set(NamespacedKey(BooCart.plugin, NamespaceKeys.HANDLE), PersistentDataType.BYTE, 0)
            it.isUnbreakable = true
        }
        handle.itemMeta = handleMeta
        return handle
    }
}