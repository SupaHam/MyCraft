package mycraft.common;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemHellShard extends Item{

	public ItemHellShard(int i){
		super(i);
		maxStackSize = 10;
		this.setTabToDisplayOn(CreativeTabs.tabMaterials);
	}
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer){
		if(par3EntityPlayer != null){
			if(!par3EntityPlayer.capabilities.isCreativeMode){
				par3EntityPlayer.capabilities.isCreativeMode = true;
				par3EntityPlayer.capabilities.allowFlying = true;
				par3EntityPlayer.capabilities.setFlySpeed(0.05F);
				par3EntityPlayer.addChatMessage("You can now fly!");
			}else{
				par3EntityPlayer.capabilities.isCreativeMode = false;
				par3EntityPlayer.capabilities.allowFlying = false;
				par3EntityPlayer.capabilities.isFlying = false;
				par3EntityPlayer.addChatMessage("You can no longer fly!");
			}
		}
		return par1ItemStack;
		
	}
	public String getTextureFile(){
		return MyCraft.itemT;
	}
}
