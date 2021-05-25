package net.meglandevs.meglancore.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import static net.meglandevs.meglancore.Commands.GodMode.isGodMode;

public class damageEvent implements Listener {

    @EventHandler
    public void onDamange(EntityDamageEvent e) {
        if(e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if(isGodMode.contains(p)) {
                e.setCancelled(true);
            } else {
                e.setCancelled(false);
            }
        }
    }
}
