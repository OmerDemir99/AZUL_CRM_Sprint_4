Feature: Task assign function in quick navigate menu.
  AZUL-1586-US06: As a user, I should be able to assign tasks under Quick Navigate Menu.

  Background: Users should be able to login with valid credentials (hr)
    Given users should login with valid credentials as "hr"
    When click TASK in the quick navigation menu

    #PASS
  #ac1 - Mandatory fields: Task name, Responsible person
  Scenario: HR User should be able to create a "High priority" tasks with the mandatory fields.
    And clicks task name field and write
    And ticks the high priority box
    And go to responsible person field remove the default value if any and add user
    And click send button
    Then verify that the task was created with high priority

    #PASS
  #ac1/NEGATİVE - Error message:  "The task name is not specified."
  Scenario: HR user should get the error message if she forgets to type the task name.
    And ticks the high priority box
    And go to responsible person field remove the default value if any and add user
    And click send button
    Then verify that you see error message


  #ac2 PASS
  Scenario: HR User should be able to assign a task to more than one user (Test with adding 3 users max.)
    And clicks task name field and write
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
    And clicks task name field and write
    And go to responsible person field remove the default value if any
    And click send button
    Then verify that you see responsible person error message


  @AZUL1586
  #ac3 #PASS
  Scenario: When task(s) is(are) created, they can be seen on the count on the homepage under "MY TASKS" table.
    And check the number of tasks
    And clicks task name field and write
    And go to responsible person field remove the default value if any and add user
    And click send button
    Then verify that the created task is in MY TASKS table


  #ac4 PASS
  Scenario: Checklist should be able to be added while creating a task.
    And clicks task name field and write
    And go to responsible person field remove the default value if any and add user
    And click on checklist and write something in the things to do
    And click on checkmark or add
    And click send button
    Then verify that checklist has been added


    #ac5 PASS
  Scenario: Deadline should be able to be added while creating a task.
    And clicks task name field and write
    And go to responsible person field remove the default value if any and add user
    And click on the deadline input
    And set valid day, month, year
    And set time using arrows
    And click the select button
    And click send button
    Then verify that the deadline is added while creating the task



  #ac6 PASS
  Scenario: Time planning function should be able to be used in the setting of deadline.
    And clicks task name field and write
    And go to responsible person field remove the default value if any and add user
    And click time planning button
    And set task start and finish time
    And click send button
    Then verify that time planning was added while creating the task


  #ac6 PASS
  Scenario Outline: Time planning function should be able to be used in the setting of deadline.
    And clicks task name field and write
    And go to responsible person field remove the default value if any and add user
    And click time planning button
    And set task start time
    And set the duration "<duration>" "<time>"
    Then verify that day, hour, minute can be changed as set duration
    Examples:
      | duration | time    |
      | 10       | days    |
      | 10       | hours   |
      | 10       | minutes |



