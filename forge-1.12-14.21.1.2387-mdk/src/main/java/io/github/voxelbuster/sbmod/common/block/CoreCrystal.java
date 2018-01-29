package io.github.voxelbuster.sbmod.common.block;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import io.github.voxelbuster.sbmod.common.util.RegisterUtil;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class CoreCrystal extends ModBlock {
    public CoreCrystal() {
        super(Material.ROCK, "corecrystal");
        this.setResistance(30f);
        this.setLightLevel((float) 10 / 15);
        this.setCreativeTab(StarboundMod.creativeTab);
        this.setHardness(10f);
        this.setHarvestLevel("pickaxe", 1);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        EnumFacing initialDirection;
        EnumFacing[] directions = {EnumFacing.NORTH, EnumFacing.SOUTH, EnumFacing.EAST, EnumFacing.WEST};
        for (EnumFacing direction : directions) {
            if (world.getBlockState(pos.offset(direction).down()) == Blocks.OBSIDIAN.getDefaultState()) {
                initialDirection = direction;
                BlockPos currentPos = pos.offset(initialDirection).down().offset(initialDirection).down();
                if (world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                    currentPos = currentPos.offset(initialDirection).down();
                    if (world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                        currentPos = currentPos.down();
                        if (world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                            currentPos = currentPos.down();
                            if (world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                currentPos = currentPos.down();
                                if (world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                    currentPos = currentPos.offset(initialDirection.getOpposite()).down();
                                    if (world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                        currentPos = currentPos.offset(initialDirection.getOpposite());
                                        if (world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                            currentPos = currentPos.offset(initialDirection.getOpposite());
                                            if (world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                currentPos = currentPos.offset(initialDirection.getOpposite());
                                                if (world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                    currentPos = currentPos.offset(initialDirection.getOpposite());
                                                    if (world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                        currentPos = currentPos.offset(initialDirection.getOpposite());
                                                        if (world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                            currentPos = currentPos.offset(initialDirection.getOpposite());
                                                            if (world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                                currentPos = currentPos.offset(initialDirection.getOpposite());
                                                                if (world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                                    currentPos = currentPos.offset(initialDirection.getOpposite());
                                                                    if (world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                                        currentPos = currentPos.offset(initialDirection.getOpposite()).up();
                                                                        if (world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                                                            currentPos = currentPos.up();
                                                                            if (world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                                                                currentPos = currentPos.up();
                                                                                if (world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                                                                    currentPos = currentPos.up();
                                                                                    if (world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                                                                        currentPos = currentPos.up().offset(initialDirection);
                                                                                        if (world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                                                                            currentPos = currentPos.up().offset(initialDirection);
                                                                                            if (world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState() &&
                                                                                                    world.getBlockState(pos.offset(initialDirection.getOpposite(), 4)) == this.getDefaultState()) {
                                                                                                if (player.inventory.hasItemStack(new ItemStack(RegisterUtil.corefragment, 20)) || player.isCreative()) {
                                                                                                    if (!player.isCreative())
                                                                                                        player.inventory.decrStackSize(player.inventory.getSlotFor(new ItemStack(RegisterUtil.corefragment, 20)), 20);
                                                                                                } else {
                                                                                                    player.sendMessage(new TextComponentString("You need 20 core fragments to activate the gate."));
                                                                                                    return false;
                                                                                                }
                                                                                                for (int i = 0; i < 5; i++) {
                                                                                                    GatePortalBlock.freezeEvent = true;
                                                                                                    world.setBlockState(pos.down().offset(initialDirection.getOpposite(), i), ModBuildingBlocks.gateportal.getDefaultState());
                                                                                                }
                                                                                                for (int i = 0; i < 7; i++) {
                                                                                                    GatePortalBlock.freezeEvent = true;
                                                                                                    world.setBlockState(pos.down(2).offset(initialDirection.getOpposite(), i - 1), ModBuildingBlocks.gateportal.getDefaultState());
                                                                                                }
                                                                                                for (int i = 0; i < 9; i++) {
                                                                                                    GatePortalBlock.freezeEvent = true;
                                                                                                    world.setBlockState(pos.down(3).offset(initialDirection.getOpposite(), i - 2), ModBuildingBlocks.gateportal.getDefaultState());
                                                                                                }
                                                                                                for (int i = 0; i < 9; i++) {
                                                                                                    GatePortalBlock.freezeEvent = true;
                                                                                                    world.setBlockState(pos.down(4).offset(initialDirection.getOpposite(), i - 2), ModBuildingBlocks.gateportal.getDefaultState());
                                                                                                }
                                                                                                for (int i = 0; i < 9; i++) {
                                                                                                    GatePortalBlock.freezeEvent = true;
                                                                                                    world.setBlockState(pos.down(5).offset(initialDirection.getOpposite(), i - 2), ModBuildingBlocks.gateportal.getDefaultState());
                                                                                                }
                                                                                                for (int i = 0; i < 9; i++) {
                                                                                                    GatePortalBlock.freezeEvent = true;
                                                                                                    world.setBlockState(pos.down(6).offset(initialDirection.getOpposite(), i - 2), ModBuildingBlocks.gateportal.getDefaultState());
                                                                                                }
                                                                                                GatePortalBlock.freezeEvent = false;
                                                                                                return true;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
