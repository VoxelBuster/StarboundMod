package io.github.voxelbuster.sbmod.common.util;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import io.github.voxelbuster.sbmod.common.block.BlockMineral;
import io.github.voxelbuster.sbmod.common.block.BlockOre;
import io.github.voxelbuster.sbmod.common.item.ItemMineral;
import io.github.voxelbuster.sbmod.common.item.ItemOre;
import io.github.voxelbuster.sbmod.common.item.ModItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber(modid = StarboundMod.MODID)
@GameRegistry.ObjectHolder(StarboundMod.MODID)
public class RegisterUtil {
    private static final ItemOre copper_ore = new ItemOre(MaterialVariant.COPPER);
    private static final ItemOre silver_ore = new ItemOre(MaterialVariant.SILVER);
    private static final ItemOre titanium_ore = new ItemOre(MaterialVariant.TITANIUM);
    private static final ItemOre tungsten_ore = new ItemOre(MaterialVariant.TUNGSTEN);
    private static final ItemOre durasteel_ore = new ItemOre(MaterialVariant.DURASTEEL);
    private static final ItemOre aegisalt_ore = new ItemOre(MaterialVariant.AEGISALT);
    private static final ItemOre ferozium_ore = new ItemOre(MaterialVariant.FEROZIUM);
    private static final ItemOre violium_ore = new ItemOre(MaterialVariant.VIOLIUM);
    private static final ItemOre solarium_ore = new ItemOre(MaterialVariant.SOLARIUM);
    private static final ItemOre corefragment = new ItemOre(MaterialVariant.COREFRAGMENT);

    private static final ItemMineral copper = new ItemMineral(MaterialVariant.COPPER);
    private static final ItemMineral silver = new ItemMineral(MaterialVariant.SILVER);
    private static final ItemMineral titanium = new ItemMineral(MaterialVariant.TITANIUM);
    private static final ItemMineral tungsten = new ItemMineral(MaterialVariant.TUNGSTEN);
    private static final ItemMineral durasteel = new ItemMineral(MaterialVariant.DURASTEEL);
    private static final ItemMineral aegisalt = new ItemMineral(MaterialVariant.AEGISALT);
    private static final ItemMineral ferozium = new ItemMineral(MaterialVariant.FEROZIUM);
    private static final ItemMineral violium = new ItemMineral(MaterialVariant.VIOLIUM);
    private static final ItemMineral solarium = new ItemMineral(MaterialVariant.SOLARIUM);
    private static final ItemMineral supermatter = new ItemMineral(MaterialVariant.SUPERMATTER);

    private static final BlockMineral copper_block = new BlockMineral(Material.IRON, MaterialVariant.COPPER);
    private static final BlockMineral silver_block = new BlockMineral(Material.IRON, MaterialVariant.SILVER);
    private static final BlockMineral titanium_block = new BlockMineral(Material.IRON, MaterialVariant.TITANIUM);
    private static final BlockMineral tungsten_block = new BlockMineral(Material.IRON, MaterialVariant.TUNGSTEN);
    private static final BlockMineral durasteel_block = new BlockMineral(Material.IRON, MaterialVariant.DURASTEEL);
    private static final BlockMineral aegisalt_block = new BlockMineral(Material.IRON, MaterialVariant.AEGISALT);
    private static final BlockMineral ferozium_block = new BlockMineral(Material.IRON, MaterialVariant.FEROZIUM);
    private static final BlockMineral violium_block = new BlockMineral(Material.IRON, MaterialVariant.VIOLIUM);
    private static final BlockMineral solarium_block = new BlockMineral(Material.IRON, MaterialVariant.SOLARIUM);

    private static final BlockOre ore_block_copper = new BlockOre(Material.ROCK, MaterialVariant.COPPER);
    private static final BlockOre ore_block_silver = new BlockOre(Material.ROCK, MaterialVariant.SILVER);
    private static final BlockOre ore_block_titanium = new BlockOre(Material.ROCK, MaterialVariant.TITANIUM);
    private static final BlockOre ore_block_tungsten = new BlockOre(Material.ROCK, MaterialVariant.TUNGSTEN);
    private static final BlockOre ore_block_durasteel = new BlockOre(Material.ROCK, MaterialVariant.DURASTEEL);
    private static final BlockOre ore_block_aegisalt = new BlockOre(Material.ROCK, MaterialVariant.AEGISALT);
    private static final BlockOre ore_block_ferozium = new BlockOre(Material.ROCK, MaterialVariant.FEROZIUM);
    private static final BlockOre ore_block_violium = new BlockOre(Material.ROCK, MaterialVariant.VIOLIUM);
    private static final BlockOre ore_block_solarium = new BlockOre(Material.ROCK, MaterialVariant.SOLARIUM);

    public void registerItemModel(ModItem item) {
        StarboundMod.commonProxy.registerItemRender(item, 0, item.getName());
    }

    public void registerBlockModel(ModBlock block) {
        StarboundMod.commonProxy.registerBlockRender(block, 0, block.getName());
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
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

        for (Item i : items) {
            registerItemModel((ModItem) i);
        }
    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        final Block[] blocks = {
            copper_block,
            silver_block,
            titanium_block,
            tungsten_block,
            durasteel_block,
            aegisalt_block,
            ferozium_block,
            violium_block,
            solarium_block,
            ore_block_copper,
            ore_block_silver,
            ore_block_titanium,
            ore_block_tungsten,
            ore_block_durasteel,
            ore_block_aegisalt,
            ore_block_ferozium,
            ore_block_violium,
            ore_block_solarium
        };
        event.getRegistry().registerAll(blocks);

        for (Block b: blocks) {
            registerBlockModel((ModBlock) b);
        }
    }
}
