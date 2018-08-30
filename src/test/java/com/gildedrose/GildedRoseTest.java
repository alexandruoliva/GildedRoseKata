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

}
