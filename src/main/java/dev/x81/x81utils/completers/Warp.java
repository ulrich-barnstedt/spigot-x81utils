package dev.x81.x81utils.completers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;
import dev.x81.x81utils.X81utils;
import org.bukkit.configuration.ConfigurationSection;

public class Warp implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        ConfigurationSection section = X81utils.running.getConfig().getConfigurationSection("warps");

        if (section == null) {
            return null;
        } else {
            return new ArrayList<>(section.getKeys(false));
        }
    }
}
