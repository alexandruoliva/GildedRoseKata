package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {
            if (item.name == "normal") {
                ((NormalItem)item).handle();
            } else if (item.name == "Aged Brie") {
                ((AgedBrie)item).handle();
            } else if (item.name == "Sulfuras") {
            	((Sulfuras)item).handle();
            } else if(item.name== "Backstage Passes"){
            	((BackstagePasses)item).handle();
            } else if(item.name=="Conjured") {
            	((Conjured)item).handle();
            }
        }
    }
}