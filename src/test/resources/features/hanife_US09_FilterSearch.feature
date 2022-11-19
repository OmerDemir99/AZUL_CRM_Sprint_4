Feature: Filter and Search Functionality
  US09:As a user, I should be able to use "Filter and search" functionality on Active Stream.

  Background: Login with valid credentials ( hr - helpdesk - marketing )
    Given users should login with valid credentials as "marketing"
    When user click the filter and search input box

    #@wip #ac1
  @AZUL-1625
    Scenario:User should be able to see default filters as "my activity, work, favorite, announcements, and workflows"
      Then user should see and verify below filters as default filters
        | WORK          |
        | FAVORITES     |
        | MY ACTIVITY   |
        | ANNOUNCEMENTS |
        | WORKFLOWS     |

 # @wip  #ac2, ac6
  Scenario:User should be able to add and remove fields and restore the default fields
    When user click restore default filter link
    And user see default selected fields and nonselected fields
    When user click add field linktext
    When user click and select nonselected fields
    Then user verify adding new fields
    When user click selected fields
    Then user verify removing fields
    And user click an empty area
    When user click restore default filter link
    Then user see default selected fields and nonselected fields

  #@wip #ac2, ac6
  Scenario:User should be able to  restore the default fields by removing fields
    When user click restore default filter link
    When user click add field linktext
    When user click and select nonselected fields
    And user verify adding new fields
    And user clicks the x sign near the fields input boxes
    Then user see default selected fields and nonselected fields

   #@wip   #ac3
   Scenario:User should be able to search by specifying the Date,
     And user click the date inbox,user choose a date
     And user click search button
     Then user verify searching by specifying Date

    # @wip   #ac3
  Scenario:User should be able to search by specifying the Exact Date
    When user click the date inbox,user choose exact date
    And user click the calendar box and click a specific date
    And user click search button
    Then user verify searching by specifying Date

  #@wip   #ac3
  Scenario:User should be able to search by typing the exact date
    When user click the date inbox,user choose exact date
    And user click the calendar box and type a "11/15/2022"
    And user click search button
    Then user verify searching by specifying Date


  #@wip #ac4
  Scenario:User should be able to search by selecting single or multiple types,
    When user click the types inbox, user choose a type
    And user click search button
    Then user verify searching by specifying single type


  #@wip #ac4
  Scenario:User should be able to search by selecting single or multiple types,
    When user click the types inbox, user choose multiple types
    And user click search button
    Then user verify searching by selecting multiple types



  # @wip #ac5
  Scenario:User should be able to save the filter.
    When user click the save filter text
    And user click filter name inbox
    And user types "GOOD NEWS" as new filter
    And user click save button
    Then user verify saving new filter


  #@wip #ac7
  Scenario:User should be able to reset filters to default.
    When user click the save filter text
    And user click the reset to default link
    And user click continue button
    Then user verify to reset filters to default





