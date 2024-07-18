package dev.netho.skywars.listener;

import dev.netho.skywars.SkyWars;
import dev.netho.skywars.instance.Arena;
import dev.netho.skywars.manager.ConfigManager;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectListener implements Listener {

    private SkyWars plugin;
    public ConnectListener(SkyWars plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.teleport(ConfigManager.getLobbySpawn());
        player.setGameMode(GameMode.ADVENTURE);
        player.setFoodLevel(20);
        player.setHealth(20);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Arena arena = plugin.getArenaManager().getArenaByPlayer(event.getPlayer());

        if(arena != null) {
            arena.removePlayer(event.getPlayer());
        }



    }
}
