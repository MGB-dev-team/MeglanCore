package net.meglandevs.meglancore;

import net.luckperms.api.LuckPermsProvider;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Utils {

    public static String chat(String args) {
        return ChatColor.translateAlternateColorCodes('&', args);
    }


    public static String getPrefix(UUID uuid) {
        String prefix = LuckPermsProvider.get().getGroupManager().getGroup(LuckPermsProvider.get().getUserManager().getUser(uuid).getPrimaryGroup()).getCachedData().getMetaData().getPrefix();
        return prefix;
    }


    public static void upDate() {
        Bukkit.getScheduler().runTaskTimerAsynchronously(Main.getPlugin(Main.class), new Runnable() {

            @Override
            public synchronized void run() {
                for(Player all : Bukkit.getOnlinePlayers()) {
                    all.setPlayerListName(chat(Utils.getPrefix(all.getUniqueId()) + "&7" + all.getName()));
                }
            }

        }, 1, 40);
    }
}
