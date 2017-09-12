package io.github.voxelbuster.sbmod.common.util;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import io.github.voxelbuster.sbmod.common.block.BlockMineral;
import io.github.voxelbuster.sbmod.common.block.BlockOre;
import io.github.voxelbuster.sbmod.common.block.IndustrialFurnace;
import io.github.voxelbuster.sbmod.common.block.ModBuildingBlocks;
import io.github.voxelbuster.sbmod.common.item.ItemMineral;
import io.github.voxelbuster.sbmod.common.item.ItemOre;
import io.github.voxelbuster.sbmod.common.item.ModItem;
import io.github.voxelbuster.sbmod.common.world.ModOreGen;
import io.github.voxelbuster.sbmod.common.world.WorldGenAncientGate;
import io.github.voxelbuster.sbmod.common.world.WorldGenOilPool;
import io.github.voxelbuster.sbmod.common.world.WorldUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

import java.awt.*;
import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = StarboundMod.MODID)
@GameRegistry.ObjectHolder(StarboundMod.MODID)
public class RegisterUtil {
    public static final ItemOre copper_ore = new ItemOre(MaterialVariant.COPPER);
    public static final ItemOre silver_ore = new ItemOre(MaterialVariant.SILVER);
    public static final ItemOre titanium_ore = new ItemOre(MaterialVariant.TITANIUM);
    public static final ItemOre tungsten_ore = new ItemOre(MaterialVariant.TUNGSTEN);
    public static final ItemOre durasteel_ore = new ItemOre(MaterialVariant.DURASTEEL);
    public static final ItemOre aegisalt_ore = new ItemOre(MaterialVariant.AEGISALT);
    public static final ItemOre ferozium_ore = new ItemOre(MaterialVariant.FEROZIUM);
    public static final ItemOre violium_ore = new ItemOre(MaterialVariant.VIOLIUM);
    public static final ItemOre solarium_ore = new ItemOre(MaterialVariant.SOLARIUM);
    public static final ItemOre corefragment = new ItemOre(MaterialVariant.COREFRAGMENT);
    public static final ItemOre uraniumore = new ItemOre(MaterialVariant.URANIUM);
    public static final ItemOre plutoniumore = new ItemOre(MaterialVariant.PLUTONIUM);
    public static final ItemOre platinumore = new ItemOre(MaterialVariant.PLATINUM);

    public static final ItemMineral copper = new ItemMineral(MaterialVariant.COPPER);
    public static final ItemMineral silver = new ItemMineral(MaterialVariant.SILVER);
    public static final ItemMineral titanium = new ItemMineral(MaterialVariant.TITANIUM);
    public static final ItemMineral tungsten = new ItemMineral(MaterialVariant.TUNGSTEN);
    public static final ItemMineral durasteel = new ItemMineral(MaterialVariant.DURASTEEL);
    public static final ItemMineral aegisalt = new ItemMineral(MaterialVariant.AEGISALT);
    public static final ItemMineral ferozium = new ItemMineral(MaterialVariant.FEROZIUM);
    public static final ItemMineral violium = new ItemMineral(MaterialVariant.VIOLIUM);
    public static final ItemMineral solarium = new ItemMineral(MaterialVariant.SOLARIUM);
    public static final ItemMineral supermatter = new ItemMineral(MaterialVariant.SUPERMATTER);
    public static final ItemMineral uranium = new ItemMineral(MaterialVariant.URANIUM);
    public static final ItemMineral plutonium = new ItemMineral(MaterialVariant.PLUTONIUM);
    public static final ItemMineral platinum = new ItemMineral(MaterialVariant.PLATINUM);
    public static final ItemMineral flawlessdia = new ItemMineral(MaterialVariant.DIAMOND);

    public static final BlockMineral copper_block = new BlockMineral(Material.IRON, MaterialVariant.COPPER);
    public static final BlockMineral silver_block = new BlockMineral(Material.IRON, MaterialVariant.SILVER);
    public static final BlockMineral titanium_block = new BlockMineral(Material.IRON, MaterialVariant.TITANIUM);
    public static final BlockMineral tungsten_block = new BlockMineral(Material.IRON, MaterialVariant.TUNGSTEN);
    public static final BlockMineral durasteel_block = new BlockMineral(Material.IRON, MaterialVariant.DURASTEEL);
    public static final BlockMineral aegisalt_block = new BlockMineral(Material.IRON, MaterialVariant.AEGISALT);
    public static final BlockMineral ferozium_block = new BlockMineral(Material.IRON, MaterialVariant.FEROZIUM);
    public static final BlockMineral violium_block = new BlockMineral(Material.IRON, MaterialVariant.VIOLIUM);
    public static final BlockMineral solarium_block = new BlockMineral(Material.IRON, MaterialVariant.SOLARIUM);
    public static final BlockMineral uranium_block = new BlockMineral(Material.IRON, MaterialVariant.URANIUM);
    public static final BlockMineral plutonium_block = new BlockMineral(Material.IRON, MaterialVariant.PLUTONIUM);
    public static final BlockMineral platinum_block = new BlockMineral(Material.IRON, MaterialVariant.PLATINUM);
    public static final BlockMineral flawlessdia_block = new BlockMineral(Material.IRON, MaterialVariant.DIAMOND);

    public static final BlockOre ore_block_copper = new BlockOre(Material.ROCK, MaterialVariant.COPPER);
    public static final BlockOre ore_block_silver = new BlockOre(Material.ROCK, MaterialVariant.SILVER);
    public static final BlockOre ore_block_titanium = new BlockOre(Material.ROCK, MaterialVariant.TITANIUM);
    public static final BlockOre ore_block_tungsten = new BlockOre(Material.ROCK, MaterialVariant.TUNGSTEN);
    public static final BlockOre ore_block_durasteel = new BlockOre(Material.ROCK, MaterialVariant.DURASTEEL);
    public static final BlockOre ore_block_aegisalt = new BlockOre(Material.ROCK, MaterialVariant.AEGISALT);
    public static final BlockOre ore_block_ferozium = new BlockOre(Material.ROCK, MaterialVariant.FEROZIUM);
    public static final BlockOre ore_block_violium = new BlockOre(Material.ROCK, MaterialVariant.VIOLIUM);
    public static final BlockOre ore_block_solarium = new BlockOre(Material.ROCK, MaterialVariant.SOLARIUM);
    public static final BlockOre ore_block_uranium = new BlockOre(Material.ROCK, MaterialVariant.URANIUM);
    public static final BlockOre ore_block_plutonium = new BlockOre(Material.ROCK, MaterialVariant.PLUTONIUM);
    public static final BlockOre ore_block_platinum = new BlockOre(Material.ROCK, MaterialVariant.PLATINUM);

    public static final IndustrialFurnace industrialfurnace = new IndustrialFurnace();

    private static ArrayList<ItemBlock> itemblocks = new ArrayList<>();

    public static void registerItemModel(Item item) {
        StarboundMod.commonProxy.registerItemRender(item, 0, item.getRegistryName().toString());
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        final Item[] items = {
                copper_ore,
                silver_ore,
                titanium_ore,
                tungsten_ore,
                durasteel_ore,
                aegisalt_ore,
                ferozium_ore,
                violium_ore,
                solarium_ore,
                copper,
                silver,
                titanium,
                tungsten,
                durasteel,
                aegisalt,
                ferozium,
                violium,
                solarium,
                corefragment,
                supermatter,
                uranium,
                platinum,
                plutonium,
                flawlessdia,
                uraniumore,
                plutoniumore,
                platinumore
        };
        event.getRegistry().registerAll(items);
        for (ItemBlock ib : itemblocks) {
            event.getRegistry().register(ib);
            registerItemModel(ib);
        }

        for (Item i : items) {
            registerItemModel(i);
        }

    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        final ArrayList<Block> blocks = new ArrayList<>();
        Block[] bTemp = {
                ore_block_copper,
                ore_block_silver,
                ore_block_titanium,
                ore_block_tungsten,
                ore_block_durasteel,
                ore_block_aegisalt,
                ore_block_ferozium,
                ore_block_violium,
                ore_block_solarium,
                copper_block,
                silver_block,
                titanium_block,
                tungsten_block,
                durasteel_block,
                aegisalt_block,
                ferozium_block,
                violium_block,
                solarium_block,
                industrialfurnace,
                flawlessdia_block,
                ore_block_uranium,
                ore_block_plutonium,
                ore_block_platinum,
                uranium_block,
                plutonium_block,
                platinum_block
        };
        for (Block b : bTemp) {
            event.getRegistry().register(b);
            blocks.add(b);
        }
        ModBuildingBlocks.addAll();
        for (Block b : ModBuildingBlocks.blockSet) {
            event.getRegistry().register(b);
            blocks.add(b);
        }

        for (Block b: blocks) {
            ItemBlock itemBlock = (ItemBlock) new ItemBlock(b).setRegistryName(b.getRegistryName());
            itemBlock.setCreativeTab(StarboundMod.creativeTab);
            itemblocks.add(itemBlock);
        }
    }

    public static void init(FMLInitializationEvent event) {
        GameRegistry.registerTileEntity(IndustrialFurnace.TileEntityCustom.class, "TileEntityindustrialFurnace");
    }

    public static void registerWorldGen() {
        GameRegistry.registerWorldGenerator(new ModOreGen(), 3);
        GameRegistry.registerWorldGenerator(new WorldGenAncientGate(), 1);
        GameRegistry.registerWorldGenerator(new WorldGenOilPool(), 2);

        DimensionManager.registerDimension(WorldUtil.dim_outpost.getId(), WorldUtil.dim_outpost);
    }
}
