package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        if (items[0].name=="normal") {
            if (items[0].sellIn == 0) {
                if (items[0].quality > 1)
                    items[0].quality -= 2;
                else
                    items[0].quality = 0;
            } else {
                items[0].quality -= 1;
                items[0].sellIn -= 1;
            }
        }
        else
        {
            if (items[0].sellIn > 0) {
                if (items[0].quality < 50)
                    items[0].quality += 1;
                items[0].sellIn -= 1;
            } else {
                if (items[0].quality < 50)
                    items[0].quality += 1;
            }
        }
    }

}