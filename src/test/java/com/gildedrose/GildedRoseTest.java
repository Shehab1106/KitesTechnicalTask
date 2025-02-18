package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void itemNameRemainsUnchanged() {
        Item[] items = new Item[] { new Item("Milk", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Milk", app.items[0].name); 
    }

    @Test
    void qualityDegradesTwiceAfterSellByDate() {
        Item[] items = new Item[] { new Item("Milk", -1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }

    @Test
    void qualityDegradesTwiceAfterSellByDate2() {
        Item[] items = new Item[] { new Item("Milk", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void qualityNeverNegative() {
        Item[] items = new Item[] { new Item("Milk", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality); 
    }

    @Test
    void agedBrieIncreasesQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality); 
    }

    @Test
    void agedBrieIncreasesQuality2() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 12) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, app.items[0].quality); 
    }

    @Test
    void qualityNeverExceeds50() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality); 
    }

    @Test
    void sulfurasDoesNotChange() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality); 
        assertEquals(5, app.items[0].sellIn); 
    }

    @Test
    void sulfurasDoesNotChange2() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 2, 60) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(60, app.items[0].quality); 
        assertEquals(2, app.items[0].sellIn); 
    }

    @Test
    void backstagePassesIncreaseInQualityFivetoTen() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality); 
    }

    @Test
    void backstagePassesIncreaseInQualityFivetoTen2() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 16) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(18, app.items[0].quality); 
    }
    @Test
    void backstagePassesIncreaseInQualityLessFive() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, app.items[0].quality); 
    }

    @Test
    void backstagePassesIncreaseInQualityLessFive2() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 3, 16) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(19, app.items[0].quality); 
    }

    @Test
    void backstagePassZeroAfterConcert() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality); 
    }

    @Test
    void conjuredItemsDegradeTwiceAsFast() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void conjuredItemsDegradeTwiceAsFast2() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 5, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].quality);
    }

    @Test
    void conjuredItemsDegradeFourAfterSellIn() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
    }

    @Test
    void conjuredItemsDegradeFourAfterSellIn2() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 14) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].quality);
    }
}
