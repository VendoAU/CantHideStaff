package com.vendoau.canthidestaff.mode;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.vendoau.canthidestaff.CantHideStaff;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PacketMode {

    public PacketMode(CantHideStaff plugin) {
        ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(plugin, PacketType.Play.Server.CHAT) {
            @Override
            public void onPacketSending(PacketEvent event) {
                PacketContainer packet = event.getPacket();
                Player player = Bukkit.getPlayer(packet.getUUIDs().read(0));
                if (player != null && player.hasPermission("canthidestaff.staff")) {
                    packet.getUUIDs().write(0, new UUID(0, 0));
                }
            }
        });
    }
}
