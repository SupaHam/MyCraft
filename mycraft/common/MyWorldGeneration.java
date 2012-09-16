package mycraft.common;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class MyWorldGeneration implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.worldType){
		case -1: generateNether(world, random, chunkX*16, chunkZ*16);
		case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
		}
	}

	private void generateNether(World world, Random random, int i, int j) {
		int Xcoord = i + random.nextInt(16);
		int Ycoord = random.nextInt(60);
		int Zcoord = j + random.nextInt(16);
		
		(new WorldGenMinableNether(Block.glowStone.blockID, 0, 10)).generate(world, random, Xcoord, Ycoord, Zcoord);
	}

	//args: World, Random, BlockX, BlockZ
	private void generateSurface(World world, Random random, int i, int j) {
		int Xcoord = i + random.nextInt(16);
		int Ycoord = random.nextInt(60);
		int Zcoord = j + random.nextInt(16);
		//WGM takes the block and the amount it will try to generate (10)
		(new WorldGenMinable(MyCraft.hellOre.blockID, 10)).generate(world, random, Xcoord, Ycoord, Zcoord);
	}
	
	

}
