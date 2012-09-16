package mycraft.common;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemHolyShard extends Item{

	protected ItemHolyShard(int par1) {
		super(par1);
		this.setTabToDisplayOn(CreativeTabs.tabMaterials);
	}
	public static ItemStack holyShards;
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer){
		if(par3EntityPlayer != null){
			if(par3EntityPlayer.capabilities.isFlying){
				/*holyShards = par1ItemStack;
				int x = holyShards.stackSize + 0;
				for(int i = x; i >= 0; --i){
				--holyShards.stackSize;
				}*/
				if(par3EntityPlayer.capabilities.getFlySpeed() == 0.05F){
					par3EntityPlayer.capabilities.setFlySpeed(0.7F);
				}else if(par3EntityPlayer.capabilities.getFlySpeed() != 0.05){
					par3EntityPlayer.capabilities.setFlySpeed(0.05F);
				}
			}else{
				return par1ItemStack;
			}
		}
		return par1ItemStack;
		
	}
	
	public String getTextureFile(){
		return MyCraft.itemT;
	}
	
}
