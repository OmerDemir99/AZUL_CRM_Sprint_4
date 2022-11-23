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


  Scenario Outline: (AC-1) User should be able to add Event start and ending date and time, select "All day" and specify the time zone
    When type the event start date "<date1>" and event end date "<date2>" different format with right order except the default format
    Then click send button
    And verify that dates turn into correct format automatically

    Examples: Different format but correct order
      | date1      | date2      |
      | 11.25.2022 | 11.26.2022 |
      | 11-28-2022 | 11-29-2022 |


  Scenario Outline: (AC-1) User should be able to add Event start and ending date and time, select "All day" and specify the time zone
    When type the event start "<date1>" and end date "<date2>" different format except the default format
    Then click send button
    And verify that user should not create event

    Examples: Different Format
      | date1      | date2      |
      | 26/11/2022 | 30/11/2022 |
      | 26.11.2022 | 30.11.2022 |


  Scenario Outline: (AC-1) User should be able to add Event start and ending date and time, select "All day" and specify the time zone
    When type different characters for event start date "<char1>" and for event end date "<char2>"
    Then click send button
    And verify that user should not create event

    Examples: Date
      | char1  | char2   |
      | 098746 | qwtyhbv |
      | "!'^&% | /()=?_  |
      | ,;.:@∑ | €®₺¥üi  |
      | öπ¨~ß∂ | ƒğ∆¬´`  |
      | <>Ω≈ç√ | ∫µ≤≥÷£  |
      | $½§{[] | }\  -ş  |
      |        |         |

  Scenario Outline: (AC-1) User should be able to add Event start and ending date and time, select "All day" and specify the time zone
    When type different characters for event start time "<char1>" and for event end time "<char2>"
    Then click send button
    And verify that user should not create event

    Examples: Time
      | char1  | char2   |
      | 098746 | qwtyhbv |
      | "!'^&% | /()=?_  |
      | ,;.:@∑ | €®₺¥üi  |
      | öπ¨~ß∂ | ƒğ∆¬´`  |
      | <>Ω≈ç√ | ∫µ≤≥÷£  |
      | $½§{[] | }\  -ş  |
      |        |         |

  Scenario: (AC-1) User should be able to add Event start and ending date and time, select "All day" and specify the time zone
    When for event end date select a date earlier than event start date
      | start date | 11/30/2022 |
      | end date   | 11/29/2022 |
    Then click send button
    And verify that user should not create event

  Scenario: (AC-1) User should be able to add Event start and ending date and time, select "All day" and specify the time zone
    When for event start date select a date earlier than current date
    Then click send button
    And verify that user should not create event

  Scenario: (AC-1) User should be able to add Event start and ending date and time, select "All day" and specify the time zone
    When select impossible event start date and end date
      | start date | 11/26/1700 |
      | end date   | 11/27/2300 |
    Then click send button
    And verify that user should not create event

  Scenario: (AC-1) User should be able to add Event start and ending date and time, select "All day" and specify the time zone
    When for event end time select a time earlier than event start time
    Then click send button
    And verify that user should not create event

  Scenario Outline: (AC-1) User should be able to add Event start and ending date and time, select "All day" and specify the time zone
    When click specify time zone button
    Then click time zone start button
    Then select appropriate time zone for beginning "<timeZoneStart>"
    Then click time zone end button
    Then select appropriate time zone for ending "<timeZoneEnd>"
    And verify that user should be able to select time zones correctly "<timeZoneStart>" and "<timeZoneEnd>"

    Examples: Time Zones
    |timeZoneStart|timeZoneEnd|
    |(UTC -11:00) Pacific/Midway|(UTC +14:00) Pacific/Kiritimati|
    |(UTC -04:00) America/Halifax|(UTC -04:00) Atlantic/Bermuda|
    |(UTC +01:00) Europe/Oslo|(UTC +01:00) Europe/Zurich|


  Scenario Outline: (AC-1) User should be able to add Event start and ending date and time, select "All day" and specify the time zone
    When click specify time zone button
    Then click time zone start button
    Then select appropriate time zone for beginning "<timeZoneStart>"
    Then click time zone end button
    Then select not appropriate time zone for ending "<timeZoneEnd>"
    And verify that user should be able to see information message of question mark
    Then click hide time zone button
    And verify that user should not be able to create event if the times don't match with the time zones
    Examples: Time Zones
      |timeZoneStart|timeZoneEnd|
      |(UTC +05:00) Asia/Aqtau|(UTC +02:00) Europe/Helsinki|
      |(UTC -01:00) Atlantic/Azores|(UTC -03:00) America/Fortaleza|


  Scenario: (AC-1) User should be able to add Event start and ending date and time, select "All day" and specify the time zone
    When verify that set reminder button is clickable
    Then verify that all options are selectable
    Then verify that reminder time is changeable by manually

  Scenario Outline: (AC-1) User should be able to add Event start and ending date and time, select "All day" and specify the time zone
    When create an event with inappropriate reminder "<options>"
    And verify that user should not be able to create event

    Examples: Reminder options
    |options|
    |-10|
    |Ten|
    | *!?%/* |
    |skfnskfnowr|
    |1500|







