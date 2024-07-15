package dev.netho.skywars.listener;

import dev.netho.skywars.SkyWars;
import dev.netho.skywars.instance.Arena;
import dev.netho.skywars.instance.GameState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class GameListener implements Listener {

    private final SkyWars plugin;

    public GameListener(SkyWars plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerKill(PlayerDeathEvent event) {
        if(event.getEntity().getKiller() != null) {
            Player killer = event.getEntity().getKiller();

            Arena arena = plugin.getArenaManager().getArenaByPlayer(killer);
            if(arena != null && arena.getGameState() == GameState.LIVE) {
                for (int i = 0; i < 20; i++) {
                    arena.getGame().addPoint(killer);
                }

            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        Arena arena = plugin.getArenaManager().getArenaByPlayer(event.getPlayer());
        if(arena != null && arena.getGameState() == GameState.LIVE) {
            arena.getGame().addPoint(event.getPlayer());
        }
    }
}
