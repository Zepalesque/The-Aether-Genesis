package com.aetherteam.aether_genesis.data.generators;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.item.AetherItems;
import com.aetherteam.aether_genesis.Genesis;
import com.aetherteam.aether_genesis.GenesisTags;
import com.aetherteam.aether_genesis.block.GenesisBlocks;
import com.aetherteam.aether_genesis.data.providers.GenesisRecipeProvider;
import com.aetherteam.aether_genesis.item.GenesisItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class GenesisRecipeData extends GenesisRecipeProvider {
    public GenesisRecipeData(PackOutput output) {
        super(output, Genesis.MODID);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        makeSwetJelly(GenesisItems.BLUE_SWET_JELLY, AetherItems.SWET_BALL).save(consumer);
        makeSwetJelly(GenesisItems.GOLDEN_SWET_JELLY, GenesisItems.GOLDEN_SWET_BALL).save(consumer);
        makeSwetJelly(GenesisItems.DARK_SWET_JELLY, GenesisItems.DARK_SWET_BALL).save(consumer);
        twoByTwoPacker(consumer, RecipeCategory.TOOLS, GenesisItems.BLUE_PARACHUTE.get(), AetherBlocks.BLUE_AERCLOUD.get());
        twoByTwoPacker(consumer, RecipeCategory.TOOLS, GenesisItems.GREEN_PARACHUTE.get(), GenesisBlocks.GREEN_AERCLOUD.get());
        twoByTwoPacker(consumer, RecipeCategory.TOOLS, GenesisItems.PURPLE_PARACHUTE.get(), GenesisBlocks.PURPLE_AERCLOUD.get());

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GenesisItems.ICESTONE_POPROCKS.get(), 3).requires(AetherBlocks.ICESTONE.get()).requires(Items.SUGAR).unlockedBy(getHasName(AetherBlocks.ICESTONE.get()), has(AetherBlocks.ICESTONE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GenesisItems.BLUEBERRY_LOLLIPOP.get()).requires(AetherItems.BLUE_BERRY.get()).requires(Items.SUGAR).requires(AetherItems.SKYROOT_STICK.get()).unlockedBy(getHasName(AetherItems.BLUE_BERRY.get()), has(AetherItems.BLUE_BERRY.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GenesisItems.ORANGE_LOLLIPOP.get()).requires(GenesisItems.ORANGE.get()).requires(Items.SUGAR).requires(AetherItems.SKYROOT_STICK.get()).unlockedBy(getHasName(GenesisItems.ORANGE.get()), has(GenesisItems.ORANGE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GenesisItems.COCOATRICE.get()).requires(Items.COCOA_BEANS).requires(AetherItems.SKYROOT_MILK_BUCKET.get()).requires(Items.SUGAR).unlockedBy(getHasName(Items.COCOA_BEANS), has(Items.COCOA_BEANS)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GenesisItems.WRAPPED_CHOCOLATES.get()).requires(Items.COCOA_BEANS).requires(AetherItems.SKYROOT_MILK_BUCKET.get()).requires(AetherItems.AECHOR_PETAL.get()).requires(Items.SUGAR).unlockedBy(getHasName(AetherItems.AECHOR_PETAL.get()), has(AetherItems.AECHOR_PETAL.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GenesisItems.JELLY_PUMPKIN.get()).requires(GenesisItems.ORANGE.get()).requires(GenesisTags.Items.SWET_JELLY).requires(Items.SUGAR).unlockedBy(getHasName(GenesisItems.ORANGE.get()), has(GenesisItems.ORANGE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GenesisItems.CANDY_CORN.get(), 5).requires(GenesisItems.CORNSTARCH_BOWL.get()).requires(AetherItems.SKYROOT_MILK_BUCKET.get()).requires(AetherItems.SKYROOT_WATER_BUCKET.get()).requires(Items.SUGAR).unlockedBy(getHasName(GenesisItems.CORNSTARCH_BOWL.get()), has(GenesisItems.CORNSTARCH_BOWL.get())).save(consumer);

        wall(consumer, RecipeCategory.DECORATIONS, GenesisBlocks.SKYROOT_LOG_WALL.get(), AetherBlocks.SKYROOT_LOG.get());
        wall(consumer, RecipeCategory.DECORATIONS, GenesisBlocks.SKYROOT_WOOD_WALL.get(), AetherBlocks.SKYROOT_WOOD.get());
        wall(consumer, RecipeCategory.DECORATIONS, GenesisBlocks.STRIPPED_SKYROOT_LOG_WALL.get(), AetherBlocks.STRIPPED_SKYROOT_LOG.get());
        wall(consumer, RecipeCategory.DECORATIONS, GenesisBlocks.STRIPPED_SKYROOT_WOOD_WALL.get(), AetherBlocks.STRIPPED_SKYROOT_WOOD.get());

        twoByTwoPacker(consumer, RecipeCategory.DECORATIONS, GenesisBlocks.AETHER_CRAFTING_TABLE.get(), AetherBlocks.SKYROOT_PLANKS.get());
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, GenesisBlocks.HOLYSTONE_FURNACE.get()).define('#', AetherBlocks.HOLYSTONE.get()).pattern("###").pattern("# #").pattern("###").unlockedBy(getHasName(GenesisBlocks.HOLYSTONE_FURNACE.get()), has(AetherBlocks.HOLYSTONE.get())).save(consumer);}
}
