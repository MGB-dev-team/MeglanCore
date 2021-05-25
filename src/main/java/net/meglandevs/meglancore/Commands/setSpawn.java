package net.meglandevs.meglancore.Commands;

import net.meglandevs.meglancore.Main;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static net.meglandevs.meglancore.Utils.chat;

public class setSpawn implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            return true;
        }

        Player p = (Player) sender;

        if(p.hasPermission("megla.setspawn")) {
            World world = p.getWorld();

            int x = (int) p.getLocation().getX();
            int y = (int) p.getLocation().getY();
            int z = (int) p.getLocation().getZ();
            world.setSpawnLocation(x,y,z);
            p.sendMessage(chat(Main.prefix + " &fspawn set!"));
        } else {
            p.sendMessage(chat(Main.prefix + " &cNo permissions"));
        }
        return true;
    }
}
