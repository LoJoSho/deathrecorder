package me.lojosho.deathrecorder.Listener;

import me.lojosho.deathrecorder.DeathRecorder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayersDeath implements Listener {

    private final DeathRecorder plugin;

    public PlayersDeath(DeathRecorder plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        String player = event.getEntity().getPlayer().getName();
        if (plugin.getConfig().contains(player + ".deaths")) {
            int DeathsAmount = plugin.getConfig().getInt(player + ".deaths");
            plugin.getConfig().set(player + ".deaths", DeathsAmount + 1);
            plugin.saveConfig();
        } else {
            plugin.getConfig().createSection(player + ".deaths");
            plugin.getConfig().set(player + ".deaths", 1);
            plugin.saveConfig();
        }
    }
}
