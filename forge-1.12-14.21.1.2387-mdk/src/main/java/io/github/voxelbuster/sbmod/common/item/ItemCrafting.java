package io.github.voxelbuster.sbmod.common.item;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import io.github.voxelbuster.sbmod.common.util.RegisterUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;

public class ItemCrafting extends Item {
    public static Item[] itemSet = {
            new ItemCrafting().setName("upgrade_kit"),
            new ItemCrafting().setName("manipulator_upgrade"),
            new ItemCrafting().setName("tech_card")
    };

    private String name;

    public String getName() {
        return name;
    }

    public Item setName(String s) {
        this.name = s;
        this.setRegistryName(s);
        return this.setUnlocalizedName(s);
    }

    public ItemCrafting() {
        this.setCreativeTab(StarboundMod.creativeTab);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (getName().equals("manipulator_upgrade")) {
            if (player.inventory.hasItemStack(new ItemStack(RegisterUtil.manipulator))) {
                int slot = -1;
                for (int i=0; i<player.inventory.getSizeInventory(); i++) {
                    if (player.getHeldItemMainhand().getItem().getUnlocalizedName().equals("manipulator")) {
                        slot = i;
                        break;
                    }
                }
                if (slot < 0) {
                    return EnumActionResult.FAIL;
                }
                ItemStack istack = player.inventory.getStackInSlot(slot);
                ItemManipulator item = (ItemManipulator) istack.getItem();
                int needed = ItemManipulator.modulesNeededForUpgrade(istack);
                if (player.inventory.getStackInSlot(player.inventory.getSlotFor(new ItemStack(this))).getCount() >= needed) {
                    item.upgrade(istack);
                    player.inventory.decrStackSize(player.inventory.getSlotFor(new ItemStack(this)), needed);
                    return EnumActionResult.SUCCESS;
                } else {
                    player.sendMessage(new TextComponentString("You need " + needed + " modules to upgrade."));
                    return EnumActionResult.FAIL;
                }
            } else {
                player.sendMessage(new TextComponentString("You don't have a matter manipulator."));
                return EnumActionResult.FAIL;
            }
        } else {
            return EnumActionResult.PASS;
        }
    }
}
