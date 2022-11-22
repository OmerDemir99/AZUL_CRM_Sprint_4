package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sena_US05_CompanyStructurePage {

    public Sena_US05_CompanyStructurePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[@class=\"menu-item-link-text\"])[10]")
    public WebElement employeeButton;

    @FindBy(xpath = "//span[@id=\"pagetitle\"]")
    public WebElement companyStructure;

    @FindBy(css = "#pagetitle-menu > a")
            //(xpath = "//a[@class=\"webform-small-button webform-small-button-blue webform-small-button-add\"]")
    public WebElement addDepartmentButton;
    @FindBy(xpath = "//span[@class=\"popup-window-button popup-window-button-accept\"]")
    public WebElement addButton;
    @FindBy(xpath = "//div[@class=\"webform-content\"]")
    public WebElement errorMessage;

    @FindBy(xpath = "(//input[@type=\"text\"])[2]")
    public WebElement nameInputBox;

    @FindBy(xpath = "//option[@value=\"129\"]")
    public WebElement parentDepartment;

    @FindBy(xpath = "//select[@name=\"IBLOCK_SECTION_ID\"]")
    public WebElement changeParDep;

    @FindBy(xpath = "//a[@id=\"single-user-choice\"]")
    public WebElement structureArticle;

    @FindBy(xpath = "(//span[@class=\"finder-box-tab-text\"])[1]")
    public WebElement recent;

    @FindBy(xpath = "(//span[@class=\"finder-box-tab-text\"])[2]")
    public WebElement company;

    @FindBy(xpath = "(//span[@class=\"finder-box-tab-text\"])[3]")
    public WebElement search;

    @FindBy(xpath = "//*[@id=\"BXStructure\"]/div[3]/span[2]")
            //(xpath = "//span[@class=\"popup-window-button popup-window-button-link popup-window-button-link-cancel\"]")
    public WebElement closeButton;

    @FindBy(xpath = "//*[@id=\"tasks-iframe-popup\"]/span")
            //xpath = "(//span[@class=\"popup-window-close-icon popup-window-titlebar-close-icon\"])[2]")
    public WebElement xForClose;

    @FindBy(xpath = "(//div[@class=\"structure-edit-icon\"])[1]")
    public WebElement pencilMark;

    @FindBy(xpath = "(//div[@title=\"Add child department\"])[1]")
    public WebElement plusMark;

    @FindBy(xpath = "(//div[@class=\"structure-delete-icon\"])[1]")
    public WebElement xMark;

    @FindBy()
    public WebElement warningMessage;

    @FindBy(xpath = "(//span[@class=\"structure-dept-block structure-dept-third structure-dept-editable\"])[1]")
    public WebElement childDepartment;

    @FindBy(xpath = "(//span[@class=\"structure-dept-block structure-dept-second structure-dept-editable\"])[1]")
    public WebElement newDepartment;

    @FindBy(xpath = "(//div[@class=\"finder-box-item-text\"])[1]")
    public WebElement getRecent;
    @FindBy(xpath= "(//div[@class=\"company-department-text\"])[1]")
    public WebElement companyItem;

    @FindBy(xpath = "(//div[@class=\"company-department-employee\"])[3]")
    public WebElement getCompany;

    @FindBy(xpath = "//span[@class=\"popup-window-titlebar-text\"]")
    public WebElement editPage;


}
