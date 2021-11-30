package dev.x81.x81utils.commands;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;

public class ToggleFrame implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;
        World world = player.getWorld();
        java.util.Collection<Entity> list = world.getNearbyEntities(player.getLocation().add(0, 1, 0), 1, 1, 1);

        if (list.size() == 1) {
            return true;
        }

        Entity entity = null;
        for (Entity ent : list) {
            entity = ent;

            if (entity instanceof ItemFrame) {
                break;
            }
        }

        if (entity == null) return true;
        ItemFrame frame = (ItemFrame) entity;
        frame.setVisible(!frame.isVisible());
        return true;
    }
}
