package edu.insightr.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {
    @Test
    public void updateQuality()
    {
        /*int expectedValue = 5;
        int realValue = 5;
        assertEquals(expectedValue, realValue);*/

        Item VesteTest = new Item("+5 Dexterity Vest",10,20);
        Item BrieTest = new Item("Aged Brie", 2, 0);
        Item SulfurasTest = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        Item PassTest = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        Item ConjuredTest = new Item("Conjured Mana Cake", 3, 6);

        Item[] itemsTest = new Item[5];
        itemsTest[0] = VesteTest;
        itemsTest[1] = BrieTest;
        itemsTest[2] = SulfurasTest;
        itemsTest[3] = PassTest;
        itemsTest[4] = ConjuredTest;

        Inventory inventTest = new Inventory(itemsTest);

        inventTest.updateQuality();

        assertEquals(19, inventTest.getItems()[0].getQuality());
        assertEquals(1, inventTest.getItems()[1].getQuality());
        assertEquals(80, inventTest.getItems()[2].getQuality());
        assertEquals(21, inventTest.getItems()[3].getQuality());
        assertEquals(4, inventTest.getItems()[4].getQuality());
    }

    @Test
    public void testSellInNormal()
    {
        Item Vest = new Item("+5 Dexterity Vest", 1, 6);
        Item[] itemTab = new Item[1];
        itemTab[0] = Vest;

        Inventory inventTest = new Inventory(itemTab);

        inventTest.updateQuality();

        assertEquals(5, Vest.getQuality());
    }

    @Test
    public void testBrie()
    {
        Item AgedBrie = new Item("Aged Brie", 2, 6);

        Item[] itemTab = new Item[1];

        itemTab[0] = AgedBrie;

        Inventory inventTest = new Inventory(itemTab);

        inventTest.updateQuality();

        assertEquals(1, AgedBrie.getSellIn());
        assertEquals(7, AgedBrie.getQuality());
        //AgedBrie's quality increases when it ages
    }

    @Test
    public void testSulfuras()
    {
        Item Sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        Item[] itemTab = new Item[1];
        itemTab[0] = Sulfuras;

        Inventory inv = new Inventory(itemTab);

        inv.updateQuality();
        assertEquals(80,Sulfuras.getQuality());
        assertEquals(0,Sulfuras.getSellIn());
        //Sulfuras never has to be sold and as such, its quality does not decrease and sellIn remains zero
    }

    @Test
    public void testBackstage()
    {
        //Creating different variables to test outcomes in different cases
        int quality = 20;
        int sellin = 12;
        int sellin2 = 9;
        int sellin3 = 4;
        int sellin4 = 0;

        Item BackPass = new Item("Backstage passes to a TAFKAL80ETC concert", sellin, quality);
        Item BackPass2 = new Item("Backstage passes to a TAFKAL80ETC concert", sellin2, quality);
        Item BackPass3 = new Item("Backstage passes to a TAFKAL80ETC concert", sellin3, quality);
        Item BackPass4 = new Item("Backstage passes to a TAFKAL80ETC concert", sellin4, quality);

        Item[] itemTab = new Item[4];
        itemTab[0] = BackPass;
        itemTab[1] = BackPass2;
        itemTab[2] = BackPass3;
        itemTab[3] = BackPass4;

        Inventory inv = new Inventory(itemTab);
        inv.updateQuality();

        assertEquals(quality + 1,BackPass.getQuality());
        assertEquals(quality + 2,BackPass2.getQuality());
        assertEquals(quality + 3,BackPass3.getQuality());
        assertEquals(0, BackPass4.getQuality());
    }

    @Test
    public void testConjured()
    {
        int quality = 6;
        Item ConjuredTest = new Item("Conjured Mana Cake", 3, quality);
        Item[] tab = new Item[1];
        tab[0] = ConjuredTest;
        Inventory inv = new Inventory(tab);
        inv.updateQuality();
        assertEquals(quality - 2, ConjuredTest.getQuality());
        //"Conjured" items degrade in Quality twice as fast as normal items
    }
}