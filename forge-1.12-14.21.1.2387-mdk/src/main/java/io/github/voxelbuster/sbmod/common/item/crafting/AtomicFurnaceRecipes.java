package io.github.voxelbuster.sbmod.common.item.crafting;

import io.github.voxelbuster.sbmod.common.util.RegisterUtil;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AtomicFurnaceRecipes {
    public static int getCookTime(ItemStack stackInSlot) {
        if (stackInSlot.getItem() == Item.getItemFromBlock(Blocks.IRON_ORE)) return 15;
        else if (stackInSlot.getItem() == Item.getItemFromBlock(Blocks.GOLD_ORE)) return 15;
        else if (stackInSlot.getItem() == RegisterUtil.copper_ore) return 10;
        else if (stackInSlot.getItem() == RegisterUtil.silver_ore) return 10;
        else if (stackInSlot.getItem() == RegisterUtil.platinumore) return 15;
        else if (stackInSlot.getItem() == RegisterUtil.tungsten_ore) return 15;
        else if (stackInSlot.getItem() == RegisterUtil.uraniumore) return 20;
        else if (stackInSlot.getItem() == RegisterUtil.plutoniumore) return 30;
        else if (stackInSlot.getItem() == RegisterUtil.titanium_ore) return 20;
        else if (stackInSlot.getItem() == RegisterUtil.durasteel_ore) return 20;
        else if (stackInSlot.getItem() == RegisterUtil.ferozium_ore) return 30;
        else if (stackInSlot.getItem() == RegisterUtil.aegisalt_ore) return 30;
        else if (stackInSlot.getItem() == RegisterUtil.violium_ore) return 30;
        else if (stackInSlot.getItem() == RegisterUtil.solarium_ore) return 60;
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
        else if (stackInSlot.getItem() == RegisterUtil.plutoniumore && stackInSlot.getCount() >= 2)
            return new ItemStack(RegisterUtil.plutonium);
        else if (stackInSlot.getItem() == RegisterUtil.titanium_ore) return new ItemStack(RegisterUtil.titanium);
        else if (stackInSlot.getItem() == RegisterUtil.durasteel_ore) return new ItemStack(RegisterUtil.durasteel);
        else if (stackInSlot.getItem() == RegisterUtil.aegisalt_ore && stackInSlot.getCount() >= 2)
            return new ItemStack(RegisterUtil.aegisalt);
        else if (stackInSlot.getItem() == RegisterUtil.ferozium_ore && stackInSlot.getCount() >= 2)
            return new ItemStack(RegisterUtil.ferozium);
        else if (stackInSlot.getItem() == RegisterUtil.violium_ore && stackInSlot.getCount() >= 2)
            return new ItemStack(RegisterUtil.violium);
        else if (stackInSlot.getItem() == RegisterUtil.solarium_ore && stackInSlot.getCount() >= 2)
            return new ItemStack(RegisterUtil.solarium);
        else return null;
    }
}
