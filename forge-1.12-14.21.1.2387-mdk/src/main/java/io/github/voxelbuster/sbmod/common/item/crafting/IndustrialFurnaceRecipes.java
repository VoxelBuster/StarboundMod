package io.github.voxelbuster.sbmod.common.item.crafting;

import io.github.voxelbuster.sbmod.common.util.RegisterUtil;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class IndustrialFurnaceRecipes {
    public static int getCookTime(ItemStack stackInSlot) {
        if (stackInSlot.getItem() == Item.getItemFromBlock(Blocks.IRON_ORE)) return 50;
        else if (stackInSlot.getItem() == Item.getItemFromBlock(Blocks.GOLD_ORE)) return 50;
        else if (stackInSlot.getItem() == RegisterUtil.copper_ore) return 40;
        else if (stackInSlot.getItem() == RegisterUtil.silver_ore) return 40;
        else if (stackInSlot.getItem() == RegisterUtil.platinumore) return 75;
        else if (stackInSlot.getItem() == RegisterUtil.tungsten_ore) return 75;
        else if (stackInSlot.getItem() == RegisterUtil.uraniumore) return 100;
        else if (stackInSlot.getItem() == RegisterUtil.titanium_ore) return 100;
        else if (stackInSlot.getItem() == RegisterUtil.durasteel_ore) return 100;
        else return 0;
    }

    public static boolean isSmeltable(ItemStack stackInSlot) {
        return getCookTime(stackInSlot) > 0;
    }

    public static ItemStack getProduct(ItemStack stackInSlot) {
        if (stackInSlot.getItem() == Item.getItemFromBlock(Blocks.IRON_ORE)) return new ItemStack(Items.IRON_INGOT);
        else if (stackInSlot.getItem() == Item.getItemFromBlock(Blocks.GOLD_ORE))
            return new ItemStack(Items.GOLD_INGOT);
        else if (stackInSlot.getItem() == RegisterUtil.copper_ore) return new ItemStack(RegisterUtil.copper);
        else if (stackInSlot.getItem() == RegisterUtil.silver_ore) return new ItemStack(RegisterUtil.silver);
        else if (stackInSlot.getItem() == RegisterUtil.platinumore) return new ItemStack(RegisterUtil.platinum);
        else if (stackInSlot.getItem() == RegisterUtil.tungsten_ore) return new ItemStack(RegisterUtil.tungsten);
        else if (stackInSlot.getItem() == RegisterUtil.uraniumore) return new ItemStack(RegisterUtil.uranium);
        else if (stackInSlot.getItem() == RegisterUtil.titanium_ore) return new ItemStack(RegisterUtil.titanium);
        else if (stackInSlot.getItem() == RegisterUtil.durasteel_ore) return new ItemStack(RegisterUtil.durasteel);
        else return null;
    }
}
