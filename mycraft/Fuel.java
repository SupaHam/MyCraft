package mods.mycraft;

import net.minecraft.src.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class Fuel implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		if(fuel.itemID == MyCraft.itemWeird.shiftedIndex){
			return 1000;
		}else{
		return 0;
		}
	}

}
