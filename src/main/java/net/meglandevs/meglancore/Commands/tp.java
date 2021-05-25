package net.meglandevs.meglancore.Commands;

import net.meglandevs.meglancore.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static net.meglandevs.meglancore.Utils.chat;

public class tp implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            return true;
        }

        Player p = (Player) sender;

        if(p.hasPermission("meglan.tp")) {
            if(args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if(target.isOnline()) {
                    p.teleport(target.getLocation());
                    p.sendMessage(chat(Main.prefix + " &fteleported you to " + target.getName()));
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
