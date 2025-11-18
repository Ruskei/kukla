package com.ixume.kuklaRagdolls.listener

import com.ixume.kuklaRagdolls.KuklaRagdolls
import com.ixume.kuklaRagdolls.RagdollCreator
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent

object PlayerDeathListener : Listener {
    fun init() {
        Bukkit.getPluginManager().registerEvents(this, KuklaRagdolls.INSTANCE)
    }
   
    @EventHandler
    fun onPlayerDeath(e: PlayerDeathEvent) {
        RagdollCreator.create(e.player)
    }
}