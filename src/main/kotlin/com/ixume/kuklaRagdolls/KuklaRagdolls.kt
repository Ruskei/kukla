package com.ixume.kuklaRagdolls

import com.github.retrooper.packetevents.PacketEvents
import com.github.retrooper.packetevents.event.PacketListenerPriority
import org.bukkit.plugin.java.JavaPlugin

class KuklaRagdolls : JavaPlugin() {

    override fun onEnable() {
        PacketEvents.getAPI().eventManager.registerListener(Listener, PacketListenerPriority.NORMAL)

        TestCommand.init()
    }

    override fun onDisable() {
    }
}
