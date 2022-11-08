package com.azulcrm.step_definitions;

import com.azulcrm.pages.Omer_US_1584_EventPage;
import com.azulcrm.utilities.BrowserUtils;
import io.cucumber.java.en.Then;

public class Omer_US_1584_EventModule {

    Omer_US_1584_EventPage eventPage = new Omer_US_1584_EventPage();

    @Then("users click event button")
    public void users_click_event_button() {
        eventPage.eventButton.click();
        BrowserUtils.sleep(2);
    }

}
