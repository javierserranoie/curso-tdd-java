package com.gildedrose;

public class ValuableItem extends Item {
    public ValuableItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void degrade(Integer qualityIncrement) {
        this.decreaseQuality(qualityIncrement);
        this.decay();
        if (this.hasExpired()) {
            this.decreaseQuality(qualityIncrement);
        }
    }

    public void improve(Integer qualityIncrement) {
        this.increaseQuality(qualityIncrement);
        this.decay();
        if (this.hasExpired()) {
            this.increaseQuality(qualityIncrement);
        }
    }

    public void decay() {
        this.sellIn -= 1;
    }

    public int getQuality() {
        return this.quality;
    }

    private void decreaseQuality(Integer increment) {
        if (this.quality > 0) {
            this.quality -= increment;
        }
    }

    private void increaseQuality(Integer increment) {
        if (increment == null) {
            this.quality = 0;
        } else {
            if (this.quality < 50) {
                this.quality += increment;
            }
        }
    }

    private boolean hasExpired() {
        return this.sellIn < 0;
    }
}
