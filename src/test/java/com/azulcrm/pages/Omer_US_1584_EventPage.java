package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Omer_US_1584_EventPage {

    public Omer_US_1584_EventPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy ( id = "feed-add-post-form-tab-calendar")
    public WebElement eventButton;




}
