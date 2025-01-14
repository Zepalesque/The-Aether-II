package com.aetherteam.aetherii.data.generators;

import com.aetherteam.aetherii.AetherII;
import com.aetherteam.aetherii.block.AetherIIBlocks;
import com.aetherteam.aetherii.data.providers.AetherIILanguageProvider;
import com.aetherteam.aetherii.item.AetherIICreativeTabs;
import com.aetherteam.aetherii.item.AetherIIItems;
import net.minecraft.data.PackOutput;

public class AetherIILanguageData extends AetherIILanguageProvider {
    public AetherIILanguageData(PackOutput output) {
        super(output, AetherII.MODID);
    }

    @Override
    protected void addTranslations() {
        this.addBlock(AetherIIBlocks.AETHER_GRASS_BLOCK, "Aether Grass Block");
        this.addBlock(AetherIIBlocks.AETHER_DIRT, "Aether Dirt");
        this.addBlock(AetherIIBlocks.QUICKSOIL, "Quicksoil");
        this.addBlock(AetherIIBlocks.HOLYSTONE, "Holystone");
        this.addBlock(AetherIIBlocks.UNDERSHALE, "Undershale");
        this.addBlock(AetherIIBlocks.AMBROSIUM_ORE, "Ambrosium Ore");
        this.addBlock(AetherIIBlocks.ZANITE_ORE, "Zanite Ore");
        this.addBlock(AetherIIBlocks.ARKENIUM_ORE, "Arkenium Ore");
        this.addBlock(AetherIIBlocks.GRAVITITE_ORE, "Gravitite Ore");
        this.addBlock(AetherIIBlocks.COLD_AERCLOUD, "Cold Aercloud");
        this.addBlock(AetherIIBlocks.SKYROOT_LOG, "Skyroot Log");
        this.addBlock(AetherIIBlocks.GREATROOT_LOG, "Greatroot Log");
        this.addBlock(AetherIIBlocks.WISPROOT_LOG, "Wisproot Log");
        this.addBlock(AetherIIBlocks.AMBEROOT_LOG, "Amberoot Log");
        this.addBlock(AetherIIBlocks.SKYROOT_WOOD, "Skyroot Wood");
        this.addBlock(AetherIIBlocks.GREATROOT_WOOD, "Greatroot Wood");
        this.addBlock(AetherIIBlocks.WISPROOT_WOOD, "Wisproot Wood");
        this.addBlock(AetherIIBlocks.AMBEROOT_WOOD, "Amberoot Wood");
        this.addBlock(AetherIIBlocks.SKYROOT_LEAVES, "Skyroot Leaves");
        this.addBlock(AetherIIBlocks.SKYPLANE_LEAVES, "Skyplane Leaves");
        this.addBlock(AetherIIBlocks.SKYBIRCH_LEAVES, "Skybirch Leaves");
        this.addBlock(AetherIIBlocks.SKYPINE_LEAVES, "Skypine Leaves");
        this.addBlock(AetherIIBlocks.WISPROOT_LEAVES, "Wisproot Leaves");
        this.addBlock(AetherIIBlocks.WISPTOP_LEAVES, "Wisptop Leaves");
        this.addBlock(AetherIIBlocks.GREATROOT_LEAVES, "Greatroot Leaves");
        this.addBlock(AetherIIBlocks.GREATOAK_LEAVES, "Greatoak Leaves");
        this.addBlock(AetherIIBlocks.GREATBOA_LEAVES, "Greatboa Leaves");
        this.addBlock(AetherIIBlocks.AMBEROOT_LEAVES, "Amberoot Leaves");
        this.addBlock(AetherIIBlocks.SKYROOT_PLANKS, "Skyroot Planks");
        this.addBlock(AetherIIBlocks.GREATROOT_PLANKS, "Greatroot Planks");
        this.addBlock(AetherIIBlocks.WISPROOT_PLANKS, "Wisproot Planks");

        this.addItem(AetherIIItems.SKYROOT_STICK, "Skyroot Stick");
        this.addItem(AetherIIItems.AMBROSIUM_SHARD, "Ambrosium Shard");
        this.addItem(AetherIIItems.ZANITE_GEMSTONE, "Zanite Gemstone");
        this.addItem(AetherIIItems.RAW_ARKENIUM, "Raw Arkenium");
        this.addItem(AetherIIItems.ARKENIUM_PLATE, "Arkenium Plate");
        this.addItem(AetherIIItems.RAW_GRAVITITE, "Raw Gravitite");
        this.addItem(AetherIIItems.GRAVITITE_PLATE, "Gravitite Plate");

        this.addCreativeTab(AetherIICreativeTabs.AETHER_BUILDING_BLOCKS.get(), "Aether II Building Blocks");
        this.addCreativeTab(AetherIICreativeTabs.AETHER_DUNGEON_BLOCKS.get(), "Aether II Dungeon Blocks");
        this.addCreativeTab(AetherIICreativeTabs.AETHER_NATURAL_BLOCKS.get(), "Aether II Natural Blocks");
        this.addCreativeTab(AetherIICreativeTabs.AETHER_FUNCTIONAL_BLOCKS.get(), "Aether II Functional Blocks");
        this.addCreativeTab(AetherIICreativeTabs.AETHER_REDSTONE_BLOCKS.get(), "Aether II Redstone Blocks");
        this.addCreativeTab(AetherIICreativeTabs.AETHER_EQUIPMENT_AND_UTILITIES.get(), "Aether II Equipment & Utilities");
        this.addCreativeTab(AetherIICreativeTabs.AETHER_ARMOR_AND_ACCESSORIES.get(), "Aether II Armor & Accessories");
        this.addCreativeTab(AetherIICreativeTabs.AETHER_FOOD_AND_DRINKS.get(), "Aether II Food & Drinks");
        this.addCreativeTab(AetherIICreativeTabs.AETHER_INGREDIENTS.get(), "Aether II Ingredients");
        this.addCreativeTab(AetherIICreativeTabs.AETHER_SPAWN_EGGS.get(), "Aether II Spawn Eggs");

        this.addPackDescription("mod", "Aether II Resources");
    }
}
