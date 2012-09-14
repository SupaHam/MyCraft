package mods.mycraft;

import net.minecraft.src.EnumRarity;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemSpade;
import net.minecraft.src.ItemStack;

public class ItemMySpade extends ItemSpade{

	public ItemMySpade(int itemID, EnumToolMaterial material) {
		super(itemID, material);
		
	}
	
	public EnumRarity getRarity(ItemStack sword){
		
		return EnumRarity.uncommon;
	}
	
	@Override
	public String getTextureFile(){
		return "/mycraft/item.png";
	}

}
