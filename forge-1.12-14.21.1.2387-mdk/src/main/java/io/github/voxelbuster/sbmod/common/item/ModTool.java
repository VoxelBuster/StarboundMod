package io.github.voxelbuster.sbmod.common.item;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import net.minecraft.block.Block;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.util.EnumHelper;

import java.util.Set;

public class ModTool extends ItemTool {

    enum ItemType {
        COPPER_PICKAXE,
        SILVER_PICKAXE,
        PLATINUM_PICKAXE,
        COPPER_DRILL,
        SILVER_DRILL,
        GOLD_DRILL,
        PLATINUM_DRILL,
        DIAMOND_DRILL,
        CHAINSAW,
        MANIPULATOR
    }

    public static ToolMaterial getToolMaterial(ItemType type) {
        switch (type) {
            case COPPER_PICKAXE:
                return EnumHelper.addToolMaterial("copperpick", 2, 127, 5f, 3f, 16);
            default:
                return null;
        }
    } // TODO finish definitions

    public ModTool(ItemType type, ToolMaterial materialIn, Set<Block> effectiveBlocksIn) {
        super(materialIn, effectiveBlocksIn);
        setCreativeTab(StarboundMod.creativeTab);
        if (type == ItemType.COPPER_PICKAXE) {
            this.setUnlocalizedName("copperpickaxe");
            this.setRegistryName("copperpickaxe");
            this.setMaxStackSize(1);
            this.setMaxDamage(127);
            this.setHarvestLevel("pickaxe", 2);
            this.damageVsEntity = 3f;
            this.attackSpeed = 1f;
        } else if (type == ItemType.SILVER_PICKAXE) {
            this.setUnlocalizedName("silverpickaxe");
            this.setRegistryName("silverpickaxe");
            this.setMaxStackSize(1);
            this.setMaxDamage(216);
            this.setHarvestLevel("pickaxe", 2);
            this.damageVsEntity = 3f;
            this.attackSpeed = 1f;
        } else if (type == ItemType.PLATINUM_PICKAXE) {
            this.setUnlocalizedName("platinumpickaxe");
            this.setRegistryName("platinumpickaxe");
            this.setMaxStackSize(1);
            this.setMaxDamage(512);
            this.setHarvestLevel("pickaxe", 3);
            this.damageVsEntity = 3f;
            this.attackSpeed = 1f;
        } else if (type == ItemType.COPPER_DRILL) {
            this.setUnlocalizedName("copperdrill");
            this.setRegistryName("copperdrill");
            this.setMaxStackSize(1);
            this.setMaxDamage(255);
            this.setHarvestLevel("pickaxe", 2);
            this.damageVsEntity = 1f;
            this.attackSpeed = 4f;
        } else if (type == ItemType.SILVER_DRILL) {
            this.setUnlocalizedName("silverdrill");
            this.setRegistryName("silverdrill");
            this.setMaxStackSize(1);
            this.setMaxDamage(432);
            this.setHarvestLevel("pickaxe", 2);
            this.damageVsEntity = 1f;
            this.attackSpeed = 4f;
        } else if (type == ItemType.GOLD_DRILL) {
            this.setUnlocalizedName("golddrill");
            this.setRegistryName("golddrill");
            this.setMaxStackSize(1);
            this.setMaxDamage(512);
            this.setHarvestLevel("pickaxe", 2);
            this.damageVsEntity = 1f;
            this.attackSpeed = 4f;
        } else if (type == ItemType.PLATINUM_DRILL) {
            this.setUnlocalizedName("platinumdrill");
            this.setRegistryName("platinumdrill");
            this.setMaxStackSize(1);
            this.setMaxDamage(1024);
            this.setHarvestLevel("pickaxe", 3);
            this.damageVsEntity = 1f;
            this.attackSpeed = 4f;
        } else if (type == ItemType.DIAMOND_DRILL) {
            this.setUnlocalizedName("diamonddrill");
            this.setRegistryName("diamonddrill");
            this.setMaxStackSize(1);
            this.setMaxDamage(2048);
            this.setHarvestLevel("pickaxe", 4);
            this.damageVsEntity = 1.5f;
            this.attackSpeed = 4f;
        } else if (type == ItemType.CHAINSAW) {
            this.setUnlocalizedName("chainsaw");
            this.setRegistryName("chainsaw");
            this.setMaxStackSize(1);
            this.setMaxDamage(1024);
            this.setHarvestLevel("axe", 3);
            this.damageVsEntity = 2f;
            this.attackSpeed = 4f;
        } else if (type == ItemType.MANIPULATOR) {
            this.setUnlocalizedName("manipulator");
            this.setRegistryName("manipulator");
            this.setMaxStackSize(1);
            this.setMaxDamage(-1);
            this.setHarvestLevel("axe", 3);
            this.damageVsEntity = 0f;
            this.attackSpeed = 0.5f;
        }
    }
}
