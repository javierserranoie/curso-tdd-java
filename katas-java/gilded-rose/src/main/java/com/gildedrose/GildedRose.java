package com.gildedrose;

class GildedRose {

	ValuableItem[] items;

    public GildedRose(ValuableItem[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (ValuableItem item : items) {
			valueItem(item);
		}
    }

	private void valueItem(ValuableItem item) {
		Integer qualityIncrement;

		if (item.name.equals("Sulfuras, Hand of Ragnaros")) return;

		if (item.name.equals("Aged Brie")) {
			qualityIncrement = getQualityIncrement();
			item.improve(qualityIncrement);
			return;
		}

		if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
			qualityIncrement = getBackstageQualityIncrement(item);
			item.improve(qualityIncrement);
			return;
		}

		qualityIncrement = getQualityIncrement();
		item.degrade(qualityIncrement);
	}

	private Integer getQualityIncrement() {
		return 1;
	}

	private Integer getBackstageQualityIncrement(Item item) {
		if (item.sellIn >= 11) {
			return 1;
		} else if (item.sellIn >= 6) {
			return 2;
		} else if (item.sellIn >= 1){
			return 3;
		} else {
			return null;  // TODO: smell
		}
	}
}
