package rocks.sakira.gentlefawn.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import rocks.sakira.gentlefawn.GentleFawn;
import rocks.sakira.gentlefawn.register.Entities;
import rocks.sakira.gentlefawn.register.SoundEvents;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;

public class EntityDeer extends AnimalEntity {
    private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.WHEAT);
    public short rotationHead;
    private boolean moveHead = false;
    private static final Random rand = new Random();

    private static final DataParameter<String> TYPE = EntityDataManager.createKey(EntityDeer.class, DataSerializers.STRING);

    public EntityDeer(EntityType<? extends EntityDeer> deer, World world) {
        super(deer, world);

        this.stepHeight = 1.4F;
    }

    @Override
    protected void registerData() {
        super.registerData();

        getDataManager().register(TYPE, "");
    }

    @Override
    public ILivingEntityData onInitialSpawn(@Nonnull IWorld worldIn, @Nonnull DifficultyInstance difficultyIn, @Nonnull SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        ILivingEntityData data = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);

        if (dataManager.isEmpty() || getTextureName().trim().isEmpty()) {
            if (rand.nextInt(100) <= 19) {  // 20%
                setTextureName("buck");
            } else {
                setTextureName("doe");
            }
        }

        return data;
    }

    @Override
    public void writeAdditional(@Nonnull CompoundNBT compound) {
        super.writeAdditional(compound);

        compound.putString("Type", dataManager.get(TYPE));
    }

    @Override
    public void readAdditional(@Nonnull CompoundNBT compound) {
        super.readAdditional(compound);

        dataManager.set(TYPE, compound.getString("Type"));
    }

    public String getTextureName() {
        String textureName = dataManager.get(TYPE);

        if (textureName.isEmpty()) {
            if (rand.nextInt(100) <= 19) {  // 20%
                setTextureName("buck");

                return "buck";
            } else {
                setTextureName("doe");

                return "doe";
            }
        }

        return textureName;
    }

    public void setTextureName(String name) {
        dataManager.set(TYPE, name);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.5D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 0.8D));
        this.goalSelector.addGoal(4, new AvoidEntityGoal<>(this, WolfEntity.class, 6.0F, 1.0D, 1.2D));
        this.goalSelector.addGoal(5, new TemptGoal(this, 1.0D, false, TEMPTATION_ITEMS));
        this.goalSelector.addGoal(6, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(9, new LookAtGoal(this, EntityDeer.class, 6.0F));
        this.goalSelector.addGoal(10, new LookRandomlyGoal(this));
    }

    @Override
    public boolean canSpawn(@Nonnull IWorld worldIn, @Nonnull SpawnReason spawnReasonIn) {
        return super.canSpawn(worldIn, spawnReasonIn);
    }

    @Override
    public void livingTick() {
        super.livingTick();
        if (this.world.isRemote) {
            if (this.getPosX() != this.prevPosZ) {
                if (this.moveHead) {
                    this.rotationHead++;

                }
            }
        }
    }

    @Override
    public boolean isBreedingItem(@Nonnull ItemStack stack) {
        return !stack.isEmpty() && TEMPTATION_ITEMS.test(stack);
    }

    @Override @Nonnull
    public EntitySize getSize(@Nonnull Pose poseIn) {
        EntitySize size = super.getSize(poseIn);

        return this.isChild() ? size.scale(0.66F) : size;
    }

    @Override
    public EntityDeer createChild(@Nonnull AgeableEntity ageable) {
        return Entities.DEER_ENTITY.get().create(this.world);
    }

    @Override
    protected float getStandingEyeHeight(@Nonnull Pose pose, @Nonnull EntitySize size) {
        return this.isChild() ? 1.0F : 1.5F;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(@Nonnull DamageSource damageSourceIn) {
        if (this.isChild()) return SoundEvents.FAWN_SOUND.get();
        if (this.getTextureName().equals("buck")) return SoundEvents.BUCK_SOUND.get();

        return SoundEvents.DOE_SOUND.get();
    }


    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(rocks.sakira.gentlefawn.register.Items.DEER_SPAWN_EGG.get());
    }

    public void dropHead() {
        if (this.getTextureName().equals("buck")) {
            this.entityDropItem(new ItemStack(rocks.sakira.gentlefawn.register.Items.BUCK_HEAD_ITEM.get(), 1));
        } else {
            this.entityDropItem(new ItemStack(rocks.sakira.gentlefawn.register.Items.DOE_HEAD_ITEM.get(), 1));
        }
    }

    @Override
    public void onDeath(@Nonnull DamageSource cause) {
        super.onDeath(cause);

        Entity damageSource = cause.getImmediateSource();

        if (damageSource != null && !this.isChild()) {
            if (damageSource.getType().equals(EntityType.CREEPER)) {
                // Mobs always drop heads when killed by a charged creeper
                CreeperEntity creeper = (CreeperEntity) damageSource;

                if (creeper.isCharged() && cause.isExplosion()) {
                    dropHead();

                    return;
                }
            }

            if (damageSource.getType().equals(EntityType.SPECTRAL_ARROW)) {
                // Give a lowered chance of obtaining the head when a spectral arrow is used
                if (damageSource.world.rand.nextInt(4) == 0) {
                    dropHead();
                }
            }
        }
    }
}
