package dev.netho.skywars.manager;

import dev.netho.skywars.SkyWars;
import dev.netho.skywars.instance.Arena;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ArenaManager {

    private List<Arena> arenas = new ArrayList<>();

    public ArenaManager(SkyWars plugin) {
        FileConfiguration config = plugin.getConfig();
        for(String arenaId : config.getConfigurationSection("arenas").getKeys(false)) {
            arenas.add(new Arena(plugin, Integer.parseInt(arenaId), new Location(
                    Bukkit.getWorld(config.getString("arenas." + arenaId + ".world")),
                    config.getDouble("arenas." + arenaId + ".x"),
                    config.getDouble("arenas." + arenaId + ".y"),
                    config.getDouble("arenas." + arenaId + ".z"),
                    (float) config.getDouble("arenas." + arenaId + ".yaw"),
                    (float) config.getDouble("arenas." + arenaId + ".pitch")
            )));
        }
    }

    public List<Arena> getArenas() { return arenas; }

    public Arena getArenaByPlayer(Player player) {
        for(Arena arena : arenas) {
            if(arena.getPlayers().contains(player.getUniqueId())) {
                return arena;
            }
        }
        return null;
    }

    public Arena getArenaById(int id) {
        for(Arena arena : arenas) {
            if (arena.getId() == id) {
                return arena;
            }
        }

        return null;
    }
}
