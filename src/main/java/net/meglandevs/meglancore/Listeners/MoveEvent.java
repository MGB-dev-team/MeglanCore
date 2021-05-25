package net.meglandevs.meglancore.Listeners;

import net.meglandevs.meglancore.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import static net.meglandevs.meglancore.Commands.freeze.freezed;
import static net.meglandevs.meglancore.Utils.chat;

public class MoveEvent implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if(freezed.contains(p)) {
            e.setCancelled(true);
            p.sendMessage(chat(Main.prefix + " &fYou've been frozen"));
        } else {
            e.setCancelled(false);
        }
    }
}
