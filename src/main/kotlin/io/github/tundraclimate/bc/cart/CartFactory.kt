package io.github.tundraclimate.bc.cart

import BooCart
import org.bukkit.Location
import org.bukkit.World
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.metadata.FixedMetadataValue

class CartFactory {
    fun spawn(world: World, loc: Location, owner: Player) {
        val cart = world.spawnEntity(loc, EntityType.PIG)
        cart.setMetadata("BooCart:cart", FixedMetadataValue(BooCart.plugin, true))
        cart.setMetadata("BooCart:owner", FixedMetadataValue(BooCart.plugin, owner))
    }
}