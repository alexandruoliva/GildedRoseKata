package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        if (items[0].sellIn == 0){
            items[0].quality = 8;
        }else {
            items[0].quality = 9;
            items[0].sellIn = 4;
        }
        }
}