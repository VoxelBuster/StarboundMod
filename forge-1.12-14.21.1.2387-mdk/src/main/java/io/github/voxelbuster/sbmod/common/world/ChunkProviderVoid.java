package io.github.voxelbuster.sbmod.common.world;

import com.google.common.collect.Sets;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ReportedException;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ChunkProviderVoid implements IChunkGenerator, IChunkProvider {
    private Set<Long> loadingChunks = com.google.common.collect.Sets.newHashSet();
    private final World worldObj;
    public final Long2ObjectMap<Chunk> id2ChunkMap = new Long2ObjectOpenHashMap(8192);
    private final Set<Long> droppedChunksSet = Sets.<Long>newHashSet();

    public ChunkProviderVoid(World world) {
        super();
        worldObj = world;
        worldObj.setSeaLevel(0);
    }

    @Override
    public Chunk generateChunk(int x, int z) {
        ChunkPrimer chunkprimer = new ChunkPrimer();


        Chunk chunk = new Chunk(this.worldObj, chunkprimer, x, z);
        byte[] abyte = chunk.getBiomeArray();

        for (int l = 0; l < abyte.length; ++l) {
            abyte[l] = (byte) Biome.getIdForBiome(Biomes.PLAINS);
        }

        chunk.generateSkylightMap();
        return chunk;
    }

    @Override
    public void populate(int x, int z) {

    }

    @Override
    public boolean generateStructures(Chunk chunkIn, int x, int z) {

        return false;
    }

    @Override
    public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
        return new ArrayList();
    }

    @Nullable
    @Override
    public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position, boolean findUnexplored) {
        return null;
    }

    @Override
    public void recreateStructures(Chunk chunkIn, int x, int z) {

    }

    @Override
    public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos) {
        return false;
    }

    @Nullable
    @Override
    public Chunk getLoadedChunk(int x, int z) {
        long i = ChunkPos.asLong(x, z);
        Chunk chunk = id2ChunkMap.get(i);

        if (chunk != null) {
            chunk.markLoaded(false);
        }

        return chunk;
    }

    @Override
    public Chunk provideChunk(int x, int z) {
        Chunk chunk = this.loadChunk(x, z);

        if (chunk == null) {
            long i = ChunkPos.asLong(x, z);

            try {
                chunk = generateChunk(x, z);
            } catch (Throwable throwable) {
                CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Exception generating new chunk");
                CrashReportCategory crashreportcategory = crashreport.makeCategory("Chunk to be generated");
                crashreportcategory.addCrashSection("Location",
                        String.format("%d,%d", new Object[]{Integer.valueOf(x), Integer.valueOf(z)}));
                crashreportcategory.addCrashSection("Position hash", Long.valueOf(i));
                crashreportcategory.addCrashSection("Generator", this);
                throw new ReportedException(crashreport);
            }

            id2ChunkMap.put(i, chunk);
            chunk.onLoad();
        }

        return chunk;
    }

    @Override
    public boolean tick() {
        return false;
    }

    @Override
    public String makeString() {
        return null;
    }

    @Override
    public boolean isChunkGeneratedAt(int x, int z) {
        return false;
    }

    @Nullable
    public Chunk loadChunk(int x, int z) {
        return loadChunk(x, z, null);
    }

    @Nullable
    public Chunk loadChunk(int x, int z, Runnable runnable) {
        Chunk chunk = getLoadedChunk(x, z);
        if (chunk == null) {
            long pos = ChunkPos.asLong(x, z);
            chunk = net.minecraftforge.common.ForgeChunkManager.fetchDormantChunk(pos, worldObj);
            if (chunk != null) {
                if (!loadingChunks.add(pos)) {
                    net.minecraftforge.fml.common.FMLLog.bigWarning(
                            "There is an attempt to load a chunk (%d,%d) in dimension %d that is already being loaded. This will cause weird chunk breakages.",
                            x, z, worldObj.provider.getDimension());
                }

                if (chunk != null) {
                    id2ChunkMap.put(ChunkPos.asLong(x, z), chunk);
                    chunk.onLoad();
                    chunk.populate(this, this);
                }

                loadingChunks.remove(pos);
            }
        }

        // If we didn't load the chunk async and have a callback run it now
        if (runnable != null) {
            runnable.run();
        }
        return chunk;
    }
}
