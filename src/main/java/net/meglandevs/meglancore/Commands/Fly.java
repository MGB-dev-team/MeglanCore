package net.meglandevs.meglancore.Commands;

import net.meglandevs.meglancore.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static net.meglandevs.meglancore.Utils.chat;

public class Fly implements CommandExecutor {

    public static List<Player> flight = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;

        if(player.hasPermission("megaln.donor")) {
            if(args.length > 0) {
                player.sendMessage(chat(Main.prefix + " &fInvalid args"));
            } else {
                if(flight.contains(player)) {
                    flight.remove(player);
                    player.setAllowFlight(false);
                    player.sendMessage(chat(Main.prefix + " &fFlight &c&ndisabled"));
                } else {
                    flight.add(player);
                    player.setAllowFlight(true);
                    player.sendMessage(chat(Main.prefix + " &fFlight &a&nenabled"));
                }
            }
        } else {
            player.sendMessage(chat(Main.prefix + " &fNo permissions"));
        }
        return true;
    }
}
