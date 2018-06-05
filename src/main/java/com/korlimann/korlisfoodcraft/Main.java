package com.korlimann.korlisfoodcraft;

import com.korlimann.korlisfoodcraft.proxy.CommonProxy;
import com.korlimann.korlisfoodcraft.tabs.KorlisSushiCraft;
import com.korlimann.korlisfoodcraft.util.Reference;
import com.korlimann.korlisfoodcraft.util.handlers.ObjectRegistry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/*
 * Main Class. Can't really put in words what happens here. See first/second tutorial from Loremasters Youtube Tutorial
 * */
@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
 
	public static final CreativeTabs korlissushicraft = new KorlisSushiCraft("korlissushicraft");
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event) {
		ObjectRegistry.Common();
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		
	}
	
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event) {
		
	}
}
