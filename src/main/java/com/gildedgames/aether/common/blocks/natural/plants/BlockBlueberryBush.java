package com.gildedgames.aether.common.blocks.natural.plants;

import com.gildedgames.aether.api.registrar.BlocksAether;
import com.gildedgames.aether.api.registrar.ItemsAether;
import com.gildedgames.aether.common.blocks.IBlockMultiName;
import com.gildedgames.aether.common.blocks.natural.BlockAetherGrass;
import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.state.BooleanProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.item.ItemGroup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class BlockBlueberryBush extends BlockAetherPlant implements IBlockMultiName, IGrowable
{
	public static final int
			BERRY_BUSH_STEM = 0,
			BERRY_BUSH_RIPE = 1;

	public static final BooleanProperty PROPERTY_HARVESTABLE = BooleanProperty.create("harvestable");

	private static final AxisAlignedBB BUSH_AABB = new AxisAlignedBB(0.2D, 0.0D, 0.2D, 0.8D, 0.8D, 0.8D);

	public BlockBlueberryBush()
	{
		super(Material.LEAVES);

		this.setHardness(1.0f);

		this.setSoundType(SoundType.PLANT);

		this.setTickRandomly(true);
	}

	@Override
	public float getBlockHardness(final BlockState blockState, final World worldIn, final BlockPos pos)
	{
		if (blockState.getValue(PROPERTY_HARVESTABLE))
		{
			return 0.0f;
		}

		return super.getBlockHardness(blockState, worldIn, pos);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void getSubBlocks(final ItemGroup tab, final NonNullList<ItemStack> list)
	{
		list.add(new ItemStack(this, 1, BERRY_BUSH_STEM));
		list.add(new ItemStack(this, 1, BERRY_BUSH_RIPE));
	}

	@Override
	public boolean removedByPlayer(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final boolean willHarvest)
	{
		if (state.getValue(PROPERTY_HARVESTABLE))
		{
			if (player.isCreative())
			{
				world.setBlockToAir(pos);

				return false;
			}

			if (!world.isRemote)
			{
				for (final ItemStack item : this.getFruitDrops(world, pos, state))
				{
					Block.spawnAsEntity(world, pos, item);
				}
			}

			world.setBlockState(pos, state.withProperty(PROPERTY_HARVESTABLE, false));

			return false;
		}

		return super.removedByPlayer(state, world, pos, player, willHarvest);
	}

	@Override
	public List<ItemStack> getDrops(final IBlockReader world, final BlockPos pos, final BlockState state, final int fortune)
	{
		final List<ItemStack> items = super.getDrops(world, pos, state, fortune);

		items.addAll(this.getFruitDrops(world, pos, state));

		return items;
	}

	private List<ItemStack> getFruitDrops(final IBlockReader world, final BlockPos pos, final BlockState state)
	{
		final Random rand = world instanceof World ? ((World) world).rand : new Random();

		final BlockState stateUnderneath = world.getBlockState(pos.down());

		final boolean applyBonus = stateUnderneath.getBlock() == BlocksAether.aether_grass
				&& stateUnderneath.getValue(BlockAetherGrass.PROPERTY_VARIANT) == BlockAetherGrass.ENCHANTED;

		final int count = state.getValue(PROPERTY_HARVESTABLE) ? (rand.nextInt(2) + (applyBonus ? 2 : 1)) : 0;

		return Lists.newArrayList(new ItemStack(ItemsAether.blueberries, count));
	}

	@Override
	public void updateTick(final World world, final BlockPos pos, final BlockState state, final Random random)
	{
		if (!state.getValue(PROPERTY_HARVESTABLE))
		{
			if (world.getLight(pos) >= 9)
			{
				if (random.nextInt(60) == 0)
				{
					world.setBlockState(pos, state.withProperty(PROPERTY_HARVESTABLE, true));
				}
			}
		}
	}

	@Override
	public int damageDropped(final BlockState state)
	{
		return BERRY_BUSH_STEM;
	}

	@Override
	public boolean canGrow(final World worldIn, final BlockPos pos, final BlockState state, final boolean isClient)
	{
		return !state.getValue(PROPERTY_HARVESTABLE);
	}

	@Override
	public boolean canUseBonemeal(final World worldIn, final Random rand, final BlockPos pos, final BlockState state)
	{
		return !state.getValue(PROPERTY_HARVESTABLE);
	}

	@Override
	public void grow(final World world, final Random rand, final BlockPos pos, final BlockState state)
	{
		world.setBlockState(pos, state.withProperty(PROPERTY_HARVESTABLE, true));
	}

	@Override
	public boolean isFullBlock(final BlockState state)
	{
		return state.getValue(PROPERTY_HARVESTABLE);
	}

	@Override
	public BlockState getStateFromMeta(final int meta)
	{
		return this.getDefaultState().withProperty(PROPERTY_HARVESTABLE, meta == BERRY_BUSH_RIPE);
	}

	@Override
	public int getMetaFromState(final BlockState state)
	{
		return state.getValue(PROPERTY_HARVESTABLE) ? BERRY_BUSH_RIPE : BERRY_BUSH_STEM;
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, PROPERTY_HARVESTABLE);
	}

	@Override
	public AxisAlignedBB getBoundingBox(final BlockState state, final IBlockReader source, final BlockPos pos)
	{
		return state.getValue(PROPERTY_HARVESTABLE) ? FULL_BLOCK_AABB : BUSH_AABB;
	}

	@Override
	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(final BlockState state, final IBlockReader worldIn, final BlockPos pos)
	{
		return state.getValue(PROPERTY_HARVESTABLE) ? FULL_BLOCK_AABB : NULL_AABB;
	}

	@Override
	public String getTranslationKey(final ItemStack stack)
	{
		switch (stack.getMetadata())
		{
			case BERRY_BUSH_STEM:
				return "stem";
			case BERRY_BUSH_RIPE:
				return "ripe";
			default:
				return "missingno";
		}
	}
}
