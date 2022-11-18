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
    public WebElement task;

    @FindBy(xpath = "//input[@name='ACTION[0][ARGUMENTS][data][TITLE]']")
    public WebElement taskNameInput;

    @FindBy(xpath = "//input[@id='tasks-task-priority-cb']")
    public WebElement highPriorityBox;

    @FindBy(xpath = "(//span[@title='Cancel selection'])[1]")
    public WebElement defaultNameDlt;

    @FindBy(xpath = "(//a[@class='js-id-tdp-mem-sel-is-open-form task-form-field-when-filled task-form-field-link add'])[1]")
    public WebElement addMoreBtn;

    @FindBy(xpath = "//span[@class='tasks-task-mpf-link']")
    public WebElement checklistBtn;


}
