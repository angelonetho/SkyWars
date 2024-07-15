package dev.netho.skywars.instance;

import dev.netho.skywars.SkyWars;
import dev.netho.skywars.manager.ConfigManager;
import org.bukkit.scheduler.BukkitRunnable;

public class Countdown extends BukkitRunnable {

    private SkyWars plugin;
    private Arena arena;
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
            arena.sendMessage("A Partida começará em " + countdownSeconds + " segundo" + (countdownSeconds ==1 ? "" : "s") + ". ");
        }

        arena.sendTitle(countdownSeconds + " segundo" + (countdownSeconds == 1 ? "" : "s"), "até o jogo começar");

        countdownSeconds--;

    }
}
