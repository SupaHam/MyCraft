package mycraft.common;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class BlockHellStone extends Block{

	public BlockHellStone(int par1, int par2) {
		super(par1, par2, Material.rock);
		this.setCreativeTab(CreativeTabs.tabDeco);
	}
	
	public String getTextureFile(){
		return MyCraft.blockT;
	}

}
