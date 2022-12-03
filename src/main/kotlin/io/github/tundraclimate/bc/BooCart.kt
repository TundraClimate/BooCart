import io.github.tundraclimate.bc.Config
import org.bukkit.plugin.java.JavaPlugin

class BooCart: JavaPlugin() {
    companion object {
        private lateinit var plu: JavaPlugin
        val plugin
            get() = plu
    }

    override fun onEnable() {
        plu = this
    }
}