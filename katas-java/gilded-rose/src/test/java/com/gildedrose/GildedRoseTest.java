package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseTest {


  @Test
  public void quality_cannot_drop_below_0() {
    ValuableItem[] items = new ValuableItem[]{new ValuableItem("foo", 0, 0)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(0, app.items[0].getQuality());
  }

  @Test
  public void quality_cannot_be_higher_than_50() {
    ValuableItem[] items = new ValuableItem[]{new ValuableItem("Aged Brie", 0, 50)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(50, app.items[0].getQuality());
  }

  @Test
  public void Aged_brie_get() {
    ValuableItem[] items = new ValuableItem[]{
            new ValuableItem("Aged Brie", 0, 30),
            new ValuableItem("Aged Brie", -3, 30)
    };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(32, app.items[0].getQuality());
    assertEquals(32, app.items[1].getQuality());
  }

  @Test
  public void quality_degrades_twice_as_fast_when_sell_date_passes() {
    ValuableItem[] items = new ValuableItem[]{new ValuableItem("foo", 0, 10)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(8, app.items[0].getQuality());
  }

  @Test
  public void aged_brie_increases_quality_when_gets_older() {
    ValuableItem[] items = new ValuableItem[]{new ValuableItem("Aged Brie", 5, 10)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(11, app.items[0].getQuality());

  }

  @Test
  public void sulfuras_never_sold() {
    ValuableItem[] items = new ValuableItem[]{
            new ValuableItem("Sulfuras, Hand of Ragnaros", 0, 10),
            new ValuableItem("Sulfuras, Hand of Ragnaros", 5, 20)
    };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(0, app.items[0].sellIn);
    assertEquals(10, app.items[0].getQuality());
    assertEquals(5, app.items[1].sellIn);
    assertEquals(20, app.items[1].getQuality());
  }

  @Test
  public void backstage_quality_increases_when_sellIn_decreases() {
    ValuableItem[] items = new ValuableItem[]{
            new ValuableItem("Backstage passes to a TAFKAL80ETC concert", 11, 8),
            new ValuableItem("Backstage passes to a TAFKAL80ETC concert", 10, 10),
            new ValuableItem("Backstage passes to a TAFKAL80ETC concert", 9, 12),
    };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(9, app.items[0].getQuality());
    assertEquals(12, app.items[1].getQuality());
    assertEquals(14, app.items[2].getQuality());
  }

  @Test
  public void backstage_quality_increases_by_3_when_sellIn_is_5days_or_less() {
    ValuableItem[] items = new ValuableItem[]{
            new ValuableItem("Backstage passes to a TAFKAL80ETC concert", 6, 8),
            new ValuableItem("Backstage passes to a TAFKAL80ETC concert", 5, 10),
            new ValuableItem("Backstage passes to a TAFKAL80ETC concert", 4, 12),
    };
    GildedRose app = new GildedRose(items);

    app.updateQuality();


    assertEquals(10, app.items[0].getQuality());
    assertEquals(13, app.items[1].getQuality());
    assertEquals(15, app.items[2].getQuality());
  }

  @Test
  public void backstage_quality_decreases_to_0() {
    ValuableItem[] items = new ValuableItem[]{
            new ValuableItem("Backstage passes to a TAFKAL80ETC concert", 0, 8),
    };
    GildedRose app = new GildedRose(items);

    app.updateQuality();


    assertEquals(0, app.items[0].getQuality());
  }


}
