package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Zeynep_AZUL1583 {
    public Zeynep_AZUL1583() {

        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//span[text()='Message']")
    public WebElement MessageLink;

    @FindBy(id = "bx-b-mention-blogPostForm")
    public WebElement AddMention;

    @FindBy(xpath = "//*[contains(@id,'destDepartmentTab_mention')]")
    public WebElement employeeAndDepartment;
}
