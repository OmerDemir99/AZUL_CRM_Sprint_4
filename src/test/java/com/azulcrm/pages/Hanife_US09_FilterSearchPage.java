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

    @FindBy(xpath = "//div[@class='main-ui-filter-bottom-controls']")
    public WebElement bottomBlank;

    //Fields


    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[1]")
    public WebElement date;

    @FindBy(xpath = "//div[@data-name='DATE_CREATE_datesel']")
    public WebElement inboxDate;

    @FindBy(xpath = "(//span[@class='main-ui-select-name'])[1]")
    public WebElement yesterdayDate;

    @FindBy(xpath = "(//span[@class='main-ui-select-name'])[4]")
    public WebElement currentdayDate;

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


    @FindBy(xpath = "(//span[@title='Hide field'])[5]")
    public WebElement xSign;



//    @FindBy(xpath = "//span[@title='Hide field']")
//    public List<WebElement> fields ;

    // saving filter part
    @FindBy(xpath = "//span[.='Save filter']")
    public WebElement saveFilterText;

    @FindBy(xpath = "//input[@class='main-ui-filter-sidebar-edit-control']")
    public WebElement inboxAddingFilter;

    @FindBy(xpath = "//span[@class='ui-btn ui-btn-success main-ui-filter-field-button main-ui-filter-save']")
    public WebElement saveButton;

    @FindBy(xpath = "//span[.='good News']")
    public WebElement newFilter;

    @FindBy(xpath = "//span[.='Reset to default']")
    public WebElement resetFilterLink;

    @FindBy(xpath = "//span[@class='popup-window-button']")
    public WebElement continueButton;


    @FindBy(css = "#popup-window-content-LIVEFEED_search_container > div > div > div.main-ui-filter-bottom-controls > div.main-ui-filter-field-preset-button-container > div > button")
    public WebElement searchButton;

    @FindBy(css = "#LIVEFEED_search_container > div.main-ui-filter-search-square.main-ui-square > div.main-ui-item-icon.main-ui-square-delete")
    public WebElement searchCloseSign;

    //types
    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[1]")
    public WebElement typePosts;

    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[2]")
    public WebElement typeAnnouncements;

    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[3]")
    public WebElement typeAppretiations;

    @FindBy(xpath = "//*[@id=\"popup-window-content-LIVEFEED_search_container\"]/div/div/div[2]/div[1]/div[2]/span[2]")
    public WebElement space;

    @FindBy(xpath = "//div[@class='main-ui-square-item']")
    public WebElement searchResult;

    @FindBy(xpath = "//div[@class='main-ui-item-icon main-ui-square-delete']")
    public  WebElement deleteResult;

}
