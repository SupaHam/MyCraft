package mods.mycraft;

import net.minecraft.src.EnumRarity;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ItemSword;

public class ItemMySword extends ItemSword {

	public ItemMySword(int itemID, EnumToolMaterial material) {
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
