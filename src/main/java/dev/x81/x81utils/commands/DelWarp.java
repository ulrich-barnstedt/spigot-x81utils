package dev.x81.x81utils.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import dev.x81.x81utils.X81utils;

public class DelWarp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.isOp()) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command.");
            return true;
        }
        if (args.length == 0) return false;

        String name = args[0];

        if (!X81utils.running.getConfig().contains("warps." + name)) {
            sender.sendMessage(ChatColor.RED + "Invalid warp.");
            return true;
        }

        X81utils.running.getConfig().set("warps." + name, null);
        X81utils.running.saveConfig();

        sender.sendMessage("Deleted warp " + name);
        return true;
    }
}
