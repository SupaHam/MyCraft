// This Mod has been developed by iAliHD using Wuppy29's Tutorial guide for help!

package mycraft.common;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "iAliHD_MyCraft", name = "MyCraft", version = "Indev 0.2")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class MyCraft {
	
	@Instance
	public static MyCraft instance;
	
	@SidedProxy(clientSide = "mycraft.client.ClientProxy", serverSide = "mycraft.common.CommonProxy")
	public static CommonProxy proxy;
	
	public final static String itemT = "/mycraft/common/item.png";
	public final static String blockT = "/mycraft/common/block.png";
	
	// Refering the blocks
	public static int hellOreID = 230;
	public static Block hellOre;
	public static Block hellStone;
	
	// Refering the items
	public static Item hellShard;
	public static Item lemonFood;
	public static Item holyShard;
	
	public static Item holySword;
	public static Item holyPickaxe;
	public static Item holyShovel;
	
	static EnumToolMaterial HolyToolMaterial = EnumHelper.addToolMaterial("HolyMaterial", 3, 1024, 10F, 2, 14);
	
	@Init
	public void load(FMLInitializationEvent event){
		loadBlocks();
		loadItems();
		loadRecipies();
		loadShapelessRecipies();
		loadSmeltingRecipies();
		loadDungeonStuff();
		loadGeneration();
		proxy.registerRenderInformation();
		
	}
	
	public void loadBlocks(){
		
		//Mineable
		hellOre = new BlockOres(hellOreID, 1).setStepSound(Block.soundStoneFootstep).setHardness(3F).setResistance(3F).setBlockName("hellOre");
		Item.itemsList[hellOreID] = new ItemBlockOres(hellOreID-256, hellOre).setItemName("hellOre");
		LanguageRegistry.instance().addStringLocalization("tile.hellOre.ore.name", "Hell Ore");
		LanguageRegistry.instance().addStringLocalization("tile.hellOre.netherore.name", "Hell Stone");
		
		//Craftable
		hellStone = new BlockHellStone(231, 5).setStepSound(Block.soundStoneFootstep).setHardness(3F).setResistance(6F).setBlockName("hellStone");
		
	}
	
	public void loadItems(){
		
		//Mineable
		hellShard = new ItemHellShard(550).setIconIndex(6).setItemName("hellShard");
		LanguageRegistry.addName(hellShard, "Hell Shard");
		
		//Uncraftable
		lemonFood = new ItemLemonFood(551, 5, false).setIconIndex(7).setItemName("lemonFood");
		LanguageRegistry.addName(lemonFood, "Lemon");
		
		//Uncraftable
		holyShard = new ItemHolyShard(552).setIconIndex(8).setItemName("holyShard");
		LanguageRegistry.addName(holyShard, "Holy Shard");
		GameRegistry.registerFuelHandler(new Fuel());
		
		holySword = new ItemHolySword(553, HolyToolMaterial).setIconIndex(1).setItemName("holySword");
		LanguageRegistry.addName(holySword, "Holy Sword");
		
		holyShovel = new ItemHolyShovel(554, HolyToolMaterial).setIconIndex(2).setItemName("holyShovel");
		LanguageRegistry.addName(holyShovel, "Holy Shovel");
		
		holyPickaxe = new ItemHolyPickaxe(555, HolyToolMaterial).setIconIndex(3).setItemName("holyPickaxe");
		LanguageRegistry.addName(holyPickaxe, "Holy Pickaxe");

		
		
		
	}
	
	public void loadRecipies(){
		
		//Blocks
		GameRegistry.addRecipe(new ItemStack(hellStone), new Object[]{
			"XXX", "XXX", "XXX", 'X', hellShard
		});
		
		//Items
		GameRegistry.addRecipe(new ItemStack(holySword), new Object[]{
			"X", "X", "S", 'X', holyShard, 'S', Item.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(holySword), new Object[]{
			"X", "S", "S", 'X', holyShard, 'S', Item.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(holyPickaxe), new Object[]{
			"XXX", " S ", " S ", 'X', holyShard, 'S', Item.stick
		});
	}
	
	public void loadShapelessRecipies(){
		
	}
	
	public void loadSmeltingRecipies(){
		
	}
	
	public void loadDungeonStuff(){
		DungeonHooks.addDungeonLoot(new ItemStack(holyShard), 50, 1, 4);
		DungeonHooks.setDungeonLootTries(12);
	}
	
	public void loadGeneration(){
		GameRegistry.registerWorldGenerator(new MyWorldGeneration());
	}
	
	public void isPlayerFlying(EntityPlayer par1EntityPlayer){
		if(par1EntityPlayer.capabilities.isFlying){
			

		}
	}
}
