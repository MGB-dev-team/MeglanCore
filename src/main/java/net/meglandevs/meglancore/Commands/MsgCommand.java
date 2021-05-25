package net.meglandevs.meglancore.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static net.meglandevs.meglancore.Utils.chat;

public class MsgCommand implements CommandExecutor, Listener {

    public static Map<Player, Player> KnownSender = new HashMap<>();
    public static ArrayList<Player> snakes = new ArrayList<Player>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;

        if (args.length >= 1) {
            Player target = Bukkit.getPlayer(args[0]);
            String message = getMessage(args);
            assert target != null;
            if (target.isOnline()) {
                target.sendMessage(chat("&8[&3From&8] " + "&7" + player.getName() + "&8: " + "&f" + message));
                sender.sendMessage(chat("&8[&3To&8] " + "&7" + target.getName() + "&8: " + "&f" + message));
                KnownSender.put(target, player);
                KnownSender.put(player, target);
                SocialSpy.sendtosnake(player, target, message);
                return true;
            } else {
                player.sendMessage(chat("&8[&3!&8] &3" + target.getName() + " &7is not online!"));
            }
        } else {
            player.sendMessage(chat("&cInvalid usage"));
            return  true;
        }
        return true;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        KnownSender.remove(e.getPlayer());
        snakes.remove(e.getPlayer());
    }

    private static String getMessage(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            sb.append(args[i]).append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
