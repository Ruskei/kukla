package com.ixume.kuklaRagdolls.listener

import com.ixume.kuklaRagdolls.KuklaRagdolls
import com.ixume.kuklaRagdolls.RagdollCreator
import com.ixume.udar.physicsWorld
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent

object PlayerDeathListener : Listener {
    fun init() {
        Bukkit.getPluginManager().registerEvents(this, KuklaRagdolls.INSTANCE)
    }

    @EventHandler
    fun onPlayerDeath(e: PlayerDeathEvent) {
        RagdollCreator.createVanilla(e.player) { ragdoll ->
            ragdoll ?: return@createVanilla
            val dir = (e.damageSource.causingEntity as? Player ?: return@createVanilla).location.direction
            val magnitude = 33.0
            e.player.world.physicsWorld?.run {
                ragdoll.body.velocity.add(dir.x * magnitude, dir.y * magnitude, dir.z * magnitude)
            }
        }
    }
}