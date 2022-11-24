package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class aziz_AZUL1594_UploadingFiles {


    public aziz_AZUL1594_UploadingFiles() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy ( xpath = "//span[@id=\"feed-add-post-form-tab-message\"]")
    public WebElement messageButton;


    @FindBy (id="bx-b-uploadfile-blogPostForm")
    public WebElement UploadButton;

  //  @FindBy (xpath = "(//div[@class='diskuf-uploader'])[1]")



   @FindBy (xpath = "(//input[@class='diskuf-fileUploader wd-test-file-light-inp '])[1]")

    public WebElement UploadFilesImagesButton;

    @FindBy ()
    public WebElement selection;



    @FindBy () // locate edelim
    public WebElement OpenButton;













}
