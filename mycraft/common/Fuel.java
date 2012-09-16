package mycraft.common;

import net.minecraft.src.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class Fuel implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		if(fuel.itemID == MyCraft.holyShard.shiftedIndex){
		return 12800;	
		}else{
		return 0;
		}
	}

}
