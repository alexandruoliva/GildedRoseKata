package com.gildedrose;

public class Conjured extends Item {

	public Conjured(int sellIn, int quality) {
		super("Conjured", sellIn, quality);
	}
	public void handle() {
		if(this.sellIn==0) {
		 if(this.quality>4)
			 this.quality -=4;
		else
			this.quality=0;
		}else {
			this.quality -= 1;
			this.sellIn -= 1;
		}
	}

}
