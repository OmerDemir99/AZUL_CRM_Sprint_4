package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Adnan_AZUL_1584_messageModule {

    public Adnan_AZUL_1584_messageModule(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//span[@id=\"feed-add-post-form-tab-message\"]")
    public WebElement messageBtn;

    @FindBy(xpath = "//div[@class=\"feed-buttons-block\"]/button[1]")
    public WebElement sendBtn;

    @FindBy(css = "button[id=\"blog-submit-button-cancel\"]")
    public WebElement cancelBtn;

    @FindBy(xpath = "//span[@class=\"feed-add-post-destination-text\"]")
    public WebElement allEmployeesBtn;

    @FindBy(xpath = "//a[@class=\"feed-add-destination-link\"]")
    public WebElement addMoreLink;

    @FindBy(xpath = "//iframe[@class=\"bx-editor-iframe\"]")
    public WebElement messageIframe;

    @FindBy(css = "span[title=\"Topic\"]")
    public WebElement topicBtn;

    @FindBy(css = "input[id=\"POST_TITLE\"]")
    public WebElement inputTopic;

    @FindBy(css = "body[style=\"min-height: 184px;\"]")
    public WebElement messageBody;

    @FindBy(css = "span[class=\"feed-add-post-del-but\"]")
    public WebElement removeAllEmp;

    @FindBy(css = "a[id=\"bx-destination-tag\"]")
    public WebElement addRecipients;

    @FindBy (xpath = "//a[starts-with(@id, \"destDepartmentTab_destination\")]")
    public WebElement empDepBtn;

    @FindBy(css = "input[id=\"feed-add-post-destination-input\"]")
    public WebElement inputAddRecipient;

    @FindBy(css = "span[class=\"feed-add-info-text\"]")
    public WebElement messageTitleError;

    @FindBy(css = "span[class=\"feed-add-info-text\"]")
    public WebElement noRecipientError;


    @FindBy(css = "input[id=\"LIVEFEED_search\"]")
    public WebElement searchBox;


    @FindBy (css = "span[id=\"feed-post-more-2571\"]")
    public WebElement moreBtn;


    @FindBy (xpath = "(//span[@class='menu-popup-item-text'])[7]")
    public WebElement delBtn;


    @FindBy (css = "div[class=\"feed-post-block feed-post-block-short feed-post-block-separator feed-post-block-deleted\"]")
    public WebElement postDeletedMessage;


}
