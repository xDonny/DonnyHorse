
package net.donnycraft.dev;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Horse spawner plugin for Bukkit
 *
 * @author xDonny
 */
public class HorsePlugin extends JavaPlugin {

    @Override
    public void onDisable() {
        getLogger().info("Goodbye world!");
    }

    @Override
    public void onEnable() {

        // Register our commands
        getCommand("horse").setExecutor(new HorseSpawn());

        PluginDescriptionFile pdfFile = this.getDescription();
        getLogger().info( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
    }

  
}
