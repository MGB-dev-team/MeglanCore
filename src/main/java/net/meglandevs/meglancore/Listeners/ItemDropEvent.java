package net.meglandevs.meglancore.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import static net.meglandevs.meglancore.Commands.VanishCommand.isVanished;

public class ItemDropEvent implements Listener {


    @EventHandler
    public void ItemDropEvent(PlayerDropItemEvent e) {
        Player p = e.getPlayer();

        if(isVanished.contains(p)) {
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }
}
