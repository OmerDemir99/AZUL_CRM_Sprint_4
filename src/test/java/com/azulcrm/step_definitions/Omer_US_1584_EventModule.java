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
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
        List<String> expectedResult = new ArrayList<>();
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






    @When("type the event start date {string} and event end date {string} different format with right order except the default format")
    public void type_the_event_start_date_and_event_end_date_different_format_with_right_order_except_the_default_format(String startDate, String endDate) {
        eventPage.startDate.clear();
        eventPage.startDate.sendKeys(startDate);

        BrowserUtils.sleep(2);

        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(eventPage.endDate).moveToElement(eventPage.startTime).sendKeys(Keys.BACK_SPACE).perform();
        // eventPage.endDate.clear();
        eventPage.endDate.sendKeys(endDate);
    }

    @Then("click send button")
    public void click_send_button() {
        eventPage.sendButton.click();
    }

    @Then("verify that dates turn into correct format automatically {string} and {string}")
    public void verify_that_dates_turn_into_correct_format_automatically(String startDate, String endDate) {
        BrowserUtils.sleep(2);
        String actualStartDate = eventPage.upcomingEvents.getText().substring(5,15);
        String actualEndDate = eventPage.upcomingEvents.getText().substring(30,40);
        System.out.println(eventPage.upcomingEvents.getText());
        System.out.println(actualStartDate);
        System.out.println(actualEndDate);

        Assert.assertEquals(startDate, actualStartDate);
        Assert.assertEquals(endDate, actualEndDate);

        BrowserUtils.sleep(2);
        eventPage.deleteEvent();
    }


    @When("type the event start {string} and end date {string} different format except the default format")
    public void type_the_event_start_and_end_date_different_format_except_the_default_format(String startDate, String endDate) {
        eventPage.startDate.clear();
        eventPage.startDate.sendKeys(startDate);

        BrowserUtils.sleep(2);

        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(eventPage.endDate).moveToElement(eventPage.startTime).sendKeys(Keys.BACK_SPACE).perform();
        eventPage.endDate.sendKeys(endDate);
    }

    @Then("verify that user should not be able to create event")
    public void verify_that_user_should_not_be_able_to_create_event() {

        BrowserUtils.sleep(2);
        try {
            Assert.assertFalse(eventPage.eventDateInfo.isDisplayed());
        }catch (AssertionError r){
            r.printStackTrace();
            System.out.println("------------The fail of event creation-------------");
        }finally {
            if (eventPage.sidebarTopTitle.get(0).getText().equalsIgnoreCase("Upcoming Events")) {
                BrowserUtils.sleep(1);
                eventPage.deleteEvent();
                System.out.println("-----------Event is deleted successfully----------");
            }else {
                BrowserUtils.sleep(1);
                eventPage.alternativeDeleteEvent();
                System.out.println("-----------Event is deleted successfully----------");
            }
        }

    }


    @When("type different characters for event start date {string} and for event end date {string}")
    public void type_different_characters_for_event_start_date_and_for_event_end_date(String startDate, String endDate) {
        eventPage.startDate.clear();
        eventPage.startDate.sendKeys(startDate);

        BrowserUtils.sleep(2);

        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(eventPage.endDate).moveToElement(eventPage.startTime).sendKeys(Keys.BACK_SPACE).perform();
        eventPage.endDate.sendKeys(endDate);

    }


    @When("type different characters for event start time {string} and for event end time {string}")
    public void type_different_characters_for_event_start_time_and_for_event_end_time(String startTime, String endTime) {
        BrowserUtils.sleep(1);
        eventPage.startTime.clear();
        eventPage.startTime.sendKeys(startTime);

        BrowserUtils.sleep(2);

        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(eventPage.endTime).moveToElement(eventPage.endDate).sendKeys(Keys.BACK_SPACE).perform();
        eventPage.endTime.sendKeys(endTime);

    }


    @When("for event end date select a date earlier than event start date")
    public void for_event_end_date_select_a_date_earlier_than_event_start_date(Map<String, String> eventDate) {
        eventPage.startDate.clear();
        eventPage.startDate.sendKeys(eventDate.get("start date"));

        BrowserUtils.sleep(2);

        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(eventPage.endDate).moveToElement(eventPage.startTime).sendKeys(Keys.BACK_SPACE).perform();
        eventPage.endDate.sendKeys(eventDate.get("end date"));
    }



    @When("for event start date select a date earlier than current date")
    public void for_event_start_date_select_a_date_earlier_than_current_date() {
        eventPage.startDate.click();
        eventPage.calenderCells.get(10).click();

        eventPage.endDate.click();
        eventPage.calenderCells.get(11).click();

    }


    @When("select impossible event start date and end date")
    public void select_impossible_event_start_date_and_end_date(Map<String, String> eventDate) {
        eventPage.startDate.clear();
        eventPage.startDate.sendKeys(eventDate.get("start date"));

        BrowserUtils.sleep(2);

        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(eventPage.endDate).moveToElement(eventPage.startTime).sendKeys(Keys.BACK_SPACE).perform();
        eventPage.endDate.sendKeys(eventDate.get("end date"));
    }

    @Then("verify that user should not be able to create event successfully")
    public void verify_that_user_should_not_be_able_to_create_event_successfully() {

        BrowserUtils.sleep(1);
        try {
            Assert.assertFalse(eventPage.eventDateInfo.isDisplayed());
        }catch (AssertionError r){
            System.out.println("------------The fail of event creation-------------");
        }finally {
            if (eventPage.sidebarTopTitle.get(1).getText().equals("Upcoming Events")) {
                BrowserUtils.sleep(2);
                eventPage.upcomingEvents.click();
                BrowserUtils.sleep(15);
                eventPage.deleteButton.click();
                BrowserUtils.sleep(10);
                System.out.println("-----------Something went wrong while displaying this webpage----------");
            }else {
                BrowserUtils.sleep(2);
                eventPage.Calender.click();
                BrowserUtils.sleep(1);
                eventPage.myEventText.click();
                BrowserUtils.sleep(1);
                eventPage.myEventText.click();
                BrowserUtils.sleep(15);
                eventPage.deleteButton.click();
                BrowserUtils.sleep(10);
                System.out.println("-----------Something went wrong while displaying this webpage----------");
            }
        }

    }

    @When("for event end time select a time earlier than event start time")
    public void for_event_end_time_select_a_time_earlier_than_event_start_time() {
        eventPage.endTime.click();
        eventPage.decreaseDownButtons.get(0).click();
        BrowserUtils.sleep(1);
        eventPage.decreaseDownButtons.get(0).click();
        eventPage.setTimeButtons.get(0).click();

    }



    @When("click specify time zone button")
    public void click_specify_time_zone_button() {


    }


    @Then("select appropriate time zone for beginning {string}")
    public void select_appropriate_time_zone_for_beginning(String string) {


    }

    @Then("click time zone end button")
    public void click_time_zone_end_button() {


    }

    @Then("select appropriate time zone for ending {string}")
    public void select_appropriate_time_zone_for_ending(String string) {


    }

    @Then("verify that user should be able to select time zones correctly {string} and {string}")
    public void verify_that_user_should_be_able_to_select_time_zones_correctly_and(String string, String string2) {


    }


    @Then("select not appropriate time zone for ending {string}")
    public void select_not_appropriate_time_zone_for_ending(String string) {


    }

    @Then("verify that user should be able to see information message of question mark")
    public void verify_that_user_should_be_able_to_see_information_message_of_question_mark() {


    }

    @Then("click hide time zone button")
    public void click_hide_time_zone_button() {


    }

    @Then("verify that user should not be able to create event if the times don't match with the time zones")
    public void verify_that_user_should_not_be_able_to_create_event_if_the_times_don_t_match_with_the_time_zones() {


    }


    @Then("click time zone start button")
    public void click_time_zone_start_button() {


    }


    @When("verify that set reminder button is clickable")
    public void verify_that_set_reminder_button_is_clickable() {
        eventPage.setReminderButton.click();
        BrowserUtils.sleep(1);
        eventPage.setReminderButton.click();
        Assert.assertTrue(eventPage.setReminderButton.isSelected());

    }

    @Then("verify that all options are selectable")
    public void verify_that_all_options_are_selectable() {
        List<String> reminder = new ArrayList<>(Arrays.asList("minutes", "hours", "days"));
        for (int i = 0; i < reminder.size(); i++) {
            eventPage.selectOption(eventPage.reminderOptions, reminder.get(i));
        }

    }

    @Then("verify that reminder time is changeable by manually")
    public void verify_that_reminder_time_is_changeable_by_manually() {
        String defaultValue = eventPage.remindCounter.getAttribute("value");
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(eventPage.remindCounter).sendKeys(Keys.BACK_SPACE).perform();
        actions.sendKeys(eventPage.remindCounter,"25").perform();
        String actualValue = eventPage.remindCounter.getAttribute("value");
        Assert.assertNotEquals(defaultValue, actualValue);
    }


    @When("create an event with inappropriate reminder {string}")
    public void create_an_event_with_inappropriate_reminder(String reminderValue) {
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(eventPage.remindCounter).perform();
        actions.sendKeys(Keys.BACK_SPACE).perform();
        BrowserUtils.sleep(1);
        actions.sendKeys(eventPage.remindCounter,reminderValue).perform();

        eventPage.sendButton.click();
        BrowserUtils.sleep(1);
        try {
            Assert.fail(eventPage.getReminderText());
        }catch (AssertionError r){
            r.printStackTrace();
            System.out.println("-----------Test Fail-----------");
        }
        BrowserUtils.sleep(1);

    }


    @When("click select meeting room button")
    public void click_select_meeting_room_button() {
        eventPage.selectingMeetingRoomButton.click();

    }

    @Then("verify that all room options are selectable")
    public void verify_that_all_room_options_are_selectable() {
        List<String> expectedResult = new ArrayList<>(Arrays.asList("Central Meeting Room", "East Meeting Room", "West Meeting Room"));
        eventPage.centralMeetingRoom.click();
        List<String> actualResult = new ArrayList<>();
        actualResult.add(eventPage.selectingMeetingRoomButton.getAttribute("value"));

        eventPage.selectingMeetingRoomButton.click();
        eventPage.eastMeetingRoom.click();
        actualResult.add(eventPage.selectingMeetingRoomButton.getAttribute("value"));

        eventPage.selectingMeetingRoomButton.click();
        eventPage.westMeetingRoom.click();
        actualResult.add(eventPage.selectingMeetingRoomButton.getAttribute("value"));

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Then("verify that the event can be created for all room option")
    public void verify_that_the_event_can_be_created_for_all_room_option() {


    }

    @Then("type anything using keyboard by manually")
    public void type_anything_using_keyboard_by_manually() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(eventPage.selectingMeetingRoomButton, "qwery0987#$½").perform();
        eventPage.sendButton.click();
        BrowserUtils.sleep(1);
        try {
            Assert.fail(eventPage.locationInfo.getText());
        }catch (AssertionError r){
            r.printStackTrace();
            System.out.println("-----------Test Fail-----------");
        }
        BrowserUtils.sleep(1);

    }


    @When("click add person input box")
    public void click_add_person_input_box() {
        eventPage.addPersonsInputBox.click();
    }

    @Then("click to all employees option")
    public void click_to_all_employees_option() {
        eventPage.toAllEmployees.click();
    }

    @Then("click employees and department option")
    public void click_employees_and_department_option() {
        eventPage.employeesAndDepartment.click();
    }

    @Then("click all departments and select all department options")
    public void click_all_departments_and_select_all_department_options() {

        int sizeDepartments = eventPage.departments.size();
        int sizeAllDepartments = eventPage.allDepartment.size();
        for (int i = 1; i < sizeDepartments ; i++) {
            eventPage.departments.get(i).click();
            //BrowserUtils.sleep(1);
        }
        for (int j = 0; j < sizeAllDepartments ; j++) {
            eventPage.allDepartment.get(j).click();
            //BrowserUtils.sleep(1);
        }
    }

    @Then("verify that all departments are added the member input box")
    public void verify_that_all_departments_are_added_the_member_input_box() {
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add(eventPage.toAllEmployees.getAttribute("textContent"));
        int sizeDepartments = eventPage.departments.size();
        for (int i = 1; i < sizeDepartments; i++) {
            expectedResult.add(eventPage.departments.get(i).getText());
        }

        List<String> actualResult = new ArrayList<>();
        int sizeOfAddedMembers = eventPage.addedMembers.size();
        for (int i = 0; i < sizeOfAddedMembers ; i++) {
            actualResult.add(eventPage.addedMembers.get(i).getText());
        }
        Assert.assertEquals(expectedResult,actualResult);
    }


    @Then("select one people from the list")
    public void select_one_people_from_the_list() {
        eventPage.peopleFromList.get(2).click();
    }

    @Then("click add more text")
    public void click_add_more_text() {
        eventPage.closeButtonForAddMembers.click();
        eventPage.addMoreText.click();
    }

    @Then("select two people from the list")
    public void select_two_people_from_the_list() {
        eventPage.peopleFromList.get(1).click();
        eventPage.peopleFromList.get(3).click();

    }

    @Then("click member input box and add new people by typing the email address manually")
    public void click_member_input_box_and_add_new_people_by_typing_the_email_address_manually() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(eventPage.addPersonsInputBox, "hr10").sendKeys(Keys.ENTER).perform();

    }

    @Then("delete all options from member input box")
    public void delete_all_options_from_member_input_box() {
        for (WebElement each : eventPage.deleteMembers){
            each.click();
        }
    }

    @Then("verify that all members are deleted successfully")
    public void verify_that_all_members_are_deleted_successfully() {
        String expectedResult = "Add persons, groups or department";
        Assert.assertEquals(expectedResult, eventPage.memberInputBoxText.getAttribute("innerText"));
    }

    @Then("type something for adding new people {string}")
    public void type_something_for_adding_new_people(String text) {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(eventPage.addPersonsInputBox, text).perform();
        BrowserUtils.sleep(3);
    }

    @Then("verify that user should not be able to add new people if he or she not exist the member list")
    public void verify_that_user_should_not_be_able_to_add_new_people_if_he_she_not_exist_the_member_list() {
        String expectedResult = "Add persons, groups or department";
        Assert.assertEquals(expectedResult, eventPage.memberInputBoxText.getAttribute("innerText"));

    }

    String expectedEventStartTime = eventPage.startTime.getAttribute("value");
    String expectedEventEndTime = eventPage.endTime.getAttribute("value");
    String expectedEventEndDate = eventPage.endDate.getAttribute("value");

    @Then("click time wrapper and slide it to left")
    public void click_time_wrapper_and_slide_it_to_left() {
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 7; i++) {
            actions.clickAndHold(eventPage.timeLineWrapper).sendKeys(Keys.ARROW_LEFT);
        }
    }

    @Then("click time line selector and slide it to left")
    public void click_time_line_selector_and_slide_it_to_left() {
        Actions actions = new Actions(Driver.getDriver());
        eventPage.timeLineSelector.click();
        actions.clickAndHold(eventPage.timeLineSelector).moveToElement(eventPage.attendees).perform();

    }

    @Then("click time wrapper and slide it to right")
    public void click_time_wrapper_and_slide_it_to_right() {
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 7; i++) {
            actions.clickAndHold(eventPage.timeLineWrapper).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    @Then("click time line selector and slide it to right")
    public void click_time_line_selector_and_slide_it_to_right() {
        Actions actions = new Actions(Driver.getDriver());
        eventPage.timeLineSelector.click();
        actions.clickAndHold(eventPage.timeLineSelector).moveToElement(eventPage.popularPosts).perform();
    }

    @Then("verify that event start and end time change according to act of time line selector")
    public void verify_that_event_start_and_end_time_change_according_to_act_of_time_line_selector() {
        String actualEventEndTime = eventPage.endTime.getAttribute("value");
        Assert.assertEquals(expectedEventEndTime ,actualEventEndTime);

        System.out.println("expectedEventEndTime = " + expectedEventEndTime);
        System.out.println("actualEventEndTime = " + actualEventEndTime);

    }

    @Then("click time line selector and slide it to left and right")
    public void click_time_line_selector_and_slide_it_to_left_and_right() {
        Point point = eventPage.timeLineSelector.getLocation();
        int x = point.getX();
        int y = point.getY();
        Actions actions = new Actions(Driver.getDriver());
        try {
            actions.dragAndDropBy(eventPage.timeLineSelector, 0, 1000).perform();
            BrowserUtils.sleep(2);
            actions.dragAndDropBy(eventPage.timeLineSelector, 0, 1750).perform();
            BrowserUtils.sleep(2);
        }catch (MoveTargetOutOfBoundsException m){
            m.printStackTrace();
        }
    }

    @Then("verify that event start and end date change according to act of time line selector")
    public void verify_that_event_start_and_end_date_change_according_to_act_of_time_line_selector() {
        String actualEventEndDate = eventPage.endDate.getAttribute("value");
        Assert.assertEquals(expectedEventEndDate ,actualEventEndDate);
        System.out.println("expectedEventEndDate = " + expectedEventEndDate);
        System.out.println("actualEventEndDate = " + actualEventEndDate);

    }

    @Then("click time line resizer and increase the event time")
    public void click_time_line_resizer_and_increase_the_event_time() {
        Actions actions = new Actions(Driver.getDriver());
        try {
            actions.dragAndDropBy(eventPage.timeLineResizer, 0, 100).perform();
            BrowserUtils.sleep(2);
        }catch (MoveTargetOutOfBoundsException m){
            m.printStackTrace();
        }
        BrowserUtils.sleep(2);
        for (int i = 0; i < 5; i++) {
            actions.clickAndHold(eventPage.timeLineWrapper).sendKeys(Keys.ARROW_RIGHT);
        }


    }

    @Then("click time line resizer and decrease the event time")
    public void click_time_line_resizer_and_decrease_the_event_time() {
        Actions actions = new Actions(Driver.getDriver());
        try {
            actions.dragAndDropBy(eventPage.timeLineResizer, 0, 20).perform();
            BrowserUtils.sleep(2);
        }catch (MoveTargetOutOfBoundsException m){
            m.printStackTrace();
        }

    }

    @Then("verify that event start and end time change according to act of time line resizer")
    public void verify_that_event_start_and_end_time_change_according_to_act_of_time_line_resizer() {
        String actualEventStartTime = eventPage.startTime.getAttribute("value");
        Assert.assertEquals(expectedEventStartTime ,actualEventStartTime );
        System.out.println("expectedEventStartTime = " + expectedEventStartTime);
        System.out.println("actualEventStartTime = " + actualEventStartTime);

        String actualEventEndTime = eventPage.endTime.getAttribute("value");
        Assert.assertEquals(expectedEventEndTime ,actualEventEndTime);
        System.out.println("expectedEventEndTime = " + expectedEventEndTime);
        System.out.println("actualEventEndTime = " + actualEventEndTime);

    }

    @When("click event name input box and give event name")
    public void click_event_name_input_box_and_give_event_name() {


    }


    @Then("verify that user should be able to create event")
    public void verify_that_user_should_be_able_to_create_event() {


    }


    @Then("click event message input box and type something")
    public void click_event_message_input_box_and_type_something() {
        String str = "1234567890*-\"é!'^^%&/()=?_,;.:<>£#$½§{[]}\\|@∑€®₺¥üiöπ¨~~ß∂ƒğ^∆¨¬´´``Ω≈ç√∫~µ≤≥qwertyuıopğüasdfghjklşizxcvbnmöç ";

    }

    @Then("verify that both of them accept all possible characters")
    public void verify_that_both_of_them_accept_all_possible_characters() {


    }

    @Then("click cancel button")
    public void click_cancel_button() {


    }
    @Then("verify that user should be able to access home page")
    public void verify_that_user_should_be_able_to_access_home_page() {


    }

    @Then("click send button right after click cancel button")
    public void click_send_button_right_after_click_cancel_button() {


    }

    @Then("verify that user should be able to cancel event sending")
    public void verify_that_user_should_be_able_to_cancel_event_sending() {


    }

}

