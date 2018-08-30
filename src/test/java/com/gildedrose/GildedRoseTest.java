package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void When_NormalItemTicks_Expect_QualityAndSellInDecreaseByOne() {
        Item[] items = new Item[] { new Item("normal", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    public void When_ExpiredNormalItemTicks_Expect_QualityDecreasesByTwo() {
        Item[] items = new Item[] { new Item("normal", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }

}
