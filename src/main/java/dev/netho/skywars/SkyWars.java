package dev.netho.skywars;

import dev.netho.skywars.command.ArenaCommand;
import dev.netho.skywars.listener.ConnectListener;
import dev.netho.skywars.listener.GameListener;
import dev.netho.skywars.manager.ArenaManager;
import dev.netho.skywars.manager.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SkyWars extends JavaPlugin {

    private ArenaManager arenaManager;

    @Override
    public void onEnable() {
        ConfigManager.setupConfig(this);
        arenaManager = new ArenaManager(this);

        Bukkit.getPluginManager().registerEvents(new ConnectListener(this), this);
        Bukkit.getPluginManager().registerEvents(new GameListener(this), this);

        getCommand("arena").setExecutor(new ArenaCommand(this));
    }

    public ArenaManager getArenaManager() {
        return arenaManager;
    }

}
