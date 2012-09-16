package mycraft.common;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.EnumRarity;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ItemSword;

public class ItemHolySword extends ItemSword{

	public ItemHolySword(int itemID, EnumToolMaterial toolMaterial) {
		super(itemID, toolMaterial);
		
	}
	
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack){
		return EnumRarity.uncommon;
	}
	public String getTextureFile(){
		return MyCraft.itemT;
	}
}
