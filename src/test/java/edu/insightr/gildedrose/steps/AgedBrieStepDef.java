package edu.insightr.gildedrose.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.insightr.gildedrose.Inventory;
import edu.insightr.gildedrose.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AgedBrieStepDef {
    private Inventory inventory;
    private Item[] items;
    private Item brie;

    @Given("^I have a new inventory$")
    public void iHaveANewInventory() throws Throwable{
        inventory = new Inventory();
        items = inventory.getItems();
        brie = items[1];
    }

    @Then("^the quality of the AgedBrie item is (\\d+)$")
    public void theQualityOfTheConjuredIs(int brieQuality) throws Throwable {
        assertThat(brie.getQuality(), is(brieQuality));
    }

    @When("^I update the inventory$")
    public void iUpdateTheInventory() throws Throwable {
        inventory.updateQuality();
    }
}

