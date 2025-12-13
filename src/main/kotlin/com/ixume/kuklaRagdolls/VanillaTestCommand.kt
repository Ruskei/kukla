package com.ixume.kuklaRagdolls

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabExecutor
import org.bukkit.entity.Player

object VanillaTestCommand : TabExecutor {
    fun init() {
        Bukkit.getPluginCommand("kukla2")!!.setExecutor(this)
        Bukkit.getPluginCommand("kukla2")!!.tabCompleter = this
    }

    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        alias: String,
        args: Array<out String>,
    ): List<String> {
        return emptyList()
    }

    override fun onCommand(
        sender: CommandSender,
        command: Command,
        alias: String,
        args: Array<out String>,
    ): Boolean {
        val player = sender as? Player ?: return false
        RagdollCreator.createVanilla(player) {}

        return true
    }
}