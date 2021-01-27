package com.vendoau.canthidestaff;

import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class CantHideStaff extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        int pluginId = 10143;
        Metrics metrics = new Metrics(this, pluginId);

        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        if (player.hasPermission("canthidestaff.staff")) {
            event.setCancelled(true);

            Bukkit.broadcastMessage(event.getFormat()
                    .replace("%1$s", player.getDisplayName())
                    .replace("%2$s", event.getMessage()));
        }
    }
}
