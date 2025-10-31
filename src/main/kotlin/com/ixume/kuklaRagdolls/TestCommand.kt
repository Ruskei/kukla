package com.ixume.kuklaRagdolls

import com.ixume.kuklaRagdolls.udar.ItemDisplayCuboid
import com.ixume.udar.body.active.ActiveBody
import com.ixume.udar.body.active.Cuboid
import com.ixume.udar.body.active.tag.Tag
import com.ixume.udar.physicsWorld
import kr.toxicity.model.api.BetterModel
import kr.toxicity.model.api.util.TransformedItemStack
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabExecutor
import org.bukkit.craftbukkit.entity.CraftPlayer
import org.bukkit.entity.Player
import org.joml.Quaterniond
import org.joml.Vector3d
import org.joml.Vector3f
import kotlin.random.Random

object TestCommand : TabExecutor {
    fun init() {
        Bukkit.getPluginCommand("kukla")!!.setExecutor(this)
        Bukkit.getPluginCommand("kukla")!!.tabCompleter = this
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
        val skinManager = BetterModel.plugin().skinManager()
        val data = skinManager.getOrRequest((player as CraftPlayer).handle.gameProfile)
        val head = spawnObj(player, data.head(), "head")
        val chest = spawnObj(player, data.chest(), "chest")
        val waist = spawnObj(player, data.waist(), "waist")
        val hip = spawnObj(player, data.hip(), "hip")
        val rightArm = spawnObj(player, data.rightArm(), "rightArm")
        val rightForeArm = spawnObj(player, data.rightForeArm(), "rightForeArm")
        val leftArm = spawnObj(player, data.leftArm(), "leftArm")
        val leftForeArm = spawnObj(player, data.leftForeArm(), "leftForeArm")
        val rightLeg = spawnObj(player, data.rightLeg(), "rightLeg")
        val rightForeLeg = spawnObj(player, data.rightForeLeg(), "rightForeLeg")
        val leftLeg = spawnObj(player, data.leftLeg(), "leftLeg")
        val leftForeLeg = spawnObj(player, data.leftForeLeg(), "leftForeLeg")
        
        join(
            a = head,
            aName = "head",
            aPos = Vector3f(0.0f, -0.5f + MARGIN, 0.0f),
            b = chest,
            bName = "chest",
            bPos = Vector3f(0.0f, 0.5f - MARGIN, 0.0f),
            jA = Vector3f(0.0f, 1.0f, 0.0f),
            jB = Vector3f(0.0f, 1.0f, 0.0f),
            gA = Vector3f(0.0f, 0.0f, 1.0f),
            gB = Vector3f(0.0f, 0.0f, 1.0f),
            swingAngle = Math.toRadians(40.0).toFloat(),
            minTwistAngle = -Math.toRadians(70.0).toFloat(),
            maxTwistAngle = Math.toRadians(70.0).toFloat()
        )

        join(
            a = chest,
            aName = "chest",
            aPos = Vector3f(0.0f, -0.5f + MARGIN, 0.0f),
            b = waist,
            bName = "waist",
            bPos = Vector3f(0.0f, 0.5f - MARGIN, 0.0f),
            jA = Vector3f(0.0f, 1.0f, 0.0f),
            jB = Vector3f(0.0f, 1.0f, 0.0f),
            gA = Vector3f(0.0f, 0.0f, 1.0f),
            gB = Vector3f(0.0f, 0.0f, 1.0f),
            swingAngle = Math.toRadians(20.0).toFloat(),
            minTwistAngle = -Math.toRadians(10.0).toFloat(),
            maxTwistAngle = Math.toRadians(10.0).toFloat()
        )

        join(
            a = waist,
            aName = "waist",
            aPos = Vector3f(0.0f, -0.5f + MARGIN, 0.0f),
            b = hip,
            bName = "hip",
            bPos = Vector3f(0.0f, 0.5f - MARGIN, 0.0f),
            jA = Vector3f(0.0f, 1.0f, 0.0f),
            jB = Vector3f(0.0f, 1.0f, 0.0f),
            gA = Vector3f(0.0f, 0.0f, 1.0f),
            gB = Vector3f(0.0f, 0.0f, 1.0f),
            swingAngle = Math.toRadians(20.0).toFloat(),
            minTwistAngle = -Math.toRadians(10.0).toFloat(),
            maxTwistAngle = Math.toRadians(10.0).toFloat()
        )

        join(
            a = rightArm,
            aName = "rightArm",
            aPos = Vector3f(0.5f - MARGIN, 0.5f, 0.0f),
            b = chest,
            bName = "chest",
            bPos = Vector3f(-0.5f + MARGIN, 0.5f, 0.0f),
            jA = Vector3f(0.0f, -1.0f, 0.0f),
            jB = Vector3f(-1.0f, 0.0f, 0.0f),
            gA = Vector3f(1.0f, 0.0f, 0.0f),
            gB = Vector3f(0.0f, -1.0f, 0.0f),
            swingAngle = Math.toRadians(85.0).toFloat(),
            minTwistAngle = -Math.toRadians(5.0).toFloat(),
            maxTwistAngle = Math.toRadians(5.0).toFloat()
        )

        join(
            a = rightArm,
            aName = "rightArm",
            aPos = Vector3f(0.0f, -0.5f + MARGIN, 0.0f),
            b = rightForeArm,
            bName = "rightForeArm",
            bPos = Vector3f(0.0f, 0.5f - MARGIN, 0.0f),
            jA = Vector3f(1.0f, 0.0f, 0.0f),
            jB = Vector3f(1.0f, 0.0f, 0.0f),
            gA = Vector3f(0.0f, 1.0f, 0.0f),
            gB = Vector3f(0.0f, 1.0f, 0.0f),
            minAngle = -Math.toRadians(90.0).toFloat(),
            maxAngle = 0f,
        )

        join(
            a = leftArm,
            aName = "leftArm",
            aPos = Vector3f(-0.5f + MARGIN, 0.5f, 0.0f),
            b = chest,
            bName = "chest",
            bPos = Vector3f(0.5f - MARGIN, 0.5f, 0.0f),
            jA = Vector3f(0.0f, -1.0f, 0.0f),
            jB = Vector3f(1.0f, 0.0f, 0.0f),
            gA = Vector3f(-1.0f, 0.0f, 0.0f),
            gB = Vector3f(0.0f, -1.0f, 0.0f),
            swingAngle = Math.toRadians(85.0).toFloat(),
            minTwistAngle = -Math.toRadians(5.0).toFloat(),
            maxTwistAngle = Math.toRadians(5.0).toFloat()
        )

        join(
            a = leftArm,
            aName = "leftArm",
            aPos = Vector3f(0.0f, -0.5f + MARGIN, 0.0f),
            b = leftForeArm,
            bName = "leftForeArm",
            bPos = Vector3f(0.0f, 0.5f - MARGIN, 0.0f),
            jA = Vector3f(1.0f, 0.0f, 0.0f),
            jB = Vector3f(1.0f, 0.0f, 0.0f),
            gA = Vector3f(0.0f, 1.0f, 0.0f),
            gB = Vector3f(0.0f, 1.0f, 0.0f),
            minAngle = -Math.toRadians(90.0).toFloat(),
            maxAngle = 0f,
        )

        join(
            a = rightLeg,
            aName = "rightLeg",
            aPos = Vector3f(0.0f, 0.5f - MARGIN, 0.0f),
            b = hip,
            bName = "hip",
            bPos = Vector3f(-0.25f, -0.5f + MARGIN, 0.0f),
            jA = Vector3f(0.0f, 1.0f, 0.0f),
            jB = Vector3f(0.0f, 1.0f, 0.0f),
            gA = Vector3f(0.0f, 0.0f, 1.0f),
            gB = Vector3f(0.0f, 0.0f, 1.0f),
            swingAngle = Math.toRadians(80.0).toFloat(),
            minTwistAngle = -Math.toRadians(20.0).toFloat(),
            maxTwistAngle = Math.toRadians(20.0).toFloat(),
        )

        join(
            a = rightLeg,
            aName = "rightLeg",
            aPos = Vector3f(0.0f, -0.5f + MARGIN, 0.0f),
            b = rightForeLeg,
            bName = "rightForeLeg",
            bPos = Vector3f(0.0f, 0.5f - MARGIN, 0.0f),
            jA = Vector3f(1.0f, 0.0f, 0.0f),
            jB = Vector3f(1.0f, 0.0f, 0.0f),
            gA = Vector3f(0.0f, 1.0f, 0.0f),
            gB = Vector3f(0.0f, 1.0f, 0.0f),
            minAngle = 0f,
            maxAngle = Math.toRadians(90.0).toFloat(),
        )

        join(
            a = leftLeg,
            aName = "leftLeg",
            aPos = Vector3f(0.0f, 0.5f - MARGIN, 0.0f),
            b = hip,
            bName = "hip",
            bPos = Vector3f(0.25f, -0.5f + MARGIN, 0.0f),
            jA = Vector3f(0.0f, 1.0f, 0.0f),
            jB = Vector3f(0.0f, 1.0f, 0.0f),
            gA = Vector3f(0.0f, 0.0f, 1.0f),
            gB = Vector3f(0.0f, 0.0f, 1.0f),
            swingAngle = Math.toRadians(80.0).toFloat(),
            minTwistAngle = -Math.toRadians(20.0).toFloat(),
            maxTwistAngle = Math.toRadians(20.0).toFloat(),
        )

        join(
            a = leftLeg,
            aName = "leftLeg",
            aPos = Vector3f(0.0f, -0.5f + MARGIN, 0.0f),
            b = leftForeLeg,
            bName = "leftForeLeg",
            bPos = Vector3f(0.0f, 0.5f - MARGIN, 0.0f),
            jA = Vector3f(1.0f, 0.0f, 0.0f),
            jB = Vector3f(1.0f, 0.0f, 0.0f),
            gA = Vector3f(0.0f, 1.0f, 0.0f),
            gB = Vector3f(0.0f, 1.0f, 0.0f),
            minAngle = 0f,
            maxAngle = Math.toRadians(90.0).toFloat(),
        )

        return true
    }

    private val tag = Tag("kukla_" + Random.nextInt(), collide = false)

    private fun spawnObj(player: Player, stack: TransformedItemStack, name: String): ActiveBody {
        val offset = offsets[name]!!
        val mOffset = modelOffsets[name]!!
        val dims = dimensions[name]!!
        val rot = Quaterniond()//.rotationZ(Math.PI * 0.25)
        val isLocked = false
        val body =
            ItemDisplayCuboid(
                Cuboid(
                    world = player.world,
                    pos = player.location.toVector().toVector3d().add(
                        Vector3d(
                            (-offset.x / 16f + mOffset.x / 16f).toDouble(),
                            (offset.y / 16f - 1.8f + dims.y / 16f / 2f + mOffset.y / 16f).toDouble(),
                            (offset.z / 16f + mOffset.z / 16f).toDouble(),
                        ).rotate(rot)
                    ),
                    velocity = Vector3d(),
                    q = Quaterniond(rot),
                    omega = Vector3d(),
                    width = dims.x.toDouble() / 16,
                    height = dims.y.toDouble() / 16,
                    length = dims.z.toDouble() / 16,
                    density = if (isLocked) 1_000_000.0 else 1.0,
                    hasGravity = !isLocked,
                )/*.blockEntity(Material.GLASS)*/,
                stack = stack.itemStack,
                modelOffset = Vector3d(0.0, -dims.y / 16.0 / 2.0, 0.0).sub(
                    (mOffset.x / 16f).toDouble(),
                    (mOffset.y / 16f).toDouble(),
                    (mOffset.z / 16f).toDouble(),
                )
            )

        body.tags += tag
        player.world.physicsWorld?.registerBody(body)

        return body
    }

    private fun join(
        a: ActiveBody,
        aName: String,
        aPos: Vector3f,
        b: ActiveBody,
        bName: String,
        bPos: Vector3f,
        jA: Vector3f,
        jB: Vector3f,
        gA: Vector3f,
        gB: Vector3f,
        swingAngle: Float,
        minTwistAngle: Float,
        maxTwistAngle: Float,
    ) {
        a.physicsWorld.sphericalJointConstraints.addConstraint(
            a = a,
            ra = Vector3d(dimensions[aName]!!).mul(aPos).mul(1 / 16.0),
            b = b,
            rb = Vector3d(dimensions[bName]!!).mul(bPos).mul(1 / 16.0),
        )
        a.physicsWorld.angularConstraints.addConstraint(
            a = a,
            b = b,
            jA = jA,
            jB = jB,
            gA = gA,
            gB = gB,
            swingAngle = swingAngle,
            minTwistAngle = minTwistAngle,
            maxTwistAngle = maxTwistAngle,
        )
    }

    private fun join(
        a: ActiveBody,
        aName: String,
        aPos: Vector3f,
        b: ActiveBody,
        bName: String,
        bPos: Vector3f,
        jA: Vector3f,
        jB: Vector3f,
        gA: Vector3f,
        gB: Vector3f,
        minAngle: Float,
        maxAngle: Float,
    ) {
        a.physicsWorld.sphericalJointConstraints.addConstraint(
            a = a,
            ra = Vector3d(dimensions[aName]!!).mul(aPos).mul(1 / 16.0),
            b = b,
            rb = Vector3d(dimensions[bName]!!).mul(bPos).mul(1 / 16.0),
        )
        a.physicsWorld.angularConstraints.addConstraint(
            a = a,
            b = b,
            bodyAAxis = jA,
            bodyBAxis = jB,
        )
        a.physicsWorld.angularConstraints.addConstraint(
            a = a,
            b = b,
            jA = jA,
            jB = jB,
            gA = gA,
            gB = gB,
            minAngle = minAngle,
            maxAngle = maxAngle,
        )
    }

    private val offsets = mapOf(
        "head" to Vector3f(0f, 22.5f, 0f),
        "chest" to Vector3f(0f, 18.75f, 0f),
        "waist" to Vector3f(0f, 15f, 0f),
        "hip" to Vector3f(0f, 11.25f, 0f),
        "rightArm" to Vector3f(5f, 22f, 0f),
        "rightForeArm" to Vector3f(5f, 16.5f, 0f),
        "leftArm" to Vector3f(-5f, 22f, 0f),
        "leftForeArm" to Vector3f(-5f, 16.5f, 0f),
        "rightLeg" to Vector3f(1.875f, 11.25f, 0f),
        "rightForeLeg" to Vector3f(1.875f, 5.625f, 0f),
        "leftLeg" to Vector3f(-1.875f, 11.25f, 0f),
        "leftForeLeg" to Vector3f(-1.875f, 5.625f, 0f),
    )

    private val modelOffsets = mapOf(
        "head" to Vector3f(0f),
        "chest" to Vector3f(0f),
        "waist" to Vector3f(0f),
        "hip" to Vector3f(0f),
        "rightArm" to Vector3f(0f, -5.625f, 0f),
        "rightForeArm" to Vector3f(0f, -5.625f, 0f),
        "leftArm" to Vector3f(0f, -5.625f, 0f),
        "leftForeArm" to Vector3f(0f, -5.625f, 0f),
        "rightLeg" to Vector3f(0f, -5.625f, 0f),
        "rightForeLeg" to Vector3f(0f, -5.625f, 0f),
        "leftLeg" to Vector3f(0f, -5.625f, 0f),
        "leftForeLeg" to Vector3f(0f, -5.625f, 0f)
    )

    private val dimensions = mapOf(
        "head" to Vector3f(7.5f, 7.5f, 7.5f),
        "chest" to Vector3f(7.5f, 3.75f, 3.75f),
        "waist" to Vector3f(7.5f, 3.75f, 3.75f),
        "hip" to Vector3f(7.5f, 3.75f, 3.75f),
        "rightArm" to Vector3f(3.75f, 5.625f, 3.75f),
        "rightForeArm" to Vector3f(3.75f, 5.625f, 3.75f),
        "leftArm" to Vector3f(3.75f, 5.625f, 3.75f),
        "leftForeArm" to Vector3f(3.75f, 5.625f, 3.75f),
        "rightLeg" to Vector3f(3.75f, 5.625f, 3.75f),
        "rightForeLeg" to Vector3f(3.75f, 5.625f, 3.75f),
        "leftLeg" to Vector3f(3.75f, 5.625f, 3.75f),
        "leftForeLeg" to Vector3f(3.75f, 5.625f, 3.75f)
    )
}

private const val MARGIN = 0.05f