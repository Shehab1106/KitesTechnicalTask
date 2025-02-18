class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                updateItem(item);
            }
        }
    }

    private void updateItem(Item item) {
        if (item.name.equals("Aged Brie")) {
            handleAgedBrie(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            handleBackstage(item);
        } else {
            handleConjuredOrDefault(item);
        }

        decrementSellIn(item);

        if (item.sellIn < 0) {
            handleExpiredItem(item);
        }
    }

    private void handleExpiredItem(Item item) {
        if(!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
        	 handleConjuredOrDefault(item);
        }
    }
    private void handleBackstage(Item item){
        if (item.sellIn <= 0) {
            resetQuality(item);
        }
        else{
            incrementQuality(item);
            if (item.sellIn <= 10){
                incrementQuality(item);
                if (item.sellIn <= 5){
                    incrementQuality(item);
                }
            }
        } 
    }
    private void handleAgedBrie(Item item){
        incrementQuality(item);
    }
    private void handleConjuredOrDefault(Item item) {
        item.quality = (item.name.startsWith("Conjured"))? Math.max(0, item.quality - 2) : Math.max(0, item.quality - 1);
    }
    private void incrementQuality(Item item){
        item.quality = Math.min(item.quality + 1, 50);
    }   
    private void decrementSellIn(Item item){
        item.sellIn--;
    }
    private void resetQuality(Item item){
        item.quality = 0;
    }
}
