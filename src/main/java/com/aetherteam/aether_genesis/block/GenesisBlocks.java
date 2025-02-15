package com.aetherteam.aether_genesis.block;

import com.aetherteam.aether.block.natural.AercloudBlock;
import com.aetherteam.aether.block.natural.AetherDoubleDropsLeaves;
import com.aetherteam.aether.block.natural.LeavesWithParticlesBlock;
import com.aetherteam.aether.mixin.mixins.common.accessor.FireBlockAccessor;
import com.aetherteam.aether_genesis.Genesis;
import com.aetherteam.aether_genesis.block.container.AetherCraftingTableBlock;
import com.aetherteam.aether_genesis.block.container.HolystoneFurnaceBlock;
import com.aetherteam.aether_genesis.block.natural.GenesisDoubleDropsWall;
import com.aetherteam.aether_genesis.block.natural.GreenAercloudBlock;
import com.aetherteam.aether_genesis.block.natural.PurpleAercloudBlock;
import com.aetherteam.aether_genesis.client.particle.GenesisParticleTypes;
import com.aetherteam.aether_genesis.item.GenesisItems;
import com.aetherteam.aether_genesis.world.treegrower.BlueSkyrootTree;
import com.aetherteam.aether_genesis.world.treegrower.DarkBlueSkyrootTree;
import com.aetherteam.aether_genesis.world.treegrower.PurpleCrystalTree;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

public class GenesisBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Genesis.MODID);

    public static final RegistryObject<Block> GREEN_AERCLOUD = register("green_aercloud", () -> new GreenAercloudBlock(Block.Properties.of(Material.ICE, MaterialColor.COLOR_LIGHT_GREEN).strength(0.3F).sound(SoundType.WOOL).noOcclusion().dynamicShape().isRedstoneConductor(GenesisBlocks::never).isSuffocating(GenesisBlocks::never).isViewBlocking(GenesisBlocks::never)));
    public static final RegistryObject<Block> PURPLE_AERCLOUD = register("purple_aercloud", () -> new PurpleAercloudBlock(Block.Properties.of(Material.ICE, MaterialColor.COLOR_MAGENTA).strength(0.3F).sound(SoundType.WOOL).noOcclusion().dynamicShape().isRedstoneConductor(GenesisBlocks::never).isSuffocating(GenesisBlocks::never).isViewBlocking(GenesisBlocks::never)));
    public static final RegistryObject<Block> STORM_AERCLOUD = register("storm_aercloud", () -> new AercloudBlock(Block.Properties.of(Material.ICE, MaterialColor.DEEPSLATE).strength(0.3F).sound(SoundType.WOOL).noOcclusion().dynamicShape().isRedstoneConductor(GenesisBlocks::never).isSuffocating(GenesisBlocks::never).isViewBlocking(GenesisBlocks::never)));

    public static final RegistryObject<Block> BLUE_SKYROOT_LEAVES = register("blue_skyroot_leaves", () -> new AetherDoubleDropsLeaves(Block.Properties.of(Material.LEAVES, MaterialColor.DIAMOND).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(GenesisBlocks::ocelotOrParrot).isSuffocating(GenesisBlocks::never).isViewBlocking(GenesisBlocks::never)));
    public static final RegistryObject<Block> DARK_BLUE_SKYROOT_LEAVES = register("dark_blue_skyroot_leaves", () -> new AetherDoubleDropsLeaves(Block.Properties.of(Material.LEAVES, MaterialColor.LAPIS).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(GenesisBlocks::ocelotOrParrot).isSuffocating(GenesisBlocks::never).isViewBlocking(GenesisBlocks::never)));
    public static final RegistryObject<Block> PURPLE_CRYSTAL_LEAVES = register("purple_crystal_leaves", () -> new LeavesWithParticlesBlock(GenesisParticleTypes.PURPLE_CRYSTAL_LEAVES, Block.Properties.of(Material.LEAVES, MaterialColor.COLOR_PURPLE).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(GenesisBlocks::ocelotOrParrot).isSuffocating(GenesisBlocks::never).isViewBlocking(GenesisBlocks::never)));
    public static final RegistryObject<Block> PURPLE_CRYSTAL_FRUIT_LEAVES = register("purple_crystal_fruit_leaves", () -> new LeavesWithParticlesBlock(GenesisParticleTypes.PURPLE_CRYSTAL_LEAVES, Block.Properties.of(Material.LEAVES, MaterialColor.COLOR_PURPLE).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(GenesisBlocks::ocelotOrParrot).isSuffocating(GenesisBlocks::never).isViewBlocking(GenesisBlocks::never)));

    public static final RegistryObject<SaplingBlock> BLUE_SKYROOT_SAPLING = register("blue_skyroot_sapling", () -> new SaplingBlock(new BlueSkyrootTree(), Block.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<SaplingBlock> DARK_BLUE_SKYROOT_SAPLING = register("dark_blue_skyroot_sapling", () -> new SaplingBlock(new DarkBlueSkyrootTree(), Block.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<SaplingBlock> PURPLE_CRYSTAL_TREE_SAPLING = register("purple_crystal_tree_sapling", () -> new SaplingBlock(new PurpleCrystalTree(), Block.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<FlowerPotBlock> POTTED_BLUE_SKYROOT_SAPLING = BLOCKS.register("potted_blue_skyroot_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, BLUE_SKYROOT_SAPLING, Block.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistryObject<FlowerPotBlock> POTTED_DARK_BLUE_SKYROOT_SAPLING = BLOCKS.register("potted_dark_blue_skyroot_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, DARK_BLUE_SKYROOT_SAPLING, Block.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistryObject<FlowerPotBlock> POTTED_PURPLE_CRYSTAL_TREE_SAPLING = BLOCKS.register("potted_purple_crystal_tree_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PURPLE_CRYSTAL_TREE_SAPLING, Block.Properties.copy(Blocks.FLOWER_POT)));

    public static final RegistryObject<WallBlock> SKYROOT_LOG_WALL = register("skyroot_log_wall", () -> new GenesisDoubleDropsWall(Block.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<WallBlock> STRIPPED_SKYROOT_LOG_WALL = register("stripped_skyroot_log_wall", () -> new WallBlock(Block.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<WallBlock> SKYROOT_WOOD_WALL = register("skyroot_wood_wall", () -> new GenesisDoubleDropsWall(Block.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<WallBlock> STRIPPED_SKYROOT_WOOD_WALL = register("stripped_skyroot_wood_wall", () -> new WallBlock(Block.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> AETHER_CRAFTING_TABLE = register("skyroot_crafting_table", () -> new AetherCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> HOLYSTONE_FURNACE = register("holystone_furnace", () -> new HolystoneFurnaceBlock(Block.Properties.of(Material.STONE).strength(3.5F).requiresCorrectToolForDrops()));

    public static void registerPots() {
        FlowerPotBlock pot = (FlowerPotBlock) Blocks.FLOWER_POT;
        pot.addPlant(GenesisBlocks.BLUE_SKYROOT_SAPLING.getId(), GenesisBlocks.POTTED_BLUE_SKYROOT_SAPLING);
        pot.addPlant(GenesisBlocks.DARK_BLUE_SKYROOT_SAPLING.getId(), GenesisBlocks.POTTED_DARK_BLUE_SKYROOT_SAPLING);
        pot.addPlant(GenesisBlocks.PURPLE_CRYSTAL_TREE_SAPLING.getId(), GenesisBlocks.POTTED_PURPLE_CRYSTAL_TREE_SAPLING);
    }

    public static void registerFlammability() {
        FireBlockAccessor fireBlockAccessor = (FireBlockAccessor) Blocks.FIRE;
        fireBlockAccessor.callSetFlammable(GenesisBlocks.BLUE_SKYROOT_LEAVES.get(), 30, 60);
        fireBlockAccessor.callSetFlammable(GenesisBlocks.DARK_BLUE_SKYROOT_LEAVES.get(), 30, 60);
        fireBlockAccessor.callSetFlammable(GenesisBlocks.SKYROOT_LOG_WALL.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(GenesisBlocks.STRIPPED_SKYROOT_LOG_WALL.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(GenesisBlocks.SKYROOT_WOOD_WALL.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(GenesisBlocks.STRIPPED_SKYROOT_WOOD_WALL.get(), 5, 5);
    }

    private static <T extends Block> RegistryObject<T> baseRegister(String name, Supplier<? extends T> block, Function<RegistryObject<T>, Supplier<? extends Item>> item) {
        RegistryObject<T> register = BLOCKS.register(name, block);
        GenesisItems.ITEMS.register(name, item.apply(register));
        return register;
    }

    @SuppressWarnings("unchecked")
    private static <B extends Block> RegistryObject<B> register(String name, Supplier<? extends Block> block) {
        return (RegistryObject<B>) baseRegister(name, block, GenesisBlocks::registerBlockItem);
    }

    private static <B extends Block> Supplier<BlockItem> registerBlockItem(final RegistryObject<B> blockRegistryObject) {
        return () -> {
            B block = Objects.requireNonNull(blockRegistryObject.get());
            return new BlockItem(block, new Item.Properties());
        };
    }

    private static boolean never(BlockState p_test_1_, BlockGetter p_test_2_, BlockPos p_test_3_) {
        return false;
    }

    private static boolean ocelotOrParrot(BlockState p_235441_0_, BlockGetter p_235441_1_, BlockPos p_235441_2_, EntityType<?> p_235441_3_) {
        return p_235441_3_ == EntityType.OCELOT || p_235441_3_ == EntityType.PARROT;
    }
}
