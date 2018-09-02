package com.gildedrose;

public class BackstagePasses extends Item{

	public BackstagePasses( int sellIn, int quality) {
		super("Backstage Passes", sellIn, quality);
	}
	public void handle() {
	        if (this.sellIn > 10) {
	            this.quality += 1;
	        } else if (this.sellIn > 5) {
	            this.quality += 2;
	        } else if (this.sellIn > 1) {
	            this.quality += 3;
	        } else {
	            this.quality = 0;
	        }
	        this.sellIn -= 1;
	    }
	
}
