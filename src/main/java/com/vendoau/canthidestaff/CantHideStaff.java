package com.vendoau.canthidestaff;

import com.vendoau.canthidestaff.mode.BroadcastMode;
import com.vendoau.canthidestaff.mode.PacketMode;
import org.bstats.bukkit.Metrics;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class CantHideStaff extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();

        new Metrics(this, 10143);

        if (getConfig().getBoolean("packet")) {
            if (getServer().getPluginManager().getPlugin("ProtocolLib") == null) {
                getLogger().severe("ProtocolLib is required for packet mode");
                getServer().getPluginManager().disablePlugin(this);
            } else {
                new PacketMode(this);
            }
        } else {
            new BroadcastMode(this);
        }
    }
}
