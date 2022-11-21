package com.azulcrm.step_definitions;

import com.azulcrm.pages.Hatice_US06_1586_TaskPage;
import com.azulcrm.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import java.util.List;

public class Hatice_US06_1586_AssignTask_StepDefs {

    Hatice_US06_1586_TaskPage taskPage = new Hatice_US06_1586_TaskPage();


    @When("User clicks TASK menu")
    public void user_clicks_task_menu() {
        taskPage.taskMenu.click();
        BrowserUtils.sleep(2);
    }
    @When("clicks task name field and write")
    public void clicks_task_name_field_and_write() {
        taskPage.taskNameInput.click();
        taskPage.taskNameInput.sendKeys("TEST");

    }
    @When("ticks the high priority box")
    public void ticks_the_high_priority_box() {
        taskPage.highPriorityBox.click();
        BrowserUtils.sleep(2);
    }
    @When("go to responsible person field remove the default value if any and add user")
    public void go_to_responsible_person_field_remove_the_default_value_if_any_and_add_user() {
        taskPage.defaultNameDlt.click();
        taskPage.anyUser.click();
        BrowserUtils.sleep(2);
    }
    @Then("click send button")
    public void click_send_button() {
        taskPage.sendBtn.click();
    }
    @Then("verify that you see error message")
    public void verify_that_you_see_error_message() {
        Assert.assertTrue(taskPage.taskNameErrorMessage.isDisplayed());
        BrowserUtils.sleep(2);
    }
    @When("go to responsible person field remove the default value if any")
    public void go_to_responsible_person_field_remove_the_default_value_if_any() {
        taskPage.defaultNameDlt.click();
        taskPage.taskNameInput.click();
        BrowserUtils.sleep(2);
    }
    @And("click add more and add three users")
    public void clickAddMoreAndAddThreeUsers(List<String> users) {
        for (String each : users) {
            taskPage.responsiblePersonInputBox.sendKeys(each);
            BrowserUtils.sleep(3);
            taskPage.personPopup.click();

        }
        BrowserUtils.sleep(3);
    }
    @Then("see task created alert")
    public void seeTaskCreatedAlert() {
        Assert.assertTrue(taskPage.taskCreatedPopup.isDisplayed());
    }
    @Then("verify that you see responsible person error message")
    public void verifyThatYouSeeResponsiblePersonErrorMessage() {
        Assert.assertTrue(taskPage.taskNameErrorMessage.isDisplayed());
        BrowserUtils.sleep(5);
    }
    @When("user clicks on tasks menu under activity stream")
    public void user_clicks_on_tasks_menu_under_activity_stream() {

    }
    @When("sees my tasks text")
    public void sees_my_tasks_text() {

    }
    @Then("verify that the number of all has increased")
    public void verifyThatTheNumberOfAllHasIncreased() {

    }
    @When("click on checklist and write something in the things to do")
    public void click_on_checklist_and_write_something_in_the_things_to_do() {

    }
    @And("click on checkmark or add")
    public void clickOnCheckmarkOrAdd() {
    }
    @Then("verify that checklist has been added")
    public void verify_that_checklist_has_been_added() {

    }





}
