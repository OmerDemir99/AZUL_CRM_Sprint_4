package com.azulcrm.pages;

import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Gulsum_US07_1587_pollPage {

    public Gulsum_US07_1587_pollPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@id='feed-add-post-form-tab-vote']")
    public WebElement pollButton;

    @FindBy(xpath = "//a[@id='bx-destination-tag']")
    public WebElement addMore;

    @FindBy(xpath = "//div[@class='bx-finder-box-tabs']/a[2]" )
    public WebElement employeesAndDepartments;


    @FindBy(xpath ="//div[@class='bx-finder-company-department-employee-name']\n" )
    public List<WebElement> multipleContacts;


    @FindBy(xpath = "//input[@id='question_0']" )
    public WebElement question1;

    @FindBy(xpath = "//input[@id='answer_0__0_']" )
    public WebElement answer1;

    @FindBy(xpath = "//input[@id='answer_0__1_']" )
    public WebElement answer2;

    @FindBy(xpath = "//a[@class='vote-new-question-link addq']" )
    public WebElement addQuestion;

    @FindBy(xpath = "//input[@id='question_1']")
    public WebElement question2;

    @FindBy(xpath = "//input[@id='answer_1__0_']")
    public WebElement secQuestAnswer;

    @FindBy(xpath = "//input[@id='question_2']")
    public WebElement question3;

    @FindBy(xpath = "//input[@id='answer_2__0_']")
    public WebElement thirdQuestAns;

    @FindBy(xpath = "//input[@id='answer_2__1_']")
    public WebElement thirdQuest2Ans;

    @FindBy (xpath = "//input[@id='multi_0']" )
    public WebElement allowMultipleChoiceButton;

    @FindBy (xpath = "//input[@id='multi_1']" )
    public WebElement secondAllowMultipleChoiceButton;

    @FindBy (xpath = "//div[@class='feed-buttons-block']/button[1]")
    public WebElement sendButton;

//   @FindBy (xpath = "//button[@id='blog-submit-button-save']")
//   public WebElement sendButton;

//   @FindBy (xpath = "//body[@contenteditable='true']")
//    public WebElement pollBox;

   @FindBy (xpath = "//span[@class='feed-add-post-del-but']")
    public WebElement removeAllEmployees;

   @FindBy (xpath = "//span[@class='feed-add-info-text']")
    public  WebElement personErrorMessage;

    @FindBy (xpath = "")
    public  WebElement questionErrorMessage;

    @FindBy (xpath = "")
    public  WebElement answerErrorMessage;


    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }









}
