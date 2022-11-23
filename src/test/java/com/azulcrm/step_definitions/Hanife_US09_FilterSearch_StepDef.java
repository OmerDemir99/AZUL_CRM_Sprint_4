package com.azulcrm.step_definitions;

import com.azulcrm.pages.Hanife_US09_FilterSearchPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

        actions.moveToElement(filterPage.inboxTag).perform();
        BrowserUtils.sleep(4);
        actions.moveToElement(filterPage.xSign).click().perform();
        BrowserUtils.sleep(4);

        actions.moveToElement(filterPage.inboxExtranet).perform();
        BrowserUtils.sleep(4);
        actions.moveToElement(filterPage.xSign).click().perform();
        BrowserUtils.sleep(4);

    }

    //specifying date

    @And("user click the date inbox,user choose a date")
    public void userClickTheDateInboxUserChooseADate() {

        BrowserUtils.sleep(2);
        filterPage.inboxDate.click();
        System.out.println("date");
        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.sleep(1);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        BrowserUtils.sleep(1);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        BrowserUtils.sleep(1);

        actions.sendKeys(Keys.RETURN).perform();
        //   actions.keyDown(Keys.RETURN).keyUp(Keys.RETURN).perform();
        // actions.sendKeys(Keys.ENTER).perform();
        // actions.moveToElement(filterPage.inboxDate).keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

    }
    @And("user click search button")
    public void userClickSearchButton() {
        BrowserUtils.sleep(2);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("window.scrollBy(0,200)");

        BrowserUtils.sleep(1);
        filterPage.searchButton.click();
        BrowserUtils.sleep(1);

    }
    @Then("user verify searching by specifying Date")
    public void user_verify_searching_by_specifying_date() {

        Assert.assertTrue(filterPage.searchResult.isDisplayed());
        BrowserUtils.sleep(2);

        filterPage.deleteResult.click();

    }

    //exact date
    @When("user click the date inbox,user choose exact date")
    public void userClickTheDateInboxUserChooseExactDate() {
        BrowserUtils.sleep(2);
        filterPage.inboxDate.click();
        System.out.println("date");
        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.sleep(2);

        for (int i = 0; i <= 14; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            BrowserUtils.sleep(1);
        }

        BrowserUtils.sleep(1);
        actions.sendKeys(Keys.RETURN).perform();

    }
    @And("user click the calendar box and click a specific date")
    public void userClickTheCalendarBoxAndClickASpecificDate() {

        BrowserUtils.sleep(1);
        filterPage.calendarInbox.click();
        BrowserUtils.sleep(1);
        filterPage.november19.click();
    }

    //by typing date
    @And("user click the calendar box and type a {string}")
    public void userClickTheCalendarBoxAndTypeA(String date) {


        BrowserUtils.sleep(2);

        BrowserUtils.sleep(1);

        filterPage.calendarInbox.click();
        BrowserUtils.sleep(1);
        filterPage.calendarInbox.sendKeys(date);
    }

    // verify searching by types
    @When("user click the types inbox, user choose a type")
    public void userClickTheTypesInboxUserChooseAType() {
        BrowserUtils.sleep(2);
        filterPage.inboxType.click();
        BrowserUtils.sleep(2);
        filterPage.typePosts.click();
        filterPage.space.click();

    }
    @Then("user verify searching by specifying single type")
    public void userVerifySearchingBySpecifyingSingleType() {

        BrowserUtils.sleep(1);
        Assert.assertTrue(filterPage.searchResult.isDisplayed());
        filterPage.deleteResult.click();
    }

    @When("user click the types inbox, user choose multiple types")
    public void userClickTheTypesInboxUserChooseMultipleTypes() {

        BrowserUtils.sleep(2);
        filterPage.inboxType.click();
        BrowserUtils.sleep(2);
        filterPage.typeAnnouncements.click();
        BrowserUtils.sleep(2);
        filterPage.typeAppretiations.click();
        filterPage.space.click();
    }


    @Then("user verify searching by selecting multiple types")
    public void userVerifySearchingBySelectingMultipleTypes() {
        BrowserUtils.sleep(1);
        Assert.assertTrue(filterPage.searchResult.isDisplayed());
        filterPage.deleteResult.click();

    }





    //save filter part

    @When("user click the save filter text")
    public void user_click_the_save_filter_text() {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("window.scrollBy(0,200)");
        BrowserUtils.sleep(1);
        filterPage.saveFilterText.click();
    }

    @When("user click filter name inbox")
    public void user_click_filter_name_inbox() {
        filterPage.inboxAddingFilter.click();
    }
    @When("user types {string} as new filter")
    public void user_types_as_new_filter(String string) {
        BrowserUtils.sleep(1);
        filterPage.inboxAddingFilter.sendKeys(string);
    }
    @When("user click save button")
    public void user_click_save_button() {
        BrowserUtils.sleep(1);
        filterPage.saveButton.click();
    }
    @Then("user verify saving new filter")
    public void user_verify_saving_new_filter() {
        Assert.assertTrue(filterPage.newFilter.isDisplayed());
    }

    //restore default filters
    @And("user click the reset to default link")
    public void userClickTheResetToDefaultLink() {
        BrowserUtils.sleep(1);
        filterPage.resetFilterLink.click();
    }

    @And("user click continue button")
    public void userClickContinueButton() {
        BrowserUtils.sleep(2);
        filterPage.continueButton.click();
    }


    @Then("user verify to reset filters to default")
    public void userVerifyToResetFiltersToDefault() {
        Assert.assertFalse(filterPage.newFilter.isDisplayed());
    }



}
