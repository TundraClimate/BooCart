package io.github.tundraclimate.bc.config

class Config {
    var speed: Double = 3.0
        set(value) {
            field = value
            reload()
        }

    fun reload() {}
}