package mycraft.client;

import net.minecraftforge.client.MinecraftForgeClient;
import mycraft.common.CommonProxy;
import mycraft.common.MyCraft;

public class ClientProxy extends CommonProxy{

	@Override
	public void registerRenderInformation(){
		MinecraftForgeClient.preloadTexture(MyCraft.blockT);
		MinecraftForgeClient.preloadTexture(MyCraft.itemT);
	}
}
