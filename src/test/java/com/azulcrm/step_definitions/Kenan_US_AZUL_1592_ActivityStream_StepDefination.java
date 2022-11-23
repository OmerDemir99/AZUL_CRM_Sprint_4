package com.azulcrm.step_definitions;

import com.azulcrm.pages.Kenan_US_AZUL_1592_ActivityStreamPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Kenan_US_AZUL_1592_ActivityStream_StepDefination {

    Kenan_US_AZUL_1592_ActivityStreamPage activityStreamPage = new Kenan_US_AZUL_1592_ActivityStreamPage();


    @When("Users click the comment button on the post that employee posted")
    public void users_click_the_comment_button_on_the_post_that_employee_posted() throws InterruptedException {

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
//        jse.executeScript("arguments[0].scrollIntoView(true)",activityStreamPage.moreEventsButton);
        jse.executeScript("window.scrollBy(0,50000)");

        activityStreamPage.moreEventsButton.click();
        BrowserUtils.sleep(2);

//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
//        wait.until(ExpectedConditions.visibilityOf(activityStreamPage.commentButton));

//        jse.executeScript("window.scrollBy(0,100000)");
//        BrowserUtils.sleep(2);
//        jse.executeScript("window.scrollBy(0,100000)");


        Actions actions = new Actions(Driver.getDriver());

        for (int i = 0; i < 300; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
        }

        BrowserUtils.sleep(3);


        activityStreamPage.commentButton.click();
//        Thread.sleep(2000);
        BrowserUtils.sleep(3);




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
        activityStreamPage.moreButtonUnderOwnComment.click();
        BrowserUtils.sleep(2);
        activityStreamPage.deleteButtonUnderOwnComment.click();
        BrowserUtils.sleep(2);

        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
        BrowserUtils.sleep(3);



    }

    @When("Users click the like button on the post that employee posted")
    public void users_click_the_like_button_on_the_post_that_employee_posted() {


        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("window.scrollBy(0,50000)");

        activityStreamPage.moreEventsButton.click();
        BrowserUtils.sleep(2);


        Actions actions = new Actions(Driver.getDriver());

        for (int i = 0; i < 300; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            }

//        jse.executeScript("window.scrollBy(0,100000)");
//        BrowserUtils.sleep(2);
//        jse.executeScript("window.scrollBy(0,100000)");
//        BrowserUtils.sleep(2);
//        jse.executeScript("window.scrollBy(0,100000)");
//        BrowserUtils.sleep(4);

        activityStreamPage.likeButton.click();
        BrowserUtils.sleep(3);

    }

    @Then("Users should be able to see the kiss emoji icon is activated and is displayed on the page.")
    public void usersShouldBeAbleToSeeTheKissEmojiIconIsActivatedAndIsDisplayedOnThePage() {

        Assert.assertTrue(activityStreamPage.kissEmojiReaction.isDisplayed());
        BrowserUtils.sleep(2);


        activityStreamPage.likeButton.click();
        BrowserUtils.sleep(2);
    }


    @When("Users mouse hover the like button on the post that employee posted")
    public void usersMouseHoverTheLikeButtonOnThePostThatEmployeePosted() {


        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("window.scrollBy(0,50000)");

        activityStreamPage.moreEventsButton.click();
        BrowserUtils.sleep(2);

        Actions actions = new Actions(Driver.getDriver());

        for (int i = 0; i < 300; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
        }
        BrowserUtils.sleep(2);



//        jse.executeScript("window.scrollBy(0,100000)");
//        BrowserUtils.sleep(2);
//        jse.executeScript("window.scrollBy(0,100000)");
//        BrowserUtils.sleep(2);


        actions.moveToElement(activityStreamPage.likeButton).perform();
        BrowserUtils.sleep(4);
    }


    @And("Users see the like emoji images")
    public void usersSeeTheLikeEmojiImages() {

        Assert.assertTrue(activityStreamPage.kissEmoji.isDisplayed());
        BrowserUtils.sleep(3);

    }

    @And("Users click the kiss emoji image")
    public void usersClickTheKissEmojiImage() {

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(activityStreamPage.kissEmoji).click().perform();
    }



    @When("Users click the unfollow button on the post that employee posted")
    public void usersClickTheUnfollowButtonOnThePostThatEmployeePosted() {

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("window.scrollBy(0,50000)");

        activityStreamPage.moreEventsButton.click();
        BrowserUtils.sleep(2);

        Actions actions = new Actions(Driver.getDriver());

        for (int i = 0; i < 300; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
        }
        BrowserUtils.sleep(2);

        activityStreamPage.unfollowButton.click();

        BrowserUtils.sleep(2);

    }


    @Then("Users should be able to see the post of whom he-she unfollowed is disappeared on the page")
    public void usersShouldBeAbleToSeeThePostOfWhomHeSheUnfollowedIsDisappearedOnThePage() {

        Assert.assertFalse(activityStreamPage.postImage.isDisplayed());

    }


    @Then("Users should be able to see the like icon")
    public void usersShouldBeAbleToSeeTheLikeIcon() {

        Assert.assertTrue(activityStreamPage.likeReactionToLike.isDisplayed());
        BrowserUtils.sleep(2);
        activityStreamPage.likeButton.click();
        BrowserUtils.sleep(2);
    }

    @When("Users click the like button under the comments posted by reviewers.")
    public void users_click_the_like_button_under_the_comments_posted_by_reviewers() {

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("window.scrollBy(0,50000)");

        activityStreamPage.moreEventsButton.click();
        BrowserUtils.sleep(2);

        Actions actions = new Actions(Driver.getDriver());

        for (int i = 0; i < 300; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
        }
        BrowserUtils.sleep(2);

        activityStreamPage.likeButtonUnderPost.click();
        BrowserUtils.sleep(2);

    }
    @Then("Users should be able to see the like icon is being activated and displayed.")
    public void users_should_be_able_to_see_the_like_icon_is_being_activated_and_displayed() {

        Assert.assertTrue(activityStreamPage.likeIconAfterLikePost.isDisplayed());
        BrowserUtils.sleep(2);
        activityStreamPage.likeButtonUnderPost.click();
        BrowserUtils.sleep(2);
    }


    @When("Users click the reply button under the comments posted by reviewers.")
    public void usersClickTheReplyButtonUnderTheCommentsPostedByReviewers() {

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("window.scrollBy(0,50000)");

        activityStreamPage.moreEventsButton.click();
        BrowserUtils.sleep(2);

        Actions actions = new Actions(Driver.getDriver());

        for (int i = 0; i < 300; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
        }
        BrowserUtils.sleep(2);

//        JavascriptExecutor jse2 = (JavascriptExecutor) Driver.getDriver();
//        jse2.executeScript("window.scrollBy(0,100000)");

        activityStreamPage.replyButton.click();
        BrowserUtils.sleep(2);
    }

    @And("Users write a reply comment under a comment on the opening box")
    public void usersWriteAReplyCommentUnderACommentOnTheOpeningBox() {

        Driver.getDriver().switchTo().frame(1);

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("window.scrollBy(0,3500)");

        activityStreamPage.iframeBody.sendKeys("Let me see your reply");

        Driver.getDriver().switchTo().parentFrame();
        BrowserUtils.sleep(2);

    }

    @When("Users click the like button under their own comment")
    public void usersClickTheLikeButtonUnderTheirOwnComment() {



//        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
//        jse.executeScript("window.scrollBy(0,50000)");
//
//        activityStreamPage.moreEventsButton.click();
//        BrowserUtils.sleep(2);

//        JavascriptExecutor jse2 = (JavascriptExecutor) Driver.getDriver();
//        jse2.executeScript("window.scrollBy(0,100000)");
//
//        Actions actions = new Actions(Driver.getDriver());
//
//        for (int i = 0; i < 200; i++) {
//            actions.sendKeys(Keys.PAGE_DOWN).perform();
//        }
//        BrowserUtils.sleep(2);
//
//        activityStreamPage.commentButton.click();
//        BrowserUtils.sleep(2);
//
//        Driver.getDriver().switchTo().frame(1);
//
//        activityStreamPage.iframeBody.sendKeys("Wonderful Life");
//
//        Driver.getDriver().switchTo().parentFrame();
//        BrowserUtils.sleep(2);

//        activityStreamPage.commentBoxSendButton.click();
//
//        BrowserUtils.sleep(2);

        activityStreamPage.likeButtonUnderOwnComment.click();
        BrowserUtils.sleep(2);




    }

    @Then("Users should be able to see the like icon next to their own comment is being displayed")
    public void usersShouldBeAbleToSeeTheLikeIconNextToTheirOwnCommentIsBeingDisplayed() {

        Assert.assertTrue(activityStreamPage.likeReactionToOwnLike.isDisplayed());
        BrowserUtils.sleep(2);

        activityStreamPage.likeButtonUnderOwnComment.click();
        BrowserUtils.sleep(2);


        activityStreamPage.moreButtonUnderOwnComment.click();
        BrowserUtils.sleep(2);

        activityStreamPage.deleteButtonUnderOwnComment.click();
        BrowserUtils.sleep(2);

        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
        BrowserUtils.sleep(3);


    }

    @Then("Users should be able to see the reply comment on the post")
    public void usersShouldBeAbleToSeeTheReplyCommentOnThePost() {

        Assert.assertTrue(activityStreamPage.letMeSeeYourReplyMessage.isDisplayed());
        activityStreamPage.moreButtonUnderReplyButton.click();
        BrowserUtils.sleep(2);
        activityStreamPage.deleteButtonUnderReplyButton.click();
        BrowserUtils.sleep(2);

        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
        BrowserUtils.sleep(2);

    }

    @And("Users see their written comment on the post")
    public void usersSeeTheirWrittenCommentOnThePost() {

        Assert.assertTrue(activityStreamPage.wonderfulLifeMessage.isDisplayed());
    }
}
