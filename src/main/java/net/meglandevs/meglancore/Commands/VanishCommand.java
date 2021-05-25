package net.meglandevs.meglancore.Commands;

import net.meglandevs.meglancore.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

import static net.meglandevs.meglancore.Utils.chat;

public class VanishCommand implements CommandExecutor {

    Plugin plugin = Main.getPlugin(Main.class);

    public static List<Player> isVanished = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            return true;
        }

        Player p = (Player) sender;

        if(p.hasPermission("meglan.vanish")) {
            if(args.length >= 1) {
                p.sendMessage(chat("&cInvalid usage please use: /v"));
            } else{
                if(isVanished.contains(p)) {
                    isVanished.remove(p);
                    p.sendMessage(chat("&b&lMEGLA&3&lNSMP &fvanish &c&ndisabled"));
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.showPlayer(plugin, p);
                    }
                } else {
                    isVanished.add(p);
                    p.sendMessage(chat("&b&lMEGLA&3&lNSMP &fvanish &a&nenabled"));
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        if(all.hasPermission("meglan.bypass.vanish") || all.hasPermission("meglan.bypass.*")) {
                            all.showPlayer(plugin, p);
                        } else {
                            all.hidePlayer(plugin, p);
                        }
                    }
                }
            }
        } else {
            p.sendMessage(chat("&cYou don't have permission for this command!"));
        }
        return true;
    }
}
