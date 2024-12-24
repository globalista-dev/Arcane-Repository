package com.globalista.arcrepo.util;

import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.GenerationStep;

import java.util.function.Predicate;

public class Worldgen {

    public static void initialize(){
        ore(BiomeSelectors.foundInOverworld(), "ore_sapphire");
        ore(BiomeSelectors.foundInOverworld(), "ore_topaz");
        ore(BiomeSelectors.foundInTheEnd(), "ore_jade");
        ore(BiomeSelectors.foundInTheNether(), "ore_ruby");
    }

    public static void ore(Predicate<BiomeSelectionContext> where, String placedFeature) {

        BiomeModifications.addFeature(where, GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(RegistryKeys.PLACED_FEATURE, Locator.id(placedFeature)));

    }


}
