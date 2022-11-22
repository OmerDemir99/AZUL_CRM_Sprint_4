package com.azulcrm.step_definitions;

import com.azulcrm.pages.Omer_US_1584_EventPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.ConfigurationReader;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Omer_US_1584_EventModule {

    Omer_US_1584_EventPage eventPage = new Omer_US_1584_EventPage();

    @When("users click Event {string} button")
    public void users_click_event_button(String titleOfBlog) {
        eventPage.clickMicroBlog(titleOfBlog);
    }


    @Then("verify that the event start date is current date")
    public void verify_that_the_event_start_date_is_current_date() {
      String actualDate =  eventPage.startDate.getAttribute("value");
      String expectedDate = eventPage.currentDay();
        BrowserUtils.sleep(1);
        Assert.assertEquals(expectedDate, actualDate);

    }
    @Then("type the start date by using keyboard {string}")
    public void type_the_start_date_by_using_keyboard(String date) {
        eventPage.startDate.clear();
        eventPage.startDate.sendKeys(date);
        Assert.assertEquals(date, eventPage.startDate.getAttribute("value"));
    }
    @Then("click left arrow to change the month")
    public void click_left_arrow_to_change_the_month() {
        BrowserUtils.sleep(2);
        eventPage.startDate.click();
        String expectedMonth = eventPage.topMonth.getText();
        for (int i = 0; i < 12; i++) {
            eventPage.calenderLeftArrow.click();
        }
        Integer exp = Integer.valueOf(eventPage.topYear.getText());
        String expectedYear = String.valueOf(exp);
        Assert.assertEquals(expectedMonth, eventPage.topMonth.getText());
        Assert.assertEquals(expectedYear, eventPage.topYear.getText());
    }
    @Then("click right arrow to change the month")
    public void click_right_arrow_to_change_the_month() {
        String expectedMonth = eventPage.topMonth.getText();
        for (int i = 0; i < 12; i++) {
            eventPage.calenderRightArrow.click();
        }
        Integer exp = Integer.valueOf(eventPage.topYear.getText());
        String expectedYear = String.valueOf(exp);
        Assert.assertEquals(expectedMonth, eventPage.topMonth.getText());
        Assert.assertEquals(expectedYear, eventPage.topYear.getText());
    }
    @Then("click selected month and verify that all months are in the correct order")
    public void click_selected_month_and_verify_that_all_months_are_in_the_correct_order() {
        eventPage.topMonth.click();
        List <String> expectedResult = new ArrayList<>();
        expectedResult.addAll(Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"));
        List <String> actualResult = new ArrayList<>();
        List <WebElement> months = eventPage.monthContents;
        for (WebElement month : months) {
            actualResult.add(month.getText());
        }
        Integer monthActive = Integer.valueOf(eventPage.activeMonth.getAttribute("data-bx-month"));
        actualResult.add(eventPage.activeMonth.getText());
        String remove = actualResult.get(10);
        actualResult.remove(10);
        actualResult.add(remove);
        Assert.assertEquals(expectedResult, actualResult);
    }
    @Then("chose another month from the list {string}")
    public void chose_another_month_from_the_list(String anyMonth) {

        List<WebElement> months = eventPage.monthContents;
        for (WebElement month : months) {
            if (month.getText().equals(anyMonth)) {
                month.click();
                Assert.assertEquals(anyMonth, eventPage.topMonth.getText());
                break;
            }
        }

        eventPage.topMonth.click();
        String configMonth = ConfigurationReader.getProperty("month");
        for (WebElement month : months) {
            if (month.getText().equals(configMonth)) {
                month.click();
                Assert.assertEquals(configMonth, eventPage.topMonth.getText());
                break;
            }
        }
    }

    @Then("click selected year and chose another one")
    public void click_selected_year_and_chose_another_one() {

        eventPage.topYear.click();
        List<WebElement> years = eventPage.yearContents;
        for (WebElement year : years) {
            if (year.getText().equals("2025")){
                year.click();
                break;
            }
        }
        BrowserUtils.sleep(2);
        Assert.assertEquals("2025", eventPage.topYear.getAttribute("text"));
        //eventPage.greyContent.click();
    }

    @Then("click selected year and type the year in the year input box manually {string}")
    public void click_selected_year_and_type_the_year_in_the_year_input_box_manually(String year) {

        eventPage.startDate.click();
        eventPage.topYear.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(eventPage.yearInputBox).click().sendKeys(year).perform();
        BrowserUtils.sleep(1);
        Assert.assertEquals(year, eventPage.topYear.getText());

        BrowserUtils.sleep(2);
        String configYear = ConfigurationReader.getProperty("year");
        eventPage.topYear.click();
        actions.moveToElement(eventPage.yearInputBox).click().sendKeys(configYear).perform();
        BrowserUtils.sleep(1);
        Assert.assertEquals(configYear, eventPage.topYear.getText());
    }
    @Then("chose the event start date from the calender {string}")
    public void chose_the_event_start_date_from_the_calender(String dayOfMonth) {

        BrowserUtils.sleep(2);
        List<WebElement> calenderCells = eventPage.calenderCells;
        for (WebElement calenderCell : calenderCells) {
                if (calenderCell.getText().equals(dayOfMonth)){
                    calenderCell.click();
                    String actualDate = eventPage.startDate.getAttribute("value");
                    Assert.assertEquals("11/29/2022", actualDate);
                    break;
                }
        }

        BrowserUtils.sleep(2);
        String configDate = ConfigurationReader.getProperty("eventStartDate");
        eventPage.startDate.clear();
        eventPage.startDate.click();
        eventPage.startDate.sendKeys(configDate);
        String actualDate = eventPage.startDate.getAttribute("value");
        Assert.assertEquals(configDate, actualDate);

    }
    @Then("click and clear event start hour and type manually {string}")
    public void click_and_clear_event_start_hour_and_type_manually(String hour) {
        BrowserUtils.sleep(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(eventPage.startTime).moveToElement(eventPage.startDate).sendKeys(Keys.BACK_SPACE).perform();
        actions.sendKeys(hour).perform();
        BrowserUtils.sleep(2);
        //eventPage.greyContent.click();
        //String actualResult = eventPage.startTime.getAttribute("value").substring(6)+eventPage.startTime.getAttribute("value").substring(3,4)+eventPage.startTime.getAttribute("value").substring(4,6)+eventPage.startTime.getAttribute("value").substring(0,1)+eventPage.startTime.getAttribute("value").substring(1,3);
        //Assert.assertEquals(hour, eventPage.startTime.getAttribute("value"));

        BrowserUtils.sleep(2);
        String configHour = ConfigurationReader.getProperty("eventStartHour");
        actions.clickAndHold(eventPage.startTime).moveToElement(eventPage.startDate).sendKeys(Keys.BACK_SPACE).perform();
        actions.sendKeys(configHour).perform();
        eventPage.greyContent.click();

    }

    @Then("click event start hour input box and increase and decrease the hour and minute by using arrows")
    public void click_event_start_hour_input_box_and_increase_and_decrease_the_hour_and_minute_by_using_arrows() {
        BrowserUtils.sleep(1);
        eventPage.startTime.click();
        BrowserUtils.sleep(2);
        for (int i = 0; i < 10 ; i++) {
            eventPage.increaseUpButtons.get(0).click();
            BrowserUtils.sleep(1);
            eventPage.increaseUpButtons.get(1).click();
        }
        eventPage.setTimeButtons.get(0).click();
        BrowserUtils.sleep(1);
        Assert.assertEquals("9:50 am", eventPage.startTime.getAttribute("value"));

        BrowserUtils.sleep(1);
        eventPage.startTime.click();
        BrowserUtils.sleep(2);
        for (int i = 0; i < 10 ; i++) {
            eventPage.decreaseDownButtons.get(0).click();
            BrowserUtils.sleep(1);
            eventPage.decreaseDownButtons.get(1).click();
        }
        String configHour = ConfigurationReader.getProperty("eventStartHour");
        eventPage.setTimeButtons.get(0).click();
        BrowserUtils.sleep(1);
        //Assert.assertEquals(configHour, eventPage.startTime.getAttribute("value"));
    }
    @Then("change the time period")
    public void change_the_time_period() {
        eventPage.startTime.click();
        BrowserUtils.sleep(1);
        eventPage.amAndPmOptions.click();
        Assert.assertEquals("PM", eventPage.amAndPmOptions.getText());

        eventPage.amAndPmOptions.click();
        Assert.assertEquals("AM", eventPage.amAndPmOptions.getText());
    }
    @Then("click event start hour input box and change the hour {string} by manually")
    public void click_event_start_hour_input_box_and_change_the_hour_by_manually(String hour) {
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(eventPage.hourAndMinute.get(0)).sendKeys(Keys.BACK_SPACE).perform();
        actions.sendKeys(hour).perform();
        eventPage.setTimeButtons.get(0).click();
        eventPage.startTime.click();

        Integer i = Integer.valueOf(hour);
        if (i>12){
            i=i-12;
        }
        String str = String.valueOf(i);

        Assert.assertEquals(str, eventPage.hourAndMinute.get(0).getAttribute("value"));
        String configHour = ConfigurationReader.getProperty("eventStartHour");
        actions.doubleClick(eventPage.hourAndMinute.get(0)).sendKeys(Keys.BACK_SPACE).perform();
        actions.sendKeys(configHour.substring(0,2)).perform();

    }
    @Then("click event start minute input box and change the minute {string} by manually")
    public void click_event_start_minute_input_box_and_change_the_minute_by_manually(String minute) {
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(eventPage.hourAndMinute.get(1)).sendKeys(Keys.BACK_SPACE).perform();
        actions.sendKeys(minute).perform();
        eventPage.setTimeButtons.get(0).click();
        eventPage.startTime.click();
        BrowserUtils.sleep(2);
        Assert.assertEquals(minute, eventPage.hourAndMinute.get(1).getAttribute("value"));
        String configHour = ConfigurationReader.getProperty("eventStartHour");
        actions.doubleClick(eventPage.hourAndMinute.get(1)).sendKeys(Keys.BACK_SPACE).perform();
        actions.sendKeys(configHour.substring(2,4)).perform();
    }
    @Then("click set time button")
    public void click_set_time_button() {
        eventPage.setTimeButtons.get(0).click();
    }
    @Then("click event start hour input box and click close button")
    public void click_event_start_hour_input_box_and_click_close_button() {
        eventPage.startTime.click();
        eventPage.close.get(0).click();
    }
    @Then("verify event start hour is selected correctly")
    public void verify_event_start_hour_is_selected_correctly() {
        String configHour = ConfigurationReader.getProperty("eventStartHour");
        Assert.assertFalse(eventPage.startTime.getAttribute("value").isEmpty());
    }



    @Then("verify that the event end date is current date")
    public void verify_that_the_event_end_date_is_current_date() {
        BrowserUtils.sleep(1);
        String actualDate =  eventPage.endDate.getAttribute("value");
        String expectedDate = eventPage.currentDay();
        BrowserUtils.sleep(1);
        //Assert.assertEquals(expectedDate, actualDate);

    }
    @Then("type the end date by using keyboard {string}")
    public void type_the_end_date_by_using_keyboard(String date) {
        BrowserUtils.sleep(3);
        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(eventPage.endDate).moveToElement(eventPage.startTime).sendKeys(Keys.BACK_SPACE).perform();
        //eventPage.endDate.clear();
        BrowserUtils.sleep(1);
        eventPage.endDate.sendKeys(date);
        Assert.assertEquals(date, eventPage.endDate.getAttribute("value"));

    }

    @Then("click left arrow to change the month for end date")
    public void click_left_arrow_to_change_the_month_for_end_date() {
        BrowserUtils.sleep(2);
        eventPage.endDate.click();
        String expectedMonth = eventPage.topMonth.getText();
        for (int i = 0; i < 12; i++) {
            eventPage.calenderLeftArrow.click();
        }
        Integer exp = Integer.valueOf(eventPage.topYear.getText());
        String expectedYear = String.valueOf(exp);
        Assert.assertEquals(expectedMonth, eventPage.topMonth.getText());
        Assert.assertEquals(expectedYear, eventPage.topYear.getText());
    }
    @Then("click right arrow to change the month for end date")
    public void click_right_arrow_to_change_the_month_for_end_date() {
        String expectedMonth = eventPage.topMonth.getText();
        for (int i = 0; i < 12; i++) {
            eventPage.calenderRightArrow.click();
        }
        Integer exp = Integer.valueOf(eventPage.topYear.getText());
        String expectedYear = String.valueOf(exp);
        Assert.assertEquals(expectedMonth, eventPage.topMonth.getText());
        Assert.assertEquals(expectedYear, eventPage.topYear.getText());
    }

    @Then("click selected year and type the year in the year input box manually for end date {string}")
    public void click_selected_year_and_type_the_year_in_the_year_input_box_manually_for_end_date(String year) {
        BrowserUtils.sleep(1);
        //JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        //jse.executeScript("arguments[0].click()", eventPage.endDate);
        eventPage.endDate.click();
        eventPage.topYear.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(eventPage.yearInputBox).click().sendKeys(year).perform();
        BrowserUtils.sleep(1);
        Assert.assertEquals(year, eventPage.topYear.getText());

        BrowserUtils.sleep(2);
        String configYear = ConfigurationReader.getProperty("year");
        eventPage.topYear.click();
        actions.moveToElement(eventPage.yearInputBox).click().sendKeys(configYear).perform();
        BrowserUtils.sleep(1);
        Assert.assertEquals(configYear, eventPage.topYear.getText());
    }
    @Then("chose the event end date from the calender {string}")
    public void chose_the_event_end_date_from_the_calender(String dayOfMonth) {
        BrowserUtils.sleep(2);
        List<WebElement> calenderCells = eventPage.calenderCells;
        for (WebElement calenderCell : calenderCells) {
            if (calenderCell.getText().equals(dayOfMonth)){
                calenderCell.click();
                String actualDate = eventPage.endDate.getAttribute("value");
                Assert.assertEquals("11/30/2022", actualDate);
                break;
            }
        }

        BrowserUtils.sleep(2);
        String configDate = ConfigurationReader.getProperty("eventEndDate");
        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(eventPage.endDate).moveToElement(eventPage.startTime).sendKeys(Keys.BACK_SPACE).perform();
        eventPage.endDate.click();
        eventPage.endDate.sendKeys(configDate);
        String actualDate = eventPage.endDate.getAttribute("value");
        Assert.assertEquals(configDate, actualDate);
    }
    @Then("click and clear event end hour and type manually {string}")
    public void click_and_clear_event_end_hour_and_type_manually(String hour) {
        BrowserUtils.sleep(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(eventPage.endTime).moveToElement(eventPage.endDate).sendKeys(Keys.BACK_SPACE).perform();
        actions.sendKeys(hour).perform();
        BrowserUtils.sleep(2);
        //eventPage.greyContent.click();
        //String actualResult = eventPage.startTime.getAttribute("value").substring(6)+eventPage.startTime.getAttribute("value").substring(3,4)+eventPage.startTime.getAttribute("value").substring(4,6)+eventPage.startTime.getAttribute("value").substring(0,1)+eventPage.startTime.getAttribute("value").substring(1,3);
        //Assert.assertEquals(hour, eventPage.startTime.getAttribute("value"));

        BrowserUtils.sleep(2);
        String configHour = ConfigurationReader.getProperty("eventEndHour");
        actions.clickAndHold(eventPage.endTime).moveToElement(eventPage.endDate).sendKeys(Keys.BACK_SPACE).perform();
        actions.sendKeys(configHour).perform();
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].click()", eventPage.greyContent);
        //eventPage.greyContent.click();
    }
    @Then("click event end hour input box and increase and decrease the hour and minute by using arrows")
    public void click_event_end_hour_input_box_and_increase_and_decrease_the_hour_and_minute_by_using_arrows() {
        BrowserUtils.sleep(1);
        eventPage.endTime.click();
        BrowserUtils.sleep(2);
        for (int i = 0; i < 10 ; i++) {
            eventPage.increaseUpButtons.get(0).click();
            BrowserUtils.sleep(1);
            eventPage.increaseUpButtons.get(1).click();
        }
        eventPage.setTimeButtons.get(0).click();
        BrowserUtils.sleep(1);
        Assert.assertEquals("9:50 am", eventPage.endTime.getAttribute("value"));

        BrowserUtils.sleep(1);
        eventPage.endTime.click();
        BrowserUtils.sleep(2);
        for (int i = 0; i < 10 ; i++) {
            eventPage.decreaseDownButtons.get(0).click();
            BrowserUtils.sleep(1);
            eventPage.decreaseDownButtons.get(1).click();
        }
        String configHour = ConfigurationReader.getProperty("eventEndHour");
        eventPage.setTimeButtons.get(0).click();
        BrowserUtils.sleep(1);
        //Assert.assertEquals(configHour, eventPage.startTime.getAttribute("value"));
    }

    @Then("change the time period for end date")
    public void change_the_time_period_for_end_date() {
        eventPage.endTime.click();
        BrowserUtils.sleep(1);
        eventPage.amAndPmOptions.click();
        Assert.assertEquals("PM", eventPage.amAndPmOptions.getText());

        eventPage.amAndPmOptions.click();
        Assert.assertEquals("AM", eventPage.amAndPmOptions.getText());
    }
    @Then("click event end hour input box and change the hour {string} by manually")
    public void click_event_end_hour_input_box_and_change_the_hour_by_manually(String hour) {
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(eventPage.hourAndMinute.get(0)).sendKeys(Keys.BACK_SPACE).perform();
        actions.sendKeys(hour).perform();
        eventPage.setTimeButtons.get(0).click();
        eventPage.endTime.click();

        Integer i = Integer.valueOf(hour);
        if (i>12){
            i=i-12;
        }
        String str = String.valueOf(i);

        Assert.assertEquals(str, eventPage.hourAndMinute.get(0).getAttribute("value"));
        String configHour = ConfigurationReader.getProperty("eventEndHour");
        actions.doubleClick(eventPage.hourAndMinute.get(0)).sendKeys(Keys.BACK_SPACE).perform();
        actions.sendKeys(configHour.substring(0,2)).perform();
    }
    @Then("click event end minute input box and change the minute {string} by manually")
    public void click_event_end_minute_input_box_and_change_the_minute_by_manually(String minute) {
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(eventPage.hourAndMinute.get(1)).sendKeys(Keys.BACK_SPACE).perform();
        actions.sendKeys(minute).perform();
        eventPage.setTimeButtons.get(0).click();
        eventPage.endTime.click();
        BrowserUtils.sleep(2);
        Assert.assertEquals(minute, eventPage.hourAndMinute.get(1).getAttribute("value"));
        String configHour = ConfigurationReader.getProperty("eventEndHour");
        actions.doubleClick(eventPage.hourAndMinute.get(1)).sendKeys(Keys.BACK_SPACE).perform();
        actions.sendKeys(configHour.substring(3,5)).perform();
    }
    @Then("click event end hour input box and click close button")
    public void click_event_end_hour_input_box_and_click_close_button() {
        eventPage.endTime.click();
        eventPage.close.get(0).click();
    }
    @Then("verify event end hour is selected correctly")
    public void verify_event_end_hour_is_selected_correctly() {
        String configHour = ConfigurationReader.getProperty("eventEndHour");
        Assert.assertFalse(eventPage.endTime.getAttribute("value").isEmpty());
    }
    @Then("click all day option and verify that the button is clickable")
    public void click_all_day_option_and_verify_that_the_button_is_clickable() {
        eventPage.allDayButton.click();
        BrowserUtils.sleep(1);
        Assert.assertTrue(eventPage.allDayButton.isSelected());
        eventPage.allDayButton.click();
        BrowserUtils.sleep(1);
        Assert.assertFalse(eventPage.allDayButton.isSelected());
    }

}
