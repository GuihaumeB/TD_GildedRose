package edu.insightr.gildedrose;

public class Inventory {

    private Item[] items;

    public Item[] getItems() {
        return items;
    }

    public Inventory(Item[] items) {
        super();
        this.items = items;
    }

    public Inventory() {
        super();
        items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Conjured Mana Cake", 3, 6)
        };

    }

    public void printInventory() {
        System.out.println("***************");
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println("***************");
        System.out.println("\n");
    }

    public void updateQuality()
    {
        for (Item item : items)
        {
            if ("Sulfuras, Hand of Ragnaros".equals(item.getName())) continue;
            if("Aged Brie".equals(item.getName())) {
                item.setSellIn(item.getSellIn() - 1);
                increaseQuality(item);
                if (item.getSellIn() < 0) increaseQuality(item);
            }

            else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
                item.setSellIn(item.getSellIn() - 1);
                increaseQuality(item);

                if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
                    if (item.getSellIn() < 10) increaseQuality(item);

                    if (item.getSellIn() < 5) increaseQuality(item);

                    if (item.getSellIn() < 0) item.setQuality(0);
                }
            }

            //Looking for names containing "Conjured"
            else if (item.getName().matches(".*Conjured.*")){
                item.setSellIn(item.getSellIn() - 1);
                decreaseQuality(item);
                decreaseQuality(item);
            }

            else
            {
                item.setSellIn(item.getSellIn() - 1);
                decreaseQuality(item);

                if (item.getSellIn() < 0) decreaseQuality(item);
            }

        }
    }

    protected void decreaseQuality(Item item) {
        if (item.getQuality() > 0)
        {
            item.setQuality(item.getQuality() - 1);
        }
    }

    protected void increaseQuality(Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        for (int i = 0; i < 10; i++) {
            inventory.updateQuality();
            inventory.printInventory();
        }
    }
}