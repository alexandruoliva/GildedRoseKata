package com.gildedrose;

public class Sulfuras extends Item {
	public Sulfuras(int sellIn, int quality) {
		super("Sulfuras", sellIn, quality);
	}
	@Override
	public void handle() {
		if (this.sellIn > 0)
            this.sellIn -= 1;
	}
}
