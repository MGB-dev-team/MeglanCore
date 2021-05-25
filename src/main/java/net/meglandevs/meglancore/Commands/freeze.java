package net.meglandevs.meglancore.Commands;

import net.meglandevs.meglancore.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static net.meglandevs.meglancore.Utils.chat;

public class freeze implements CommandExecutor {

    public static List<Player> freezed = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            return true;
        }

        Player p = (Player) sender;

        if(p.hasPermission("meglan.freeze")) {
            if(args.length < 1) {
                p.sendMessage(chat(Main.prefix + " &cInvalid usage!"));
                return true;
            } else {
                Player target = Bukkit.getPlayer(args[0]);
                if(target.hasPermission("meglan.bypass.freeze") || p.hasPermission("meglan.bypass.*")) {
                    p.sendMessage(chat(Main.prefix + " &fYou cannot freeze &c&n" + target.getName()));
                } else {
                    if(target.isOnline() && !freezed.contains(target)) {
                        freezed.add(target);
                        p.sendMessage(chat(Main.prefix + " &fYou've freezed &c&n" + target.getName()));
                        target.sendMessage(chat(Main.prefix + "&fYou've been &c&nfreezed &fby a staff member! Do &4&lNOT &flogout or you will be banned!"));
                    } else if(!target.isOnline()) {
                        p.sendMessage(chat(Main.prefix + "&cPlayer is not online!"));
                    } else if(freezed.contains(target)) {
                        freezed.remove(target);
                        p.sendMessage(chat(Main.prefix + " &fYou've frozen &c&n" + target.getName()));
                        target.sendMessage(chat(Main.prefix + "&fYou've been &c&nfrozen"));
                    }
                }
            }
        } else {
            p.sendMessage(chat(Main.prefix + " &cNo permissions!"));
        }
        return true;
    }
}
