package com.azulcrm.step_definitions;

import com.azulcrm.pages.Zeynep_AZUL1583;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.Driver;
import com.github.dockerjava.api.model.Link;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.security.Key;
import java.util.Set;

public class Zeynep_StepDefinations {
    Zeynep_AZUL1583 zeynep_azul1583 = new Zeynep_AZUL1583();


    //A.C 1
    @When("user click Message field")
    public void user_click_message_field() {

        zeynep_azul1583.MessageLink.click();
    }

    @When("user click Mention button at the bottom of message area")
    public void user_click_mention_button_at_the_bottom_of_message_area() {
        zeynep_azul1583.AddMention.click();

    }

    @When("user see and click  employee and department")
    public void user_see_and_click_employee_and_department() {
        zeynep_azul1583.employeeAndDepartment.click();


    }

    @Then("user dont see add new employee area")
    public void user_dont_see_add_new_employee_area() {
        Assert.assertTrue(!zeynep_azul1583.employeeAndDepartment.getText().contains("Add new employee"));
    }

    //A.C 2
    @When("User click linkAttach button at the bottom of message area")
    public void user_click_link_attach_button_at_the_bottom_of_message_area() {

        zeynep_azul1583.attachLink.click();
    }

    @When("user write {string} message")
    public void user_write_message(String linkText) {

        zeynep_azul1583.linkText.sendKeys("Get Information From This Link-2");

    }

    @When("user write {string}")
    public void user_write(String linkURL) {
        zeynep_azul1583.linkURL.sendKeys("https://www.guru99.com/testing-tools.html");

        zeynep_azul1583.saveButton.click();
    }

    @Then("user click sendButton")
    public void user_click_send_button()  {
        zeynep_azul1583.sendButton.click();


      BrowserUtils.sleep(2);
        zeynep_azul1583.info.click();//open new Window

        BrowserUtils.sleep(2);

        String newWindow = Driver.getDriver().getWindowHandle();


        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
        // window handle 1 - main window
        // window handle 2 - 2nd window

        for (String each : allWindowHandles) {

            Driver.getDriver().switchTo().window(each);
            System.out.println("Current title while switching windows: " + Driver.getDriver().getTitle());

        }

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("guru"));


    }

    //A.C 3

    @When("User click insert video link")
    public void user_click_insert_video_link() {
        zeynep_azul1583.insertVideoLink.click();
    }

    @When("user write URL link of video")
    public void user_write_url_link_of_video()  {
        zeynep_azul1583.videoURL.sendKeys("https://www.youtube.com/watch?v=AlOPXqXncWw");
        BrowserUtils.sleep(2);
    }

    @When("User verify not take any errorMessage after write URL")
    public void user_verify_not_take_any_error_message_after_write_url() {
        Assert.assertTrue(!zeynep_azul1583.errorMessage.isDisplayed());
    }

    @Then("user click saveButton")
    public void user_click_save_button() {
zeynep_azul1583.saveButton.click();
    }

    //A.C 4
    @When("User clicks Quote Text button")
    public void userClicksQuoteTextButtonn() {

      zeynep_azul1583.quoteTextButton.click();

    }

    @When("User enters a {string} in yellow quote ribbonn")
    public void userEntersAInYellowQuoteRibbonn(String quote) {

        Driver.getDriver().switchTo().frame(zeynep_azul1583.messagesIframe);
        zeynep_azul1583.getQuoteTextRibbon.sendKeys(quote);
        Driver.getDriver().switchTo().defaultContent();

    }



    @When("User clicks Send button at Messages Tabb")
    public void user_clicks_send_button_at_messages_tabb() {
       zeynep_azul1583.sendButton.click();
    }
    @Then("User sees the {string} in Activity Stream")
    public void user_sees_the_in_activity_stream(String quote) {
        BrowserUtils.sleep(2);
        Assert.assertEquals(quote, zeynep_azul1583.actualQuote.getText());
    }



}
