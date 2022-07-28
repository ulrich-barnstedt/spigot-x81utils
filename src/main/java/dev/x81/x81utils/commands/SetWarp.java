package dev.x81.x81utils.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import dev.x81.x81utils.X81utils;

public class SetWarp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) return false;
        if (!(sender instanceof Player player)) return true;
        if (!sender.isOp()) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command.");
            return true;
        }

        Location at = player.getLocation();
        String name = args[0];

        X81utils.running.getConfig().set("warps." + name, at);
        X81utils.running.saveConfig();

        sender.sendMessage("Set warp " + name + ".");
        return true;
    }
}
