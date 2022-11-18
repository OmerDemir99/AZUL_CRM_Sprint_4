package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Kenan_US_AZUL_1592_ActivityStreamPage {

    public Kenan_US_AZUL_1592_ActivityStreamPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="blog-post-addc-add-2546")
    public WebElement commentButton;

    @FindBy(xpath="(//a[@class='bx-ilike-text'])[1]")
    public WebElement likeButton;

    @FindBy(xpath="(//a[.='Unfollow'])[1]")
    public WebElement unfollowButton;

    @FindBy(id="bx-ilike-result-reaction-like-BLOG_POST_2546-1667990984")
    public WebElement likeImage;

    @FindBy(xpath="//div[@data-reaction='kiss']")
    public WebElement kissEmoji;

   @FindBy(xpath="//div//span/span[@data-reaction='kiss']")
    public WebElement kissEmojiClick;

   @FindBy(xpath="(//a[.='Add comment'])[1]")
    public WebElement commentBox;

   @FindBy(xpath="//button[contains(@id,'lhe_button_submit_blogCommentForm')]")
    public WebElement commentBoxSendButton;

   @FindBy(xpath="//div[@id=\"record-BLOG_2546-555-text\"]/div[.='Wonderful Life']")
    public WebElement wonderfulLifeMessage;

   //@FindBy(xpath="(//body[@class=\"vsc-initialized\"])[1]")
    //public WebElement commentBoxFrame;

   @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    public WebElement iframe;

   @FindBy(tagName = "body")
   public WebElement iframeBody;

   @FindBy(xpath = "//body[.='Wonderful Life']")
    public WebElement iframeBodyMessage;

   @FindBy(xpath = "//input[@value='Wonderful Life']")
    public WebElement iframeValueMessage;

   //@FindBy()
   //















}
