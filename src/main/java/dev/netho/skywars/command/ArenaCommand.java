package dev.netho.skywars.command;

import dev.netho.skywars.SkyWars;
import dev.netho.skywars.instance.Arena;
import dev.netho.skywars.instance.GameState;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ArenaCommand implements CommandExecutor {

    private final SkyWars plugin;

    public ArenaCommand(SkyWars plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(args.length == 1 && args[0].equalsIgnoreCase("list")) {
                player.sendMessage(Component.text("Avaiable arenas:"));
                for (Arena arena : plugin.getArenaManager().getArenas()) {
                    player.sendMessage(Component.text("- " + arena.getId() + "("+ arena.getGameState().name() +")"));
                }

            } else if (args.length == 1 && args[0].equalsIgnoreCase("leave")) {
                Arena arena = plugin.getArenaManager().getArenaByPlayer(player);
                if(arena != null) {
                    player.sendMessage(Component.text("You leaved the arena"));
                    arena.removePlayer(player);
                } else {
                    player.sendMessage(Component.text("You're not in an arena"));
                }


            } else if (args.length == 2 && args[0].equalsIgnoreCase("join")) {
                if(plugin.getArenaManager().getArenaByPlayer(player) != null) {
                    player.sendMessage(Component.text("You're in an arena"));
                    return false;
                }

                int id;

                try {
                    id = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    player.sendMessage(Component.text("Invalid arena id."));
                    return false;
                }

                if(id >= 0 && id < plugin.getArenaManager().getArenas().size()) {
                    Arena arena = plugin.getArenaManager().getArenas().get(id);
                    if(arena.getGameState() == GameState.RECRUITING || arena.getGameState() == GameState.COUNTDOWN) {
                        player.sendMessage(Component.text("Youre now in arena " + arena.getId()));
                        arena.addPlayer(player);
                    } else {
                        player.sendMessage(Component.text("You can't enter this arena now"));
                    }
                } else {
                    player.sendMessage(Component.text("Invalid arena id."));
                }
            } else {
                player.sendMessage(Component.text("Invalid usage"));
            }
        }

        return true;
    }
}
