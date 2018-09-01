package com.gildedrose;

public class NormalItem extends Item{
    public NormalItem(int sellIn, int quality) {
        super("normal", sellIn, quality);
    }

    public void handleNormalItem() {
        if (this.sellIn == 0) {
            if (this.quality > 1)
                this.quality -= 2;
            else
                this.quality = 0;
        } else {
            this.quality -= 1;
            this.sellIn -= 1;
        }
    }
}