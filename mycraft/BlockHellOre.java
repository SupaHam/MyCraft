package mods.mycraft;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.Material;

public class BlockHellOre extends Block{

	public BlockHellOre(int blockID, int texture) {
		super(blockID, texture, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		setHardness(3.0f);
		setResistance(10.0f);
		setStepSound(soundStoneFootstep);
		setBlockName("Hell Ore");
		setLightValue(0.2F);
	}

	@Override
	public String getTextureFile() {
		return "/mycraft/terrain.png";
	}
	
	public int idDropped(int par1, Random par2Random, int par3){
		return par2Random.nextInt(10 - par3 * 3) < 4 ? MyCraft.itemHellShard.shiftedIndex : 0;
	}
}
