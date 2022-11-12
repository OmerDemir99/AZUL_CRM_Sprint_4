package com.azulcrm.step_definitions;

import com.azulcrm.pages.Hanife_US09_FilterSearchPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Hanife_US09_FilterSearch_StepDef {

    Hanife_US09_FilterSearchPage filterPage = new Hanife_US09_FilterSearchPage();


    @When("user click the filter and search input box")
    public void user_click_the_filter_and_search_input_box() {
       filterPage.filterSearchInputBox.click();
        BrowserUtils.sleep(2);
    }

    @Then("user should see and verify below filters as default filters")
    public void user_should_see_and_verify_below_filters_as_default_filters(List<String> expectedFilters) {
        List<WebElement> allFilters = new ArrayList<>();
        List<String> actualFilters = new ArrayList<>();


        for (WebElement each : filterPage.total(allFilters)) {

            actualFilters.add(each.getText());


        }
        System.out.println("actualFilters = " + actualFilters);

        for (int i = 0; i < expectedFilters.size(); i++) {
            BrowserUtils.sleep(2);
            Assert.assertTrue(expectedFilters.contains(actualFilters.get(i)));

        }

      // Assert.assertEquals(expectedFilters, actualFilters);
    }

    //adding and removing fields

    @Then("user see default selected fields and nonselected fields")
    public void user_see_default_selected_fields_and_nonselected_fields() {
        BrowserUtils.sleep(2);

        Assert.assertTrue(filterPage.inboxDate.isDisplayed());
        Assert.assertTrue(filterPage.inboxType.isDisplayed());
        Assert.assertTrue(filterPage.inboxAuthor.isDisplayed());
        Assert.assertTrue(filterPage.inboxTo.isDisplayed());
//        Assert.assertFalse(filterPage.inboxFavorites.isDisplayed());
//        Assert.assertFalse(filterPage.inboxTag.isDisplayed());
//        Assert.assertFalse(filterPage.inboxExtranet.isDisplayed());

    }
    @Then("user click add field linktext")
    public void user_click_add_field_linktext() {
        filterPage.addFieldLink.click();
    }
    @When("user click and select nonselected fields")
    public void user_click_and_select_nonselected_fields() {

        BrowserUtils.sleep(1);
        filterPage.favoritesField.click();
        BrowserUtils.sleep(1);
        filterPage.tag.click();
        BrowserUtils.sleep(1);
        filterPage.extranet.click();

    }
    @Then("user verify adding new fields")
    public void user_verify_adding_new_fields() {
        Assert.assertTrue(filterPage.inboxFavorites.isDisplayed());
        Assert.assertTrue(filterPage.inboxTag.isDisplayed());
        Assert.assertTrue(filterPage.inboxExtranet.isDisplayed());

    }
    @When("user click selected fields")
    public void user_click_selected_fields() {

        filterPage.tag.click();
        BrowserUtils.sleep(1);
        filterPage.type.click();
        BrowserUtils.sleep(1);

//        filterPage.date.click();
//        BrowserUtils.sleep(1);
        filterPage.to.click();
        BrowserUtils.sleep(1);





    }
    @Then("user verify removing fields")
    public void user_verify_removing_fields() {

        BrowserUtils.sleep(1);

        Assert.assertTrue(filterPage.inboxDate.isDisplayed());
        Assert.assertTrue(filterPage.inboxAuthor.isDisplayed());
        Assert.assertTrue(filterPage.inboxFavorites.isDisplayed());
        Assert.assertTrue(filterPage.inboxExtranet.isDisplayed());


    }
    @And("user click an empty area")
    public void userClickAnEmptyArea() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(filterPage.restoreLink);
    }


    @When("user click restore default filter link")
    public void userClickRestoreDefaultFilterLink() {
        BrowserUtils.sleep(3);
        filterPage.restoreLink.click();
    }



    @And("user clicks the x sign near the fields input boxes")
    public void userClicksTheXSignNearTheFieldsInputBoxes() {

        Actions actions = new Actions(Driver.getDriver());




        actions.moveToElement(filterPage.inboxFavorites).perform();
        BrowserUtils.sleep(4);
        actions.moveToElement(filterPage.xSign).click().perform();
        BrowserUtils.sleep(4);
        System.out.println("1");

        actions.moveToElement(filterPage.inboxTag).perform();
        BrowserUtils.sleep(4);
        actions.moveToElement(filterPage.xSign).click().perform();
        BrowserUtils.sleep(4);
        System.out.println("2");

        // filterPage.xSignFavorites.click();
        BrowserUtils.sleep(4);
        actions.moveToElement(filterPage.inboxExtranet).perform();
        BrowserUtils.sleep(4);
        actions.moveToElement(filterPage.xSign).click().perform();
        BrowserUtils.sleep(4);
        System.out.println("3");
        //filterPage.xSignExtranet.click();










    }

    //specifying date
    @When("user click the date inbox user see different options")
    public void user_click_the_date_inbox_user_see_different_options() {

    }
    @When("user choose the exact date")
    public void user_choose_the_exact_date() {

    }
    @When("user click the date on calendar")
    public void user_click_the_date_on_calendar() {

    }
    @When("user click search button")
    public void user_click_search_button() {

    }
    @Then("user verify searching by specifying Date")
    public void user_verify_searching_by_specifying_date() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @And("user choose and click a {string}")
    public void userChooseAndClickA(String dateOption) {

    }
}
