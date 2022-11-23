package com.azulcrm.step_definitions;

import com.azulcrm.pages.aziz_AZUL1594_UploadingFiles;
import com.azulcrm.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class aziz_AZUL1594_UploadingFiles_StepDefinitions {


    aziz_AZUL1594_UploadingFiles messagePage = new aziz_AZUL1594_UploadingFiles();


    @When("user clicks the message button")
    public void user_clicks_the_message_button() {
     messagePage.messageButton.click();

    }
    @When("User clicks the Upload files button")
    public void user_clicks_the_upload_files_button() {
       messagePage.UploadButton.click();
        BrowserUtils.sleep(4);

    }

    @When("user clicks Upload files and images section")
    public void user_clicks_upload_files_and_images_section() {
   // messagePage.UploadFilesImagesButton.click();
   //     BrowserUtils.sleep(4);

        String rootpath = System.getProperty("user.dir");

        System.out.println("rootpath = " + rootpath);

       messagePage.UploadFilesImagesButton.sendKeys(rootpath+"\\src\\test\\resources\\CI-CD Jenkins July 2021.pdf");
        messagePage.UploadFilesImagesButton.sendKeys(rootpath+"\\src\\test\\resources\\ParallelTestingETCC-1.pdf");
        messagePage.UploadFilesImagesButton.sendKeys(rootpath+"\\src\\test\\resources\\Static_Keyword.pdf");
    }


    @When("user selects three files from the database")
    public void user_selects_three_files_from_the_database() {

    //    messagePage.UploadFilesImagesButton.sendKeys("C:\\Users\\Asus\\Downloads\\Github_1_Slides.pptx");






    }
    @When("user clicks open button")
    public void user_clicks_open_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
