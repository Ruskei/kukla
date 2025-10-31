package com.ixume.kuklaRagdolls.udar

import com.ixume.udar.body.active.ActiveBody
import org.bukkit.Location
import org.bukkit.entity.EntityType
import org.bukkit.entity.ItemDisplay
import org.bukkit.inventory.ItemStack
import org.bukkit.util.Transformation
import org.joml.Quaternionf
import org.joml.Vector3d
import org.joml.Vector3f

class ItemDisplayCuboid(
    val cuboid: ActiveBody,
    stack: ItemStack,
    val modelOffset: Vector3d,
) : ActiveBody by cuboid {
    private val display: ItemDisplay

    private val _v = Vector3f()
    private val _s = Vector3f(1f)
    private val _r = Quaternionf()
    private val _eq = Quaternionf()

    init {
        val p = Vector3d(pos).add(Vector3d(modelOffset).rotate(q))
        display = world.spawnEntity(
            Location(world, p.x, p.y, p.z),
            EntityType.ITEM_DISPLAY
        ) as ItemDisplay

        display.setItemStack(stack)

        display.transformation = createTransformation()
        display.itemDisplayTransform = ItemDisplay.ItemDisplayTransform.FIXED
        display.interpolationDuration = 3
        display.interpolationDelay = 0
        display.teleportDuration = 3
    }

    private fun createTransformation(): Transformation {
        return Transformation(
            _v,
            Quaternionf(q),
            _s,
            _eq,
        )
    }

    val modelPos = Vector3d()

    override fun visualize() {
        if (!awake.get()) return

        val pos2 = modelPos.set(pos).add(Vector3d(modelOffset).rotate(q))
        display.interpolationDuration = 3
        display.interpolationDelay = 0
        display.teleportDuration = 3
        display.transformation = createTransformation()
        display.teleport(Location(world, pos2.x, pos2.y, pos2.z))
    }

    override fun onKill() {
        cuboid.onKill()
        display.remove()
    }
}