package com.azulcrm.step_definitions;

import com.azulcrm.pages.Kenan_US_AZUL_1592_ActivityStreamPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

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

        activityStreamPage.likeButton.click();
        BrowserUtils.sleep(2);

    }

    @Then("Users should be able to see the kiss emoji icon is activated and is displayed on the page.")
    public void usersShouldBeAbleToSeeTheKissEmojiIconIsActivatedAndIsDisplayedOnThePage() {

        Assert.assertTrue(activityStreamPage.kissEmojiAfterClick.isDisplayed());
        BrowserUtils.sleep(2);

    }


    @When("Users mouse hover the like button on the post that employee posted")
    public void usersMouseHoverTheLikeButtonOnThePostThatEmployeePosted() {

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(activityStreamPage.likeButton).perform();
        BrowserUtils.sleep(2);



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



        //activityStreamPage.kissEmojiAfterClick.click();


    }



    @When("Users click the unfollow button on the post that employee posted")
    public void usersClickTheUnfollowButtonOnThePostThatEmployeePosted() {

        activityStreamPage.unfollowButton.click();

    }


    @Then("Users should be able to see the post of whom he-she unfollowed is disappeared on the page")
    public void usersShouldBeAbleToSeeThePostOfWhomHeSheUnfollowedIsDisappearedOnThePage() {

        Assert.assertFalse(activityStreamPage.postImage.isDisplayed());

    }


    @Then("Users should be able to see the like icon")
    public void usersShouldBeAbleToSeeTheLikeIcon() {

    }

    @When("Users click the like button under the comments posted by reviewers.")
    public void users_click_the_like_button_under_the_comments_posted_by_reviewers() {

        activityStreamPage.likeButtonUnderPost.click();
        BrowserUtils.sleep(2);

    }
    @Then("Users should be able to see the like icon is being activated and displayed.")
    public void users_should_be_able_to_see_the_like_icon_is_being_activated_and_displayed() {

        Assert.assertTrue(activityStreamPage.likeIconAfterLikePost.isDisplayed());
    }


    @When("Users click the reply button under the comments posted by reviewers.")
    public void usersClickTheReplyButtonUnderTheCommentsPostedByReviewers() {
        activityStreamPage.replyButton.click();

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
        activityStreamPage.likeButtonUnderOwnComment.click();
        BrowserUtils.sleep(2);
    }

    @Then("Users should be able to see the like icon next to their own comment is being displayed")
    public void usersShouldBeAbleToSeeTheLikeIconNextToTheirOwnCommentIsBeingDisplayed() {
        Assert.assertTrue(activityStreamPage.likeReactionToOwnLike.isDisplayed());
    }
}
