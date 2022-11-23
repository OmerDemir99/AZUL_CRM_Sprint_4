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

    @FindBy(xpath = "//span[@class='if-not-no']")
    public WebElement highPriority;

    @FindBy(xpath = "//div[@class='sidebar-widget sidebar-widget-tasks']")
    public WebElement myTasks;

    @FindBy(xpath = "//span[@id='menu-counter-tasks_total']")
    public WebElement tasksCount;

    @FindBy(xpath = "//input[@name='ACTION[0][ARGUMENTS][data][TITLE]']")
    public WebElement taskNameInput;

    @FindBy(xpath = "//input[@id='tasks-task-priority-cb']")
    public WebElement highPriorityBox;

    @FindBy(xpath = "(//span[@title='Cancel selection'])[1]")
    public WebElement defaultNameDlt;

    @FindBy(xpath = "//div[@class='task-message-label error']")
    public WebElement errorMessage;

    @FindBy(xpath = "(//input[@class='js-id-tdp-mem-sel-is-search js-id-network-selector-search task-form-field-search task-form-field-input'])[1]")
    public WebElement responsiblePersonInputBox;

    @FindBy(xpath = "//div[@class='feed-create-task-popup-title']")
    public WebElement taskCreatedPopup;

    @FindBy(xpath = "//span[@class='popup-window-button']")
    public WebElement viewTaskBtn;

    @FindBy(xpath = "//table[@class='bx-finder-box-tabs-content-table']//td//a")
    public WebElement personPopup;

    @FindBy(xpath = "//table[@class='bx-finder-box-tabs-content-table']//tr//td//a[2]")
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

    @FindBy(xpath = "//div[@class='task-checklist-field generic']")
    public WebElement checklistVerify;

    @FindBy(xpath = "//iframe[@class='side-panel-iframe']")
    public WebElement taskIframe;

    @FindBy(xpath = "(//input[@class='task-options-inp'])[1]")
    public WebElement deadlineInput;

    @FindBy(xpath = "//span[@id='task-detail-deadline']")
    public WebElement deadlineCheck;

    @FindBy(xpath = "//a[@class='bx-calendar-top-month']")
    public WebElement monthsList;

    @FindBy(xpath = "//span[.='January']")
    public WebElement anyMonth;

    @FindBy(xpath = "//a[@class='bx-calendar-top-year']")
    public WebElement yearList;

    @FindBy(xpath = "//input[@class='bx-calendar-year-input']")
    public WebElement yearInput;

    @FindBy(xpath = "//a[@class='bx-calendar-cell']")
    public WebElement weekdays;

    @FindBy(xpath = "//a[@class='bx-calendar-cell bx-calendar-active']")
    public WebElement activeDay;

    @FindBy(xpath = "(//input[@class='bx-calendar-form-input'])[1]")
    public WebElement hourInput;

    @FindBy(xpath = "(//input[@class='bx-calendar-form-input'])[2]")
    public WebElement minuteInput;

    @FindBy(xpath = "(//a[@class='bx-calendar-form-arrow bx-calendar-form-arrow-top'])[1]")
    public WebElement hourUpArrow;

    @FindBy(xpath = "(//a[@class='bx-calendar-form-arrow bx-calendar-form-arrow-bottom'])[1]")
    public WebElement hourDownArrow;

    @FindBy(xpath = "(//a[@class='bx-calendar-form-arrow bx-calendar-form-arrow-top'])[2]")
    public WebElement minuteUpArrow;

    @FindBy(xpath = "(//a[@class='bx-calendar-form-arrow bx-calendar-form-arrow-bottom'])[2]")
    public WebElement minuteDownArrow;

    @FindBy(xpath = "(//a[@class='bx-calendar-form-arrow-top'])")
    public WebElement amArrow;

    @FindBy(xpath = "//a[@class='bx-calendar-button bx-calendar-button-select']")
    public WebElement selectBtn;

    @FindBy(xpath = "//span[.='Time planning']")
    public WebElement timePlanningBtn;

    @FindBy(xpath = "(//input[@class='task-options-inp'])[2]")
    public WebElement startTaskInput;

    @FindBy(xpath = "(//input[@class='task-options-inp'])[4]")
    public WebElement finishInput;

    @FindBy(xpath = "(//div[@class='task-detail-sidebar-item-value'])[5]")
    public WebElement timePlanningCheck;

    @FindBy(xpath = "//input[@data-bx-id='dateplanmanager-duration']")
    public WebElement durationInput;

    @FindBy(xpath = "//span[@data-unit='days']")
    public WebElement durationDays;

    @FindBy(xpath = "//span[@data-unit='hours']")
    public WebElement durationHours;

    @FindBy(xpath = "//span[@data-unit='mins']")
    public WebElement durationMints;











}
