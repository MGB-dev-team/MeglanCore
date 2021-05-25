package net.meglandevs.meglancore.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import static net.meglandevs.meglancore.Commands.GodMode.isGodMode;

public class HungerChange implements Listener {

    @EventHandler
    public void healthChange(FoodLevelChangeEvent e) {
        Player p = (Player) e.getEntity();
        if(e.getEntity() instanceof Player) {
            if(isGodMode.contains(p)) {
                e.setCancelled(true);
            } else {
                e.setCancelled(false);
            }
        }
    }
}
