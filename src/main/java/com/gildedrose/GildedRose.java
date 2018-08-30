package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        if (items[0].name == "normal") {
            if (items[0].sellIn == 0) {
                if (items[0].quality > 1)
                    items[0].quality -= 2;
                else
                    items[0].quality = 0;
            } else {
                items[0].quality -= 1;
                items[0].sellIn -= 1;
            }
        } else if (items[0].name == "Aged Brie") {
            if (items[0].quality < 50)
                items[0].quality += 1;
            if (items[0].sellIn > 0)
                items[0].sellIn -= 1;
        } else if (items[0].name == "Sulfuras"){
            if (items[0].sellIn > 0)
            items[0].sellIn -= 1;

        }
        else {
            if(items[0].sellIn>10){
                items[0].sellIn -= 1;
                items[0].quality +=1;
            }
            else if(items[0].sellIn>5){
                items[0].sellIn -= 1;
                items[0].quality +=2;
            }
        }
    }

}