package com.azulcrm.step_definitions;

import com.azulcrm.pages.HomePage;
import com.azulcrm.utilities.BrowserUtils;
import io.cucumber.java.en.Then;

public class Omer_US_1584_EventModule {

    HomePage homePage = new HomePage();

    @Then("users click event button")
    public void users_click_event_button() {
        homePage.eventButton.click();
        BrowserUtils.sleep(2);
    }

}
