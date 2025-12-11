package com.ixume.kuklaRagdolls

import com.ixume.kuklaRagdolls.udar.ItemDisplayCuboid
import com.ixume.udar.body.active.ActiveBody
import com.ixume.udar.body.active.Cuboid
import com.ixume.udar.body.active.tag.Tag
import com.ixume.udar.physics.cone.ConeConstraint
import com.ixume.udar.physics.hinge.HingeConstraint
import com.ixume.udar.physicsWorld
import kr.toxicity.model.api.BetterModel
import kr.toxicity.model.api.util.TransformedItemStack
import org.bukkit.craftbukkit.entity.CraftPlayer
import org.bukkit.entity.Player
import org.joml.Quaterniond
import org.joml.Vector3d
import org.joml.Vector3f

object RagdollCreator {
    fun create(player: Player): Ragdoll {
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

        joinCone(
            a = head,
            aName = "head",
            aPos = Vector3f(0.0f, -0.5f + MARGIN, 0.0f),
            b = chest,
            bName = "chest",
            bPos = Vector3f(0.0f, 0.5f - MARGIN, 0.0f),
            x1 = Vector3f(1f, 0f, 0f),
            y1 = Vector3f(0f, 0f, 1f),
            x2 = Vector3f(1f, 0f, 0f),
            z2 = Vector3f(0f, -1f, 0f),
            maxXAngle = Math.toRadians(40.0).toFloat(),
            maxYAngle = Math.toRadians(40.0).toFloat(),
            minTwistAngle = -Math.toRadians(60.0).toFloat(),
            maxTwistAngle = Math.toRadians(60.0).toFloat()
        )

        joinCone(
            a = chest,
            aName = "chest",
            aPos = Vector3f(0.0f, -0.5f + MARGIN, 0.0f),
            b = waist,
            bName = "waist",
            bPos = Vector3f(0.0f, 0.5f - MARGIN, 0.0f),
            x1 = Vector3f(1f, 0f, 0f),
            y1 = Vector3f(0f, 0f, 1f),
            x2 = Vector3f(1f, 0f, 0f),
            z2 = Vector3f(0f, -1f, 0f),
            maxXAngle = Math.toRadians(20.0).toFloat(),
            maxYAngle = Math.toRadians(20.0).toFloat(),
            minTwistAngle = -Math.toRadians(10.0).toFloat(),
            maxTwistAngle = Math.toRadians(10.0).toFloat()
        )

        joinCone(
            a = waist,
            aName = "waist",
            aPos = Vector3f(0.0f, -0.5f + MARGIN, 0.0f),
            b = hip,
            bName = "hip",
            bPos = Vector3f(0.0f, 0.5f - MARGIN, 0.0f),
            x1 = Vector3f(1f, 0f, 0f),
            y1 = Vector3f(0f, 0f, 1f),
            x2 = Vector3f(1f, 0f, 0f),
            z2 = Vector3f(0f, -1f, 0f),
            maxXAngle = Math.toRadians(20.0).toFloat(),
            maxYAngle = Math.toRadians(20.0).toFloat(),
            minTwistAngle = -Math.toRadians(10.0).toFloat(),
            maxTwistAngle = Math.toRadians(10.0).toFloat()
        )
//
        joinCone(
            a = chest,
            aName = "chest",
            aPos = Vector3f(-0.5f + MARGIN, 0.5f, 0.0f),
            b = rightArm,
            bName = "rightArm",
            bPos = Vector3f(0.5f - MARGIN, 0.5f, 0.0f),
            x1 = Vector3f(1f, 0f, 0f),
            y1 = Vector3f(0f, 0f, 1f),
            x2 = Vector3f(1f, 0f, 0f),
            z2 = Vector3f(0f, -1f, 0f),
            maxXAngle = Math.toRadians(85.0).toFloat(),
            maxYAngle = Math.toRadians(80.0).toFloat(),
            minTwistAngle = -Math.toRadians(30.0).toFloat(),
            maxTwistAngle = Math.toRadians(30.0).toFloat()
        )

        joinCone(
            a = chest,
            aName = "chest",
            aPos = Vector3f(0.5f - MARGIN, 0.5f, 0.0f),
            b = leftArm,
            bName = "leftArm",
            bPos = Vector3f(-0.5f + MARGIN, 0.5f, 0.0f),
            x1 = Vector3f(1f, 0f, 0f),
            y1 = Vector3f(0f, 0f, 1f),
            x2 = Vector3f(1f, 0f, 0f),
            z2 = Vector3f(0f, -1f, 0f),
            maxXAngle = Math.toRadians(85.0).toFloat(),
            maxYAngle = Math.toRadians(80.0).toFloat(),
            minTwistAngle = -Math.toRadians(30.0).toFloat(),
            maxTwistAngle = Math.toRadians(30.0).toFloat()
        )

        joinHinge(
            a = rightArm,
            aName = "rightArm",
            aPos = Vector3f(0.0f, -0.5f + MARGIN, 0.0f),
            b = rightForeArm,
            bName = "rightForeArm",
            bPos = Vector3f(0.0f, 0.5f - MARGIN, 0.0f),
            a1 = Vector3f(1f, 0f, 0f),
            n1 = Vector3f(0f, 1f, 0f),
            a2 = Vector3f(1f, 0f, 0f),
            n2 = Vector3f(0f, 1f, 0f),
            minAngle = 0f,
            maxAngle = Math.toRadians(150.0).toFloat()
        )

        joinHinge(
            a = leftArm,
            aName = "leftArm",
            aPos = Vector3f(0.0f, -0.5f + MARGIN, 0.0f),
            b = leftForeArm,
            bName = "leftForeArm",
            bPos = Vector3f(0.0f, 0.5f - MARGIN, 0.0f),
            a1 = Vector3f(1f, 0f, 0f),
            n1 = Vector3f(0f, 1f, 0f),
            a2 = Vector3f(1f, 0f, 0f),
            n2 = Vector3f(0f, 1f, 0f),
            minAngle = 0f,
            maxAngle = Math.toRadians(150.0).toFloat()
        )

        joinCone(
            a = rightLeg,
            aName = "rightLeg",
            aPos = Vector3f(0.0f, 0.5f - MARGIN, 0.0f),
            b = hip,
            bName = "hip",
            bPos = Vector3f(-0.25f, -0.5f + MARGIN, 0.0f),
            x1 = Vector3f(1f, 0f, 0f),
            y1 = Vector3f(0f, 0f, 1f),
            x2 = Vector3f(1f, 0f, 0f),
            z2 = Vector3f(0f, -1f, 0f),
            maxXAngle = Math.toRadians(70.0).toFloat(),
            maxYAngle = Math.toRadians(20.0).toFloat(),
            minTwistAngle = -Math.toRadians(10.0).toFloat(),
            maxTwistAngle = Math.toRadians(10.0).toFloat()
        )

        joinHinge(
            a = rightLeg,
            aName = "rightLeg",
            aPos = Vector3f(0.0f, -0.5f + MARGIN, 0.0f),
            b = rightForeLeg,
            bName = "rightForeLeg",
            bPos = Vector3f(0.0f, 0.5f - MARGIN, 0.0f),
            a1 = Vector3f(1f, 0f, 0f),
            n1 = Vector3f(0f, 1f, 0f),
            a2 = Vector3f(1f, 0f, 0f),
            n2 = Vector3f(0f, 1f, 0f),
            minAngle = 0f,
            maxAngle = Math.toRadians(80.0).toFloat()
        )

        joinCone(
            a = leftLeg,
            aName = "leftLeg",
            aPos = Vector3f(0.0f, 0.5f - MARGIN, 0.0f),
            b = hip,
            bName = "hip",
            bPos = Vector3f(0.25f, -0.5f + MARGIN, 0.0f),
            x1 = Vector3f(1f, 0f, 0f),
            y1 = Vector3f(0f, 0f, 1f),
            x2 = Vector3f(1f, 0f, 0f),
            z2 = Vector3f(0f, -1f, 0f),
            maxXAngle = Math.toRadians(70.0).toFloat(),
            maxYAngle = Math.toRadians(20.0).toFloat(),
            minTwistAngle = -Math.toRadians(10.0).toFloat(),
            maxTwistAngle = Math.toRadians(10.0).toFloat()
        )

        joinHinge(
            a = leftLeg,
            aName = "leftLeg",
            aPos = Vector3f(0.0f, -0.5f + MARGIN, 0.0f),
            b = leftForeLeg,
            bName = "leftForeLeg",
            bPos = Vector3f(0.0f, 0.5f - MARGIN, 0.0f),
            a1 = Vector3f(1f, 0f, 0f),
            n1 = Vector3f(0f, 1f, 0f),
            a2 = Vector3f(1f, 0f, 0f),
            n2 = Vector3f(0f, 1f, 0f),
            minAngle = 0f,
            maxAngle = Math.toRadians(80.0).toFloat()
        )

        return Ragdoll(
            head,
            chest,
            waist,
            hip,
            rightArm,
            rightForeArm,
            leftArm,
            leftForeArm,
            rightLeg,
            rightForeLeg,
            leftLeg,
            leftForeLeg,
        )
    }

    private fun spawnObj(player: Player, stack: TransformedItemStack, name: String): ActiveBody {
        val offset = offsets[name]!!
        val mOffset = modelOffsets[name]!!
        val dims = dimensions[name]!!
        val rot = Quaterniond()
        if (name == "head") {
            rot.rotationY(Math.toRadians(-player.yaw.toDouble()))
            rot.rotateX(Math.toRadians(player.pitch.toDouble()))
        } else {
            rot.rotationY(Math.toRadians(-player.bodyYaw.toDouble()))
        }

        val isLocked = false//name == "head"
        val body =
            ItemDisplayCuboid(
                Cuboid(
                    world = player.world,
                    pos = player.location.toVector().toVector3d().add(
                        Vector3d(
                            (-offset.x / 16f + mOffset.x / 16f).toDouble(),
                            (dims.y / 16f / 2f).toDouble(),
                            (offset.z / 16f + mOffset.z / 16f).toDouble(),
                        )
                            .rotate(rot)
                            .add(0.0, offset.y / 16.0 + mOffset.y / 16.0 + 0.15, 0.0)
                    ),
                    velocity = Vector3d(),
                    q = Quaterniond(rot),
                    omega = Vector3d(),
                    width = dims.x.toDouble() / 16,
                    height = dims.y.toDouble() / 16,
                    length = dims.z.toDouble() / 16,
                    density = if (isLocked) 1_00_000.0 else 1.0,
                    hasGravity = !isLocked,
                )/*.blockEntity(Material.GLASS)*/,
                stack = stack.itemStack,
                modelOffset = Vector3d(0.0, -dims.y / 16.0 / 2.0, 0.0).sub(
                    (mOffset.x / 16f).toDouble(),
                    (mOffset.y / 16f).toDouble(),
                    (mOffset.z / 16f).toDouble(),
                )
            )

        player.world.physicsWorld?.registerBody(body)

        return body
    }

    private fun joinCone(
        a: ActiveBody,
        aName: String,
        aPos: Vector3f,
        b: ActiveBody,
        bName: String,
        bPos: Vector3f,
        x1: Vector3f,
        y1: Vector3f,
        x2: Vector3f,
        z2: Vector3f,
        maxXAngle: Float,
        maxYAngle: Float,
        minTwistAngle: Float,
        maxTwistAngle: Float,
    ) {
        val tag = Tag("kukla_$aName+$bName", collide = false)
        a.tags += tag
        b.tags += tag
        a.physicsWorld.constraintManager.constrain(
            ConeConstraint(
                b1 = a,
                r1x = dimensions[aName]!!.x * aPos.x / 16f,
                r1y = dimensions[aName]!!.y * aPos.y / 16f,
                r1z = dimensions[aName]!!.z * aPos.z / 16f,
                b2 = b,
                r2x = dimensions[bName]!!.x * bPos.x / 16f,
                r2y = dimensions[bName]!!.y * bPos.y / 16f,
                r2z = dimensions[bName]!!.z * bPos.z / 16f,

                x1x = x1.x,
                x1y = x1.y,
                x1z = x1.z,

                y1x = y1.x,
                y1y = y1.y,
                y1z = y1.z,

                x2x = x2.x,
                x2y = x2.y,
                x2z = x2.z,

                z2x = z2.x,
                z2y = z2.y,
                z2z = z2.z,

                maxXAngle = maxXAngle,
                maxYAngle = maxYAngle,

                minTwistAngle = minTwistAngle,
                maxTwistAngle = maxTwistAngle,
            )
        )
    }

    private fun joinHinge(
        a: ActiveBody,
        aName: String,
        aPos: Vector3f,
        b: ActiveBody,
        bName: String,
        bPos: Vector3f,
        a1: Vector3f,
        n1: Vector3f,
        a2: Vector3f,
        n2: Vector3f,
        minAngle: Float,
        maxAngle: Float,
    ) {
        val tag = Tag("kukla_$aName+$bName", collide = false)
        a.tags += tag
        b.tags += tag
        a.physicsWorld.constraintManager.constrain(
            HingeConstraint(
                b1 = a,
                r1x = dimensions[aName]!!.x * aPos.x / 16f,
                r1y = dimensions[aName]!!.y * aPos.y / 16f,
                r1z = dimensions[aName]!!.z * aPos.z / 16f,
                b2 = b,
                r2x = dimensions[bName]!!.x * bPos.x / 16f,
                r2y = dimensions[bName]!!.y * bPos.y / 16f,
                r2z = dimensions[bName]!!.z * bPos.z / 16f,

                a1x = a1.x,
                a1y = a1.y,
                a1z = a1.z,

                a2x = a2.x,
                a2y = a2.y,
                a2z = a2.z,

                n1x = n1.x,
                n1y = n1.y,
                n1z = n1.z,

                n2x = n2.x,
                n2y = n2.y,
                n2z = n2.z,

                min = minAngle,
                max = maxAngle,
            )
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

private const val MARGIN = 0.1f
