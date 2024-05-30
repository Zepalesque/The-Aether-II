package com.aetherteam.aetherii.world.tree.foliage;

import com.aetherteam.aetherii.AetherII;
import com.aetherteam.aetherii.world.tree.foliage.wisproot.WisprootFoliagePlacer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AetherIIFoliagePlacers {

    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create(BuiltInRegistries.FOLIAGE_PLACER_TYPE, AetherII.MODID);

    public static final DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<WisprootFoliagePlacer>> WISPROOT_FOLIAGE = FOLIAGE_PLACERS.register("wisproot_foliage", () -> new FoliagePlacerType<>(WisprootFoliagePlacer.CODEC));

}
