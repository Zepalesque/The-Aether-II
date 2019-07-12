package com.gildedgames.aether.common.blocks.util;

import com.gildedgames.aether.common.entities.blocks.EntityFloatingBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockFloating extends Block
{
	public BlockFloating(Material material)
	{
		super(material);
	}

	public static boolean canFallInto(World world, BlockPos pos)
	{
		if (world.isAirBlock(pos))
		{
			return true;
		}

		BlockState state = world.getBlockState(pos);

		Material material = state.getMaterial();

		return state.getBlock() == Blocks.FIRE || material == Material.AIR || material == Material.WATER || material == Material.LAVA;
	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, BlockState state)
	{
		world.scheduleUpdate(pos, this, this.tickRate(world));
	}

	@Override
	public void neighborChanged(BlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
		world.scheduleUpdate(pos, this, this.tickRate(world));
	}

	@Override
	public void updateTick(World world, BlockPos pos, BlockState state, Random rand)
	{
		if (!world.isRemote)
		{
			this.checkFallable(world, pos);
		}
	}

	private void checkFallable(World world, BlockPos pos)
	{
		boolean floatInstantly = BlockSand.fallInstantly;

		if (canFallInto(world, pos.up()) && pos.getY() >= 0)
		{
			byte b0 = 32;

			if (!floatInstantly && world.isAreaLoaded(pos.add(-b0, -b0, -b0), pos.add(b0, b0, b0)))
			{
				if (!world.isRemote)
				{
					EntityFloatingBlock entity = new EntityFloatingBlock(world,
							pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D, world.getBlockState(pos));
					world.spawnEntity(entity);
				}
			}
			else
			{
				world.setBlockToAir(pos);

				BlockPos bottomPos = pos.down();

				while (canFallInto(world, bottomPos) && bottomPos.getY() > 0)
				{
					bottomPos = bottomPos.down();
				}

				if (bottomPos.getY() > 0)
				{
					world.setBlockState(bottomPos.up(), this.getDefaultState());
				}
			}
		}
	}

	@Override
	public int tickRate(World worldIn)
	{
		return 2;
	}
}
