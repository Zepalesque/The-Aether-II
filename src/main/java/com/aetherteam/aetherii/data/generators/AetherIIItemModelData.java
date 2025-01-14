package com.aetherteam.aetherii.data.generators;

import com.aetherteam.aetherii.AetherII;
import com.aetherteam.aetherii.block.AetherIIBlocks;
import com.aetherteam.aetherii.data.providers.AetherIIItemModelProvider;
import com.aetherteam.aetherii.item.AetherIIItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class AetherIIItemModelData extends AetherIIItemModelProvider {
    public AetherIIItemModelData(PackOutput output, ExistingFileHelper helper) {
        super(output, AetherII.MODID, helper);
    }

    @Override
    protected void registerModels() {
        this.handheldItem(AetherIIItems.SKYROOT_STICK.get(), "materials/");
        this.item(AetherIIItems.AMBROSIUM_SHARD.get(), "materials/");
        this.item(AetherIIItems.ZANITE_GEMSTONE.get(), "materials/");
        this.item(AetherIIItems.RAW_ARKENIUM.get(), "materials/");
        this.item(AetherIIItems.ARKENIUM_PLATE.get(), "materials/");
        this.item(AetherIIItems.RAW_GRAVITITE.get(), "materials/");
        this.item(AetherIIItems.GRAVITITE_PLATE.get(), "materials/");

        this.itemBlock(AetherIIBlocks.AETHER_GRASS_BLOCK.get());
        this.itemBlock(AetherIIBlocks.AETHER_DIRT.get());
        this.itemBlock(AetherIIBlocks.QUICKSOIL.get());
        this.itemBlock(AetherIIBlocks.HOLYSTONE.get());
        this.itemBlock(AetherIIBlocks.UNDERSHALE.get());
        this.itemBlock(AetherIIBlocks.AMBROSIUM_ORE.get());
        this.itemBlock(AetherIIBlocks.ZANITE_ORE.get());
        this.itemBlock(AetherIIBlocks.ARKENIUM_ORE.get());
        this.itemBlock(AetherIIBlocks.GRAVITITE_ORE.get());
        this.itemBlock(AetherIIBlocks.COLD_AERCLOUD.get());
        this.itemBlock(AetherIIBlocks.SKYROOT_LOG.get());
        this.itemBlock(AetherIIBlocks.GREATROOT_LOG.get());
        this.itemBlock(AetherIIBlocks.WISPROOT_LOG.get());
        this.itemBlock(AetherIIBlocks.AMBEROOT_LOG.get());
        this.itemBlock(AetherIIBlocks.SKYROOT_WOOD.get());
        this.itemBlock(AetherIIBlocks.GREATROOT_WOOD.get());
        this.itemBlock(AetherIIBlocks.WISPROOT_WOOD.get());
        this.itemBlock(AetherIIBlocks.AMBEROOT_WOOD.get());
        this.itemBlock(AetherIIBlocks.SKYROOT_LEAVES.get());
        this.itemBlock(AetherIIBlocks.SKYPLANE_LEAVES.get());
        this.itemBlock(AetherIIBlocks.SKYBIRCH_LEAVES.get());
        this.itemBlock(AetherIIBlocks.SKYPINE_LEAVES.get());
        this.itemBlock(AetherIIBlocks.WISPROOT_LEAVES.get());
        this.itemBlock(AetherIIBlocks.WISPTOP_LEAVES.get());
        this.itemBlock(AetherIIBlocks.GREATROOT_LEAVES.get());
        this.itemBlock(AetherIIBlocks.GREATOAK_LEAVES.get());
        this.itemBlock(AetherIIBlocks.GREATBOA_LEAVES.get());
        this.itemBlock(AetherIIBlocks.AMBEROOT_LEAVES.get());
        this.itemBlock(AetherIIBlocks.SKYROOT_PLANKS.get());
        this.itemBlock(AetherIIBlocks.GREATROOT_PLANKS.get());
        this.itemBlock(AetherIIBlocks.WISPROOT_PLANKS.get());
    }
}
