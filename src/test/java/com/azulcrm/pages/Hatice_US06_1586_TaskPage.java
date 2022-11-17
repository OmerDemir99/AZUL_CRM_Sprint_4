package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Hatice_US06_1586_TaskPage {

    public Hatice_US06_1586_TaskPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//span[@id='feed-add-post-form-tab-tasks']")
    public WebElement taskMenu;

    @FindBy(xpath = "//a[@title='Tasks']")
    public WebElement tasksModule;

    @FindBy(xpath = "//span[@id='pagetitle']")
    public WebElement myTasksText;

    @FindBy(xpath = "(//span[@class='main-buttons-item-counter'])[1]")
    public WebElement countAllTasks;

    @FindBy(xpath = "//input[@name='ACTION[0][ARGUMENTS][data][TITLE]']")
    public WebElement taskNameInput;

    @FindBy(xpath = "//input[@id='tasks-task-priority-cb']")
    public WebElement highPriorityBox;

    @FindBy(xpath = "(//span[@title='Cancel selection'])[1]")
    public WebElement defaultNameDlt;

    @FindBy(xpath = "//div[@id='bx-component-scope-lifefeed_task_form-responsible']")
    public WebElement responsiblePersonInputBox;

    @FindBy(xpath = "//div[@id='popup-window-content-BXSocNetLogDestination']")
    public WebElement personPopup;

    @FindBy(xpath = "//span[@class='popup-window-close-icon']")
    public WebElement personPopupDlt;

    @FindBy(xpath = "//table[@class='bx-finder-box-tabs-content-table']//tr//td//a")
    public WebElement anyUser;

    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    public WebElement sendBtn;

    @FindBy(xpath = "//span[@class='tasks-task-mpf-link']")
    public WebElement checklistBtn;

    @FindBy(xpath = "//input[@class='js-id-checklist-is-form-title task-checklist-field-add']")
    public WebElement checklistInput;

    @FindBy(xpath = "//span[@class='js-id-checklist-is-form-submit block-edit tasks-btn-apply task-field-title-ok']")
    public WebElement checklistTick;

    @FindBy(xpath = "(//span[.='add'])[2]")
    public WebElement checklistAddBtn;

    @FindBy(xpath = "(//input[@class='task-options-inp'])[1]")
    public WebElement deadlineInput;

    @FindBy(xpath = "//a[@class='bx-calendar-top-month']")
    public WebElement monthsList;

    @FindBy(xpath = "//div[@class='task-message-label error']")
    public WebElement taskNameErrorMessage;

   // @FindBy(xpath = "(//div[@class='task-message-label error'])[2]")
   // public WebElement responsiblePrsnErrorMessage;




}
