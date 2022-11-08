package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import io.cucumber.core.filter.Filters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class Hanife_US09_FilterSearchPage {

    public Hanife_US09_FilterSearchPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//input[@id='LIVEFEED_search']")
    public WebElement filterSearchInputBox;

//default filters
    @FindBy(xpath = "(//span[@class='main-ui-filter-sidebar-item-text'])[1]")
    public WebElement work;

    @FindBy(xpath = "(//span[@class='main-ui-filter-sidebar-item-text'])[2]")
    public WebElement favorites;

    @FindBy(xpath = "(//span[@class='main-ui-filter-sidebar-item-text'])[3]")
    public WebElement myActivity;

    @FindBy(xpath = "(//span[@class='main-ui-filter-sidebar-item-text'])[4]")
    public WebElement announcements;

    @FindBy(xpath = "(//span[@class='main-ui-filter-sidebar-item-text'])[5]")
    public WebElement workflows;


    public List<WebElement> total(List<WebElement> allFilters) {
        allFilters.addAll(Arrays.asList(work, favorites, myActivity, announcements, workflows));
        return allFilters;
    }

    @FindBy(xpath = "//span[.='Add field']")
    public WebElement addFieldLink;

    //Fields


    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[1]")
    public WebElement date;

    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[2]")
    public WebElement type;

    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[3]")
    public WebElement author;

    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[4]")
    public WebElement to;

    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[5]")
    public WebElement favoritesField;

    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[6]")
    public WebElement tag;

    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[7]")
    public WebElement extranet;

    @FindBy(xpath = "//span[.='Restore default fields']")
    public WebElement restoreLink;


}
