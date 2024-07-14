package dev.netho.skywars.manager;

import dev.netho.skywars.SkyWars;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Objects;

public class ConfigManager {

    private static FileConfiguration config;

    public static void setupConfig(SkyWars plugin) {
        config = plugin.getConfig();
        plugin.saveDefaultConfig();
    }

    public static int getRequiredPlayers() { return config.getInt("required-players"); }

    public static int getCountdownSeconds() { return config.getInt("countdown-seconds"); }

    public static Location getLobbySpawn() { return new Location(
            Bukkit.getWorld(Objects.requireNonNull(config.getString("lobby-spawn.world"))),
            config.getDouble("lobby-spawn.x"),
            config.getDouble("lobby-spawn.y"),
            config.getDouble("lobby-spawn.z"),
            (float) config.getDouble("lobby-spawn.yaw"),
            (float) config.getDouble("lobby-spawn.pitch")
    ); }
}
