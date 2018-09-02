package com.gildedrose;

import static org.junit.Assert.*;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class GildedRoseTest {

	@Before
	public void Setup() {

	}

	@Test
	@Parameters({ "10, 8", "7, 5", " 1, 0" })
	public void When_ExpiredNormalItemTicks_Expect_QualityDecreasesByTwo(int quality, int expectedQuality) {
		Item[] items = new Item[] { new NormalItem(0, quality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(expectedQuality, app.items[0].quality);
		assertEquals(0, app.items[0].sellIn);
	}

	@Test
	public void When_ExpiredNormalItemWithQuality0Ticks_Expect_QualityRemains0() {
		Item[] items = new Item[] { new NormalItem(0, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(0, app.items[0].quality);
		assertEquals(0, app.items[0].sellIn);
	}

	@Test
	@Parameters({ "4, 6, 3, 5", "5, 10, 4, 9" })
	public void When_NormalItemTicks_Expect_QualityAndSellInDecreaseByOne(int sellIn, int quality, int expectedSellIn,
			int expectedQuality) {
		Item[] items = new Item[] { new NormalItem(sellIn, quality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(expectedQuality, app.items[0].quality);
		assertEquals(expectedSellIn, app.items[0].sellIn);
	}

	@Test
	@Parameters({ "4, 6, 3, 7", "5, 10, 4, 11" })
	public void When_CheeseTicks_Expect_QualityIncreaseByOne_AndSellInDecreaseByOne(int sellIn, int quality,
			int expectedSellIn, int expectedQuality) {
		Item[] items = new Item[] { new AgedBrie(sellIn, quality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(expectedQuality, app.items[0].quality);
		assertEquals(expectedSellIn, app.items[0].sellIn);
	}

	@Test
	public void When_ExpiredCheeseTicks_Expect_QualityIncreaseByOne_AndSellInRemainsZero() {
		Item[] items = new Item[] { new AgedBrie(0, 10) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(11, app.items[0].quality);
		assertEquals(0, app.items[0].sellIn);
	}

	@Test
	@Parameters({ "5, 4", "0, 0" })
	public void When_VeryHighQualityCheeseTicks_Expect_QualityRemainsTheSame_AndSellInDeacreasesByOne(int sellIn,
			int exptectedSellIn) {
		Item[] items = new Item[] { new AgedBrie(sellIn, 50) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(50, app.items[0].quality);
		assertEquals(exptectedSellIn, app.items[0].sellIn);
	}

	@Test
	@Parameters({ "5, 4", "0, 0" })
	public void When_SulfurasTicks_Expect_QualityRemainsTheSame_AndSellInDeacreasesByOne(int sellIn,
			int exptectedSellIn) {
		Item[] items = new Item[] { new Sulfuras(sellIn, 100) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(100, app.items[0].quality);
		assertEquals(exptectedSellIn, app.items[0].sellIn);
	}

	@Test
	@Parameters({ "11, 10, 4, 5" })
	public void When_BackstagePassesTicks_AndSellInOver10Days_Expect_QualityIncreasesByOne_AndSellInDecreasesByOne(
			int sellIn, int exptectedSellIn, int quality, int qualityExpected) {
		Item[] items = new Item[] { new BackstagePasses(sellIn, quality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(qualityExpected, app.items[0].quality);
		assertEquals(exptectedSellIn, app.items[0].sellIn);
	}

	@Test
	@Parameters({ "7, 6, 4, 6" })
	public void When_BackstagePassesTicks_AndSellInBetween5And10Days_Expect_QualityIncreasesByTwo_AndSellInDecreasesByOne(
			int sellIn, int exptectedSellIn, int quality, int qualityExpected) {
		Item[] items = new Item[] { new BackstagePasses(sellIn, quality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(qualityExpected, app.items[0].quality);
		assertEquals(exptectedSellIn, app.items[0].sellIn);
	}

	@Test
	@Parameters({ "4, 3, 4, 7" })
	public void When_BackstagePassesTicks_AndSellIsUnder5Days_Expect_QualityIncreasesByThree_AndSellInDecreasesByOne(
			int sellIn, int exptectedSellIn, int quality, int qualityExpected) {
		Item[] items = new Item[] { new BackstagePasses(sellIn, quality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(qualityExpected, app.items[0].quality);
		assertEquals(exptectedSellIn, app.items[0].sellIn);
	}

	@Test
	@Parameters({ "1, 0, 4, 0" })
	public void When_BackstagePassesTicks_AndSellIs0_Expect_QualityDropsTo0_AndSellRemains0(int sellIn,
			int exptectedSellIn, int quality, int qualityExpected) {
		Item[] items = new Item[] { new BackstagePasses(sellIn, quality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(qualityExpected, app.items[0].quality);
		assertEquals(exptectedSellIn, app.items[0].sellIn);
	}

	@Test
	public void When_InventoryContainingCheeseAndSulfurasTicks_Expect_QualityAndSellInUpdateCorrectly() {
		Item[] items = new Item[] { new AgedBrie(4, 3), new Sulfuras(20, 30) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(4, app.items[0].quality);
		assertEquals(30, app.items[1].quality);
		assertEquals(3, app.items[0].sellIn);
		assertEquals(19, app.items[1].sellIn);
	}

	@Test
	public void When_InventoryContainingConjuredTicks_Expect_QualityDecreseBy4() {

	}

	@Test
	@Parameters({ "9,8,10, 9", "8,7,5, 4", "3,2, 4, 3" })
	public void When_InventoryContainingConjuredTicksNormal_Expect_QualityAndSellInDecreseBy1(int sellIn, int expectedSellIn,
			int quality, int expectedQuality) {
		Item[] items = new Item[] { new Conjured( sellIn, quality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(expectedQuality, app.items[0].quality);
		assertEquals(expectedSellIn, app.items[0].sellIn);
	}
	@Test
	@Parameters({ "8,4", "4,0", "3,0" })
	public void When_InventoryContainingConjuredExpired_Expect_QualityDecreasesBy4(
			int quality, int expectedQuality) {
		Item[] items = new Item[] { new Conjured( 0,quality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(expectedQuality, app.items[0].quality);
		assertEquals(0, app.items[0].sellIn);
	}
}
