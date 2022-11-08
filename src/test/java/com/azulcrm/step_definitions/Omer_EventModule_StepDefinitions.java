package com.azulcrm.step_definitions;

import com.azulcrm.pages.LoginPage;
import io.cucumber.java.en.Given;

public class Omer_EventModule_StepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("users should login with valid credentials")
    public void users_should_login_with_valid_credentials() {
        loginPage.loginAsHR();
    }




}
