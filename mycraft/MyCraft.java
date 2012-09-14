package mods.mycraft;

import net.minecraft.server.MinecraftServer;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "MyCraft", name = "MyCraft", version = "In-Dev 0.1")
@NetworkMod(channels = { "MyCraft" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class MyCraft {

	public static Block blockEmeraldFurnaceIdle = new BlockEmeraldFurnace(205, 3, false).setCreativeTab(CreativeTabs.tabBlock);
	public static Block blockEmeraldFurnaceActive = new BlockEmeraldFurnace(206, 4, true);
	public static Block blockBlackTorch = new BlockBlackTorch(207, 0);
	public static Block blockHellOre = new BlockHellOre(208, 1);
	
	public static EnumToolMaterial MyEnumToolMaterial = EnumHelper.addToolMaterial("Holy", 3, -1, 60.0F, 6, 10);
	
	
	public static Item itemWeird = new ItemWeird(300).setIconCoord(0, 0).setItemName("Weird Item");
	public static Item itemHellShard = new ItemHellShard(306).setIconCoord(6, 0).setItemName("Hell Shard");
	public static Item itemSword = new ItemMySword(301, MyEnumToolMaterial).setItemName("Holy Sword").setIconCoord(1, 0);
	public static Item itemSpade = new ItemMySpade(302, MyEnumToolMaterial).setItemName("Holy Shovel").setIconCoord(2, 0);
	public static Item itemPickaxe = new ItemMyPickaxe(303, MyEnumToolMaterial).setItemName("Holy Pickaxe").setIconCoord(3, 0);
	public static Item itemAxe = new ItemMyAxe(304, MyEnumToolMaterial).setItemName("Holy Axe").setIconCoord(4, 0);
	public static Item itemHoe = new ItemMyHoe(305, MyEnumToolMaterial).setItemName("Holy Hoe").setIconCoord(5, 0);
	
	
	
	@Instance
	public static MyCraft instance;

	@SidedProxy(clientSide = "mods.mycraft.ClientProxy", serverSide = "mods.mycraft.CommonProxy")
	public static CommonProxy proxy;

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {

	}
	

	@Init
	public void init(FMLInitializationEvent evt) {
		LanguageRegistry.addName(blockEmeraldFurnaceIdle, "Emerald Furnace");
		LanguageRegistry.addName(blockEmeraldFurnaceActive, "Emerald Furnace");
		LanguageRegistry.addName(blockBlackTorch, "Black Torch");
		LanguageRegistry.addName(blockHellOre, "Hell Ore");
		LanguageRegistry.addName(itemHellShard, "Hell Shard");
		
		LanguageRegistry.addName(itemWeird, "Weird Item");
		LanguageRegistry.addName(itemSword, "Holy Sword");
		LanguageRegistry.addName(itemSpade, "Holy Spade");
		LanguageRegistry.addName(itemPickaxe, "Holy Pickaxe");
		LanguageRegistry.addName(itemAxe, "Holy Axe");
		LanguageRegistry.addName(itemHoe, "Holy Hoe");
		
		GameRegistry.registerBlock(blockEmeraldFurnaceIdle);
		GameRegistry.registerBlock(blockEmeraldFurnaceActive);
		GameRegistry.registerBlock(blockBlackTorch);
		GameRegistry.registerBlock(blockHellOre);
		
		GameRegistry.registerWorldGenerator(new MyWorldGenerator());

		GameRegistry.addRecipe(new ItemStack(blockEmeraldFurnaceIdle, 1), new Object[]{
			"XXX", "XYX" , "XXX", 'X', Block.blockEmerald, 'Y', Block.stoneOvenIdle
		});
		GameRegistry.addRecipe(new ItemStack(itemSword, 1), new Object[]{
			" X ", " X ", " Y ", 'X', Block.blockGold, 'Y', Item.stick
		});
		GameRegistry.addRecipe(new ItemStack(itemSpade, 1), new Object[]{
			" X ", " Y ", " Y ", 'X', Block.blockGold, 'Y', Item.stick
		});
		GameRegistry.addRecipe(new ItemStack(itemPickaxe, 1), new Object[]{
			"XXX", " Y ", " Y ", 'X', Block.blockGold, 'Y', Item.stick
		});
		GameRegistry.addRecipe(new ItemStack(itemAxe, 1), new Object[]{
			"XX ", "XY ", " Y ", 'X', Block.blockGold, 'Y', Item.stick
		});
		GameRegistry.addRecipe(new ItemStack(itemHoe, 1), new Object[]{
			"XX ", " Y ", " Y ", 'X', Block.blockGold, 'Y', Item.stick
		});
		
		GameRegistry.registerFuelHandler(new Fuel());
		
		GameRegistry.addSmelting(Block.planks.blockID, new ItemStack(Block.blockEmerald, 9), 5F);
		
		proxy.registerRenderInformation();
	}

	@PostInit
	public void postInit(FMLPostInitializationEvent evt) {

	}

	public MyCraft() {

	}
}
