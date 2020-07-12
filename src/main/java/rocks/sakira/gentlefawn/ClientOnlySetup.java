package rocks.sakira.gentlefawn;

import net.minecraft.block.SkullBlock;
import net.minecraft.client.renderer.entity.model.GenericHeadModel;
import net.minecraft.client.renderer.tileentity.SkullTileEntityRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rocks.sakira.gentlefawn.block.DeerSkullBlock;
import rocks.sakira.gentlefawn.block.model.BuckHeadModel;
import rocks.sakira.gentlefawn.block.model.DoeHeadModel;

import java.lang.reflect.Field;
import java.util.HashMap;

public class ClientOnlySetup {
    private static final Logger LOGGER = LogManager.getLogger();

    @OnlyIn(Dist.CLIENT)
    public static void setupSkullRenderer() throws NoSuchFieldException, IllegalAccessException {
        // This is hacky, but the best way to make everything work with minimal extra code.
        // This is likely to break between major Forge versions.

        Field models, skins;

        try {
            // Attempt to grab the obfuscated references
            models = SkullTileEntityRenderer.class.getDeclaredField("field_199358_e");
            skins = SkullTileEntityRenderer.class.getDeclaredField("field_199357_d");
        } catch (NoSuchFieldException e) {
            models = SkullTileEntityRenderer.class.getDeclaredField("MODELS");
            skins = SkullTileEntityRenderer.class.getDeclaredField("SKINS");
        }

        try {
            // Bypass `private` access modifiers.
            models.setAccessible(true);
            skins.setAccessible(true);

            // Get at the underlying HashMaps
            HashMap<SkullBlock.ISkullType, GenericHeadModel> modelsMap =
                    (HashMap<SkullBlock.ISkullType, GenericHeadModel>) models.get(SkullTileEntityRenderer.class);

            HashMap<SkullBlock.ISkullType, ResourceLocation> skinsMap =
                    (HashMap<SkullBlock.ISkullType, ResourceLocation>) skins.get(SkullTileEntityRenderer.class);

            // Add model entries
            modelsMap.put(DeerSkullBlock.Types.BUCK, new BuckHeadModel());
            modelsMap.put(DeerSkullBlock.Types.DOE, new DoeHeadModel());

            // Add skin entries
            skinsMap.put(DeerSkullBlock.Types.BUCK, new ResourceLocation(GentleFawn.MOD_ID, "textures/blocks/deer_head.png"));
            skinsMap.put(DeerSkullBlock.Types.DOE, new ResourceLocation(GentleFawn.MOD_ID, "textures/blocks/deer_head.png"));
        } catch (IllegalAccessException e) {
            LOGGER.error("Failed to set up skull renderer", e);
            throw e;
        }
    }
}
