package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Zeynep_AZUL1583 {
    public Zeynep_AZUL1583() {

        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//span[text()='Message']")
    public WebElement MessageLink;

    @FindBy(id = "bx-b-mention-blogPostForm")
    public WebElement AddMention;

    @FindBy(xpath = "//*[contains(@id,'destDepartmentTab_mention')]")
    public WebElement employeeAndDepartment;

    @FindBy(xpath = "//span[@title='Link']")
    public WebElement attachLink;



    @FindBy(xpath = "//input[@placeholder='Link text']")
    public WebElement linkText;


    @FindBy(xpath = "//input[@placeholder='Link URL']")
    public WebElement linkURL;


    @FindBy(xpath = "//input[@id='undefined']")
    public WebElement saveButton;


    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    public WebElement sendButton;

    //div//a[.='Get Information From This Link']
    @FindBy(xpath = "//div//a[.='Get Information From This Link-2']")
    public WebElement info;

    @FindBy(xpath = "//span[@class='bxhtmled-top-bar-btn bxhtmled-button-video']")
    public WebElement insertVideoLink;

    @FindBy(xpath = "//input[@id='video_idPostFormLHE_blogPostForm-source']")
    public WebElement videoURL;

    @FindBy(xpath = "//span[@class='bxhtmled-video-error']")
    public WebElement errorMessage;

    @FindBy(xpath = "//input[@value='Save']")
    public WebElement videoSaveButton;

    @FindBy(xpath = "//span[@title='Quote text']")
    public WebElement addQuote;


    @FindBy(xpath = "//blockquote[@class='bxhtmled-quote']")
    public WebElement quoteTextArea;



}

