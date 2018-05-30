package com.korlimann.korlisfoodcraft.init;

import java.util.ArrayList;
import java.util.List;

import com.korlimann.korlisfoodcraft.items.ItemBase;
import com.korlimann.korlisfoodcraft.items.ItemBaseFood;
import com.korlimann.korlisfoodcraft.items.ItemBaseSeed;
import com.korlimann.korlisfoodcraft.items.ItemBaseSeedFood;
import com.korlimann.korlisfoodcraft.items.ItemBlockBaseSpecial;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class ModItems {

	/*
	 * In this class, all our items get initalized before they then get registered by our ObjectRegistry class. Hereby, the
	 * name every item at least has, is the one that you will need to set all your textures/models-files to.
	 * */
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	//CT = Craftingtable
	//Drops von Pflanzen (Essbar)
	public static final Item AVOCADO = new ItemBaseFood("avocado", 3, 0.3f, false); //Wächst an Bäumen - Einzeln im CT = Seeds für Avocadobaum
	public static final Item CHAMPIGNONS = new ItemBase("champignons"); //Gefunden in der Wildnis/Villagerdörfer/Kisten
	public static final Item CORN = new ItemBaseSeedFood("corn", ModBlocks.CROP_CORN, Blocks.FARMLAND, 2, 0.0f);
	public static final Item CUCUMBER = new ItemBase("gurke"); //Gefunden in der Wildnis/Villagerdörfer/Kisten
	public static final Item OLIVE = new ItemBase("olive"); //Gefunden in der Wildnis/Villagerdörfer/Kisten
	public static final Item ONION = new ItemBaseSeedFood("onion", ModBlocks.CROP_ONION, Blocks.FARMLAND, 2, 0.0f);
	public static final Item RICE = new ItemBaseSeedFood("rice", ModBlocks.CROP_RICE, Blocks.FARMLAND, 2, 0.0f); //Gefunden in der Wildnis/Villagerdörfer/Kisten
	public static final Item SEAWEED = new ItemBlockBaseSpecial(ModBlocks.SEAWEED_BLOCK, "seaweed"); //Droppt von Seegras
	public static final Item TOMATO = new ItemBaseFood("tomato", 2, 0.3f, false); //Gefunden in der Wildnis/Villagerdörfer/Kisten
	//public static final Item CORN_SEED = new ItemBaseSeed(ModBlocks.CROP_CORN, Blocks.FARMLAND, "corn_seed"); //Gefunden in der Wildnis/Villagerdörfer/Kisten
	//public static final Item TOMATOSEEDS = new ItemBase("tomatoseeds"); 
	
	//Drops von Blöcken
	public static final Item SALT = new ItemBase("salt"); //Gefunden in der Wildnis(Erz)/Villagerdörfer/Kisten
	
	//Bearbeitetes Essen (Pflanzen/Essbar)
	//public static final Item GESCHNITTENE_AVOCADO = new ItemBaseFood("geschnittene_avocado", 2, 0.6f, false); //Hergestellt: Brett: Messer + Avocado
	//public static final Item GESCHNITTENE_GURKE = new ItemBaseFood("geschnittene_gurke", 2, 0.6f, false); //Hergestellt: Brett: Messer + Gurke = 4 geschnittene Gurke
	
	//Bearbeitetes Essen (Anderes/Nicht essbar)	
	public static final Item DOUGH = new ItemBase("dough");
	public static final Item FLOUR = new ItemBase("flour");
	public static final Item NORI = new ItemBase("nori"); //Crafted from seaweed
	public static final Item OLIVEOIL = new ItemBase("oliveoil"); //Hergestellt: Mörser
	public static final Item RAW_FRIES = new ItemBase("raw_fries");
	//public static final Item HEFEPILZ = new ItemBase("hefepilz");
	//public static final Item BEER_AND_LEMONADE = new ItemBase("radler");
	
	//Bearbeitetes/Gekochtes Essen
	public static final Item AVOCADOMAKI = new ItemBaseFood("avocadomaki", 2, 0.6f, false); //Reis, Seetang, Avocado / Maki, Avocado
	public static final Item AVOCADOSUSHI = new ItemBaseFood("avocadosushi", 2, 0.6f, false); //Reis, Avocado
	public static final Item BEER = new ItemBase("beer");
	public static final Item BURGER = new ItemBaseFood("burger", 2, 0.6f, false);
	public static final Item BUTTER = new ItemBaseFood("butter", 2, 0.6f, false);
	public static final Item CACAO = new ItemBaseFood("cacao", 2, 0.6f, false);
	public static final Item CHEESE = new ItemBaseFood("cheese", 2, 0.6f, false); //Wird mit Milch und Lab hergestellt
	public static final Item COFFEE = new ItemBaseFood("coffee", 2, 0.6f, false);
	public static final Item CUCUMBERMAKI = new ItemBaseFood("gurkenmaki", 2, 0.6f, false); //Reis, Seetang, geschnittene Gurke / Maki, geschnittene Gurke
	public static final Item FRIES = new ItemBaseFood("pommes", 2, 0.6f, false);
	public static final Item HOPS = new ItemBaseSeedFood("hops", ModBlocks.CROP_HOPS, Blocks.FARMLAND, 2, 0.0f);
	public static final Item ICEBERG_SALAD = new ItemBaseFood("eisbergsalat", 2, 0.6f, false);
	public static final Item JAEGERMEISTER = new ItemBaseFood("jaegermeister", 2, 0.6f, false);
	public static final Item KEBAB = new ItemBaseFood("doener", 2, 0.6f, false);
	public static final Item LEEK = new ItemBaseFood("leek", 2, 0.6f, false);
	public static final Item MAKI = new ItemBaseFood("maki", 2, 0.6f, false); //Reis, Seetang
	public static final Item MALT = new ItemBaseSeedFood("malt", ModBlocks.CROP_MALT, Blocks.FARMLAND, 2, 0.0f);
	public static final Item ONIGIRI = new ItemBaseFood("onigiri", 2, 0.6f, false);
	public static final Item OREGANO = new ItemBaseFood("oregano", 2, 0.6f, false);
	public static final Item PARSLEY = new ItemBaseFood("parsley", 2, 0.6f, false);
	public static final Item PEPPER = new ItemBaseFood("pepper", 2, 0.6f, false);
	public static final Item PIZZA = new ItemBaseFood("pizza", 2, 0.6f, false);
	public static final Item SALMONMAKI = new ItemBaseFood("lachsmaki", 2, 0.6f, false); //Reis, Seetang, Filetierter Lachs / Maki, Filetierter Lachs
	public static final Item SALMONSUSHI = new ItemBaseFood("lachssushi", 2, 0.6f, false); //Reis, Filetierter Lachs	
	public static final Item SAUSAGE = new ItemBaseFood("sausage", 2, 0.6f, false);
	public static final Item TOMATOSAUCE = new ItemBaseFood("tomatensauce", 2, 0.6f, false); //Hergestellt: Mörser
	//public static final Item MOZZARELLA = new ItemBaseFood("mozzarella", 2, 0.6f, false); //Wird mit Büffelmilch hergestellt, auf einem Brett
	//public static final Item LAB = new ItemBase("lab"); //Wird von Kuhkälbern gedroppt	
		
	//Küchengeräte
	public static final Item COOKINGPOT = new ItemBase("cookingpot");
	public static final Item CUP = new ItemBase("cup");
	public static final Item GOSMAS = new ItemBase("goasmoas");
	public static final Item KITCHENKNIFE = new ItemBase("kitchenknife");
	public static final Item MIXINGBOWL = new ItemBase("mischschuessel");
	public static final Item MORTAR = new ItemBase("mortar");
	public static final Item PAN = new ItemBase("pan");
	public static final Item PASTRY_ROLLER = new ItemBase("nudelholz");
	//public static final Item BRETTMITMESSER = new ItemBase("brettmitmesser"); //Hergestellt: Werkbank: Brett + Messer
}
