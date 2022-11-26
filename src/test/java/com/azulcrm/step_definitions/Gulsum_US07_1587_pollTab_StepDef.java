package com.azulcrm.step_definitions;

import com.azulcrm.pages.Gulsum_US07_1587_pollPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Gulsum_US07_1587_pollTab_StepDef {

    Gulsum_US07_1587_pollPage pollPage = new Gulsum_US07_1587_pollPage();

    @When("user click the Poll button")
    public void userClickThePollButton() {
        pollPage.pollButton.click();
        BrowserUtils.sleep(2);
    }

    @When("user click the {string} button")
    public void userClickTheButton(String string) {
        pollPage.addMore.click();
        BrowserUtils.sleep(2);
    }

    @And("user click the Employees and departments button")
    public void user_click_the_employees_and_departments_button() {
//       pollPage.employeesAndDepartments.click();

        BrowserUtils.sleep(2);
        pollPage.clickWithJS(pollPage.employeesAndDepartments);

    }

    @And("user adds on usernames {string} and {string} and {string}")
    public void userAddsOnUsernamesAndAnd(String user1, String user2, String user3) {
        pollPage.helpdeskUsername.click();
        BrowserUtils.sleep(2);
        pollPage.hrUsername.click();
        BrowserUtils.sleep(2);
        pollPage.marketingUsername.click();
        BrowserUtils.sleep(2);
    }

//    @When("user adds {string} by selecting multiple contacts")
//    public void user_adds_by_selecting_multiple_contacts(String users) {
//
//        for (WebElement each : pollPage.multipleContacts) {
//            if (each.getText().equals(users)) {
//                each.click();
//            }
//        }
//        BrowserUtils.sleep(3);
//
//    }


    @When("user adds question {string}")
    public void userAddsQuestion(String firstQuestion) {
        pollPage.question1.sendKeys(firstQuestion);
        BrowserUtils.sleep(1);
    }

    @And("user adds answer {string}")
    public void userAddsAnswer(String ans1) {
        pollPage.answer1.sendKeys(ans1);
        BrowserUtils.sleep(1);
    }

    @And("user adds second answer {string}")
    public void userAddsSecondAnswer(String ans2) {
        pollPage.answer2.sendKeys(ans2);
        BrowserUtils.sleep(1);
    }

    @And("user click the Add question button")
    public void userClickTheAddQuestionButton() {
        pollPage.addQuestion.click();
        BrowserUtils.sleep(2);
    }

    @And("user adds second question {string}")
    public void userAddsSecondQuestion(String secondQuestion) {
        pollPage.question2.sendKeys(secondQuestion);
        BrowserUtils.sleep(1);
    }

    @And("user adds second question's answer {string}")
    public void userAddsSecondQuestionSAnswer(String secQuestAns) {
        pollPage.secQuestAnswer.sendKeys(secQuestAns);
        BrowserUtils.sleep(1);
    }

    @And("user adds third question {string}")
    public void userAddsThirdQuestion(String thirdQuestion) {
        pollPage.question3.sendKeys(thirdQuestion);
        BrowserUtils.sleep(1);
    }

    @And("user adds third question's answer {string}")
    public void userAddsThirdQuestionSAnswer(String thirdQuestAnswer) {
        pollPage.thirdQuestAns.sendKeys(thirdQuestAnswer);
        BrowserUtils.sleep(2);
    }

    @Then("user adds third question's second answer {string}")
    public void userAddsThirdQuestionSSecondAnswer(String thirdQuestSecAns) {
        pollPage.thirdQuest2Ans.sendKeys(thirdQuestSecAns);
        BrowserUtils.sleep(2);
    }

    @And("user deletes the question")
    public void userDeletesTheQuestion() {
        pollPage.question1.clear();
        BrowserUtils.sleep(1);
    }

    @And("user deletes the answer")
    public void userDeletesTheAnswer() {
        pollPage.answer1.clear();
        BrowserUtils.sleep(1);
    }

    @And("user deletes second answer")
    public void userDeletesSecondAnswer() {
        pollPage.answer2.clear();
        BrowserUtils.sleep(1);
    }

    @And("user deletes second question")
    public void userDeletesSecondQuestion() {
        pollPage.question2.clear();
        BrowserUtils.sleep(1);
    }


    @And("user deletes second question's answer")
    public void userDeletesSecondQuestionSAnswer() {
        pollPage.secQuestAnswer.clear();
        BrowserUtils.sleep(2);
    }

    @When("user click the Allow multiple choice button")
    public void userClickTheAllowMultipleChoiceButton() {
        BrowserUtils.sleep(2);
        pollPage.allowMultipleChoiceButton.click();
        BrowserUtils.sleep(2);
    }

    @Then("user click the Allow multiple choice button under the second question")
    public void userClickTheAllowMultipleChoiceButtonUnderTheSecondQuestion() {
        pollPage.secondAllowMultipleChoiceButton.click();
        BrowserUtils.sleep(2);
    }

    @And("user click Send button")
    public void userClickSendButton() {
        //pollPage.sendButton.click();

        pollPage.clickWithJS(pollPage.sendButton);
        BrowserUtils.sleep(2);
    }

     @When("user writes message {string} in poll box")
    public void userWritesMessageInPollBox(String message) {
        Driver.getDriver().switchTo().frame(0);

        pollPage.pollMessage.sendKeys(message);

        Driver.getDriver().switchTo().parentFrame();

         BrowserUtils.sleep(2);
    }

    @And("user removes All employees at To box")
    public void userRemovesAllEmployeesAtToBox() {
        pollPage.removeAllEmployees.click();
        BrowserUtils.sleep(2);
    }

    @And("user closes the opened users window")
    public void userUserClosesTheOpenedUsersWindow() {
        pollPage.closeIcon.click();
        BrowserUtils.sleep(4);
    }

    @Then("user should see title error message {string}")
    public void userShouldSeeTitleErrorMessage(String titleError ) {
        String expectedString = "The message title is not specified";
        String actualString = pollPage.titleErrorMessage.getText();

        Assert.assertEquals(expectedString,actualString);
        BrowserUtils.sleep(2);
    }

    @Then("user should see person error message {string}")
    public void userShouldSeePersonErrorMessage(String personError) {
//        Assert.assertTrue(pollPage.personErrorMessage.isDisplayed());
//        BrowserUtils.sleep(2);

        String expectedString = "Please specify at least one person.";
        String actualString = pollPage.personErrorMessage.getText();

        Assert.assertEquals(expectedString,actualString);
        Assert.assertTrue(pollPage.personErrorMessage.isDisplayed());
        BrowserUtils.sleep(2);
    }

    @Then("user should see question error message {string}")
    public void userShouldSeeQuestionErrorMessage(String questionError) {

        String expectedString = "Please specify at least one question.";
        String actualString = pollPage.questionErrorMessage.getText();

        Assert.assertEquals(expectedString,actualString);
        BrowserUtils.sleep(2);
    }


    @Then("user should see answer error message {string}")
    public void userShouldSeeAnswerErrorMessage(String answerError) {
        String expected= "Please specify at least two answers.";
        String actual=pollPage.answerErrorMessage.getText();

        Assert.assertEquals(expected,actual);
        BrowserUtils.sleep(2);
    }


}

