package com.azulcrm.step_definitions;

import com.azulcrm.pages.Kenan_US_AZUL_1592_ActivityStreamPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class Kenan_US_AZUL_1592_ActivityStream_StepDefination {

    Kenan_US_AZUL_1592_ActivityStreamPage activityStreamPage = new Kenan_US_AZUL_1592_ActivityStreamPage();


    @When("Users click the comment button on the post that employee posted")
    public void users_click_the_comment_button_on_the_post_that_employee_posted() throws InterruptedException {

        activityStreamPage.commentButton.click();
        Thread.sleep(2000);
        // BrowserUtils.sleep(3);

    }
    @When("Users write a comment on the opening comment box")
    public void users_write_a_comment_on_the_opening_comment_box() {


        Driver.getDriver().switchTo().frame(1);

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("window.scrollBy(0,3500)");

        activityStreamPage.iframeBody.sendKeys("Wonderful Life");

        Driver.getDriver().switchTo().parentFrame();
        BrowserUtils.sleep(2);


        //System.out.println(activityStreamPage.commentBoxFrame.getAttribute("style"));
        //activityStreamPage.commentBox.sendKeys("Wonderful Life");

    }
    @When("Users click the send button")
    public void users_click_the_send_button() {
        activityStreamPage.commentBoxSendButton.click();
        BrowserUtils.sleep(2);

    }
    @Then("Users should be able to see the written comment on the post")
    public void users_should_be_able_to_see_the_written_comment_on_the_post() {
        Assert.assertTrue(activityStreamPage.wonderfulLifeMessage.isDisplayed());

    }

    @When("Users click the like button on the post that employee posted")
    public void users_click_the_like_button_on_the_post_that_employee_posted() {

    }

    @Then("Users should be able to see the kiss emoji icon is activated and is displayed on the page.")
    public void usersShouldBeAbleToSeeTheKissEmojiIconIsActivatedAndIsDisplayedOnThePage() {



    }


    @When("Users mouse hover the like button on the post that employee posted")
    public void usersMouseHoverTheLikeButtonOnThePostThatEmployeePosted() {

    }


    @And("Users see the like emoji images")
    public void usersSeeTheLikeEmojiImages() {

    }

    @And("Users click the kiss emoji image")
    public void usersClickTheKissEmojiImage() {


    }



    @When("Users click the unfollow button on the post that employee posted")
    public void usersClickTheUnfollowButtonOnThePostThatEmployeePosted() {

    }


    @Then("Users should be able to see the post of whom he-she unfollowed is disappeared on the page")
    public void usersShouldBeAbleToSeeThePostOfWhomHeSheUnfollowedIsDisappearedOnThePage() {

    }


    @Then("Users should be able to see the like icon")
    public void usersShouldBeAbleToSeeTheLikeIcon() {



    }
}
