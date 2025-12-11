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
        val ragdoll = RagdollCreator.create(e.player)
        val dir = (e.damageSource.causingEntity as? Player ?: return).location.direction
        println("dir: $dir")
        val magnitude = 100.0
//        Bukkit.getScheduler().runTaskLater(KuklaRagdolls.INSTANCE, Runnable {
        e.player.world.physicsWorld?.run {
            println("adding velocity=> ${dir.x * magnitude} ${dir.y * magnitude} ${dir.z * magnitude}!")
            ragdoll.chest.velocity.add(dir.x * magnitude, dir.y * magnitude, dir.z * magnitude)
        }
//        }, 5)
//        val ls = listOf(
//            ragdoll.head,
//            ragdoll.chest,
//            ragdoll.waist,
//            ragdoll.hip,
//            ragdoll.rightArm,
//            ragdoll.rightForeArm,
//            ragdoll.leftArm,
//            ragdoll.leftForeArm,
//            ragdoll.rightLeg,
//            ragdoll.rightForeLeg,
//            ragdoll.leftLeg,
//            ragdoll.leftForeLeg,
//        )
//
//        val start = e.player.eyeLocation.toVector().toVector3d()
//        val dir = e.player.location.direction.toVector3d().mul(20.0)
//        val end = Vector3d(start).add(dir)
//
//        val allIntersections = mutableListOf<Triple<ActiveBody, Vector3d, Vector3d>>()
//        for (body in ls) {
//            if (body.isChild) continue
//
//            allIntersections += body.intersect(start, end).map { Triple(body, it.first, it.second) }
//        }
//
//        val (body, intersection, normal) = allIntersections.minByOrNull { (_, inter, _) ->
//            inter.distanceSquared(
//                start
//            )
//        } ?: return
//
//        body.applyImpulse(
//            intersection,
//            normal,
//            Vector3d(dir).normalize(100.0)
//        )
    }
}