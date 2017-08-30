package io.github.voxelbuster.sbmod.common.util;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import io.github.voxelbuster.sbmod.common.block.BlockMineral;
import io.github.voxelbuster.sbmod.common.block.BlockOre;
import io.github.voxelbuster.sbmod.common.block.IndustrialFurnaceBlock;
import io.github.voxelbuster.sbmod.common.item.ItemMineral;
import io.github.voxelbuster.sbmod.common.item.ItemOre;
import io.github.voxelbuster.sbmod.common.item.ModItem;
import io.github.voxelbuster.sbmod.common.tileentity.IndustrialFurnaceTileEntity;
import io.github.voxelbuster.sbmod.common.world.BiomeAncientGarden;
import io.github.voxelbuster.sbmod.common.world.ModOreGen;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

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

    public static final IndustrialFurnaceBlock industrialfurnace = new IndustrialFurnaceBlock(Material.IRON);

    private static ArrayList<ItemBlock> itemblocks = new ArrayList<>();

    public static final BiomeAncientGarden ancientGarden = new BiomeAncientGarden(new Biome.BiomeProperties("ancientgarden")
            .setBaseBiome("mutated_forest").setTemperature(0.7f).setRainfall(0f));

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

        GameRegistry.addSmelting(new ItemStack(copper_ore, 2), new ItemStack(copper, 1), 0.5f);
        GameRegistry.addSmelting(new ItemStack(silver_ore, 2), new ItemStack(silver, 1), 0.5f);
        GameRegistry.addSmelting(new ItemStack(tungsten_ore, 2), new ItemStack(tungsten, 1), 0.5f);
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        final Block[] blocks = {
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
                industrialfurnace
        };
        event.getRegistry().registerAll(blocks);

        for (Block b: blocks) {
            ItemBlock itemBlock = (ItemBlock) new ItemBlock(b).setRegistryName(b.getRegistryName());
            itemBlock.setCreativeTab(StarboundMod.creativeTab);
            itemblocks.add(itemBlock);
        }

        GameRegistry.registerTileEntity(IndustrialFurnaceTileEntity.class, "starboundmod:industrialfurnace");
    }

    public static void registerWorldGen() {
        GameRegistry.registerWorldGenerator(new ModOreGen(), 3);
    }

    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
        IForgeRegistry<Biome> registry = event.getRegistry();

        registry.register(ancientGarden);

        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(ancientGarden, 3));
        
        FMLLog.log.info("MY BIOME ID HERE: " + Biome.getIdForBiome(ancientGarden));
    }
}
