package com.azulcrm.step_definitions;

import com.azulcrm.pages.Hanife_US09_FilterSearchPage;
import com.azulcrm.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Hanife_US09_FilterSearch_StepDef {

    Hanife_US09_FilterSearchPage filterPage = new Hanife_US09_FilterSearchPage();


    @When("user click the filter and search input box")
    public void user_click_the_filter_and_search_input_box() {
       filterPage.filterSearchInputBox.click();
        BrowserUtils.sleep(3);
    }

    @Then("user should see and verify below filters as default filters")
    public void user_should_see_and_verify_below_filters_as_default_filters(List<String> expectedFilters) {
        List<WebElement> allFilters = new ArrayList<>();
        List<String> actualFilters = new ArrayList<>();

        for (WebElement each : filterPage.total(allFilters)) {
            actualFilters.add(each.getText());

        }
        System.out.println("actualFilters = " + actualFilters);

        Assert.assertEquals(expectedFilters, actualFilters);
    }

    //adding and removing fields
    @Then("user click add field linktext")
    public void user_click_add_field_linktext() {
        filterPage.addFieldLink.click();
    }
    @Then("user see selected fields and nonselected fields")
    public void user_see_selected_fields_and_nonselected_fields() {
        BrowserUtils.sleep(2);

        Assert.assertTrue(filterPage.date.isEnabled());
        Assert.assertTrue(filterPage.type.isEnabled());
        Assert.assertTrue(filterPage.author.isEnabled());
        Assert.assertTrue(filterPage.to.isEnabled());
        Assert.assertTrue(!filterPage.favoritesField.isSelected());
        Assert.assertTrue(!filterPage.tag.isSelected());
        Assert.assertTrue(!filterPage.extranet.isSelected());


    }
    @When("user click and select nonselected fields")
    public void user_click_and_select_nonselected_fields() {

        BrowserUtils.sleep(1);
        filterPage.favoritesField.click();
        filterPage.tag.click();
        filterPage.extranet.click();
    }
    @Then("user verify adding new fields")
    public void user_verify_adding_new_fields() {
        Assert.assertTrue(filterPage.favoritesField.isEnabled());
        Assert.assertTrue(filterPage.tag.isEnabled());
        Assert.assertTrue(filterPage.extranet.isEnabled());

    }
    @When("user click default selected fields")
    public void user_click_default_selected_fields() {

        filterPage.date.click();
        filterPage.type.click();
        filterPage.author.click();
        filterPage.to.click();

    }
    @Then("user verify removing fields")
    public void user_verify_removing_fields() {

        Assert.assertTrue(!filterPage.date.isSelected());
        Assert.assertTrue(!filterPage.type.isSelected());
        Assert.assertTrue(!filterPage.author.isSelected());
        Assert.assertTrue(!filterPage.to.isSelected());
    }


    @When("user click restore default filter link")
    public void userClickRestoreDefaultFilterLink() {
        filterPage.restoreLink.click();
    }

    @Then("user should be able to restore the default field")
    public void userShouldBeAbleToRestoreTheDefaultField() {
        Assert.assertTrue(filterPage.date.isEnabled());
        Assert.assertTrue(filterPage.type.isEnabled());
        Assert.assertTrue(filterPage.author.isEnabled());
        Assert.assertTrue(filterPage.to.isEnabled());
        Assert.assertTrue(!filterPage.favoritesField.isSelected());
        Assert.assertTrue(!filterPage.tag.isSelected());
        Assert.assertTrue(!filterPage.extranet.isSelected());
    }
}
