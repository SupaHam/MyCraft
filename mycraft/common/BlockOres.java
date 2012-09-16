package mycraft.common;

import java.util.List;
import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class BlockOres extends Block{

	public BlockOres(int par1, int par2){
        super(par1, par2, Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setRequiresSelfNotify();
    }
	
	public int idDropped(int par1, Random par2Random, int par3){
		switch(par1){
		case 0:
			return MyCraft.hellShard.shiftedIndex;
		case 1:
			return MyCraft.hellStone.blockID;
		default:
			return MyCraft.hellShard.shiftedIndex;
		
		}
	}
	
	public int quantityDropped(Random par1Random){
		return par1Random.nextInt(3)+1;
	}
	
	public int getBlockTextureFromSideAndMetadata(int par1, int par2){
		switch(par2){
		case 0: return 1;
		case 1: return 5;
		default: return 1;
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List){
		for(int var4 = 0; var4 < 2; ++var4){
			par3List.add(new ItemStack(par1, 1, var4));
		}
	}
	public String getTextureFile(){
		return MyCraft.blockT; 
	}
}
