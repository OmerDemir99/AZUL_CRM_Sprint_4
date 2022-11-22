package com.azulcrm.step_definitions;

import com.azulcrm.pages.Hatice_US06_1586_TaskPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;


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
        taskPage.responsiblePersonInputBox.click();
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
        BrowserUtils.sleep(3);
        taskPage.checklistBtn.click();
        BrowserUtils.sleep(3);
        taskPage.checklistInput.sendKeys("Test");
    }
    @And("click on checkmark or add")
    public void clickOnCheckmarkOrAdd() {
        String str = "Add";
        if (str.equals("Add")){
            taskPage.checklistAddBtn.click();
        }else {
            taskPage.checklistTick.click();
        }
    }
    @Then("verify that checklist has been added")
    public void verify_that_checklist_has_been_added() {
        BrowserUtils.sleep(3);
        taskPage.viewTaskBtn.click();
        Driver.getDriver().switchTo().frame(taskPage.taskIframe);
        Assert.assertTrue(taskPage.checklistVerify.isDisplayed());

    }


    @When("user sees the my tasks table on the homepage")
    public void userSeesTheMyTasksTableOnTheHomepage() {
        Assert.assertTrue(taskPage.myTasks.isDisplayed());
    }

    @Then("check and verify created task counts")
    public void checkAndVerifyCreatedTaskCounts() {
        if (!(taskPage.firstCount.getText().equals(taskPage.firstCount.getText()))){

        }
    }

    @And("click on the deadline input")
    public void clickOnTheDeadlineInput() {
        taskPage.deadlineInput.click();
        BrowserUtils.sleep(3);
    }


    @And("set valid day, month, year")
    public void setValidDayMonthYear() {
        taskPage.monthsList.click();
        BrowserUtils.sleep(2);
        taskPage.anyMonth.click();
        taskPage.yearList.click();
        BrowserUtils.sleep(2);
        taskPage.yearInput.sendKeys("2023");
        BrowserUtils.sleep(3);
        taskPage.weekdays.click();
        BrowserUtils.sleep(3);
    }

    @And("set time using arrows")
    public void setTimeUsingArrows() {
        taskPage.hourUpArrow.click();

        for (int i = 0; i < 3; i++) {
            taskPage.minuteDownArrow.click();
        }

    }

    @Then("click the select button")
    public void clickTheSelectButton() {
        taskPage.selectBtn.click();
        BrowserUtils.sleep(3);

    }


    @And("set time by typing")
    public void setTimeByTyping() {
        taskPage.hourInput.sendKeys("03");
        taskPage.minuteInput.sendKeys("30");
    }

    @And("make sure the deadline is correct")
    public void makeSureTheDeadlineIsCorrect() {
        String expected = "01/02/2023 03:30 ";
        Assert.assertEquals(expected, taskPage.deadlineInput.getAttribute("value"));

    }

    @And("click time planning button")
    public void clickTimePlanningButton() {
        taskPage.timePlanningBtn.click();
        BrowserUtils.sleep(3);
    }

    @Then("set task start and finish time")
    public void setTaskStartAndFinishTime() {
        taskPage.startTaskInput.click();
        taskPage.monthsList.click();
        BrowserUtils.sleep(2);
        taskPage.anyMonth.click();
        taskPage.yearList.click();
        BrowserUtils.sleep(2);
        taskPage.yearInput.sendKeys("2022");
        taskPage.weekdays.click();

        taskPage.hourUpArrow.click();
        for (int i = 0; i < 10; i++) {
            taskPage.minuteUpArrow.click();
        }

        taskPage.selectBtn.click();
        Assert.assertEquals("01/03/2022 10:10 am", taskPage.startTaskInput.getAttribute("value"));

        taskPage.finishInput.click();
        taskPage.monthsList.click();
        BrowserUtils.sleep(2);
        taskPage.anyMonth.click();
        taskPage.yearList.click();
        BrowserUtils.sleep(2);
        taskPage.yearInput.sendKeys("2022");
        taskPage.weekdays.click();

        taskPage.hourUpArrow.click();
        for (int i = 0; i < 30; i++) {
            taskPage.minuteDownArrow.click();
        }

        taskPage.selectBtn.click();
        Assert.assertEquals("01/03/2022 07:30 pm", taskPage.finishInput.getAttribute("value"));





    }

    @And("set task start time")
    public void setTaskStartTime() {
    }

    @Then("verify that day, hour, minute can be changed as set duration")
    public void verifyThatDayHourMinuteCanBeChangedAsSetDuration() {
    }
}
