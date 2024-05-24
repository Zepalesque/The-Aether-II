package com.aetherteam.aetherii.data.generators;

import com.aetherteam.aetherii.AetherII;
import com.aetherteam.aetherii.AetherIITags;
import com.aetherteam.aetherii.block.AetherIIBlocks;
import com.aetherteam.aetherii.data.providers.AetherIIRecipeProvider;
import com.aetherteam.aetherii.item.AetherIIItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;

public class AetherIIRecipeData extends AetherIIRecipeProvider {
    public AetherIIRecipeData(PackOutput output) {
        super(output, AetherII.MODID);
    }

    @Override
    protected void buildRecipes(RecipeOutput consumer) {
        woodFromLogs(consumer, AetherIIBlocks.SKYROOT_WOOD.get(), AetherIIBlocks.SKYROOT_LOG.get());
        woodFromLogs(consumer, AetherIIBlocks.GREATROOT_WOOD.get(), AetherIIBlocks.GREATROOT_LOG.get());
        woodFromLogs(consumer, AetherIIBlocks.WISPROOT_WOOD.get(), AetherIIBlocks.WISPROOT_LOG.get());
        woodFromLogs(consumer, AetherIIBlocks.AMBEROOT_WOOD.get(), AetherIIBlocks.AMBEROOT_LOG.get());
        planksFromLog(consumer, AetherIIBlocks.SKYROOT_PLANKS.get(), AetherIITags.Items.CRAFTS_SKYROOT_PLANKS, 4);
        planksFromLog(consumer, AetherIIBlocks.GREATROOT_PLANKS.get(), AetherIITags.Items.CRAFTS_GREATROOT_PLANKS, 4);
        planksFromLog(consumer, AetherIIBlocks.WISPROOT_PLANKS.get(), AetherIITags.Items.CRAFTS_WISPROOT_PLANKS, 4);

        this.fence(AetherIIBlocks.SKYROOT_FENCE, AetherIIBlocks.SKYROOT_PLANKS).save(consumer);
        this.fenceGate(AetherIIBlocks.SKYROOT_FENCE_GATE, AetherIIBlocks.SKYROOT_PLANKS).save(consumer);
        buttonBuilder(AetherIIBlocks.SKYROOT_BUTTON.get(), Ingredient.of(AetherIIBlocks.SKYROOT_PLANKS.get())).unlockedBy(getHasName(AetherIIBlocks.SKYROOT_PLANKS.get()), has(AetherIIBlocks.SKYROOT_PLANKS.get())).group("wooden_button").save(consumer);
        pressurePlateBuilder(RecipeCategory.REDSTONE, AetherIIBlocks.SKYROOT_PRESSURE_PLATE.get(), Ingredient.of(AetherIIBlocks.SKYROOT_PLANKS.get())).unlockedBy(getHasName(AetherIIBlocks.SKYROOT_PLANKS.get()), has(AetherIIBlocks.SKYROOT_PLANKS.get())).group("wooden_pressure_plate").save(consumer);
        this.stairs(AetherIIBlocks.SKYROOT_STAIRS, AetherIIBlocks.SKYROOT_PLANKS).group("wooden_stairs").save(consumer);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, AetherIIBlocks.SKYROOT_SLAB.get(), Ingredient.of(AetherIIBlocks.SKYROOT_PLANKS.get()))
                .group("wooden_slab")
                .unlockedBy(getHasName(AetherIIBlocks.SKYROOT_PLANKS.get()), has(AetherIIBlocks.SKYROOT_PLANKS.get()))
                .save(consumer);

        this.fence(AetherIIBlocks.GREATROOT_FENCE, AetherIIBlocks.GREATROOT_PLANKS).save(consumer);
        this.fenceGate(AetherIIBlocks.GREATROOT_FENCE_GATE, AetherIIBlocks.GREATROOT_PLANKS).save(consumer);
        buttonBuilder(AetherIIBlocks.GREATROOT_BUTTON.get(), Ingredient.of(AetherIIBlocks.GREATROOT_PLANKS.get())).unlockedBy(getHasName(AetherIIBlocks.GREATROOT_PLANKS.get()), has(AetherIIBlocks.GREATROOT_PLANKS.get())).group("wooden_button").save(consumer);
        pressurePlateBuilder(RecipeCategory.REDSTONE, AetherIIBlocks.GREATROOT_PRESSURE_PLATE.get(), Ingredient.of(AetherIIBlocks.GREATROOT_PLANKS.get())).unlockedBy(getHasName(AetherIIBlocks.GREATROOT_PLANKS.get()), has(AetherIIBlocks.GREATROOT_PLANKS.get())).group("wooden_pressure_plate").save(consumer);
        this.stairs(AetherIIBlocks.GREATROOT_STAIRS, AetherIIBlocks.GREATROOT_PLANKS).group("wooden_stairs").save(consumer);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, AetherIIBlocks.GREATROOT_SLAB.get(), Ingredient.of(AetherIIBlocks.GREATROOT_PLANKS.get()))
                .group("wooden_slab")
                .unlockedBy(getHasName(AetherIIBlocks.GREATROOT_PLANKS.get()), has(AetherIIBlocks.GREATROOT_PLANKS.get()))
                .save(consumer);

        this.fence(AetherIIBlocks.WISPROOT_FENCE, AetherIIBlocks.WISPROOT_PLANKS).save(consumer);
        this.fenceGate(AetherIIBlocks.WISPROOT_FENCE_GATE, AetherIIBlocks.WISPROOT_PLANKS).save(consumer);
        buttonBuilder(AetherIIBlocks.WISPROOT_BUTTON.get(), Ingredient.of(AetherIIBlocks.WISPROOT_PLANKS.get())).unlockedBy(getHasName(AetherIIBlocks.WISPROOT_PLANKS.get()), has(AetherIIBlocks.WISPROOT_PLANKS.get())).group("wooden_button").save(consumer);
        pressurePlateBuilder(RecipeCategory.REDSTONE, AetherIIBlocks.WISPROOT_PRESSURE_PLATE.get(), Ingredient.of(AetherIIBlocks.WISPROOT_PLANKS.get())).unlockedBy(getHasName(AetherIIBlocks.WISPROOT_PLANKS.get()), has(AetherIIBlocks.WISPROOT_PLANKS.get())).group("wooden_pressure_plate").save(consumer);
        this.stairs(AetherIIBlocks.WISPROOT_STAIRS, AetherIIBlocks.WISPROOT_PLANKS).group("wooden_stairs").save(consumer);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, AetherIIBlocks.WISPROOT_SLAB.get(), Ingredient.of(AetherIIBlocks.WISPROOT_PLANKS.get()))
                .group("wooden_slab")
                .unlockedBy(getHasName(AetherIIBlocks.WISPROOT_PLANKS.get()), has(AetherIIBlocks.WISPROOT_PLANKS.get()))
                .save(consumer);

        pressurePlateBuilder(RecipeCategory.REDSTONE, AetherIIBlocks.HOLYSTONE_PRESSURE_PLATE.get(), Ingredient.of(AetherIIBlocks.HOLYSTONE.get())).unlockedBy(getHasName(AetherIIBlocks.HOLYSTONE.get()), has(AetherIIBlocks.HOLYSTONE.get())).save(consumer);
        buttonBuilder(AetherIIBlocks.HOLYSTONE_BUTTON.get(), Ingredient.of(AetherIIBlocks.HOLYSTONE.get())).unlockedBy(getHasName(AetherIIBlocks.HOLYSTONE.get()), has(AetherIIBlocks.HOLYSTONE.get())).save(consumer);

        wall(consumer, RecipeCategory.DECORATIONS, AetherIIBlocks.HOLYSTONE_WALL.get(), AetherIIBlocks.HOLYSTONE.get());
        this.stairs(AetherIIBlocks.HOLYSTONE_STAIRS, AetherIIBlocks.HOLYSTONE).save(consumer);
        slab(consumer, RecipeCategory.BUILDING_BLOCKS, AetherIIBlocks.HOLYSTONE_SLAB.get(), AetherIIBlocks.HOLYSTONE.get());

        wall(consumer, RecipeCategory.DECORATIONS, AetherIIBlocks.HOLYSTONE_BRICK_WALL.get(), AetherIIBlocks.HOLYSTONE_BRICKS.get());
        this.stairs(AetherIIBlocks.HOLYSTONE_BRICK_STAIRS, AetherIIBlocks.HOLYSTONE_BRICKS).save(consumer);
        slab(consumer, RecipeCategory.BUILDING_BLOCKS, AetherIIBlocks.HOLYSTONE_BRICK_SLAB.get(), AetherIIBlocks.HOLYSTONE_BRICKS.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, AetherIIBlocks.HOLYSTONE_BRICKS.get(), 4)
                .define('#', AetherIIBlocks.HOLYSTONE.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy(getHasName(AetherIIBlocks.HOLYSTONE.get()), has(AetherIIBlocks.HOLYSTONE.get()))
                .save(consumer);
        
        this.makePickaxeWithTag(AetherIIItems.SKYROOT_PICKAXE, AetherIITags.Items.CRAFTS_SKYROOT_TOOLS, "has_planks").save(consumer);
        this.makeAxeWithTag(AetherIIItems.SKYROOT_AXE, AetherIITags.Items.CRAFTS_SKYROOT_TOOLS, "has_planks").save(consumer);
        this.makeShovelWithTag(AetherIIItems.SKYROOT_SHOVEL, AetherIITags.Items.CRAFTS_SKYROOT_TOOLS, "has_planks").save(consumer);
        this.makeHoeWithTag(AetherIIItems.SKYROOT_TROWEL, AetherIITags.Items.CRAFTS_SKYROOT_TOOLS, "has_planks").save(consumer);

        this.makePickaxeWithBlock(AetherIIItems.HOLYSTONE_PICKAXE, AetherIIBlocks.HOLYSTONE).save(consumer);
        this.makeAxeWithBlock(AetherIIItems.HOLYSTONE_AXE, AetherIIBlocks.HOLYSTONE).save(consumer);
        this.makeShovelWithBlock(AetherIIItems.HOLYSTONE_SHOVEL, AetherIIBlocks.HOLYSTONE).save(consumer);
        this.makeHoeWithBlock(AetherIIItems.HOLYSTONE_TROWEL, AetherIIBlocks.HOLYSTONE).save(consumer);

        this.makePickaxeWithTag(AetherIIItems.ZANITE_PICKAXE, AetherIITags.Items.GEMS_ZANITE, "has_zanite").save(consumer);
        this.makeAxeWithTag(AetherIIItems.ZANITE_AXE, AetherIITags.Items.GEMS_ZANITE, "has_zanite").save(consumer);
        this.makeShovelWithTag(AetherIIItems.ZANITE_SHOVEL, AetherIITags.Items.GEMS_ZANITE, "has_zanite").save(consumer);
        this.makeHoeWithTag(AetherIIItems.ZANITE_TROWEL, AetherIITags.Items.GEMS_ZANITE, "has_zanite").save(consumer);

        this.makePickaxeWithTag(AetherIIItems.ARKENIUM_PICKAXE, AetherIITags.Items.PLATES_ARKENIUM, "has_arkenium").save(consumer);
        this.makeAxeWithTag(AetherIIItems.ARKENIUM_AXE, AetherIITags.Items.PLATES_ARKENIUM, "has_arkenium").save(consumer);
        this.makeShovelWithTag(AetherIIItems.ARKENIUM_SHOVEL, AetherIITags.Items.PLATES_ARKENIUM, "has_arkenium").save(consumer);
        this.makeHoeWithTag(AetherIIItems.ARKENIUM_TROWEL, AetherIITags.Items.PLATES_ARKENIUM, "has_arkenium").save(consumer);

        this.makePickaxeWithTag(AetherIIItems.GRAVITITE_PICKAXE, AetherIITags.Items.PLATES_GRAVITITE, "has_gravitite").save(consumer);
        this.makeAxeWithTag(AetherIIItems.GRAVITITE_AXE, AetherIITags.Items.PLATES_GRAVITITE, "has_gravitite").save(consumer);
        this.makeShovelWithTag(AetherIIItems.GRAVITITE_SHOVEL, AetherIITags.Items.PLATES_GRAVITITE, "has_gravitite").save(consumer);
        this.makeHoeWithTag(AetherIIItems.GRAVITITE_TROWEL, AetherIITags.Items.PLATES_GRAVITITE, "has_gravitite").save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AetherIIItems.SKYROOT_STICK.get(), 4)
                .group("sticks")
                .define('#', AetherIITags.Items.CRAFTS_SKYROOT_STICKS)
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_planks", has(AetherIITags.Items.CRAFTS_SKYROOT_STICKS))
                .save(consumer);

        this.smeltingOreRecipe(AetherIIItems.AMBROSIUM_SHARD.get(), AetherIIBlocks.AMBROSIUM_ORE.get(), 0.1F).save(consumer, this.name("ambrosium_shard_from_smelting"));
        this.blastingOreRecipe(AetherIIItems.AMBROSIUM_SHARD.get(), AetherIIBlocks.AMBROSIUM_ORE.get(), 0.1F).save(consumer, this.name("ambrosium_shard_from_blasting"));

        this.smeltingOreRecipe(AetherIIItems.ZANITE_GEMSTONE.get(), AetherIIBlocks.ZANITE_ORE.get(), 0.7F).save(consumer, this.name("zanite_gemstone_from_smelting"));
        this.blastingOreRecipe(AetherIIItems.ZANITE_GEMSTONE.get(), AetherIIBlocks.ZANITE_ORE.get(), 0.7F).save(consumer, this.name("zanite_gemstone_from_blasting"));

        this.smeltingOreRecipe(AetherIIItems.ARKENIUM_PLATE.get(), AetherIIBlocks.ARKENIUM_ORE.get(), 1.0F).save(consumer, this.name("arkenium_plate_from_smelting"));
        this.blastingOreRecipe(AetherIIItems.ARKENIUM_PLATE.get(), AetherIIBlocks.ARKENIUM_ORE.get(), 1.0F).save(consumer, this.name("arkenium_plate_from_blasting"));
        this.smeltingOreRecipe(AetherIIItems.ARKENIUM_PLATE.get(), AetherIIItems.RAW_ARKENIUM.get(), 1.0F).save(consumer, this.name("arkenium_plate_from_smelting_raw"));
        this.blastingOreRecipe(AetherIIItems.ARKENIUM_PLATE.get(), AetherIIItems.RAW_ARKENIUM.get(), 1.0F).save(consumer, this.name("arkenium_plate_from_blasting_raw"));

        this.smeltingOreRecipe(AetherIIItems.GRAVITITE_PLATE.get(), AetherIIBlocks.GRAVITITE_ORE.get(), 1.0F).save(consumer, this.name("gravitite_plate_from_smelting"));
        this.blastingOreRecipe(AetherIIItems.GRAVITITE_PLATE.get(), AetherIIBlocks.GRAVITITE_ORE.get(), 1.0F).save(consumer, this.name("gravitite_plate_from_blasting"));
        this.smeltingOreRecipe(AetherIIItems.GRAVITITE_PLATE.get(), AetherIIItems.RAW_GRAVITITE.get(), 1.0F).save(consumer, this.name("gravitite_plate_from_smelting_raw"));
        this.blastingOreRecipe(AetherIIItems.GRAVITITE_PLATE.get(), AetherIIItems.RAW_GRAVITITE.get(), 1.0F).save(consumer, this.name("gravitite_plate_from_blasting_raw"));
    }
}
