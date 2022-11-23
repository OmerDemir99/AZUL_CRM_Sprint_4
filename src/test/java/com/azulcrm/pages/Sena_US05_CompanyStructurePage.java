package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Sena_US05_CompanyStructurePage {


    @FindBy(xpath = "(//span[@class=\"menu-item-link-text\"])[10]")
    public WebElement employeeButton;

    @FindBy(xpath = "//span[@id=\"pagetitle\"]")
    public WebElement companyStructure;

    @FindBy(css = "#pagetitle-menu > a")
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
    public WebElement closeButton;

    @FindBy(xpath = "(//span[@class=\"popup-window-close-icon popup-window-titlebar-close-icon\"])[2]")
    public WebElement xForClose;

    @FindBy(xpath = "(//div[@class=\"structure-edit-icon\"])[2]")
    public WebElement pencilMark;

    @FindBy(xpath = "(//div[@title=\"Add child department\"])[2]")
    public WebElement plusMark;

    @FindBy(xpath = "(//div[@class=\"structure-delete-icon\"])[2]")
    public WebElement xMark;

    @FindBy()
    public WebElement warningMessage;

    @FindBy(xpath = "(//span[@class=\"structure-dept-block structure-dept-third structure-dept-editable\"])[1]")
    public WebElement childDepartment;

    @FindBy(xpath = "(//span[@class=\"structure-dept-block structure-dept-second structure-dept-editable\"])[1]")
    public WebElement newDepartment;

    @FindBy(xpath = "(//div[@class=\"finder-box-item-text\"])[1]")
    public WebElement getRecent;
    @FindBy(xpath = "(//div[@class=\"company-department-text\"])[1]")
    public WebElement companyItem;

    @FindBy(xpath = "(//div[@class=\"company-department-employee\"])[3]")
    public WebElement getCompany;

    @FindBy(xpath = "(//div[@class=\"structure-dept-title-text\"])[2]")
    public WebElement editPage;
}
