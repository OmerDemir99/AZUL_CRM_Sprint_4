package com.azulcrm.step_definitions;

import com.azulcrm.pages.Sena_US05_CompanyStructurePage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
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
        BrowserUtils.sleep(1);
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
        BrowserUtils.sleep(2);

    }

    @Then("verify that users should be able to select a parent department")
    public void verify_that_users_should_be_able_to_select_a_parent_department() {
        BrowserUtils.sleep(1);
        companyStructurePage.changeParDep.click();

        BrowserUtils.sleep(1);
        companyStructurePage.parentDepartment.click();
        BrowserUtils.sleep(2);

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
        BrowserUtils.sleep(2);
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

    @Then("users should be able to choose one of company item")
    public void usersShouldBeAbleToChooseOneOfCompanyItem() {

        companyStructurePage.companyItem.click();
        BrowserUtils.sleep(2);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("window.scrollBy(0,150)");
        companyStructurePage.getCompany.click();
    }

    @Then("verify that users should be able to select search")
    public void verifyThatUsersShouldBeAbleToSelectSearch() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(companyStructurePage.search).perform();
        BrowserUtils.sleep(2);
        companyStructurePage.search.click();
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

        BrowserUtils.sleep(1);
        companyStructurePage.xForClose.click();
    }

    @And("verify that users should be able to click the pencil mark on new department for editing")
    public void verifyThatUsersShouldBeAbleToClickThePencilMarkOnNewDepartmentForEditing() {

        BrowserUtils.sleep(2);
        companyStructurePage.pencilMark.click();

        BrowserUtils.sleep(1);

        Assert.assertTrue(companyStructurePage.editPage.isDisplayed());
        BrowserUtils.sleep(2);
    }

    @And("users click the plus mark on new department")
    public void usersClickThePlusMarkOnNewDepartment() {

        BrowserUtils.sleep(1);
        companyStructurePage.plusMark.click();

    }

    @And("users should be able to display new add department pop-up box")
    public void usersShouldBeAbleToDisplayNewAddDepartmentPopUpBox() {
        BrowserUtils.sleep(2);
        Assert.assertTrue(companyStructurePage.newDepartment.isDisplayed());
    }

    @And("users click the x mark on new department")
    public void usersClickTheXMarkOnNewDepartment() {
       /* BrowserUtils.sleep(1);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(companyStructurePage.xMark).perform();

        */
        BrowserUtils.sleep(2);
        companyStructurePage.xMark.click();
        BrowserUtils.sleep(1);
    }

    @And("users should be able to see warning message")
    public void usersShouldBeAbleToSeeWarningMessage() {
        Driver.getDriver().switchTo().alert().accept();


    }

    @Then("users click the ok button for delete the department")
    public void usersClickTheOkButtonForDeleteTheDepartment() {

    }


    @And("verify that user should be able to see child class")
    public void verifyThatUserShouldBeAbleToSeeChildClass() {
        BrowserUtils.sleep(2);
        Assert.assertTrue(companyStructurePage.childDepartment.isDisplayed());
    }

    @And("verify that users should be able to take a department box after that drag and drop it under another department")
    public void verifyThatUsersShouldBeAbleToTakeADepartmentBoxAfterThatDragAndDropItUnderAnotherDepartment() {
        BrowserUtils.sleep(2);

        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(companyStructurePage.childDepartment, companyStructurePage.newDepartment).build().perform();
        //JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        // jse.executeScript("window.scrollBy(0,150)");
        //actions.clickAndHold(companyStructurePage.childDepartment).moveToElement(companyStructurePage.newDepartment).release().perform();
        BrowserUtils.sleep(1);

    }


    @And("verify that users should not see the add department button")
    public void verifyThatUsersShouldNotSeeTheAddDepartmentButton() {
        BrowserUtils.sleep(3);

        Assert.assertFalse(companyStructurePage.addDepartmentButton.isDisplayed());
        BrowserUtils.sleep(2);

    }


    @And("users choose the item from structure article")
    public void usersChooseTheItemFromStructureArticle() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(companyStructurePage.recent).perform();
        BrowserUtils.sleep(2);
        companyStructurePage.recent.click();
        BrowserUtils.sleep(1);
        companyStructurePage.getRecent.click();
    }

    @And("verify that user see  and click the select from structure article")
    public void verifyThatUserSeeAndClickTheSelectFromStructureArticle() {
        Assert.assertTrue(companyStructurePage.structureArticle.isDisplayed());
        BrowserUtils.sleep(2);
        Actions acts = new Actions(Driver.getDriver());
        acts.moveToElement(companyStructurePage.structureArticle).perform();
        companyStructurePage.structureArticle.click();
        BrowserUtils.sleep(2);

    }
}
