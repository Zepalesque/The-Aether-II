package com.aetherteam.aetherii.world.foliageplacer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class SkyplaneFoliagePlacer extends FoliagePlacer {
    public static final Codec<SkyplaneFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) -> foliagePlacerParts(instance)
            .and(IntProvider.codec(0, 24).fieldOf("trunk_height").forGetter((placer) -> placer.trunkHeight))
            .apply(instance, SkyplaneFoliagePlacer::new));
    private final IntProvider trunkHeight;

    public SkyplaneFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider height) {
        super(radius, offset);
        this.trunkHeight = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return AetherIIFoliagePlacerTypes.SKYPLANE_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader level, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration config, int maxFreeTreeHeight, FoliagePlacer.FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset) {
        boolean flag = attachment.doubleTrunk();
        BlockPos blockpos = attachment.pos().above(offset);
//        this.placeLeavesRow(level, foliageSetter, random, config, blockpos, foliageRadius + attachment.radiusOffset(), -1 - foliageHeight, flag);
        this.placeLeavesRow(level, foliageSetter, random, config, blockpos, foliageRadius - 1, 0, flag);

//        this.placeLeavesRow(level, foliageSetter, random, config, blockpos, foliageRadius - 1, -1 - foliageHeight, flag);
//        this.placeLeavesRow(level, foliageSetter, random, config, blockpos, foliageRadius + attachment.radiusOffset(), -foliageHeight, flag);


//        this.placeLeavesRow(level, foliageSetter, random, config, blockpos, foliageRadius + attachment.radiusOffset() - 1, 0, flag);
    }

    private void placeLeavesDiamond(LevelSimulatedReader level, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration config, FoliagePlacer.FoliageAttachment attachment, int radius, int offset) {
//        this.placeLeavesRow(level, foliageSetter, random, config, attachment.pos().north(), radius, offset, attachment.doubleTrunk());
//        this.placeLeavesRow(level, foliageSetter, random, config, attachment.pos().south(), radius, offset, attachment.doubleTrunk());
//        this.placeLeavesRow(level, foliageSetter, random, config, attachment.pos().west(), radius, offset, attachment.doubleTrunk());
//        this.placeLeavesRow(level, foliageSetter, random, config, attachment.pos().east(), radius, offset, attachment.doubleTrunk());
    }

    @Override
    public int foliageHeight(RandomSource random, int height, TreeConfiguration config) {
//        return 0;
        return Math.max(4, height - this.trunkHeight.sample(random));
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int localX, int localY, int localZ, int range, boolean large) {
        return localX == range && localZ == range && range > 0;
    }
}
