package net.meglandevs.meglancore.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

import static net.meglandevs.meglancore.Commands.VanishCommand.isVanished;

public class pickUpEvent implements Listener {

    @EventHandler
    public void onPickUp(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();
        if(isVanished.contains(p)) {
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }
}
