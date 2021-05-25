package net.meglandevs.meglancore.Commands;

import net.meglandevs.meglancore.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static net.meglandevs.meglancore.Utils.chat;

public class GodMode implements CommandExecutor {

    public static List<Player> isGodMode = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            return true;
        }

        Player p = (Player) sender;

        if(p.hasPermission("meglan.godmode")) {
            if(isGodMode.contains(p)) {
                isGodMode.remove(p);
                p.sendMessage(chat(Main.prefix + " &fGodmode &c&ndisabled"));
            } else {
                isGodMode.add(p);
                p.sendMessage(chat(Main.prefix + " &fGodmode &a&nenabled"));
            }
        }
        return true;
    }
}
