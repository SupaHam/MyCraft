package mods.mycraft;

import net.minecraft.src.EnumRarity;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemAxe;
import net.minecraft.src.ItemStack;

public class ItemMyAxe extends ItemAxe{

	public ItemMyAxe(int itemID, EnumToolMaterial material) {
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
