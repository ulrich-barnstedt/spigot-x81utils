package dev.x81.x81utils;

import dev.x81.x81utils.commands.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class X81utils extends JavaPlugin {
    public FileConfiguration config;
    public static JavaPlugin running;

    @Override
    public void onEnable() {
        running = this;
        config = getConfig();

        setupConfig();
        registerCommands();
    }

    private void setupConfig () {
        config.options().copyDefaults(true);
        saveConfig();
    }

    private void registerCommands () {
        this.getCommand("delwarp").setExecutor(new DelWarp());
        this.getCommand("delwarp").setTabCompleter(new dev.x81.x81utils.completers.Warp());
        this.getCommand("setwarp").setExecutor(new SetWarp());
        this.getCommand("warp").setExecutor(new Warp());
        this.getCommand("warp").setTabCompleter(new dev.x81.x81utils.completers.Warp());
        this.getCommand("toggleframe").setExecutor(new ToggleFrame());
    }

    @Override
    public void onDisable() {}
}
