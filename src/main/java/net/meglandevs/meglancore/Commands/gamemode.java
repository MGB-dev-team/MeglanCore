package net.meglandevs.meglancore.Commands;

import net.meglandevs.meglancore.Main;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static net.meglandevs.meglancore.Utils.chat;

public class gamemode implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player p = (Player) sender;

        if(p.hasPermission("meglan.gamemode")) {
            switch (args[0]) {
                case "s":
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(chat(Main.prefix + " &fSet your gamemode to &a&nsurvival"));
                    break;
                case "sp":
                    p.setGameMode(GameMode.SPECTATOR);
                    p.sendMessage(chat(Main.prefix + " &fSet your gamemode to &7&nspectator"));
                    break;
                case "c":
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage(chat(Main.prefix + " &fSet your gamemode to &c&ncreative"));
                    break;
                case "a":
                    p.setGameMode(GameMode.ADVENTURE);
                    p.sendMessage(chat(Main.prefix + " &fSet your gamemode to &a&adventure"));
                    break;

            }
        } else {
            p.sendMessage(Main.prefix + " &cYou don't have permission for this command!");
        }
        return true;
    }
}
