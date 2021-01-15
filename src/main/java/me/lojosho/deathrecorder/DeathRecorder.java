package me.lojosho.deathrecorder;

import me.lojosho.deathrecorder.Listener.PlayersDeath;
import org.bukkit.plugin.java.JavaPlugin;

public final class DeathRecorder extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.saveDefaultConfig();
        registerEvents();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerEvents() {
        getServer().getPluginManager().registerEvents(new PlayersDeath(this), this);
    }
}
