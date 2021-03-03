package io.github.faecraft.gentlefawn.entity

import io.github.faecraft.gentlefawn.register.Entities
import io.github.faecraft.gentlefawn.register.Sounds
import net.minecraft.entity.EntityDimensions
import net.minecraft.entity.EntityPose
import net.minecraft.entity.EntityType
import net.minecraft.entity.ai.goal.*
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.data.DataTracker
import net.minecraft.entity.data.TrackedData
import net.minecraft.entity.data.TrackedDataHandlerRegistry
import net.minecraft.entity.mob.CreeperEntity
import net.minecraft.entity.passive.AnimalEntity
import net.minecraft.entity.passive.PassiveEntity
import net.minecraft.entity.passive.WolfEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.nbt.CompoundTag
import net.minecraft.recipe.Ingredient
import net.minecraft.server.world.ServerWorld
import net.minecraft.sound.SoundEvent
import net.minecraft.world.World

class DeerEntity(entityType: EntityType<out AnimalEntity>, world: World?) : AnimalEntity(entityType, world) {
    companion object {
        val TYPE: TrackedData<String> = DataTracker.registerData(DeerEntity::class.java, TrackedDataHandlerRegistry.STRING)
        val TEMPTATION_ITEMS = Ingredient.ofItems(Items.WHEAT)
    }

    init {
        stepHeight = 1.4F
    }

    override fun initGoals() {
        goalSelector.add(0, SwimGoal(this))
        goalSelector.add(1, EscapeDangerGoal(this, 1.5))
        goalSelector.add(2, AnimalMateGoal(this, 0.8))
        goalSelector.add(3, FleeEntityGoal(this, WolfEntity::class.java, 6.0F, 1.0, 1.2))
        goalSelector.add(4, TemptGoal(this, 1.0, false, TEMPTATION_ITEMS))
        goalSelector.add(5, FollowParentGoal(this, 1.1))
        goalSelector.add(6, WanderAroundFarGoal(this, 1.0))
        goalSelector.add(7, LookAtEntityGoal(this, PlayerEntity::class.java, 6.0F))
        goalSelector.add(8, LookAtEntityGoal(this, DeerEntity::class.java, 6.0F))
        goalSelector.add(9, LookAroundGoal(this))
    }

    override fun initDataTracker() {
        super.initDataTracker()

        dataTracker.startTracking(TYPE, randomType())
    }

    fun getDeerType(): String = dataTracker.get(TYPE)

    private fun randomType(): String {
        val random = this.world.random.nextInt(100)

        return if (random <= 16) {
            "buck"
        } else {
            "doe"
        }
    }

    override fun readCustomDataFromTag(tag: CompoundTag) {
        super.readCustomDataFromTag(tag)

        dataTracker.set(TYPE, tag.getString("Type"))
    }

    override fun writeCustomDataToTag(tag: CompoundTag) {
        super.writeCustomDataToTag(tag)

        tag.putString("Type", dataTracker.get(TYPE))
    }

    override fun getDimensions(pose: EntityPose?): EntityDimensions {
        val dimensions = super.getDimensions(pose)

        return if (this.isBaby) {
            dimensions.scaled(0.66F)
        } else {
            dimensions
        }
    }

    override fun getHurtSound(source: DamageSource?): SoundEvent = when {
        this.isBaby -> Sounds.FAWN_SOUND
        getDeerType() == "buck" -> Sounds.BUCK_SOUND

        else -> Sounds.DOE_SOUND
    }

    private fun getHeadItem(): ItemStack = if (getDeerType() == "buck") {
        ItemStack(io.github.faecraft.gentlefawn.register.Items.BUCK_HEAD, 1)
    } else {
        ItemStack(io.github.faecraft.gentlefawn.register.Items.DOE_HEAD, 1)
    }

    override fun dropEquipment(source: DamageSource, lootingMultiplier: Int, allowDrops: Boolean) {
        super.dropEquipment(source, lootingMultiplier, allowDrops)

        val attacker = source.attacker

        if (attacker is CreeperEntity) {
            if (attacker.shouldDropHead()) {
                attacker.onHeadDropped()

                dropStack(getHeadItem())
            }
        } else {
            val sourceEntity = source.source ?: return

            if (sourceEntity.type == EntityType.SPECTRAL_ARROW) {
                if (world.random.nextInt(4) == 0) {
                    dropStack(getHeadItem())
                }
            }
        }
    }

    override fun getActiveEyeHeight(pose: EntityPose, dimensions: EntityDimensions): Float =
        if (this.isBaby) 1.0F else 1.5F

    override fun createChild(world: ServerWorld, entity: PassiveEntity): PassiveEntity? = Entities.DEER.create(world)
    override fun isBreedingItem(stack: ItemStack): Boolean = (!stack.isEmpty) && TEMPTATION_ITEMS.test(stack)
}
