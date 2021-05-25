package net.meglandevs.meglancore.Listeners;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import static net.meglandevs.meglancore.Commands.VanishCommand.isVanished;
import static net.meglandevs.meglancore.Commands.freeze.freezed;
import static net.meglandevs.meglancore.Utils.chat;

public class QuitEvent implements Listener {

    @EventHandler
    public void QuitEvent(PlayerQuitEvent e) {
        Player p  = e.getPlayer();
        e.setQuitMessage(null);
        if(freezed.contains(p)) {
            Bukkit.getBanList(BanList.Type.NAME).addBan(p.getName(), "Logging out while being freezed", null, "Banned losl");
        }
        if(isVanished.contains(p)) {
            for(Player staff : Bukkit.getOnlinePlayers()) {
                if(staff.hasPermission("meglan.staff")) {
                    staff.sendMessage(chat("&b&lMEGLA&3&lNSMP &f" + p.getDisplayName() + " &fhas &c&nleft"));
                } else {
                    e.setQuitMessage(null);
                }
            }
        } else {
            e.setQuitMessage(chat("&b&lMEGLA&3&lNSMP &f" + p.getDisplayName() + " &fhas &c&nleft"));
        }
    }
}
