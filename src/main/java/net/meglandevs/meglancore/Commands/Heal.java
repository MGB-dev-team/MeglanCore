package net.meglandevs.meglancore.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static net.meglandevs.meglancore.Utils.chat;

public class Heal implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            return true;
        }

        Player p = (Player) sender;

        if(p.hasPermission("meglan.heal")) {
            if(args.length == 0) {
                p.setHealth(20);
                p.setFoodLevel(20);
                p.sendMessage(chat("&b&lMEGLA&3&lNSMP &fYou have been &c&nhealed"));
            } else if(args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if(target.isOnline()) {
                    target.setHealth(20);
                    target.setFoodLevel(20);
                    p.sendMessage(chat("&b&lMEGLA&3&lNSMP &fYou have been &c&nhealed"));
                } else {
                    p.sendMessage(chat("&cPlayer is not online!"));
                }
            } else if(args.length > 1) {
                p.sendMessage(chat("&cInvalid usage!"));
            }
        } else {
            p.sendMessage(chat("&cNo permissions!"));
        }
        return true;
    }
}
