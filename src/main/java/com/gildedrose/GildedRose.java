package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {
            if (item.name == "normal") {
                ((NormalItem)item).handleNormalItem();
            } else if (item.name == "Aged Brie") {
                ((AgedBrie)item).handleAgedBrie();
            } else if (item.name == "Sulfuras") {
            	((Sulfuras)item).handleSulfuras();
            } else {
            	((BackstagePasses)item).handleBackstagePasses();
            }
        }
    }
}