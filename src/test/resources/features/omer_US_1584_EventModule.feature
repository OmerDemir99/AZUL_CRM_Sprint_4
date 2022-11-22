Feature: "Event" module on the Home page
  AZUL-1584 (US04): As a user, I should be able to create events
  by clicking on Event tab under Activity Stream.

  Background: Login
    Given users should login with valid credentials as "helpdesk"
    When users click Event "EVENT" button


  Scenario: (AC-1) User should be able to add Event start and ending date and time, select "All day" and specify the time zone
    Then verify that the event start date is current date
    Then type the start date by using keyboard "11/25/2022"
    Then click left arrow to change the month
    Then click right arrow to change the month
    Then click selected month and verify that all months are in the correct order
    Then chose another month from the list "August"
    Then click selected year and chose another one


  Scenario: (AC-1) User should be able to add Event start and ending date and time, select "All day" and specify the time zone
    Then click selected year and type the year in the year input box manually "2024"
    Then chose the event start date from the calender "29"
    Then click and clear event start hour and type manually "22:00 am"
    Then click event start hour input box and increase and decrease the hour and minute by using arrows
    Then change the time period
    Then click event start hour input box and change the hour "13" by manually
    Then click event start minute input box and change the minute "20" by manually
    Then click set time button
    Then click event start hour input box and click close button
    And verify event start hour is selected correctly


  Scenario: (AC-1) User should be able to add Event start and ending date and time, select "All day" and specify the time zone
    Then verify that the event end date is current date
    Then type the end date by using keyboard "11/26/2022"
    Then click left arrow to change the month for end date
    Then click right arrow to change the month for end date
    Then click selected month and verify that all months are in the correct order
    Then chose another month from the list "May"
    Then click selected year and chose another one


  Scenario: (AC-1) User should be able to add Event start and ending date and time, select "All day" and specify the time zone
    Then click selected year and type the year in the year input box manually for end date "2025"
    Then chose the event end date from the calender "30"
    Then click and clear event end hour and type manually "04:20 pm"
    Then click event end hour input box and increase and decrease the hour and minute by using arrows
    Then change the time period for end date
    Then click event end hour input box and change the hour "17" by manually
    Then click event end minute input box and change the minute "45" by manually
    Then click set time button
    Then click event end hour input box and click close button
    And verify event end hour is selected correctly
    And click all day option and verify that the button is clickable

  Scenario: (AC-1) User should be able to add Event start and ending date and time, select "All day" and specify the time zone
    When type the event start date different format except the default format
    Then verify that user should not create event

  Scenario: (AC-1) User should be able to add Event start and ending date and time, select "All day" and specify the time zone
    When type the event end date different format except the default format
    Then verify that user should not create event

  Scenario: (AC-1) User should be able to add Event start and ending date and time, select "All day" and specify the time zone
    When type the event start and end date different format except the default format
    Then verify that user should not create event

  Scenario Outline: (AC-1) User should be able to add Event start and ending date and time, select "All day" and specify the time zone
    When type different characters for event start date "<char1>" and for end date "<char2>"
    Then verify that user should not create event

    Examples: Date
      | char1  | char2   |
      | 098746 | qwtyhbv |
      | "!'^&% | /()=?_  |
      | ,;.:@∑ | €®₺¥üi  |
      | öπ¨~ß∂ | ƒğ∆¬´`  |
      | <>Ω≈ç√ | ∫µ≤≥÷£  |
      | $½§{[] | }\  -ş  |

  Scenario Outline: (AC-1) User should be able to add Event start and ending date and time, select "All day" and specify the time zone
    When type different characters for event start date "<char1>" and for end date "<char2>"
    Then verify that user should not create event




