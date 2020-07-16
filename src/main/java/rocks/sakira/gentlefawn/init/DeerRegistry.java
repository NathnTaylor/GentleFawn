package rocks.sakira.gentlefawn.init;

import com.google.common.collect.Lists;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import rocks.sakira.gentlefawn.GentleFawn;
import rocks.sakira.gentlefawn.register.Entities;
import rocks.sakira.gentlefawn.utils.BiomeDictionaryHelper;
import rocks.sakira.gentlefawn.utils.ConfigurationHandler;

import java.util.Arrays;
import java.util.List;
import java.util.Set;


@EventBusSubscriber(modid = GentleFawn.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DeerRegistry {
    public static void addSpawn() {
        DeferredWorkQueue.runLater(() -> {
            List<Biome> spawnableBiomes = Lists.newArrayList();

            List<BiomeDictionary.Type> includeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(ConfigurationHandler.SPAWN.include.get()));
            List<BiomeDictionary.Type> excludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(ConfigurationHandler.SPAWN.exclude.get()));

            if (!includeList.isEmpty()) {
                for (BiomeDictionary.Type type : includeList) {
                    for (Biome biome : BiomeDictionary.getBiomes(type)) {
                        if (!biome.getSpawns(EntityClassification.CREATURE).isEmpty()) {
                            spawnableBiomes.add(biome);
                        }
                    }
                }
                if (!excludeList.isEmpty()) {
                    for (BiomeDictionary.Type type : excludeList) {
                        Set<Biome> excludeBiomes = BiomeDictionary.getBiomes(type);
                        for (Biome biome : excludeBiomes) {
                            spawnableBiomes.remove(biome);
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("Do not leave the BiomeDictionary type inclusion list empty. If you wish to disable spawning of an entity, set the weight to 0 instead.");
            }
            for (Biome biome : spawnableBiomes) {
                biome.getSpawns(EntityClassification.CREATURE).add(
                        new Biome.SpawnListEntry(
                                Entities.DEER_ENTITY.get(),
                                ConfigurationHandler.SPAWN.weight.get(),
                                ConfigurationHandler.SPAWN.min.get(),
                                ConfigurationHandler.SPAWN.max.get()
                        )
                );
            }
        });
    }
}
