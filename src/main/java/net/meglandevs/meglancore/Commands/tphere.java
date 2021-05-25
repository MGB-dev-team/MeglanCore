package net.meglandevs.meglancore.Commands;

import net.meglandevs.meglancore.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static net.meglandevs.meglancore.Utils.chat;

public class tphere implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            return true;
        }

        Player p = (Player) sender;

        if(p.hasPermission("meglan.tphere")) {
            if(args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if(target.isOnline()) {
                    target.teleport(p.getLocation());
                    target.sendMessage(chat(Main.prefix + " &fteleported you to " + p.getName()));
                } else {
                    p.sendMessage(chat(Main.prefix + " &fPlayer is not online!"));
                }
            }
        } else {
            p.sendMessage(chat("&cNo permissions"));
        }
        return true;
    }
}
