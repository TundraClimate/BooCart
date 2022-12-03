package io.github.tundraclimate.bc

class Config {
    var speed: Double = 3.0
        set(value) {
            field = value
            reload()
        }

    fun reload() {}
}