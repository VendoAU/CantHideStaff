package com.vendoau.canthidestaff.mode;

import com.vendoau.canthidestaff.CantHideStaff;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class BroadcastMode implements Listener {

    public BroadcastMode(CantHideStaff plugin) {
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
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
