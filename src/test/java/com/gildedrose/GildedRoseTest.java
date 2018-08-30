package com.gildedrose;

import static org.junit.Assert.*;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class GildedRoseTest {

    @Test
    @Parameters({"10, 8","7, 5"," 1, 0"})
    public void When_ExpiredNormalItemTicks_Expect_QualityDecreasesByTwo(int quality,  int expectedQuality) {
        Item[] items = new Item[] { new Item("normal", 0, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(expectedQuality, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    public void When_ExpiredNormalItemWithQuality0Ticks_Expect_QualityRemains0() {
        Item[] items = new Item[] { new Item("normal", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    @Parameters({"4, 6, 3, 5", "5, 10, 4, 9"})
    public void When_NormalItemTicks_Expect_QualityAndSellInDecreaseByOne(int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        Item[] items = new Item[] { new Item("normal", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(expectedQuality, app.items[0].quality);
        assertEquals(expectedSellIn, app.items[0].sellIn);
    }
    @Test
    @Parameters({"4, 6, 3, 7", "5, 10, 4, 11"})
    public void When_CheeseTicks_Expect_QualityIncreaseByOne_AndSellInDecreaseByOne(int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        Item[] items = new Item[] { new Item("Aged Brie", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(expectedQuality, app.items[0].quality);
        assertEquals(expectedSellIn, app.items[0].sellIn);
    }

    @Test
    public void When_ExpiredCheeseTicks_Expect_QualityIncreaseByOne_AndSellInRemainsZero() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    public void When_VeryHighQualityCheeseTicks_Expect_QualityRemainsTheSame_AndSellInDeacreasesByOne() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

}
