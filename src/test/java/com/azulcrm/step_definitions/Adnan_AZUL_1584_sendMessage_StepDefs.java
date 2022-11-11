package com.azulcrm.step_definitions;

import com.azulcrm.pages.Adnan_AZUL_1584_messageModule;
import com.azulcrm.pages.Adnan_AZUL_1584_messageModule;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;

public class Adnan_AZUL_1584_sendMessage_StepDefs{

    Adnan_AZUL_1584_messageModule messageModule = new Adnan_AZUL_1584_messageModule();


    // User should be able to send a message by filling in the mandatory fields.
    @When("User clicks MESSAGE module")
    public void user_clicks_message_module() {
        messageModule.messageBtn.click();
    }

    @When("User writes message into Message box")
    public void user_writes_message_into_message_box() {
//         messageModule.topicBtn.click();
//         messageModule.inputTopic.sendKeys("TEST");
        Driver.getDriver().switchTo().frame(messageModule.messageIframe);
        messageModule.messageBody.sendKeys("HI GUYS...");
        Driver.getDriver().switchTo().parentFrame();

    }

    @Then("User clicks SEND button")
    public void user_clicks_send_button() {

        messageModule.sendBtn.click();
        BrowserUtils.sleep(2);

    }

    // The message delivery should be to 'All employees' by default and should be changeable.
    @Then("All Employees button should be seen as default recipient")
    public void allEmployeesButtonShouldBeSeenAsDefaultRecipient() {
        BrowserUtils.sleep(2);
        Assert.assertTrue(messageModule.allEmployeesBtn.isDisplayed());
        System.out.println("All employees buttons.isDisplayed() = " + messageModule.allEmployeesBtn.isDisplayed());


    }

    @And("User should change the recipients")
    public void userShouldChangeTheRecipients() {
        messageModule.removeAllEmp.click();
        messageModule.addRecipients.click();
        BrowserUtils.sleep(2);
        messageModule.inputAddRecipient.sendKeys("Cate Nimal");
        BrowserUtils.sleep(2);

    }

    @Then("{string} message should be displayed")
    public void messageShouldBeDisplayed(String errorMessage1) {
        String actualErrorMessage= messageModule.messageTitleError.getText();
        Assert.assertEquals(errorMessage1,actualErrorMessage);
    }

    @And("User removes default recipient")
    public void userRemovesDefaultRecipient() {
        BrowserUtils.sleep(2);
        messageModule.removeAllEmp.click();
    }

    @Then("An {string} message should be displayed")
    public void anMessageShouldBeDisplayed(String errorMessage2) {
        String actualErrorMessage= messageModule.noRecipientError.getText();
        Assert.assertEquals(errorMessage2,actualErrorMessage);
    }

    @And("User add some recipients for this message")
    public void userAddSomeRecipientsForThisMessage() {

        messageModule.addRecipients.click();
        messageModule.inputAddRecipient.sendKeys("Cate Nimal");
        BrowserUtils.sleep(2);
        //        messageModule.empDepBtn.click();
//        BrowserUtils.sleep(2);

    }

    @Then("User cancels sending this message")
    public void userCancelsSendingThisMessage() {
        BrowserUtils.sleep(2);
        messageModule.cancelBtn.click();
    }


    @When("User searches the message that he wants to delete")
    public void user_searches_the_message_that_he_wants_to_delete() {

        messageModule.searchBox.sendKeys("Please specify at least one person." + Keys.ENTER);

    }
    @Then("User clicks the MORE button at the bottom of that message")
    public void user_clicks_the_more_button_at_the_bottom_of_that_message() {
        BrowserUtils.sleep(3);
        messageModule.moreBtn.click();

    }
    @Then("User clicks the Delete link")
    public void user_clicks_the_delete_link() {
        BrowserUtils.sleep(3);
        messageModule.delBtn.click();

    }
    @Then("User clicks the OK button on the pop up window")
    public void user_clicks_the_ok_button_on_the_pop_up_window() {
        BrowserUtils.sleep(3);
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

    }
    @Then("User sees {string} message on the window")
    public void user_sees_message_on_the_window(String message) {

        Assert.assertEquals(message, messageModule.postDeletedMessage.getText());

    }



}
