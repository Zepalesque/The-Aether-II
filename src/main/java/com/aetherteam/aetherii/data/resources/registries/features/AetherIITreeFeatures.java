package com.aetherteam.aetherii.data.resources.registries.features;

import com.aetherteam.aetherii.block.AetherIIBlocks;
import com.aetherteam.aetherii.world.tree.foliage.wisproot.WisprootFoliagePlacer;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class AetherIITreeFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> WISPROOT = AetherIIFeatureUtils.registerKey("wisproot");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        AetherIIFeatureUtils.register(context, WISPROOT, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(AetherIIBlocks.WISPROOT_LOG.get().defaultBlockState()),
                        new StraightTrunkPlacer(11, 4, 0), BlockStateProvider.simple(AetherIIBlocks.WISPROOT_LEAVES.get().defaultBlockState()),
                        new WisprootFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
                        new TwoLayersFeatureSize(0, 0, 0))
                        .ignoreVines().build());
    }


}
