package dev.netho.skywars.instance;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Game {

    private Arena arena;
    private HashMap<UUID, Integer> points;

    public Game(Arena arena) {
        this.arena = arena;
        points = new HashMap<>();
    }

    public void start() {
        arena.setGameState(GameState.LIVE);

        TextComponent message = Component.text("Let the battle begin!", TextColor.fromHexString("#FF70C6"));
        arena.sendMessage(message);

        for (UUID uuid : arena.getPlayers()) {
            points.put(uuid, 0);
        }
    }

    public void addPoint(Player player) {
        int playerPoints = points.get(player.getUniqueId()) + 1;
        if(playerPoints == 20) {

            TextComponent message = Component.text(player.getName() + " has won the game!", TextColor.fromHexString("#FF70C6"));
            arena.sendMessage(message);

            arena.reset(true);

            return;
        }

        player.sendMessage(Component.text("+1 Point!").color(TextColor.color(0x54FF24)));
        points.replace(player.getUniqueId(), playerPoints);
    }
}
