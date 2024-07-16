package dev.netho.skywars.instance;

import dev.netho.skywars.SkyWars;
import dev.netho.skywars.manager.ConfigManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.scheduler.BukkitRunnable;

public class Countdown extends BukkitRunnable {

    private final SkyWars plugin;
    private final Arena arena;
    private int countdownSeconds;

    public Countdown(SkyWars plugin, Arena arena) {
        this.plugin = plugin;
        this.arena = arena;
        this.countdownSeconds = ConfigManager.getCountdownSeconds();
    }

    public void start() {
        arena.setGameState(GameState.COUNTDOWN);
        runTaskTimer(plugin, 0, 20);
    }

    @Override
    public void run() {
        if(countdownSeconds == 0) {
            cancel();
            arena.start();
            arena.sendTitle("", "");
            return;
        }

        if(countdownSeconds <= 10 || countdownSeconds % 15 == 0) {
            TextComponent countdownMessage = Component.text("The game will start in ", TextColor.fromHexString("#FF70C6")).append(Component.text(countdownSeconds, TextColor.fromHexString("#FF99D6"))).append(Component.text(" second" + (countdownSeconds == 1 ? "" : "s"), TextColor.fromHexString("#FF70C6")));

            if(countdownSeconds % 5 == 0) {
                arena.sendMessage(countdownMessage);
            }

            arena.sendActionBarMessage(countdownMessage);
        }

        countdownSeconds--;

    }
}
