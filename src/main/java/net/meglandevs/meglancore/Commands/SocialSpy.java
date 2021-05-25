package net.meglandevs.meglancore.Commands;

import net.meglandevs.meglancore.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class SocialSpy implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player p = (Player) sender;
        if (MsgCommand.snakes.contains(p)) {
            p.sendMessage(Utils.chat("&7You are no longer a dick head!"));
            MsgCommand.snakes.remove(p);
        } else {
            p.sendMessage(Utils.chat("&7You are now in snake mode, you can see private messages!"));
            MsgCommand.snakes.add(p);
        }
        return true;
    }

    public static void sendtosnake(Player player, Player target, String message) {
        for (Player pl : Bukkit.getOnlinePlayers()) {
            if (MsgCommand.snakes.contains(pl)) {
                pl.sendMessage(Utils.chat("&e&lSOCIALSPY &8&L• &7&o " + player.getName() + " &fto &7&o" + target.getName() + "&8: &f" + message));
            }
        }
    }
}
