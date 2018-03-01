package com.korlimann.korlisfoodcraft.init;

import java.util.ArrayList;
import java.util.List;

import com.korlimann.korlisfoodcraft.items.ItemBase;
import com.korlimann.korlisfoodcraft.items.ItemBaseFood;
import com.korlimann.korlisfoodcraft.items.ItemBaseSeed;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class ModItems {

	/*
	 * In this class, all our items get initalized before they then get registered by our ObjectRegistry class. Hereby, the
	 * name every item at least has, is the one that you will need to set all your textures/models-files to.
	 * */
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	//CT = Craftingtable
	//Drops von Pflanzen (Essbar)
	public static final Item RICE = new ItemBaseSeed(ModBlocks.CROP_RICE, Blocks.FARMLAND, "rice"); //Gefunden in der Wildnis/Villagerdörfer/Kisten
	public static final Item AVOCADO = new ItemBaseFood("avocado", 3, 0.3f, false); //Wächst an Bäumen - Einzeln im CT = Seeds für Avocadobaum
	public static final Item GURKE = new ItemBase("gurke"); //Gefunden in der Wildnis/Villagerdörfer/Kisten
	public static final Item SEAWEED = new ItemBase("seaweed"); //Droppt von (neuen?) Unterwasserpflanzen
	public static final Item CORN_SEED = new ItemBaseSeed(ModBlocks.CROP_CORN, Blocks.FARMLAND, "corn_seed"); //Gefunden in der Wildnis/Villagerdörfer/Kisten
	public static final Item CORN = new ItemBaseFood("corn", 2, 0.3f, false);
	public static final Item OLIVE = new ItemBase("olive"); //Gefunden in der Wildnis/Villagerdörfer/Kisten
	public static final Item TOMATO = new ItemBaseFood("tomato", 2, 0.3f, false); //Gefunden in der Wildnis/Villagerdörfer/Kisten
	public static final Item CHAMPIGNONS = new ItemBase("champignons"); //Gefunden in der Wildnis/Villagerdörfer/Kisten
	
	//Drops von Blöcken
	public static final Item SALZ = new ItemBase("salt"); //Gefunden in der Wildnis(Erz)/Villagerdörfer/Kisten
	
	//Bearbeitetes Essen (Pflanzen/Essbar)
	public static final Item GESCHNITTENE_AVOCADO = new ItemBase("geschnittene_avocado"); //Hergestellt: Brett: Messer + Avocado
	public static final Item GESCHNITTENE_GURKE = new ItemBase("geschnittene_gurke"); //Hergestellt: Brett: Messer + Gurke = 4 geschnittene Gurke
	public static final Item TOMATENSAUCE = new ItemBase("tomatensauce"); //Hergestellt: Mörser
	
	//Bearbeitetes Essen (Anderes/Nicht essbar)
	public static final Item MEHL = new ItemBase("mehl"); //Hergestellt: Mörser
	public static final Item OLIVEOIL = new ItemBase("oliveoil"); //Hergestellt: Mörser
	public static final Item HEFEPILZ = new ItemBase("hefepilz");
	public static final Item NORI = new ItemBase("nori"); //Crafted from seaweed
	
	//Sushi, etc.
	public static final Item LACHSSUSHI = new ItemBase("lachssushi"); //Reis, Filetierter Lachs	
	public static final Item AVOCADOSUSHI = new ItemBase("avocadosushi"); //Reis, Avocado
	public static final Item MAKI = new ItemBase("maki"); //Reis, Seetang
	public static final Item AVOCADOMAKI = new ItemBase("avocadomaki"); //Reis, Seetang, Avocado / Maki, Avocado
	public static final Item LACHSMAKI = new ItemBase("lachsmaki"); //Reis, Seetang, Filetierter Lachs / Maki, Filetierter Lachs
	public static final Item GURKENMAKI = new ItemBase("gurkenmaki"); //Reis, Seetang, geschnittene Gurke / Maki, geschnittene Gurke
	public static final Item ONIGIRI = new ItemBase("onigiri");
	
	//Käse
	public static final Item CHEESE = new ItemBase("cheese"); //Wird mit Milch und Lab hergestellt
	public static final Item MOZZARELLA = new ItemBase("mozzarella"); //Wird mit Büffelmilch hergestellt, auf einem Brett
	public static final Item LAB = new ItemBase("lab"); //Wird von Kuhkälbern gedroppt
		
	//Küchengeräte
	public static final Item NUDELHOLZ = new ItemBase("nudelholz");
	public static final Item MESSER = new ItemBase("messer");
	public static final Item KOCHTOPF = new ItemBase("kochtopf");
	public static final Item PFANNE = new ItemBase("pfanne");
	public static final Item MOERSER = new ItemBase("moerser");
	public static final Item MISCHSCHUESSEL = new ItemBase("mischschuessel");
	public static final Item BRETTMITMESSER = new ItemBase("brettmitmesser"); //Hergestellt: Werkbank: Brett + Messer
	
	public static final Item BEER = new ItemBase("beer");
	public static final Item BURGER = new ItemBase("burger");
	public static final Item BUTTER = new ItemBase("butter");
	public static final Item CACAO = new ItemBase("cacao");
	public static final Item COFFEE = new ItemBase("coffee");
	public static final Item COOKINGPOT = new ItemBase("cookingpot");
	public static final Item CUP = new ItemBase("cup");
	public static final Item DOENER = new ItemBase("doener");
	public static final Item GOASMOAS = new ItemBase("goasmoas");
	public static final Item JAEGERMEISTER = new ItemBase("jaegermeister");
	public static final Item KITCHENKNIFE = new ItemBase("kitchenknife");
	public static final Item MORTAR = new ItemBase("mortar");
	public static final Item PAN = new ItemBase("pan");
	public static final Item PIZZA = new ItemBase("pizza");
	public static final Item POMMES = new ItemBase("pommes");
	public static final Item RADLER = new ItemBase("radler");
	public static final Item SAUSAGE = new ItemBase("sausage");
	public static final Item TOMATOSEEDS = new ItemBase("tomatoseeds");
}
