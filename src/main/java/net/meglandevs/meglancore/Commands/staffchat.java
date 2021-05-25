package net.meglandevs.meglancore.Commands;

import net.meglandevs.meglancore.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static net.meglandevs.meglancore.Utils.chat;

public class staffchat implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            return true;
        }

        Player p = (Player) sender;

        if(p.hasPermission("meglan.staffchat")) {
            if(args.length < 1) {
                p.sendMessage(chat(Main.prefix + " &fInvalid usage"));
            } else {
                StringBuilder message = new StringBuilder();
                for (int i = 0; i < args.length; i++)
                    message.append(String.valueOf(args[i]) + " ");
                for(Player all : Bukkit.getOnlinePlayers()) {
                    all.sendMessage(chat("&e&lSTAFFCHAT &8&L• &7&o" + p.getName() + " &f&o " + message));
                }
            }
        }
        return true;
    }
}
