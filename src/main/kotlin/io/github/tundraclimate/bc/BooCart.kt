import io.github.tundraclimate.bc.Config
import org.bukkit.plugin.java.JavaPlugin

class BooCart: JavaPlugin() {
    private lateinit var plu: JavaPlugin
    val conf = Config()
    val plugin: JavaPlugin
        get() = plu

    override fun onEnable() {
        plu = this
    }
}