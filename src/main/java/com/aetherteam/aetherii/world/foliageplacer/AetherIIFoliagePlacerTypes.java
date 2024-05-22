package com.aetherteam.aetherii.world.foliageplacer;

import com.aetherteam.aetherii.AetherII;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AetherIIFoliagePlacerTypes {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create(BuiltInRegistries.FOLIAGE_PLACER_TYPE, AetherII.MODID);

    public static final DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<SkyplaneFoliagePlacer>> SKYPLANE_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("skyplane_foliage_placer", () -> new FoliagePlacerType<>(SkyplaneFoliagePlacer.CODEC));
}
