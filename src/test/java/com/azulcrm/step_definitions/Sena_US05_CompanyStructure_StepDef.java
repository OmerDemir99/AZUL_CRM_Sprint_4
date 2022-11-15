package com.azulcrm.step_definitions;

import com.azulcrm.pages.Sena_US05_CompanyStructurePage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class Sena_US05_CompanyStructure_StepDef {

    Sena_US05_CompanyStructurePage companyStructurePage = new Sena_US05_CompanyStructurePage();

    @When("users click the employee button")
    public void users_click_the_employee_button() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(companyStructurePage.employeeButton).perform();
        BrowserUtils.sleep(1);
        companyStructurePage.employeeButton.click();

    }

    @Then("verify that users should be able to see company structure")
    public void verify_that_users_should_be_able_to_see_company_structure() {
        BrowserUtils.sleep(1);
        Assert.assertTrue(companyStructurePage.companyStructure.isDisplayed());
    }


    @When("users click the add department button")
    public void users_click_the_add_department_button() {
        BrowserUtils.sleep(1);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(companyStructurePage.addDepartmentButton).perform();
        BrowserUtils.sleep(2);
        companyStructurePage.addDepartmentButton.click();

    }

    @When("users click the add button")
    public void users_click_the_add_button() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(companyStructurePage.addButton).perform();
        BrowserUtils.sleep(2);
        companyStructurePage.addButton.click();
    }

    @Then("Verify that users should be able to see error message: {string}")
    public void verify_that_users_should_be_able_to_see_error_message(String message) {
        Assert.assertTrue(companyStructurePage.errorMessage.isDisplayed());
        BrowserUtils.sleep(2);
        Assert.assertTrue(companyStructurePage.errorMessage.getText().equals(message));
        BrowserUtils.sleep(2);

    }


    @When("users write {string} in department name input box")
    public void users_write_in_department_name_input_box(String string) {

        companyStructurePage.nameInputBox.sendKeys("Catch The Bug");
        BrowserUtils.sleep(2);
    }

    @Then("verify that users see the department they just added")
    public void verify_that_users_see_the_department_they_just_added() {

        BrowserUtils.sleep(2);
        Assert.assertTrue(companyStructurePage.newDepartment.isDisplayed());

    }

    @Then("verify that users should be able to select a parent department")
    public void verify_that_users_should_be_able_to_select_a_parent_department() {
        BrowserUtils.sleep(1);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(companyStructurePage.parentDepartment).perform();
        BrowserUtils.sleep(1);
        companyStructurePage.parentDepartment.click();
    }

    @When("verify that user see the select from structure article")
    public void verify_that_user_see_the_select_from_structure_article() {
        Assert.assertTrue(companyStructurePage.structureArticle.isDisplayed());
        BrowserUtils.sleep(2);

    }

    @When("users click the select from structure article")
    public void users_click_the_select_from_structure_article() {
        Actions acts = new Actions(Driver.getDriver());
        acts.moveToElement(companyStructurePage.structureArticle).perform();
        BrowserUtils.sleep(1);
        companyStructurePage.structureArticle.click();
        BrowserUtils.sleep(1);
    }

    @And("verify that users should be able to select recent")
    public void verifyThatUsersShouldBeAbleToSelectRecent() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(companyStructurePage.recent).perform();
        BrowserUtils.sleep(2);
        companyStructurePage.recent.click();
        BrowserUtils.sleep(1);

    }

    @Then("users should be able to choose one of recent item")
    public void usersShouldBeAbleToChooseOneOfRecentItem() {
        companyStructurePage.getRecent.click();
    }

    @And("verify that users should be able to select company")
    public void verifyThatUsersShouldBeAbleToSelectCompany() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(companyStructurePage.company).perform();
        BrowserUtils.sleep(2);
        companyStructurePage.company.click();
        BrowserUtils.sleep(1);
    }


    @Then("verify that users should be able to click the close button and pop-up closed")
    public void verifyThatUsersShouldBeAbleToClickTheCloseButtonAndPopUpClosed() {
        BrowserUtils.sleep(2);
        Assert.assertTrue(companyStructurePage.closeButton.isDisplayed());
        Actions acts = new Actions(Driver.getDriver());
        acts.moveToElement(companyStructurePage.closeButton).perform();
        BrowserUtils.sleep(1);
        companyStructurePage.closeButton.click();
    }

    @Then("verify that users should be able to click x button and pop-up closed")
    public void verifyThatUsersShouldBeAbleToClickXButtonAndPopUpClosed() {
        BrowserUtils.sleep(2);
        Actions acts = new Actions(Driver.getDriver());
        acts.moveToElement(companyStructurePage.xForClose).perform();
        BrowserUtils.sleep(1);
        companyStructurePage.xForClose.click();
    }

    @And("verify that users should be able to click the pencil mark on new department for editing")
    public void verifyThatUsersShouldBeAbleToClickThePencilMarkOnNewDepartmentForEditing() {
       /* Actions act = new Actions(Driver.getDriver());
        act.moveToElement(companyStructurePage.pencilMark).perform();
        Assert.assertTrue(companyStructurePage.pencilMark.isDisplayed());
        BrowserUtils.sleep(2);
        companyStructurePage.pencilMark.click();
        Assert.assertTrue(companyStructurePage.editPage.isDisplayed());

        */
    }
}
