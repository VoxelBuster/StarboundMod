package io.github.voxelbuster.sbmod.common.world;

import net.minecraft.init.Biomes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldProviderOutpost extends WorldProvider {

    public void createBiomeProvider() {
        this.biomeProvider = new BiomeProviderSingle(Biomes.PLAINS);
        this.hasSkyLight = false;
        NBTTagCompound nbttagcompound = this.world.getWorldInfo().getDimensionData(DimensionType.OVERWORLD);
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new ChunkProviderVoid(this.world);
    }

    @Override
    public float calculateCelestialAngle(long worldTime, float partialTicks) {
        return 0.0F;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float[] calcSunriseSunsetColors(float celestialAngle, float partialTicks) {
        return null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Vec3d getFogColor(float p_76562_1_, float p_76562_2_) {
        float f = MathHelper.cos(p_76562_1_ * ((float) Math.PI * 2F)) * 2.0F + 0.5F;
        f = MathHelper.clamp(f, 0.0F, 1.0F);
        float f1 = 0.627451F;
        float f2 = 0.5019608F;
        float f3 = 0.627451F;
        f1 = f1 * (f * 0.0F + 0.15F);
        f2 = f2 * (f * 0.0F + 0.15F);
        f3 = f3 * (f * 0.0F + 0.15F);
        return new Vec3d((double) f1, (double) f2, (double) f3);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean isSkyColored() {
        return false;
    }

    @Override
    public boolean canRespawnHere() {
        return false;
    }

    @Override
    public boolean isSurfaceWorld() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getCloudHeight() {
        return 8.0F;
    }

    @Override
    public boolean canCoordinateBeSpawn(int x, int z) {
        return false;
    }

    @Override
    public int getAverageGroundLevel() {
        return 0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean doesXZShowFog(int x, int z) {
        return false;
    }

    @Override
    public DimensionType getDimensionType() {
        return WorldUtil.dim_outpost;
    }

    @Override
    public void onWorldSave() {

    }

    @Override
    public void onWorldUpdateEntities() {

    }

    @Override
    public int getHeight() {
        return 256;
    }

    @Override
    public int getActualHeight() {
        return 0;
    }

    public long getSeed() {
        return 0;
    }
}
