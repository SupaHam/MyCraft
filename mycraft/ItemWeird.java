package mods.mycraft;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class ItemWeird extends Item{

	public ItemWeird(int itemID){
		super(itemID);
		setTabToDisplayOn(CreativeTabs.tabTools);
		setMaxStackSize(1);
		setItemName("Weird Item");
	}
	@Override
	public String getTextureFile() {
		return "/mycraft/item.png";
	}
	
}
