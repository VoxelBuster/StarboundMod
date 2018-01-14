package io.github.voxelbuster.sbmod.common.util;

import io.github.voxelbuster.sbmod.client.util.SoundHandler;
import io.github.voxelbuster.sbmod.common.StarboundMod;
import io.github.voxelbuster.sbmod.common.block.*;
import io.github.voxelbuster.sbmod.common.item.*;
import io.github.voxelbuster.sbmod.common.world.ModOreGen;
import io.github.voxelbuster.sbmod.common.world.WorldGenAncientGate;
import io.github.voxelbuster.sbmod.common.world.WorldGenOilPool;
import io.github.voxelbuster.sbmod.common.world.WorldUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemMultiTexture;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = StarboundMod.MODID)
//@GameRegistry.ObjectHolder(StarboundMod.MODID) why did i need this?
public class RegisterUtil {

    public static final ItemPixel pixel = new ItemPixel();

    public static final HeavyPipe heavypipe = new HeavyPipe();

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
    private static final ItemMineral flawlessdia = new ItemMineral(MaterialVariant.DIAMOND);

    private static final BlockMineral copper_block = new BlockMineral(Material.IRON, MaterialVariant.COPPER);
    private static final BlockMineral silver_block = new BlockMineral(Material.IRON, MaterialVariant.SILVER);
    private static final BlockMineral titanium_block = new BlockMineral(Material.IRON, MaterialVariant.TITANIUM);
    private static final BlockMineral tungsten_block = new BlockMineral(Material.IRON, MaterialVariant.TUNGSTEN);
    private static final BlockMineral durasteel_block = new BlockMineral(Material.IRON, MaterialVariant.DURASTEEL);
    private static final BlockMineral aegisalt_block = new BlockMineral(Material.IRON, MaterialVariant.AEGISALT);
    private static final BlockMineral ferozium_block = new BlockMineral(Material.IRON, MaterialVariant.FEROZIUM);
    private static final BlockMineral violium_block = new BlockMineral(Material.IRON, MaterialVariant.VIOLIUM);
    private static final BlockMineral solarium_block = new BlockMineral(Material.IRON, MaterialVariant.SOLARIUM);
    private static final BlockMineral uranium_block = new BlockMineral(Material.IRON, MaterialVariant.URANIUM);
    private static final BlockMineral plutonium_block = new BlockMineral(Material.IRON, MaterialVariant.PLUTONIUM);
    private static final BlockMineral platinum_block = new BlockMineral(Material.IRON, MaterialVariant.PLATINUM);
    private static final BlockMineral flawlessdia_block = new BlockMineral(Material.IRON, MaterialVariant.DIAMOND);

    public static final BlockOre ore_block_copper = new BlockOre(Material.ROCK, MaterialVariant.COPPER);
    public static final BlockOre ore_block_silver = new BlockOre(Material.ROCK, MaterialVariant.SILVER);
    public static final BlockOre ore_block_titanium = new BlockOre(Material.ROCK, MaterialVariant.TITANIUM);
    public static final BlockOre ore_block_tungsten = new BlockOre(Material.ROCK, MaterialVariant.TUNGSTEN);
    private static final BlockOre ore_block_durasteel = new BlockOre(Material.ROCK, MaterialVariant.DURASTEEL);
    private static final BlockOre ore_block_aegisalt = new BlockOre(Material.ROCK, MaterialVariant.AEGISALT);
    private static final BlockOre ore_block_ferozium = new BlockOre(Material.ROCK, MaterialVariant.FEROZIUM);
    private static final BlockOre ore_block_violium = new BlockOre(Material.ROCK, MaterialVariant.VIOLIUM);
    private static final BlockOre ore_block_solarium = new BlockOre(Material.ROCK, MaterialVariant.SOLARIUM);
    public static final BlockOre ore_block_uranium = new BlockOre(Material.ROCK, MaterialVariant.URANIUM);
    public static final BlockOre ore_block_plutonium = new BlockOre(Material.ROCK, MaterialVariant.PLUTONIUM);
    public static final BlockOre ore_block_platinum = new BlockOre(Material.ROCK, MaterialVariant.PLATINUM);
    public static final BlockOre ore_block_corefragment = new BlockOre(Material.ROCK, MaterialVariant.COREFRAGMENT);

    private static final ModTool manipulator = new ModTool(ModTool.ItemType.MANIPULATOR, "pickaxe");
    private static final ModTool copperpickaxe = new ModTool(ModTool.ItemType.COPPER_PICKAXE, "pickaxe");
    private static final ModTool silverpickaxe = new ModTool(ModTool.ItemType.SILVER_PICKAXE, "pickaxe");
    private static final ModTool platinumpickaxe = new ModTool(ModTool.ItemType.PLATINUM_PICKAXE, "pickaxe");
    private static final ModTool chainsaw = new ModTool(ModTool.ItemType.CHAINSAW, "axe");
    private static final ModTool copperdrill = new ModTool(ModTool.ItemType.COPPER_DRILL, "pickaxe");
    private static final ModTool silverdrill = new ModTool(ModTool.ItemType.SILVER_DRILL, "pickaxe");
    private static final ModTool golddrill = new ModTool(ModTool.ItemType.GOLD_DRILL, "pickaxe");
    private static final ModTool platinumdrill = new ModTool(ModTool.ItemType.PLATINUM_DRILL, "pickaxe");
    private static final ModTool diamonddrill = new ModTool(ModTool.ItemType.DIAMOND_DRILL, "pickaxe");

    public static final ArrayList<ModRecord> records = new ArrayList<>();

    /*static {
        preInit(); // Sounds aren't initialized yet this doesnt work
    }*/

    private static final IndustrialFurnace industrialfurnace = new IndustrialFurnace();
    private static final AtomicFurnace atomicfurnace = new AtomicFurnace();

    private static ArrayList<ItemBlock> itemblocks = new ArrayList<>();
    private static ArrayList<Block> blocks = new ArrayList<>();

    private static void registerItemModel(Item item) {
        StarboundMod.commonProxy.registerItemRender(item, 0, item.getRegistryName().toString());
    }

    private static void registerRecordModel(Item item) {
        StarboundMod.commonProxy.registerItemRender(item, 0, StarboundMod.MODID + ":disc");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        SoundHandler.addSoundEvents();
        records.add(new ModRecord("atlas_cd", SoundHandler.musics.get(0)));
        records.add(new ModRecord("casiopeia_cd", SoundHandler.musics.get(1)));
        records.add(new ModRecord("cygnus_x1_cd", SoundHandler.musics.get(2)));
        records.add(new ModRecord("epsilon_indi_cd", SoundHandler.musics.get(3)));
        records.add(new ModRecord("supervoid_cd", SoundHandler.musics.get(4)));
        records.add(new ModRecord("europa_cd", SoundHandler.musics.get(5)));
        records.add(new ModRecord("glacial_horizon_cd", SoundHandler.musics.get(6)));
        records.add(new ModRecord("haiku_cd", SoundHandler.musics.get(7)));
        records.add(new ModRecord("nebula_cd", SoundHandler.musics.get(8)));
        records.add(new ModRecord("hymn_cd", SoundHandler.musics.get(9)));
        records.add(new ModRecord("jupiter_cd", SoundHandler.musics.get(10)));
        records.add(new ModRecord("kluex_cd", SoundHandler.musics.get(11)));
        records.add(new ModRecord("magellanic_cd", SoundHandler.musics.get(12)));
        records.add(new ModRecord("mercury_cd", SoundHandler.musics.get(13)));
        records.add(new ModRecord("mira_cd", SoundHandler.musics.get(14)));
        records.add(new ModRecord("procyon_cd", SoundHandler.musics.get(15)));
        records.add(new ModRecord("psyche_cd", SoundHandler.musics.get(16)));
        records.add(new ModRecord("stellar_cd", SoundHandler.musics.get(17)));
        records.add(new ModRecord("tranquility_cd", SoundHandler.musics.get(18)));
        records.add(new ModRecord("ultramarine_cd", SoundHandler.musics.get(19)));
        records.add(new ModRecord("vast_suns_cd", SoundHandler.musics.get(20)));
        records.add(new ModRecord("via_cd", SoundHandler.musics.get(21)));

        final Item[] items = {
                pixel,
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
                platinumore,
                manipulator,
                copperpickaxe,
                silverpickaxe,
                platinumpickaxe,
                chainsaw,
                copperdrill,
                silverdrill,
                golddrill,
                platinumdrill,
                diamonddrill,
        };
        event.getRegistry().registerAll(items);
        for (ModRecord record : records) {
            event.getRegistry().register(record);
            registerRecordModel(record);
        }
        for (Item i : ModMeleeWeapons.itemSet) {
            event.getRegistry().register(i);
            registerItemModel(i);
        }
        for (Item i : ItemCrafting.itemSet) {
            event.getRegistry().register(i);
            registerItemModel(i);
        }
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
                ore_block_corefragment,
                heavypipe,
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
                atomicfurnace,
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

    public static void preInit() {

    }

    public static void init() {
        GameRegistry.registerTileEntity(IndustrialFurnace.TileEntityCustom.class, "TileEntityindustrialFurnace");
    }

    public static void registerWorldGen() {
        GameRegistry.registerWorldGenerator(new ModOreGen(), 3);
        GameRegistry.registerWorldGenerator(new WorldGenAncientGate(), 1);
        GameRegistry.registerWorldGenerator(new WorldGenOilPool(), 2);

        DimensionManager.registerDimension(WorldUtil.dim_outpost.getId(), WorldUtil.dim_outpost);
    }
}
