package com.aetherteam.aetherii.data.generators;

import com.aetherteam.aetherii.AetherII;
import com.aetherteam.aetherii.data.resources.registries.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public class AetherIIRegistrySets extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.BIOME, AetherIIBiomes::bootstrap)
            .add(Registries.DENSITY_FUNCTION, AetherIIDensityFunctions::bootstrap)
            .add(Registries.NOISE, AetherIINoises::bootstrap)
            .add(Registries.NOISE_SETTINGS, AetherIINoiseSettings::bootstrap)
            .add(Registries.DIMENSION_TYPE, AetherIIDimensions::bootstrapDimensionType)
            .add(Registries.LEVEL_STEM, AetherIIDimensions::bootstrapLevelStem);
//            .add(Registries.CONFIGURED_FEATURE, AetherConfiguredFeatures::bootstrap)
//            .add(Registries.PLACED_FEATURE, AetherPlacedFeatures::bootstrap)
//            .add(Registries.BIOME, AetherBiomes::bootstrap)
//            .add(Registries.DENSITY_FUNCTION, AetherDensityFunctions::bootstrap)
//            .add(Registries.NOISE, AetherNoises::bootstrap)
//            .add(Registries.NOISE_SETTINGS, AetherNoiseSettings::bootstrap)
//            .add(Registries.DIMENSION_TYPE, AetherDimensions::bootstrapDimensionType)
//            .add(Registries.LEVEL_STEM, AetherDimensions::bootstrapLevelStem)
//            .add(Registries.STRUCTURE, AetherStructures::bootstrap)
//            .add(Registries.STRUCTURE_SET, AetherStructureSets::bootstrap)
//            .add(Registries.DAMAGE_TYPE, AetherDamageTypes::bootstrap);

    public AetherIIRegistrySets(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Collections.singleton(AetherII.MODID));
    }
}
