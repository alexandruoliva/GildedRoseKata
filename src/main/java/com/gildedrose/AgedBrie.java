package com.gildedrose;

public class AgedBrie extends Item {
	public AgedBrie(int sellIn, int quality ) {
		super("agedBrie",sellIn, quality);
	}
	
	void handleAgedBrie() {
        if (this.quality < 50)
            this.quality += 1;
        if (this.sellIn > 0)
            this.sellIn -= 1;
    }
}
