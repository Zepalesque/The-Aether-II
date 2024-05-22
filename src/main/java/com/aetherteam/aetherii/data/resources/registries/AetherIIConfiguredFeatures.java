package com.aetherteam.aetherii.data.resources.registries;

import com.aetherteam.aetherii.AetherII;
import com.aetherteam.aetherii.data.resources.AetherIIFeatureStates;
import com.aetherteam.aetherii.world.foliageplacer.SkyplaneFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class AetherIIConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_TREE_CONFIGURATION = createKey("skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYPLANE_TREE_CONFIGURATION = createKey("skyplane_tree");

    private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(AetherII.MODID, name));
    }

    /**
     * Warning for "deprecation" is suppressed because {@link Block#builtInRegistryHolder()} is fine to use.
     */
    @SuppressWarnings("deprecation")
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        register(context, SKYROOT_TREE_CONFIGURATION, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(AetherIIFeatureStates.SKYROOT_LOG),
                        new StraightTrunkPlacer(4, 2, 0),
                        BlockStateProvider.simple(AetherIIFeatureStates.SKYROOT_LEAVES),
                        new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1)
                ).ignoreVines().build());
        register(context, SKYPLANE_TREE_CONFIGURATION, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(AetherIIFeatureStates.SKYROOT_LOG),
                        new StraightTrunkPlacer(4, 2, 0),
                        BlockStateProvider.simple(AetherIIFeatureStates.SKYROOT_LEAVES),
                        new SkyplaneFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), ConstantInt.of(3)),
                        new TwoLayersFeatureSize(1, 0, 1)
                ).ignoreVines().build());
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
