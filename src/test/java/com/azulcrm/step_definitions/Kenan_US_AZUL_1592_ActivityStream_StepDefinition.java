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

public class Kenan_US_AZUL_1592_ActivityStream_StepDefinition {


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

//        while(true) {
//            actions.sendKeys(Keys.PAGE_DOWN).perform();
//            try {
//                activityStreamPage.commentButton.click();
//                break;
//
//            } catch (Exception e) {
//                continue;
//            }
//
//        }



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


    @And("Users write a reply comment to their own comment by clicking reply button under their own comment")
    public void usersWriteAReplyCommentToTheirOwnCommentByClickingReplyButtonUnderTheirOwnComment() {

        Driver.getDriver().switchTo().frame(1);

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("window.scrollBy(0,3500)");

        activityStreamPage.iframeBody.sendKeys("I agree with you");

        Driver.getDriver().switchTo().parentFrame();
        BrowserUtils.sleep(2);
    }

    @And("Users click the reply button under their own comment")
    public void usersClickTheReplyButtonUnderTheirOwnComment() {

        activityStreamPage.replButtonUnderOwnComment.click();
        BrowserUtils.sleep(2);
    }

    @Then("Users should be able to see the own reply comment on the post")
    public void usersShouldBeAbleToSeeTheOwnReplyCommentOnThePost() {

        Assert.assertTrue(activityStreamPage.IAgreeWithYouMessage.isDisplayed());

        activityStreamPage.moreButtonUnderOwnComment.click();
        BrowserUtils.sleep(2);

        activityStreamPage.deleteButtonUnderOwnComment.click();
        BrowserUtils.sleep(2);

        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
        BrowserUtils.sleep(5);

        activityStreamPage.moreButtonUnderReplyButtonAc3.click();
        BrowserUtils.sleep(2);
        activityStreamPage.deleteButtonUnderReplyButtonAc3.click();
        BrowserUtils.sleep(2);
        Alert alert2 = Driver.getDriver().switchTo().alert();
        alert2.accept();
        BrowserUtils.sleep(3);

    }

    @And("Users click the more button under their own comment")
    public void usersClickTheMoreButtonUnderTheirOwnComment() {
        activityStreamPage.moreButtonUnderOwnComment.click();
        BrowserUtils.sleep(2);
    }


    @And("Users click the copy link button;")
    public void usersClickTheCopyLinkButton() {

        activityStreamPage.copyLinkButtonUnderOwnComment.click();
    }

    @And("Users should be able to see the link is copied.")
    public void usersShouldBeAbleToSeeTheLinkIsCopied() {

        String copyLinkUrl = activityStreamPage.copyLinkATagUnderOwnComment.getAttribute("innerHTML");
        System.out.println("copyLinkUrl = " + copyLinkUrl);

        BrowserUtils.sleep(2);

        Driver.getDriver().get(copyLinkUrl);
        String actualLandingPageUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(copyLinkUrl.equals(actualLandingPageUrl));

        activityStreamPage.moreButtonUnderOwnComment.click();
        BrowserUtils.sleep(2);
        activityStreamPage.deleteButtonUnderOwnComment.click();
        BrowserUtils.sleep(2);

        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
        BrowserUtils.sleep(3);
    }


    @When("Users click the username on the post")
    public void usersClickTheUsernameOnThePost() {

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("window.scrollBy(0,50000)");

        activityStreamPage.moreEventsButton.click();
        BrowserUtils.sleep(2);

        Actions actions = new Actions(Driver.getDriver());

        for (int i = 0; i < 300; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
        }

        BrowserUtils.sleep(3);

        activityStreamPage.cateNimalUserLink.click();
        BrowserUtils.sleep(2);
    }

    @And("Users navigate to the profile page of the user")
    public void usersNavigateToTheProfilePageOfTheUser() {

        Driver.getDriver().get("https://qa.azulcrm.com/company/personal/user/693/");
        BrowserUtils.sleep(2);
    }

    @Then("Users should be able to see the name of the user on the page")
    public void usersShouldBeAbleToSeeTheNameOfTheUserOnThePage() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Cate Nimal"));
        BrowserUtils.sleep(2);

    }

    @When("Users click the add favorites button on top right of the post")
    public void usersClickTheAddFavoritesButtonOnTopRightOfThePost() {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
//        jse.executeScript("arguments[0].scrollIntoView(true)",activityStreamPage.moreEventsButton);
        jse.executeScript("window.scrollBy(0,50000)");

        activityStreamPage.moreEventsButton.click();
        BrowserUtils.sleep(2);


        Actions actions = new Actions(Driver.getDriver());

        for (int i = 0; i < 300; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
        }

        BrowserUtils.sleep(3);

        activityStreamPage.addFavoritesButton.click();
        BrowserUtils.sleep(2);
    }

    @And("Users go to the their own profile page by clicking their username button on right top of the page")
    public void usersGoToTheTheirOwnProfilePageByClickingTheirUsernameButtonOnRightTopOfThePage() {
        activityStreamPage.usernameButton.click();
        BrowserUtils.sleep(4);

    }

    @And("Users click My Profile button on the opening menu and navigate to profile page")
    public void usersClickMyProfileButtonOnTheOpeningMenuAndNavigateToProfilePage() {

        activityStreamPage.myProfileButtonUnderUsername.click();
        BrowserUtils.sleep(4);
    }

    @And("Users navigate to Control Panel by clicking control panel button")
    public void usersNavigateToControlPanelByClickingControlPanelButton() {
        activityStreamPage.controlPanelButton.click();
        BrowserUtils.sleep(3);
    }

    @Then("Users should be able to see the list of their own favorites that they added before")
    public void usersShouldBeAbleToSeeTheListOfTheirOwnFavoritesThatTheyAddedBefore() {

        String bookMarkList = activityStreamPage.bookMarkList.getText();
        Assert.assertTrue(bookMarkList.contains("Cate Nimal"));
        BrowserUtils.sleep(2);

//        activityStreamPage.siteButton.click();
//        BrowserUtils.sleep(2);
//
//        activityStreamPage.activityStreamButton.click();
//        BrowserUtils.sleep(2);
//
//        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
////        jse.executeScript("arguments[0].scrollIntoView(true)",activityStreamPage.moreEventsButton);
//        jse.executeScript("window.scrollBy(0,50000)");
//
//        activityStreamPage.moreEventsButton.click();
//        BrowserUtils.sleep(2);
//
//
//        Actions actions = new Actions(Driver.getDriver());
//
//        for (int i = 0; i < 300; i++) {
//            actions.sendKeys(Keys.PAGE_DOWN).perform();
//        }
//
//        BrowserUtils.sleep(3);
//
//        activityStreamPage.addFavoritesButton.click();
//        BrowserUtils.sleep(2);
    }


    @And("Users click Settings button on Control Panel")
    public void usersClickSettingsButtonOnControlPanel() {
        activityStreamPage.settingsButtonOnProfile.click();
        BrowserUtils.sleep(2);
    }


    @And("Users click Bookmarks button on Settings Panel")
    public void usersClickBookmarksButtonOnSettingsPanel() {
        activityStreamPage.bookmarksButtonOnProfile.click();
        BrowserUtils.sleep(2);
    }


}
