package com.azulcrm.step_definitions;

import com.azulcrm.pages.Omer_US_1584_EventPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.ConfigurationReader;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
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






    @When("type the event start date {string} and event end date {string} different format with right order except the default format")
    public void type_the_event_start_date_and_event_end_date_different_format_with_right_order_except_the_default_format(String string, String string2) {


    }

    @Then("click send button")
    public void click_send_button() {


    }

    @Then("verify that dates turn into correct format automatically")
    public void verify_that_dates_turn_into_correct_format_automatically() {


    }


    @When("type the event start {string} and end date {string} different format except the default format")
    public void type_the_event_start_and_end_date_different_format_except_the_default_format(String string, String string2) {


    }

    @Then("verify that user should not be able to create event")
    public void verify_that_user_should_not_be_able_to_create_event() {


    }


    @When("type different characters for event start date {string} and for event end date {string}")
    public void type_different_characters_for_event_start_date_and_for_event_end_date(String string, String string2) {


    }


    @When("type different characters for event start time {string} and for event end time {string}")
    public void type_different_characters_for_event_start_time_and_for_event_end_time(String string, String string2) {


    }


    @When("for event end date select a date earlier than event start date")
    public void for_event_end_date_select_a_date_earlier_than_event_start_date(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }



    @When("for event start date select a date earlier than current date")
    public void for_event_start_date_select_a_date_earlier_than_current_date() {


    }



    @When("select impossible event start date and end date")
    public void select_impossible_event_start_date_and_end_date(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }


    @When("for event end time select a time earlier than event start time")
    public void for_event_end_time_select_a_time_earlier_than_event_start_time() {


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


    }

    @Then("verify that all options are selectable")
    public void verify_that_all_options_are_selectable() {


    }

    @Then("verify that reminder time is changeable by manually")
    public void verify_that_reminder_time_is_changeable_by_manually() {


    }


    @When("create an event with inappropriate reminder {string}")
    public void create_an_event_with_inappropriate_reminder(String string) {


    }


    @When("click select meeting room button")
    public void click_select_meeting_room_button() {


    }

    @Then("verify that all room options are selectable")
    public void verify_that_all_room_options_are_selectable() {


    }

    @Then("verify that the event can be created for all room option")
    public void verify_that_the_event_can_be_created_for_all_room_option() {


    }

    @Then("type anything using keyboard by manually")
    public void type_anything_using_keyboard_by_manually() {


    }

    @Then("verify that user should not be able to create event for different location")
    public void verify_that_user_should_not_be_able_to_create_event_for_different_location() {


    }


    @When("click add person input box")
    public void click_add_person_input_box() {


    }

    @Then("click to all employees option")
    public void click_to_all_employees_option() {


    }

    @Then("click employees and department option")
    public void click_employees_and_department_option() {


    }

    @Then("click all departments and select all department options")
    public void click_all_departments_and_select_all_department_options() {


    }

    @Then("verify that all departments are added the member input box")
    public void verify_that_all_departments_are_added_the_member_input_box() {


    }

    @Then("delete all options from member input box")
    public void delete_all_options_from_member_input_box() {


    }


    @Then("select one people from the list")
    public void select_one_people_from_the_list() {


    }

    @Then("click add more text")
    public void click_add_more_text() {


    }

    @Then("select two people from the list")
    public void select_two_people_from_the_list() {


    }

    @Then("click member input box and add new people by typing the email address manually")
    public void click_member_input_box_and_add_new_people_by_typing_the_email_address_manually() {


    }

    @Then("type something for adding new people {string}")
    public void type_something_for_adding_new_people(String string) {


    }

    @Then("verify that user should not be able to add new people if he or she not exist the member list")
    public void verify_that_user_should_not_be_able_to_add_new_people_if_he_she_not_exist_the_member_list() {


    }


    @Then("click time wrapper and slide it to right and left")
    public void click_time_wrapper_and_slide_it_to_right_and_left() {


    }

    @Then("click time line selector and slide it to right and left")
    public void click_time_line_selector_and_slide_it_to_right_and_left() {


    }

    @Then("verify that event start and end time change according to act of time line selector")
    public void verify_that_event_start_and_end_time_change_according_to_act_of_time_line_selector() {


    }

    @Then("verify that event start and end date change according to act of time line selector")
    public void verify_that_event_start_and_end_date_change_according_to_act_of_time_line_selector() {


    }

    @Then("click time line resizer and increase the event time")
    public void click_time_line_resizer_and_increase_the_event_time() {


    }

    @Then("click time line resizer and decrease the event time")
    public void click_time_line_resizer_and_decrease_the_event_time() {


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
