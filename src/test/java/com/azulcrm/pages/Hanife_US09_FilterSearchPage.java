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
    public WebElement act;

    @FindBy(xpath = "(//span[@class='main-ui-filter-sidebar-item-text'])[7]")
    public WebElement like;

    @FindBy(xpath = "(//span[@class='main-ui-filter-sidebar-item-text'])[4]")
    public WebElement myActivity;

    @FindBy(xpath = "(//span[@class='main-ui-filter-sidebar-item-text'])[5]")
    public WebElement announcements;

    @FindBy(xpath = "(//span[@class='main-ui-filter-sidebar-item-text'])[6]")
    public WebElement workflows;



    public List<WebElement> total(List<WebElement> allFilters) {
        allFilters.addAll(Arrays.asList(work, favorites, myActivity, announcements, workflows,act,like));
        allFilters.removeIf(p-> p.getText().isBlank());

        return allFilters;
    }

    @FindBy(xpath = "//span[.='Add field']")
    public WebElement addFieldLink;

    @FindBy(xpath = "//span[.='Restore default fields']")
    public WebElement restoreLink;

    //Fields


    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[1]")
    public WebElement date;

    @FindBy(xpath = "//div[@data-name='DATE_CREATE_datesel']")
    public WebElement inboxDate;

    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[2]")
    public WebElement type;

    @FindBy(xpath = "//div[@data-name='EVENT_ID']")
    public WebElement inboxType;

    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[3]")
    public WebElement author;

    @FindBy(name = "CREATED_BY_ID_label")
    public WebElement inboxAuthor;

    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[4]")
    public WebElement to;

    @FindBy(name = "TO_label")
    public WebElement inboxTo;

    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[5]")
    public WebElement favoritesField;

    @FindBy(xpath = "//div[@data-name='FAVORITES_USER_ID']")
    public WebElement inboxFavorites;

    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[6]")
    public WebElement tag;

    @FindBy(xpath = "//input[@name='TAG']")
    public WebElement inboxTag;

    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[7]")
    public WebElement extranet;

    @FindBy(xpath = "//div[@data-name='EXTRANET']")
    public WebElement inboxExtranet;



    //fields x sign for removing
    @FindBy(xpath = "(//span[@title='Hide field'])[1]")
    public WebElement xSignDate;

    @FindBy(xpath = "(//span[@title='Hide field'])[1]")
    public WebElement xSignType;

    @FindBy(xpath = "(//span[@title='Hide field'])[1]")
    public WebElement xSignAuthor;

    @FindBy(xpath = "(//span[@title='Hide field'])[1]")
    public WebElement xSignTo;

    @FindBy(xpath = "(//span[@title='Hide field'])[1]")
    public WebElement xSignFavorites;

    @FindBy(xpath = "(//span[@title='Hide field'])[1]")
    public WebElement xSignTag;

    @FindBy(xpath = "(//span[@title='Hide field'])[1]")
    public WebElement xSignExtranet;

    @FindBy(xpath = "//span[@title='Hide field']")
    public List<WebElement> fields ;


}
