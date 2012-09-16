package mycraft.common;

import net.minecraft.src.Block;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class ItemBlockOres extends ItemBlock{

	public ItemBlockOres(int par1, Block block) {
		super(par1);
		setHasSubtypes(true);
	}
	
	public int getMetadata(int par1){
		return par1;
	}
	
	public String getItemNameIS(ItemStack itemStack){
		String name = "";
		switch(itemStack.getItemDamage()){
		case 0:{
			name = "ore";
			break;
		}
		case 1:{
			name = "netherore";
			break;
		}
		default: name = "ore";
		}
		return getItemName() + "." + name;
	}

}
