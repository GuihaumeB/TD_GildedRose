package edu.insightr.gildedrose.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.insightr.gildedrose.Inventory;
import edu.insightr.gildedrose.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class VestStepDef {
    private Inventory inventory;
    private Item[] items;
    private Item vest;

    @Given("^I have a new inventory with a vest$")
    public void iHaveANewInventory() throws Throwable{
        inventory = new Inventory();
        items = inventory.getItems();
        vest = items[0];
    }

    @Then("^the quality of the Vest item is (\\d+)$")
    public void theQualityOfTheConjuredIs(int vestQuality) throws Throwable {
        assertThat(vest.getQuality(), is(vestQuality));
    }

    @When("^I update the vest inventory$")
    public void iUpdateTheInventory() throws Throwable {
        inventory.updateQuality();
    }
}

