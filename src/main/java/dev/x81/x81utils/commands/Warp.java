package dev.x81.x81utils.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import dev.x81.x81utils.X81utils;

public class Warp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) return true;
        if (args.length == 0) return false;

        String name = args[0];

        if (!X81utils.running.getConfig().contains("warps." + name)) {
            sender.sendMessage(ChatColor.RED + "Invalid warp.");
            return true;
        }

        Location to = X81utils.running.getConfig().getLocation("warps." + name);
        player.teleport(to);

        player.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "Warped you to " + name + ".");
        return true;
    }
}
