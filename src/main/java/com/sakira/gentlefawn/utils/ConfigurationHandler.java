package com.sakira.gentlefawn.utils;

import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Arrays;
import java.util.List;

import static net.minecraftforge.common.BiomeDictionary.Type.*;

public class ConfigurationHandler {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final General GENERAL = new General(BUILDER);
    public static final Spawn SPAWN = new Spawn(BUILDER);

    public static class General {
        public final ForgeConfigSpec.BooleanValue dropBeef;
        public final ForgeConfigSpec.BooleanValue dropExp;

        General(ForgeConfigSpec.Builder builder) {
            builder.push("general");
            dropBeef = builder
                    .comment("Deer drops steak (1 - 4 Raw Steak)")
                    .translation("gentlefawn.configgui.dropBeef")
                    .define("dropBeef", true);
            dropExp = builder
                    .comment("Deer experience drop")
                    .translation("gentlefawn.configgui.dropExp")
                    .define("dropExp", true);
            builder.pop();
        }
    }

    public static class Spawn {
        public final ForgeConfigSpec.IntValue min;
        public final ForgeConfigSpec.IntValue max;
        public final ForgeConfigSpec.IntValue weight;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> include;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> exclude;

        Spawn(ForgeConfigSpec.Builder builder) {
            builder.push("spawn chances");
            builder.comment("Spawn rates. Set weight to 0 to disable.");
            min = builder.defineInRange("min", 1, 2, 64);
            max = builder.defineInRange("max", 7, 2, 64);
            weight = builder.defineInRange("weight", 20, 0, 100);
            builder.pop();
            builder.push("spawnable biomes");
            builder.comment("Biomes in which deer spawn and exclusions");
            include = builder.defineList("include", Arrays.asList(FOREST.toString(), SNOWY.toString(), DENSE.toString(), MOUNTAIN.toString(), HILLS.toString()), o -> BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(String.valueOf(o))));
            exclude = builder.defineList("exclude", Arrays.asList(BEACH.toString(), END.toString(), NETHER.toString(), JUNGLE.toString(), SANDY.toString()), o -> BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(String.valueOf(o))));
            builder.pop();
        }
    }

    public static final ForgeConfigSpec spec = BUILDER.build();
}
