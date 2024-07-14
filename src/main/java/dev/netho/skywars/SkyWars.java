package dev.netho.skywars;

import dev.netho.skywars.manager.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class SkyWars extends JavaPlugin {

    @Override
    public void onEnable() {
        ConfigManager.setupConfig(this);

    }

}
