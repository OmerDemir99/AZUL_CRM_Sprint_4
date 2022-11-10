package com.azulcrm.step_definitions;

import com.azulcrm.pages.Zeynep_AZUL1583;
import com.github.dockerjava.api.model.Link;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Zeynep_StepDefinations {
    Zeynep_AZUL1583 zeynep_azul1583=new Zeynep_AZUL1583();
  @When("user click Message field")
    public void user_click_message_field() {
        zeynep_azul1583.MessageLink.click();
    }

    @When("user click Mention button at the bottom of message area")
    public void user_click_mention_button_at_the_bottom_of_message_area() {
        zeynep_azul1583.AddMention.click();

    }
    @When("user see and click  employee and department")
    public void user_see_and_click_employee_and_department() {
        zeynep_azul1583.employeeAndDepartment.click();


    }
    @Then("user dont see add new employee area")
    public void user_dont_see_add_new_employee_area() {
        Assert.assertTrue( !zeynep_azul1583.employeeAndDepartment.getText().contains("Add new employee"));
    }

}
