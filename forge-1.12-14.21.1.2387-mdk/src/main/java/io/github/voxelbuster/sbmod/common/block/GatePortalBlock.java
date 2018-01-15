package io.github.voxelbuster.sbmod.common.block;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import io.github.voxelbuster.sbmod.common.world.WorldUtil;
import io.github.voxelbuster.sbmod.common.world.teleporter.TeleporterHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class GatePortalBlock extends ModBlock {
    public static boolean freezeEvent = false;

    public GatePortalBlock() {
        super(Material.PORTAL, "gateportal");
        this.setUnlocalizedName(this.getName());
        this.setCreativeTab(StarboundMod.creativeTab);
        this.setHardness(-1f);
        this.setResistance(1f);
        this.setLightLevel(1f);
        this.setHarvestLevel("sword", 127);
        this.setRegistryName(new ResourceLocation(StarboundMod.MODID, "gateportal"));
    }

    @Override
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos neighbor) {
        if (freezeEvent) {
            return;
        }
        if (world.getBlockState(pos.down()) != ModBuildingBlocks.ancientstone.getDefaultState() && world.getBlockState(pos.down()) != this.getDefaultState()) {
            world.setBlockState(pos, Blocks.AIR.getDefaultState());
        }

        int okayNeigbor = 0;
        for (EnumFacing facing : EnumFacing.values()) {
            if (facing == EnumFacing.DOWN || facing == EnumFacing.UP) {
                continue;
            } else {
                if (world.getBlockState(pos.offset(facing)) == Blocks.OBSIDIAN.getDefaultState() || world.getBlockState(pos.offset(facing)) == ModBuildingBlocks.gateportal.getDefaultState()) {
                    okayNeigbor++;
                }
            }
        }

        if (okayNeigbor < 2) {
            world.setBlockState(pos, Blocks.AIR.getDefaultState());
        }
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return NULL_AABB;
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        if (entityIn instanceof EntityPlayer && worldIn.getWorldType().getId() != WorldUtil.dim_outpost.getId()) {
            TeleporterHandler.transferToOutpostDim(entityIn);
        } else {
            TeleporterHandler.transferToOverworld(entityIn);
        }
    }

}
