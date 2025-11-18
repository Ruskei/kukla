package com.ixume.kuklaRagdolls

import com.github.retrooper.packetevents.event.PacketListener
import com.github.retrooper.packetevents.event.PacketSendEvent
import com.github.retrooper.packetevents.wrapper.play.server.*

object Listener : PacketListener {
    override fun onPacketSend(event: PacketSendEvent) {
//        println("packet: ${event.packetType}")
//        when (event.packetType) {
//            PacketType.Play.Server.SPAWN_ENTITY -> {
//                val wrapper = WrapperPlayServerSpawnEntity(event)
//                println(wrapper.pretty())
//                wrapper.position = wrapper.position.add(0.0, 4096.0, 0.0)
//            }
//            PacketType.Play.Server.ENTITY_METADATA -> println(WrapperPlayServerEntityMetadata(event).pretty())
//            PacketType.Play.Server.ENTITY_POSITION_SYNC -> println(WrapperPlayServerEntityPositionSync(event).pretty())
//            PacketType.Play.Server.SET_PASSENGERS -> {
//                println(WrapperPlayServerSetPassengers(event).pretty())
//                event.isCancelled = true
//            }
//        }
////        if (event.packetType == PacketType.Play.Server.SPAWN_ENTITY) {
////            val spawn = WrapperPlayServerSpawnEntity(event)
////            println("spawn")
////            println(spawn)
////        } else if (event.packetType == PacketType.Play.Server.POS)
    }

    private fun WrapperPlayServerSpawnEntity.pretty(): String {
        return "($entityId) pos: $position"
    }

    private fun WrapperPlayServerEntityMetadata.pretty(): String {
        return "($entityId) ${entityMetadata.joinToString { data -> "${data.index} => ${data.value} : ${data.type}" }}"
    }

    private fun WrapperPlayServerEntityTeleport.pretty(): String {
        return "($entityId) $position"
    }
    
    private fun WrapperPlayServerEntityPositionSync.pretty(): String {
        return "($id) ${this.values.position}"
    }
    
    private fun WrapperPlayServerSetPassengers.pretty(): String {
        return "($entityId) ${this.passengers.joinToString { it.toString() }}"
    }
}