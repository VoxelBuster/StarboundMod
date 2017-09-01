package io.github.voxelbuster.sbmod.common.util;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import io.github.voxelbuster.sbmod.common.block.BlockMineral;
import io.github.voxelbuster.sbmod.common.block.BlockOre;
import io.github.voxelbuster.sbmod.common.block.ModBuildingBlocks;
import io.github.voxelbuster.sbmod.common.item.ItemMineral;
import io.github.voxelbuster.sbmod.common.item.ItemOre;
import io.github.voxelbuster.sbmod.common.item.ModItem;
import io.github.voxelbuster.sbmod.common.world.ModOreGen;
import io.github.voxelbuster.sbmod.common.world.WorldGenAncientGate;
import io.github.voxelbuster.sbmod.common.world.WorldGenOilPool;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

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

    public static final BlockMineral copper_block = new BlockMineral(Material.IRON, MaterialVariant.COPPER);
    public static final BlockMineral silver_block = new BlockMineral(Material.IRON, MaterialVariant.SILVER);
    public static final BlockMineral titanium_block = new BlockMineral(Material.IRON, MaterialVariant.TITANIUM);
    public static final BlockMineral tungsten_block = new BlockMineral(Material.IRON, MaterialVariant.TUNGSTEN);
    public static final BlockMineral durasteel_block = new BlockMineral(Material.IRON, MaterialVariant.DURASTEEL);
    public static final BlockMineral aegisalt_block = new BlockMineral(Material.IRON, MaterialVariant.AEGISALT);
    public static final BlockMineral ferozium_block = new BlockMineral(Material.IRON, MaterialVariant.FEROZIUM);
    public static final BlockMineral violium_block = new BlockMineral(Material.IRON, MaterialVariant.VIOLIUM);
    public static final BlockMineral solarium_block = new BlockMineral(Material.IRON, MaterialVariant.SOLARIUM);

    public static final BlockOre ore_block_copper = new BlockOre(Material.ROCK, MaterialVariant.COPPER);
    public static final BlockOre ore_block_silver = new BlockOre(Material.ROCK, MaterialVariant.SILVER);
    public static final BlockOre ore_block_titanium = new BlockOre(Material.ROCK, MaterialVariant.TITANIUM);
    public static final BlockOre ore_block_tungsten = new BlockOre(Material.ROCK, MaterialVariant.TUNGSTEN);
    public static final BlockOre ore_block_durasteel = new BlockOre(Material.ROCK, MaterialVariant.DURASTEEL);
    public static final BlockOre ore_block_aegisalt = new BlockOre(Material.ROCK, MaterialVariant.AEGISALT);
    public static final BlockOre ore_block_ferozium = new BlockOre(Material.ROCK, MaterialVariant.FEROZIUM);
    public static final BlockOre ore_block_violium = new BlockOre(Material.ROCK, MaterialVariant.VIOLIUM);
    public static final BlockOre ore_block_solarium = new BlockOre(Material.ROCK, MaterialVariant.SOLARIUM);

    //public static final IndustrialFurnaceBlock industrialfurnace = new IndustrialFurnaceBlock(Material.IRON);

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
                supermatter
        };
        event.getRegistry().registerAll(items);
        for (ItemBlock ib : itemblocks) {
            event.getRegistry().register(ib);
            registerItemModel(ib);
        }

        for (Item i : items) {
            registerItemModel((ModItem) i);
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
                solarium_block
                //industrialfurnace
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

        //GameRegistry.registerTileEntity(IndustrialFurnaceTileEntity.class, "starboundmod:industrialfurnace");
    }

    public static void registerWorldGen() {
        GameRegistry.registerWorldGenerator(new ModOreGen(), 3);
        GameRegistry.registerWorldGenerator(new WorldGenAncientGate(), 1);
        GameRegistry.registerWorldGenerator(new WorldGenOilPool(), 2);
    }

    public static void registerFurnaceRecipes() {
        GameRegistry.addSmelting(new ItemStack(copper_ore), new ItemStack(copper, 1), 0.5f);
        GameRegistry.addSmelting(new ItemStack(silver_ore), new ItemStack(silver, 1), 0.5f);
        GameRegistry.addSmelting(new ItemStack(tungsten_ore), new ItemStack(tungsten, 1), 0.5f);
        GameRegistry.addSmelting(new ItemStack(titanium_ore), new ItemStack(titanium, 1), 0.7f);
        GameRegistry.addSmelting(new ItemStack(durasteel_ore), new ItemStack(durasteel, 1), 0.7f);
        GameRegistry.addSmelting(new ItemStack(aegisalt_ore), new ItemStack(aegisalt, 1), 1f);
        GameRegistry.addSmelting(new ItemStack(ferozium_ore), new ItemStack(ferozium, 1), 1f);
        GameRegistry.addSmelting(new ItemStack(violium_ore), new ItemStack(violium, 1), 1f);
        GameRegistry.addSmelting(new ItemStack(solarium_ore), new ItemStack(solarium, 1), 1.5f);
    }
}
