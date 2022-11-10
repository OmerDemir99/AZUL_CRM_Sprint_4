package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class adnan_AZUL_1584_sendMessage {

    public adnan_AZUL_1584_sendMessage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//span[@id=\"feed-add-post-form-tab-message\"]")
    public WebElement messageBtn;

    @FindBy(css = "[id=\"blog-submit-button-save\"]")
    public WebElement sendBtn;

    @FindBy(css = "[id=\"blog-submit-button-cancel\"]")
    public WebElement cancelBtn;

    @FindBy(xpath = "//span[@class=\"feed-add-post-destination-text\"]")
    public WebElement allEmployeesBtn;

    @FindBy(xpath = "//a[@class=\"feed-add-destination-link\"]")
    public WebElement addMoreLink;

    // test
}
