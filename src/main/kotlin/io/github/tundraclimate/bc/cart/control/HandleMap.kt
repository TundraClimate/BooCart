package io.github.tundraclimate.bc.cart.control

import io.github.tundraclimate.bc.BooCart
import java.util.*

object HandleMap {
    private val map = mutableMapOf<UUID, Double>()

    fun init(uuid: UUID) {
        map[uuid] = 0.0
    }

    fun speedUp(uuid: UUID) {
        map[uuid]?.let {
            if (it + 0.25 > BooCart.conf.speed) return
            map[uuid] = map[uuid]!! + 0.25
        }
    }

    fun speedDown(uuid: UUID) {
        map[uuid]?.let {
            if (it - 0.25 < 0) return
            map[uuid] = map[uuid]!! - 0.25
        }
    }

    fun getSpeed(uuid: UUID) = map[uuid] ?: 0.0
}