package io.github.voxelbuster.sbmod.common.block;

import io.github.voxelbuster.sbmod.client.inventory.AtomicFurnaceGUI;
import io.github.voxelbuster.sbmod.common.StarboundMod;
import io.github.voxelbuster.sbmod.common.item.crafting.AtomicFurnaceRecipes;
import io.github.voxelbuster.sbmod.common.util.RegisterUtil;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerDispenser;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class AtomicFurnace extends Block implements ITileEntityProvider {

    public AtomicFurnace() {
        super(Material.IRON);
        this.setHardness(10.0F).setResistance(30.0F).setLightLevel(0.0F).setUnlocalizedName("atomicfurnace").setLightOpacity(0)
                .setCreativeTab(StarboundMod.creativeTab).setHarvestLevel("pickaxe", 2);
        this.setSoundType(SoundType.METAL);
        this.setRegistryName("atomicfurnace");
    }

    @Override
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random random) {
        int i = pos.getX();
        int j = pos.getY();
        int k = pos.getZ();
        World par1World = world;
        int par2 = i;
        int par3 = j;
        int par4 = k;
        Random par5Random = random;
        if (((TileEntityCustom) world.getTileEntity(pos)).isBurning()) {
            for (int la = 0; la < 4; ++la) {
                double d0 = (double) ((float) par2 + 0.5F) + (double) (par5Random.nextFloat() - 0.5F) * 0.5D;
                double d1 = ((double) ((float) par3 + 0.7F) + (double) (par5Random.nextFloat() - 0.5F) * 0.5D) + 0.5D;
                double d2 = (double) ((float) par4 + 0.5F) + (double) (par5Random.nextFloat() - 0.5F) * 0.5D;
                double d3 = 0.2199999988079071D;
                double d4 = 0.27000001072883606D;
                par1World.spawnParticle(EnumParticleTypes.REDSTONE, d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityCustom();
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileEntity tileentity = world.getTileEntity(pos);
        InventoryHelper.dropInventoryItems(world, pos, (TileEntityCustom) tileentity);
        world.removeTileEntity(pos);
        super.breakBlock(world, pos, state);
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
        playerIn.openGui(StarboundMod.instance, AtomicFurnaceGUI.GUIID, worldIn, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        int i = pos.getX();
        int j = pos.getY();
        int k = pos.getZ();
        world.scheduleUpdate(new BlockPos(i, j, k), this, this.tickRate(world));

    }

    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.SOLID;
    }

    @Override
    public int tickRate(World world) {
        return 10;
    }

    @Override
    public int quantityDropped(Random par1Random) {
        return 1;
    }

    public static class TileEntityCustom extends TileEntityLockableLoot implements ITickable {

        private NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(3, ItemStack.EMPTY);
        private int furnaceBurnTime;
        private int currentItemBurnTime;
        private int cookTime;
        private double totalCookTime;

        public int getCookTime() {
            return cookTime;
        }

        public double getTotalCookTime() {
            return totalCookTime;
        }

        public int getCurrentItemBurnTime() {
            return currentItemBurnTime;
        }

        public int getFurnaceBurnTime() {
            return furnaceBurnTime;
        }

        public int getSizeInventory() {
            return 3;
        }

        public boolean isEmpty() {
            for (ItemStack itemstack : this.stacks) {
                if (!itemstack.isEmpty()) {
                    return false;
                }
            }

            return true;
        }

        public String getName() {
            return this.hasCustomName() ? this.customName : "container.atomicFurnace";
        }

        public void readFromNBT(NBTTagCompound compound) {
            super.readFromNBT(compound);
            this.stacks = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);

            if (!this.checkLootAndRead(compound)) {
                ItemStackHelper.loadAllItems(compound, this.stacks);
            }

            if (compound.hasKey("CustomName", 8)) {
                this.customName = compound.getString("CustomName");
            }
        }

        public NBTTagCompound writeToNBT(NBTTagCompound compound) {
            super.writeToNBT(compound);

            if (!this.checkLootAndWrite(compound)) {
                ItemStackHelper.saveAllItems(compound, this.stacks);
            }

            if (this.hasCustomName()) {
                compound.setString("CustomName", this.customName);
            }

            return compound;
        }

        public int getInventoryStackLimit() {
            return 64;
        }

        public String getGuiID() {
            return "minecraft:atomicFurnace";
        }

        public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
            this.fillWithLoot(playerIn);
            return new ContainerDispenser(playerInventory, this);
        }

        @Override
        public boolean isItemValidForSlot(int slot, ItemStack stack) {
            if (slot == 0) {
                return true;
            } else if (slot == 1) {
                return isItemFuel(stack);
            } else {
                return false;
            }
        }

        public static boolean isItemFuel(ItemStack stack) {
            return getBurnTime(stack) > 0;
        }

        public static int getBurnTime(ItemStack stack) {
            if (stack.getItem() == RegisterUtil.uranium) return 800;
            else if (stack.getItem() == RegisterUtil.plutonium) return 1200;
            else return 0;
        }

        protected NonNullList<ItemStack> getItems() {
            return this.stacks;
        }

        @Override
        public void update() {
            boolean flag1 = false;

            if (this.isBurning()) {
                --this.furnaceBurnTime;
            }

            if (!this.world.isRemote) {
                ItemStack itemstack = this.getItems().get(1);

                if (this.isBurning() || !itemstack.isEmpty() && !(this.getItems().get(0)).isEmpty()) {
                    if (!this.isBurning() && this.canSmelt()) {
                        this.furnaceBurnTime = getBurnTime(itemstack);
                        this.currentItemBurnTime = this.furnaceBurnTime;

                        if (this.isBurning()) {
                            flag1 = true;

                            if (!itemstack.isEmpty()) {
                                Item item = itemstack.getItem();
                                itemstack.shrink(1);

                                if (itemstack.isEmpty()) {
                                    ItemStack item1 = item.getContainerItem(itemstack);
                                    this.getItems().set(1, item1);
                                }
                            }
                        }
                    }

                    if (this.isBurning() && this.canSmelt()) {
                        ++this.cookTime;

                        if (totalCookTime == 0)
                            this.totalCookTime = AtomicFurnaceRecipes.getCookTime(this.getItems().get(0));

                        if (this.cookTime == this.totalCookTime) {
                            this.cookTime = 0;
                            this.totalCookTime = AtomicFurnaceRecipes.getCookTime(this.getItems().get(0));
                            this.smeltItem();
                            flag1 = true;
                        }
                    } else {
                        this.cookTime = 0;
                    }
                } else if (!this.isBurning() && this.cookTime > 0) {
                    this.cookTime = (int) MathHelper.clamp(this.cookTime - 2, 0, this.totalCookTime);
                }
            }

            if (flag1) {
                this.markDirty();
            }
        }

        public boolean isBurning() {
            return this.furnaceBurnTime > 0;
        }

        private boolean canSmelt() {
            if ((this.getItems().get(0)).isEmpty()) {
                return false;
            } else {
                ItemStack itemstack = AtomicFurnaceRecipes.getProduct(this.getItems().get(0));

                if (itemstack.isEmpty()) {
                    return false;
                } else {
                    ItemStack itemstack1 = this.getItems().get(2);

                    if (itemstack1.isEmpty()) {
                        return true;
                    } else if (!itemstack1.isItemEqual(itemstack)) {
                        return false;
                    } else if (itemstack1.getCount() + itemstack.getCount() <= this.getInventoryStackLimit() && itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize())  // Forge fix: make furnace respect stack sizes in furnace recipes
                    {
                        return true;
                    } else {
                        return itemstack1.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize(); // Forge fix: make furnace respect stack sizes in furnace recipes
                    }
                }
            }
        }

        public void smeltItem() {
            if (this.canSmelt()) {
                ItemStack itemstack = this.getItems().get(0);
                ItemStack itemstack1 = AtomicFurnaceRecipes.getProduct(itemstack);
                ItemStack itemstack2 = this.getItems().get(2);

                if (itemstack2.isEmpty()) {
                    this.getItems().set(2, itemstack1.copy());
                } else if (itemstack2.getItem() == itemstack1.getItem()) {
                    itemstack2.grow(itemstack1.getCount());
                }

                itemstack.shrink(1);
            }
        }
    }
}
