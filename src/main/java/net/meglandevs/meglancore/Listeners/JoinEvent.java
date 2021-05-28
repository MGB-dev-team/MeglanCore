package net.meglandevs.meglancore.Listeners;

import net.meglandevs.meglancore.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static net.meglandevs.meglancore.Utils.chat;

public class JoinEvent implements Listener {

    @EventHandler
    public void QuitEvent(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        e.setJoinMessage(chat(Utils.getPrefix(p.getUniqueId()) + p.getName() + " &fhas &a&njoined"));
    }
}
