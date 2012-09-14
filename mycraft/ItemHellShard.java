package mods.mycraft;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemSnowball;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import net.minecraftforge.common.MinecraftForge;

public class ItemHellShard extends Item {

	protected ItemHellShard(int itemID) {
		super(itemID);
		setTabToDisplayOn(CreativeTabs.tabMaterials);
		setMaxStackSize(5);
		
	}
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	boolean flying = par3EntityPlayer.capabilities.isFlying;
    	boolean allowflying = par3EntityPlayer.capabilities.allowFlying;
    	flying = false;
    	if(par3EntityPlayer != null){
    	if(flying == false){
    		allowflying = true;
    		par3EntityPlayer.addChatMessage("You can now fly!");
    	}
    	}
    	return par1ItemStack;
    }
	@Override
	public String getTextureFile() {
		return "/mycraft/item.png";
	}
}
