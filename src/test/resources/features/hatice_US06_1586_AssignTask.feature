Feature: Task assign function in quick navigate menu.
  AZUL-1586-US06: As a user, I should be able to assign tasks under Quick Navigate Menu.

  Background: Users should be able to login with valid credentials (hr)
    Given users should login with valid credentials as "hr"

    #PASS
  #ac1 - Mandatory fields: Task name, Responsible person
  Scenario: HR User should be able to create a "High priority" tasks with the mandatory fields.
    When User clicks TASK menu
    And clicks task name field and write
    And ticks the high priority box
    And go to responsible person field remove the default value if any and add user
    Then click send button

    #PASS
  #ac1/NEGATİVE - Error message:  "The task name is not specified."
  Scenario: HR user should get the error message if she forgets to type the task name.
    When User clicks TASK menu
    And ticks the high priority box
    And go to responsible person field remove the default value if any and add user
    And click send button
    Then verify that you see error message


  #ac2 PASS
  Scenario: HR User should be able to assign a task to more than one user (Test with adding 3 users max.)
    When User clicks TASK menu
    And clicks task name field and write
    And ticks the high priority box
    And go to responsible person field remove the default value if any
    And click add more and add three users

      | hr91@cybertekschool.com        |
      | marketing84@cybertekschool.com |
      | helpdesk29@cybertekschool.com  |
    Then click send button
    Then see task created alert

  #PASS
  #ac2/NEGATİVE - Error message: "A user specified in the field "Responsible Person" was not found."
  Scenario: HR user should get an error message if the responsible person field is empty.
    When User clicks TASK menu
    And clicks task name field and write
    And ticks the high priority box
    And go to responsible person field remove the default value if any
    And click send button
    Then verify that you see responsible person error message



  #ac3
  Scenario: When task(s) is(are) created, they can be seen on the count on the homepage under "MY TASKS" table.
    When user sees the my tasks table on the homepage
    Then check and verify created task counts


  #ac4 PASS
  Scenario: Checklist should be able to be added while creating a task.
    When User clicks TASK menu
    And clicks task name field and write
    And ticks the high priority box
    And go to responsible person field remove the default value if any and add user
    And click on checklist and write something in the things to do
    And click on checkmark or add
    And click send button
    Then verify that checklist has been added


    #ac5 PASS
  Scenario: Deadline should be able to be added while creating a task.
    When User clicks TASK menu
    And clicks task name field and write
    And ticks the high priority box
    And go to responsible person field remove the default value if any and add user
    And click on the deadline input
    And set valid day, month, year
    And set time using arrows
    And click the select button
    Then click send button
    Then see task created alert

  @AZUL1586
    #ac5
  Scenario: Deadline should be able to be added while creating a task.
    When User clicks TASK menu
    And clicks task name field and write
    And ticks the high priority box
    And go to responsible person field remove the default value if any and add user
    And click on the deadline input
    And set valid day, month, year
    And set time by typing
    And click the select button
    Then click send button
    Then see task created alert
    Then make sure the deadline is correct








