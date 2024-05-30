package com.aetherteam.aetherii.world.tree.foliage.wisproot;

import com.aetherteam.aetherii.world.tree.foliage.AetherIIFoliagePlacer;
import com.aetherteam.aetherii.world.tree.foliage.AetherIIFoliagePlacers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class WisprootFoliagePlacer extends AetherIIFoliagePlacer {

    public static final Codec<WisprootFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) -> foliagePlacerParts(instance).apply(instance, WisprootFoliagePlacer::new));

    public WisprootFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected void createFoliage(LevelSimulatedReader level, FoliageSetter setter, RandomSource random, TreeConfiguration config, int maxFreeHeight, FoliageAttachment attachment, int height, int radius, int offset) {

        BlockPos origin = attachment.pos().above(offset);
        // Chose a random direction on the x or z axis, this will be the main piece offset.
        Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);
        Direction opposite = direction.getOpposite();

        // Default radius should be 2
        this.placeLeavesRow(level, setter, random, config, origin.relative(direction), radius + attachment.radiusOffset() - 1, -1, false);
        this.placeLeavesRow(level, setter, random, config, origin.relative(direction), radius + attachment.radiusOffset(), 0, true);

        // Place extra log and leaf to connect to the secondary piece
        BlockPos extraLogLoc = origin.relative(opposite);
        tryPlaceLog(level, setter, random, config, extraLogLoc, Direction.Axis.Y);
        tryPlaceLeaf(level, setter, random, config, extraLogLoc.below());

        Direction.Axis axis = direction.getAxis();
        Direction.Axis perpendicularAxis = axis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X;
        BlockPos secondaryOrigin = random.nextBoolean() ? extraLogLoc : extraLogLoc.relative(Direction.fromAxisAndDirection(perpendicularAxis, Direction.AxisDirection.NEGATIVE));

        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        // Place the secondary piece
        for (int x = -1; x <= 2; x++) {
            for (int y = 0; y <= 1; y++) {
                for (int z = -1; z <= 2; z++) {
                    boolean isTop = y == 1;
                    boolean sidesX = x == -1 || x == 2;
                    boolean sidesZ = z == -1 || z == 2;
                    // Top half should have a 4x4 round-ish shape
                    boolean topHalfLogic = !(sidesX && sidesZ);
                    // Bottom half should be a 2x2 square
                    boolean bottomHalfLogic = x != -1 && z != -1 && x != 2 && z != 2;
                    boolean shouldPlace = isTop ? topHalfLogic : bottomHalfLogic;
                    if (shouldPlace) {
                        mutable.setWithOffset(secondaryOrigin, x, y, z);
                        tryPlaceLeaf(level, setter, random, config, mutable);
                    }
                }
            }
        }

    }

    @Override
    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return 0;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource rand, int x, int y, int z, int range, boolean large) {
        // Only the lower half of the main piece should have parts that randomly are removed
        // The maximum possible shape should be a 5x5 diamond, the minimum should be a 3x3 square
        if (large) {
            return false;
        } else {
            boolean outsideDiamondShape = x + z > range;
            boolean outsideMainRadius = x >= range || z >= range;
            return (outsideMainRadius && rand.nextBoolean()) || outsideDiamondShape;
        }
    }

    @Override
    protected boolean shouldSkipLocationSigned(RandomSource rand, int x, int y, int z, int range, boolean large) {
        // Override the odd vanilla large/not-large behavior
        return shouldSkipLocation(rand, Mth.abs(x), Mth.abs(y), Mth.abs(z), range, large);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return AetherIIFoliagePlacers.WISPROOT_FOLIAGE.get();
    }
}
