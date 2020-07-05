package rocks.sakira.gentlefawn.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTables;
import rocks.sakira.gentlefawn.GentleFawn;
import rocks.sakira.gentlefawn.register.Entities;
import rocks.sakira.gentlefawn.utils.ConfigurationHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;

public class EntityDeer extends AnimalEntity {
    private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.WHEAT);
    public short rotationHead;
    private boolean moveHead = false;
    private static final Random rand = new Random();

    private static DataParameter<String> TYPE = EntityDataManager.createKey(EntityDeer.class, DataSerializers.STRING);

    private static SoundEvent buckSound = new SoundEvent(new ResourceLocation(GentleFawn.MOD_ID, "entity.deer.buck.sound"));
    private static SoundEvent doeSound = new SoundEvent(new ResourceLocation(GentleFawn.MOD_ID, "entity.deer.doe.sound"));
    private static SoundEvent fawnSound = new SoundEvent(new ResourceLocation(GentleFawn.MOD_ID, "entity.deer.fawn.sound"));

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
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        ILivingEntityData data = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);

        if (getTextureName().trim().equals("")) {
            if (rand.nextInt(100) <= 19) {  // 20%
                setTextureName("buck");
            } else {
                setTextureName("doe");
            }
        }

        return data;
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);

        compound.putString("Type", dataManager.get(TYPE));
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);

        dataManager.set(TYPE, compound.getString("Type"));
    }

    public String getTextureName() {
        return dataManager.get(TYPE);
    }

    public void setTextureName(String name) {
        dataManager.set(TYPE, name);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.5D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 0.8D));
        this.goalSelector.addGoal(4, new AvoidEntityGoal(this, WolfEntity.class, 6.0F, 1.0D, 1.2D));
        this.goalSelector.addGoal(5, new TemptGoal(this, 1.0D, false, TEMPTATION_ITEMS));
        this.goalSelector.addGoal(6, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(7, new RandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(9, new LookAtGoal(this, EntityDeer.class, 6.0F));
        this.goalSelector.addGoal(10, new LookRandomlyGoal(this));
    }

    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return super.canSpawn(worldIn, spawnReasonIn);
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.16D);
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
    protected int getExperiencePoints(PlayerEntity player) {
        if (ConfigurationHandler.GENERAL.dropExp.get()) {
            return super.getExperiencePoints(player);
        }
        return 0;
    }

    @Override
    public boolean canBreatheUnderwater() { return true; }

    @Override
    public boolean isBreedingItem(@Nonnull ItemStack stack) { return !stack.isEmpty() && TEMPTATION_ITEMS.test(stack); }

    @Override
    public EntitySize getSize(Pose poseIn) {
        EntitySize size = super.getSize(poseIn);

        return this.isChild() ? size.scale(0.66F) : size;
    }

    @Override
    @Nonnull
    public ResourceLocation getLootTable() {
        return ConfigurationHandler.GENERAL.dropBeef.get() ? super.getLootTable() : LootTables.EMPTY;
    }

    @Override
    public EntityDeer createChild(@Nonnull AgeableEntity ageable) {
        return Entities.DEER_ENTITY.get().create(this.world);
    }

    @Override
    protected float getStandingEyeHeight(Pose pose, EntitySize size) { return this.isChild() ? 1.0F : 1.5F; }

    @Override
    protected SoundEvent getAmbientSound() {
        if (this.isChild()) return fawnSound;
        if (this.getTextureName().equals("buck")) return buckSound;

        return doeSound;
    }
}
