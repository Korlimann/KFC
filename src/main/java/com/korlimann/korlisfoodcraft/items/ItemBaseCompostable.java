package com.korlimann.korlisfoodcraft.items;

public class ItemBaseCompostable extends ItemBase implements ICompostableItem {

	public ItemBaseCompostable(String name) {
		super(name);
	}

	@Override
	public int getCompostFillValue() {
		return 1;
	}

}
