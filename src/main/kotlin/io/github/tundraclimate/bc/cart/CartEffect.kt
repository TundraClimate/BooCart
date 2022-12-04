package io.github.tundraclimate.bc.cart

import io.github.tundraclimate.bc.BooCart
import org.bukkit.Effect
import org.bukkit.World
import org.bukkit.entity.Entity
import org.bukkit.scheduler.BukkitRunnable

class CartEffect {
    private val effectRunnable = object : BukkitRunnable() {
        override fun run() {
            BooCart.plugin.server.worlds.forEach {
                popEffects(it, it.entities)
            }
        }
    }

    private fun popEffects(world: World, entities: List<Entity>) {
        entities.forEach {
            popEffect(world, it)
        }
    }

    private fun popEffect(world: World, entity: Entity) {
        if (entity.hasMetadata("BooCart:cart")) {
            world.playEffect(entity.location, Effect.SMOKE, 1, 1)
        }
    }

    init {
        effectRunnable.runTaskTimer(BooCart.plugin, 0, 10)
    }
}