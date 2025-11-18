package com.ixume.kuklaRagdolls

import com.github.retrooper.packetevents.PacketEvents
import com.github.retrooper.packetevents.event.PacketListenerPriority
import com.ixume.kuklaRagdolls.listener.PlayerDeathListener
import org.bukkit.plugin.java.JavaPlugin

class KuklaRagdolls : JavaPlugin() {
    override fun onEnable() {
        INSTANCE = this
        PacketEvents.getAPI().eventManager.registerListener(Listener, PacketListenerPriority.NORMAL)

        TestCommand.init()
        PlayerDeathListener.init()
    }

    override fun onDisable() {
    }

    companion object {
        lateinit var INSTANCE: KuklaRagdolls
            private set
    }
}
