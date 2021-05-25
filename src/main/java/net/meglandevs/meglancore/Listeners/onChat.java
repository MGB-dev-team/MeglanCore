package net.meglandevs.meglancore.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import static net.meglandevs.meglancore.Commands.VanishCommand.isVanished;
import static net.meglandevs.meglancore.Utils.chat;
import static net.meglandevs.meglancore.Utils.getPrefix;

public class onChat implements Listener {



    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String message = e.getMessage();
        e.setFormat(chat(getPrefix(p.getUniqueId()) + " &7&o" + p.getName() + " &f " + message));

        if(isVanished.contains(p)) {
            e.setCancelled(true);
            for(Player staff : Bukkit.getOnlinePlayers()) {
                staff.sendMessage(chat("&e&lSTAFFCHAT &8&L• &7&o" + staff.getName() +  " &f&o" + message));
            }
        }
    }
}
