package net.meglandevs.meglancore.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import static net.meglandevs.meglancore.Utils.chat;

public class ReplyCommand implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 1) {
            Player target = MsgCommand.KnownSender.get(player);
            String message = getMessage(args);
            if (target != null) {
                if (target.isOnline()) {
                    target.sendMessage(chat("&8[&3From&8] " + "&7" + player.getName() + "&8: " + "&f" + message));
                    sender.sendMessage(chat("&8[&3To&8] " + "&7" + target.getName() + "&8: " + "&f" + message));
                    SocialSpy.sendtosnake(player, target, message);
                    return true;
                } else {
                    sender.sendMessage(chat("&7Player jumped in to a pit of lava!"));
                }
            } else {
                sender.sendMessage(chat("&7You need to message someone before using this &dUwU"));
            }

        }
        return true;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        MsgCommand.KnownSender.remove(e.getPlayer());
    }

    private static String getMessage(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            sb.append(args[i]).append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
