package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {

            if (item.name == "normal") {
                if (item.sellIn == 0) {
                    if (item.quality > 1)
                        item.quality -= 2;
                    else
                        item.quality = 0;
                } else {
                    item.quality -= 1;
                    item.sellIn -= 1;
                }
            } else if (item.name == "Aged Brie") {
                if (item.quality < 50)
                    item.quality += 1;
                if (item.sellIn > 0)
                    item.sellIn -= 1;
            } else if (item.name == "Sulfuras") {
                if (item.sellIn > 0)
                    item.sellIn -= 1;

            } else {
                if (item.sellIn > 10) {
                    item.sellIn -= 1;
                    item.quality += 1;
                } else if (item.sellIn > 5) {
                    item.sellIn -= 1;
                    item.quality += 2;
                } else if (item.sellIn > 1) {
                    item.sellIn -= 1;
                    item.quality += 3;
                } else {
                    item.sellIn -= 1;
                    item.quality = 0;
                }
            }
        }
    }

}