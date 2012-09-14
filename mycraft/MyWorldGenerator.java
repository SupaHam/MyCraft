package mods.mycraft;

import java.util.Random;

import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class MyWorldGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.worldType){
		case -1: generateNether(world, random, chunkX*16, chunkZ*16);
		case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
		}
	}

	private void generateSurface(World world, Random random, int x, int z) {
		for( int i = 0; i<30; i++){
		int Xcoord = x + random.nextInt(16);
		int Zcoord = z + random.nextInt(16);
		int Ycoord =  + random.nextInt(16);
		(new WorldGenMinable(MyCraft.blockHellOre.blockID, 10)).generate(world, random, Xcoord, Ycoord, Zcoord);
		}
	}

	private void generateNether(World world, Random random, int i, int j) {
		
	}

}
