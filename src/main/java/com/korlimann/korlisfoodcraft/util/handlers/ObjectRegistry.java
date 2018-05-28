package com.korlimann.korlisfoodcraft.util.handlers;

import java.util.HashSet;
import java.util.Set;

import com.korlimann.korlisfoodcraft.Main;
import com.korlimann.korlisfoodcraft.blocks.kitchenboard.TileEntityKitchenboard;
import com.korlimann.korlisfoodcraft.gen.KFCWorldGen;
import com.korlimann.korlisfoodcraft.init.ModBlocks;
import com.korlimann.korlisfoodcraft.init.ModItems;
import com.korlimann.korlisfoodcraft.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class ObjectRegistry {
	
	/*
	 * In this class, all our blocks and items get registered (models/textures/names load) so they'll show up ingame
	 * */
	
	public static Set<Item> items = new HashSet<Item>();
	public static Set<Block> blocks = new HashSet<Block>();
	
	public static void prepareBlocks(){
		blocks.add(ModBlocks.CROP_CORN);
		blocks.add(ModBlocks.CROP_HOPS);
		blocks.add(ModBlocks.CROP_MALT);
		blocks.add(ModBlocks.CROP_ONION);
		//blocks.add(ModBlocks.KITCHENBOARD_BLOCK);
		blocks.add(ModBlocks.SUNFLOWER);
		blocks.add(ModBlocks.BEER);
		blocks.add(ModBlocks.SALT_ORE);
		blocks.add(ModBlocks.SEAWEED_BLOCK);
		blocks.add(ModBlocks.HERBGARDEN);
		blocks.add(ModBlocks.AVOCADO_BLOCK);
		blocks.add(ModBlocks.AVOCADO_SAPLING);
	}
	
	public static void prepareItems() {
		items.add(ModItems.RICE);
		items.add(ModItems.AVOCADO);
		//items.add(ModItems.GURKE);
		items.add(ModItems.SEAWEED);
		//items.add(ModItems.CORN_SEED);
		items.add(ModItems.CORN);
		items.add(ModItems.OLIVE);
		items.add(ModItems.TOMATO);
		items.add(ModItems.ONION);
		//items.add(ModItems.CHAMPIGNONS);
		items.add(ModItems.SALZ);
		//items.add(ModItems.GESCHNITTENE_AVOCADO);
		//items.add(ModItems.GESCHNITTENE_GURKE);
		//items.add(ModItems.TOMATENSAUCE);
		//items.add(ModItems.MEHL);
		items.add(ModItems.OLIVEOIL);
		//items.add(ModItems.HEFEPILZ);
		items.add(ModItems.NORI);
		items.add(ModItems.LACHSSUSHI);
		//items.add(ModItems.AVOCADOSUSHI);
		//items.add(ModItems.MAKI);
		items.add(ModItems.AVOCADOMAKI);
		items.add(ModItems.LACHSMAKI);
		items.add(ModItems.GURKENMAKI);
		items.add(ModItems.ONIGIRI);
		items.add(ModItems.CHEESE);
		//items.add(ModItems.MOZZARELLA);
		//items.add(ModItems.NUDELHOLZ);
		//items.add(ModItems.MISCHSCHUESSEL);
		//items.add(ModItems.BRETTMITMESSER);
		//items.add(ModItems.BEER);
		items.add(ModItems.BURGER);
		items.add(ModItems.BUTTER);
		items.add(ModItems.CACAO);
		items.add(ModItems.COFFEE);
		items.add(ModItems.COOKINGPOT);
		items.add(ModItems.CUP);
		items.add(ModItems.DOENER);
		items.add(ModItems.GOASMOAS);
		items.add(ModItems.JAEGERMEISTER);
		items.add(ModItems.KITCHENKNIFE);
		items.add(ModItems.MORTAR);
		items.add(ModItems.PAN);
		items.add(ModItems.PIZZA);
		items.add(ModItems.POMMES);
		items.add(ModItems.RADLER);
		items.add(ModItems.SAUSAGE);
		//items.add(ModItems.TOMATOSEEDS);
		items.add(ModItems.RAW_FRIES);
		items.add(ModItems.PEPPER);
		items.add(ModItems.PARSLEY);
		items.add(ModItems.OREGANO);
		items.add(ModItems.MISCHSCHUESSEL);
		items.add(ModItems.MALT);
		items.add(ModItems.LEEK);
		items.add(ModItems.HOPS);
		items.add(ModItems.FLOUR);
		items.add(ModItems.EISBERGSALAT);
		items.add(ModItems.DOUGH);
	}
	
	//This method will be called without us calling it. This is because 
	//Forge calls it -for- us, when the RegistryEvent happens. This is why
	//we had to use the @Mod.EventBusSubscriber at the top of the class.
	@SubscribeEvent
	public static void registerBlocks(Register<Block> event){
		
		//We make sure that the list gets filled with our blocks.
		prepareBlocks();
		
		for(Block block : blocks){
			event.getRegistry().register(block);
		}
	}
	
	//We do not need to call prepareBlocks() in this method, because Blocks are registered before items.
	//Thus, our registerBlocks method has already happened.
	@SubscribeEvent
	public static void registerItems(Register<Item> event){
		
		for(Block block : blocks){
			ItemBlock iblock = new ItemBlock(block);
			iblock.setRegistryName(block.getRegistryName());
			event.getRegistry().register(iblock);
		}		
		
		prepareItems();
		
		for(Item item : items) {
			event.getRegistry().register(item);
		}
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {		
		for(Block block : blocks) {
			if(block instanceof IHasModel) {
				((IHasModel)block).registerModels();
			}
		}
		for(Item item : items) {
			if(item instanceof IHasModel) {
				((IHasModel)item).registerModels();
			}
		}
	}
	
	public static void Common() {
		GameRegistry.registerWorldGenerator(new KFCWorldGen(), 0);
		GameRegistry.registerTileEntity(TileEntityKitchenboard.class, "tileentitykitchenboard");
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
	}
}