package com.ixume.kuklaRagdolls

import com.ixume.udar.body.active.ActiveBody

@JvmRecord
data class Ragdoll(
    val head: ActiveBody,
    val chest: ActiveBody,
    val waist: ActiveBody,
    val hip: ActiveBody,
    val rightArm: ActiveBody,
    val rightForeArm: ActiveBody,
    val leftArm: ActiveBody,
    val leftForeArm: ActiveBody,
    val rightLeg: ActiveBody,
    val rightForeLeg: ActiveBody,
    val leftLeg: ActiveBody,
    val leftForeLeg: ActiveBody,
)

@JvmRecord
data class VanillaRagdoll(
    val head: ActiveBody,
    val body: ActiveBody,
    val rightArm: ActiveBody,
    val leftArm: ActiveBody,
    val rightLeg: ActiveBody,
    val leftLeg: ActiveBody,
)
