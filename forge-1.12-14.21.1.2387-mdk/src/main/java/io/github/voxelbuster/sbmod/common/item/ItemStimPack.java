package io.github.voxelbuster.sbmod.common.item;

import io.github.voxelbuster.sbmod.common.util.ModAPI;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemStimPack extends ModItem {
    private static final int REGEN = 0, SPEED = 1, JUMP = 2, GLOW = 3;
    private int type;

    public ItemStimPack(int type) {
        this.type = type;
        switch (type) {
            case REGEN:
                this.setName("stimpack_red");
                this.defaultInit();
                this.type = type;
                break;
            case SPEED:
                this.setName("stimpack_green");
                this.defaultInit();
                this.type = type;
                break;
            case JUMP:
                this.setName("stimpack_blue");
                this.defaultInit();
                this.type = type;
                break;
            case GLOW:
                this.setName("stimpack_yellow");
                this.defaultInit();
                this.type = type;
                break;
            default:
                return;
        }
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        switch (type) {
            case REGEN:
                player.addPotionEffect(new PotionEffect(Potion.getPotionById(ModAPI.PotionIds.REGENERATION), 90, 1));
                return EnumActionResult.SUCCESS;
            case SPEED:
                player.addPotionEffect(new PotionEffect(Potion.getPotionById(ModAPI.PotionIds.SPEED), 90, 1));
                return EnumActionResult.SUCCESS;
            case JUMP:
                player.addPotionEffect(new PotionEffect(Potion.getPotionById(ModAPI.PotionIds.JUMP_BOOST), 90, 1));
                return EnumActionResult.SUCCESS;
            case GLOW:
                player.addPotionEffect(new PotionEffect(Potion.getPotionById(ModAPI.PotionIds.NIGHT_VISION), 90, 0));
                player.addPotionEffect(new PotionEffect(Potion.getPotionById(ModAPI.PotionIds.GLOWING), 90, 0));
                return EnumActionResult.SUCCESS;
            default:
                return EnumActionResult.FAIL;
        }
    }
}
