package io.github.voxelbuster.sbmod.common.item;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import io.github.voxelbuster.sbmod.common.util.ModAPI;
import net.minecraft.block.Block;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.util.EnumHelper;

import java.util.Set;

public class ModTool extends ItemTool {

    public enum ItemType {
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
                return EnumHelper.addToolMaterial("copperpick", 2, 127, 5f, 1.5f, 16);
            case SILVER_PICKAXE:
                return EnumHelper.addToolMaterial("silverpick", 2, 216, 6f, 1.5f, 20);
            case PLATINUM_PICKAXE:
                return EnumHelper.addToolMaterial("platinumpick", 3, 512, 10f, 1.5f, 28);
            case CHAINSAW:
                return EnumHelper.addToolMaterial("chainsaw", 3, 1024, 25f, 1f, 15);
            case COPPER_DRILL:
                return EnumHelper.addToolMaterial("copperdrill", 2, 256, 7.5f, 0.5f, 8);
            case SILVER_DRILL:
                return EnumHelper.addToolMaterial("silverdrill", 2, 512, 8f, 0.5f, 10);
            case GOLD_DRILL:
                return EnumHelper.addToolMaterial("golddrill", 2, 768, 9f, 0.5f, 12);
            case PLATINUM_DRILL:
                return EnumHelper.addToolMaterial("platinumdrill", 3, 1024, 15f, 1f, 14);
            case DIAMOND_DRILL:
                return EnumHelper.addToolMaterial("diamonddrill", 4, 2048, 18f, 1f, 16);
            case MANIPULATOR:
                return EnumHelper.addToolMaterial("manipulator", 4, -1, 10f, 0f, 0);
            default:
                return null;
        }
    }

    public ModTool(ItemType type, Set<Block> effectiveBlocksIn, String toolType) {
        super(getToolMaterial(type), ModAPI.getEffectiveBlocksForType(toolType));
        setCreativeTab(StarboundMod.creativeTab);
        if (type == ItemType.COPPER_PICKAXE) {
            this.setUnlocalizedName("copperpickaxe");
            this.setRegistryName("copperpickaxe");
            this.setMaxStackSize(1);
            this.setHarvestLevel("pickaxe", 2);
            this.attackSpeed = 1f;
        } else if (type == ItemType.SILVER_PICKAXE) {
            this.setUnlocalizedName("silverpickaxe");
            this.setRegistryName("silverpickaxe");
            this.setMaxStackSize(1);
            this.setHarvestLevel("pickaxe", 2);
            this.attackSpeed = 1f;
        } else if (type == ItemType.PLATINUM_PICKAXE) {
            this.setUnlocalizedName("platinumpickaxe");
            this.setRegistryName("platinumpickaxe");
            this.setMaxStackSize(1);
            this.setHarvestLevel("pickaxe", 3);
            this.attackSpeed = 1f;
        } else if (type == ItemType.COPPER_DRILL) {
            this.setUnlocalizedName("copperdrill");
            this.setRegistryName("copperdrill");
            this.setMaxStackSize(1);
            this.setHarvestLevel("pickaxe", 2);
            this.damageVsEntity = 1f;
        } else if (type == ItemType.SILVER_DRILL) {
            this.setUnlocalizedName("silverdrill");
            this.setRegistryName("silverdrill");
            this.setMaxStackSize(1);
            this.setHarvestLevel("pickaxe", 2);
            this.attackSpeed = 4f;
        } else if (type == ItemType.GOLD_DRILL) {
            this.setUnlocalizedName("golddrill");
            this.setRegistryName("golddrill");
            this.setMaxStackSize(1);
            this.setHarvestLevel("pickaxe", 2);
            this.attackSpeed = 4f;
        } else if (type == ItemType.PLATINUM_DRILL) {
            this.setUnlocalizedName("platinumdrill");
            this.setRegistryName("platinumdrill");
            this.setMaxStackSize(1);
            this.setHarvestLevel("pickaxe", 3);
            this.attackSpeed = 4f;
        } else if (type == ItemType.DIAMOND_DRILL) {
            this.setUnlocalizedName("diamonddrill");
            this.setRegistryName("diamonddrill");
            this.setMaxStackSize(1);
            this.setHarvestLevel("pickaxe", 4);
            this.attackSpeed = 4f;
        } else if (type == ItemType.CHAINSAW) {
            this.setUnlocalizedName("chainsaw");
            this.setRegistryName("chainsaw");
            this.setMaxStackSize(1);
            this.setHarvestLevel("axe", 3);
            this.attackSpeed = 4f;
        } else if (type == ItemType.MANIPULATOR) {
            this.setUnlocalizedName("manipulator");
            this.setRegistryName("manipulator");
            this.setMaxStackSize(1);
            this.attackSpeed = 0.5f;
        }
    }
}
