package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Kenan_US_AZUL_1592_ActivityStreamPage {

    public Kenan_US_AZUL_1592_ActivityStreamPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//a[@id='blog-post-addc-add-2630']")
    public WebElement commentButton;

//    @FindBy(xpath="(//a[@class='bx-ilike-text'])[1]")
//    public WebElement likeButton;

    @FindBy(xpath = "//span[starts-with(@id,'bx-ilike-button-BLOG_POST_2630-')]")
    public WebElement likeButton;

//    @FindBy(xpath="(//a[.='Unfollow'])[1]")
    @FindBy(xpath="//span[@id='log_entry_follow_4493']")
    public WebElement unfollowButton;

//    @FindBy(xpath="(//a[.='Unfollow'])[1]")
//    public WebElement unfollowButton;

//    @FindBy(xpath = "//span[@id='log_entry_follow_4493']")
//    public WebElement unfollowButton;

//    @FindBy(xpath = "//span[@id='log_entry_follow_4493']")
//    public WebElement unfollowButton;

//    @FindBy(id="bx-ilike-result-reaction-like-BLOG_POST_2546-1667990984")
//    public WebElement likeIcon;

    @FindBy(xpath="span[starts-with(@id,'bx-ilike-result-reaction-like-BLOG_POST')]")
    public WebElement likeIcon;

    @FindBy(xpath="//div[@data-reaction='kiss']")
    public WebElement kissEmoji;

   @FindBy(xpath="//div//span/span[@data-reaction='kiss']")
   public WebElement kissEmojiReaction;

   @FindBy(xpath="(//a[.='Add comment'])[1]")
    public WebElement commentBox;

   @FindBy(xpath="//button[contains(@id,'lhe_button_submit_blogCommentForm')]")
    public WebElement commentBoxSendButton;

   @FindBy(xpath="//div[starts-with(@id,'record-BLOG_2630-')]/div[.='Wonderful Life']")
    public WebElement wonderfulLifeMessage;

   @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    public WebElement iframe;

   @FindBy(tagName = "body")
   public WebElement iframeBody;

   @FindBy(xpath = "//body[.='Wonderful Life']")
    public WebElement iframeBodyMessage;

   @FindBy(xpath = "//input[@value='Wonderful Life']")
    public WebElement iframeValueMessage;

   @FindBy(id = "disk-attach-image-382")
    public WebElement postImage;

   @FindBy(xpath = "(//span[starts-with(@id,'bx-ilike-button-BLOG_COMMENT_566')])")
    public WebElement likeButtonUnderPost;

   @FindBy(xpath = "//span[starts-with(@id,'bx-ilike-result-reaction-like-BLOG_COMMENT_566-')]" )
    public WebElement likeIconAfterLikePost;

//   @FindBy(xpath = "//span[starts-with(@id,'feed-post-more')]")
//    public WebElement moreButton;

    @FindBy(xpath = "//a[@class='feed-post-more-link feed-post-more-link-Y-N-N-N']")
    public WebElement moreButton;

    @FindBy(xpath = "//span[.='Edit']")
    public WebElement editButton;

//    @FindBy(xpath = "(//a[@class=\"feed-com-reply feed-com-reply-Y\"])[1]")
//    public WebElement replyButton;

    @FindBy(xpath = "//*[@id=\"record-BLOG_2630-566-actions-reply\"]")
    public WebElement replyButton;

    //

    @FindBy(xpath = "(//div[starts-with(@id,'feed-com-text-inner-BLOG_COMMENT-')])[2]")
    public WebElement letMeSeeYourReplyMessage;

//    @FindBy(xpath = "//*[@id=\"record-BLOG_2627-599-text\"]/div/text()")
//    public WebElement letMeSeeYourReplyMessage;



    @FindBy(xpath = "(//span[starts-with(@id,'bx-ilike-button-BLOG_COMMENT_')])[2]")
    public WebElement likeButtonUnderOwnComment;

    @FindBy(xpath = "((//span[starts-with(@data-like-id,'BLOG_POST_2630-166')]))[1]")
    public WebElement likeReactionToLike;

    @FindBy(xpath = "//a[@id=\"sonet_log_more_container_first\"]")
    public WebElement moreEventsButton;

    @FindBy(xpath = "(//span[starts-with(@data-like-id,'BLOG_COMMENT')])[2]")
    public WebElement likeReactionToOwnLike;

    @FindBy(xpath = "(//a[starts-with(@id,'record-BLOG_2630-')])[4]")
    public WebElement moreButtonUnderOwnComment;

    @FindBy(xpath = "(//div[starts-with(@id,'popup-window-content-menu-popup-action-BLOG')]/div/div/span)[3]")
    public WebElement deleteButtonUnderOwnComment;

    @FindBy(xpath = "//a[@class='feed-post-more-link feed-post-more-link-Y-Y-N-Y']")
    public WebElement moreButtonUnderReplyButton;

    @FindBy(xpath = "(//a[@class='feed-post-more-link feed-post-more-link-Y-Y-N-Y'])[2]")
    public WebElement moreButtonUnderReplyButtonAc3;

    @FindBy(xpath = "(//div[starts-with(@id,'popup-window-content-menu-popup-action-BLOG_')]/div/div/span)[3]")
    public WebElement deleteButtonUnderReplyButton;

    @FindBy(xpath = "(//div[starts-with(@id,'popup-window-content-menu-popup-action-BLOG_')]/div/div/span)[3]")
    public WebElement deleteButtonUnderReplyButtonAc3;

    @FindBy(xpath = "//a[@bx-mpl-author-name='hr6@cybertekschool.com']")
    public WebElement replButtonUnderOwnComment;

//    @FindBy(xpath = "(//div[starts-with(@id,'record-BLOG_2630-')]/div/text())[3]")
//    public WebElement IAgreeWithYouMessage;

//    @FindBy(xpath = "//div[@bx-content-view-xml-id='BLOG_COMMENT-660']")
//    public WebElement IAgreeWithYouMessage;

    @FindBy(xpath = "(//div[starts-with(@bx-content-view-xml-id,'BLOG_COMMENT-6')])[2]")
    public WebElement IAgreeWithYouMessage;

    @FindBy(xpath = "//div[starts-with(@id,'popup-window-content-menu-popup-action-BLOG')]/div/div/a")
    public WebElement viewCommentButtonUnderOwnComment;

    @FindBy(xpath = "//div[starts-with(@id,'popup-window-content-menu-popup-action-BLOG')]/div/div/span")
    public WebElement copyLinkButtonUnderOwnComment;

    @FindBy(xpath = "/html/body/a")
    public WebElement copyLinkATagUnderOwnComment;

    //https://qa.azulcrm.com/company/personal/user/693/blog/2630/?commentId=688#com688

    @FindBy(xpath = "//a[@id='bp_2766']")
    public WebElement cateNimalUserLink;
















    //



























}
