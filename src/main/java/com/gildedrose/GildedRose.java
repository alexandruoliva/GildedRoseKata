package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {
            if (item.name == "normal") {
                handleNormal(item);
            } else if (item.name == "Aged Brie") {
                handleAgedBrie(item);
            } else if (item.name == "Sulfuras") {
                handleSulfuras(item);
            } else {
                handleBackstagePasses(item);
            }
        }
    }

    private void handleNormal(Item item) {
        if (item.sellIn == 0) {
            if (item.quality > 1)
                item.quality -= 2;
            else
                item.quality = 0;
        } else {
            item.quality -= 1;
            item.sellIn -= 1;
        }
    }

    private void handleAgedBrie(Item item) {
        if (item.quality < 50)
            item.quality += 1;
        if (item.sellIn > 0)
            item.sellIn -= 1;
    }

    private void handleSulfuras(Item item) {
        if (item.sellIn > 0)
            item.sellIn -= 1;
    }

    private void handleBackstagePasses(Item item) {
        if (item.sellIn > 10) {
            item.quality += 1;
        } else if (item.sellIn > 5) {
            item.quality += 2;
        } else if (item.sellIn > 1) {
            item.quality += 3;
        } else {
            item.quality = 0;
        }
        item.sellIn -= 1;
    }

}