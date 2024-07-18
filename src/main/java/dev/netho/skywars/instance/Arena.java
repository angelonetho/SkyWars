package dev.netho.skywars.instance;

import dev.netho.skywars.SkyWars;
import dev.netho.skywars.manager.ConfigManager;
import dev.netho.skywars.util.MusicPlayer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Arena {

    private SkyWars plugin;

    private int id;
    private Location spawnLocation;

    private GameState gameState;
    private List<UUID> players;
    private Countdown countdown;
    private Game game;

    public Arena(SkyWars plugin, int id, Location spawnLocation) {
        this.plugin = plugin;
        this.id = id;
        this.spawnLocation = spawnLocation;

        this.gameState = GameState.RECRUITING;
        this.players = new ArrayList<>();
        this.countdown = new Countdown(plugin, this);
        this.game = new Game(this, plugin);
    }

    public void start() {
        game.start();
    }

    public void reset(boolean kickPlayers) {
        if(kickPlayers) {
            Location location = ConfigManager.getLobbySpawn();
            for(UUID uuid : players) {
                Bukkit.getPlayer(uuid).teleport(location);
            }
            players.clear();
        }

        countdown.cancel();
        countdown = new Countdown(plugin, this);
        gameState = GameState.RECRUITING;


    }

    @Deprecated
    public void sendMessage(String message) {
        for(UUID uuid : players) {
            Bukkit.getPlayer(uuid).sendMessage(Component.text(message));
        }
    }

    public void sendMessage(TextComponent message) {
        if(message != null) {
            for(UUID uuid : players) {

                Player player = Bukkit.getPlayer(uuid);

                if(player != null) {
                    player.sendMessage(message);
                }
            }
        }
    }

    public void sendActionBarMessage(TextComponent message) {
        if(message != null) {
            for(UUID uuid : players) {

                Player player = Bukkit.getPlayer(uuid);

                if(player != null) {
                    player.sendActionBar(message);
                }
            }
        }
    }

    public void playSound(Sound soundToPlay, float pitch) {
        getPlayers().forEach(uuid -> {

            Player player = Bukkit.getPlayer(uuid);

            if(player != null) {
                player.playSound(player.getLocation(), soundToPlay, SoundCategory.PLAYERS, 1.0f, pitch);
            }
        });
    }

    public void addPlayer(Player player) {
        players.add(player.getUniqueId());
        player.teleport(spawnLocation);

        TextComponent joinMessage = Component.empty().append(player.displayName()).append(Component.text(" joined the arena")).color(TextColor.fromHexString("#FF70C6"));
        sendMessage(joinMessage);

        if(gameState.equals(GameState.RECRUITING) && players.size() >= ConfigManager.getRequiredPlayers()) {
            countdown.start();
        }
    }

    public void removePlayer(Player player) {
        players.remove(player.getUniqueId());
        player.teleport(ConfigManager.getLobbySpawn());

        if(gameState == GameState.COUNTDOWN && players.size() < ConfigManager.getRequiredPlayers()) {
            sendMessage("Not enough players. Countdown paused.");
            reset(false);
        }

        if(gameState == GameState.LIVE && players.size() <= 1) {
            reset(true);
        }
    }

    public int getId() {
        return id;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public List<UUID> getPlayers() {
        return players;
    }

    public Game getGame() {
        return game;
    }
}
