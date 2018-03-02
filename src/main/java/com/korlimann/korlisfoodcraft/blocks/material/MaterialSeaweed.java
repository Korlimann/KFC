package com.korlimann.korlisfoodcraft.blocks.material;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class MaterialSeaweed extends Material {

	
	
	public MaterialSeaweed(MapColor color) {
		super(color);
		this.setNoPushMobility();
		
	}
	
	public boolean isLiquid()
    {
        return true;
    }

	
}
