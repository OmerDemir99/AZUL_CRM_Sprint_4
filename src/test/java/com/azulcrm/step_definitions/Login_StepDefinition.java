package com.azulcrm.step_definitions;

import com.azulcrm.pages.LoginPage;
import com.azulcrm.utilities.BrowserUtils;
import io.cucumber.java.en.Given;


public class Login_StepDefinition {

    LoginPage loginPage = new LoginPage();

    @Given("users should login with valid credentials as {string}")
    public void users_should_login_with_valid_credentials_as(String userType) {

        loginPage.login(userType);
        BrowserUtils.sleep(1);

    }


}
