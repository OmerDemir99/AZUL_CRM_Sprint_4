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
    Zeynep_AZUL1583 zeynep_azul1583=new Zeynep_AZUL1583();
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
        Assert.assertTrue( !zeynep_azul1583.employeeAndDepartment.getText().contains("Add new employee"));
    }
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
    public void user_click_send_button() throws InterruptedException {
        zeynep_azul1583.sendButton.click();



        Thread.sleep(2000);
        zeynep_azul1583.info.click();//open new Window

        BrowserUtils.sleep(2);

        String newWindow = Driver.getDriver().getWindowHandle();


        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
        // window handle 1 - main window
        // window handle 2 - 2nd window

        for(String each: allWindowHandles){

            Driver.getDriver().switchTo().window(each);
            System.out.println("Current title while switching windows: " + Driver.getDriver().getTitle());

        }

Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("guru"));



    }
    @When("User click insert video link")
    public void user_click_insert_video_link() {
  zeynep_azul1583.insertVideoLink.click();
    }
    @When("user write URL link of video")
    public void user_write_url_link_of_video() throws InterruptedException {
        zeynep_azul1583.videoURL.sendKeys("https://www.youtube.com/watch?v=AlOPXqXncWw");
        Thread.sleep(2000);
    }
    @When("User verify not take any errorMessage after write URL")
    public void user_verify_not_take_any_error_message_after_write_url() {
       Assert.assertTrue(!zeynep_azul1583.errorMessage.isDisplayed());
    }
    @Then("user click saveButton")
    public void user_click_save_button() {

    }

    @When("User click add quotes")
    public void user_click_add_quotes() {
      zeynep_azul1583.addQuote.click();

    }
    @When("user write sentences in quotes")
    public void user_write_sentences_in_quotes() {
      zeynep_azul1583.quoteTextArea.sendKeys("This is Quote Test Area");

    }
    @Then("user verify adding new quotes")
    public void user_verify_adding_new_quotes() {

    }



}
