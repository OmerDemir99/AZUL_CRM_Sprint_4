Feature: Filter and Search Functionality
  US09:As a user, I should be able to use "Filter and search" functionality on Active Stream.

  Background: Login with valid credentials ( hr - helpdesk - marketing )
    Given users should login with valid credentials as "helpdesk"
    When user click the filter and search input box

   # @wip #ac1
    Scenario:User should be able to see default filters as "my activity, work, favorite, announcements, and workflows"
      Then user should see and verify below filters as default filters
        | WORK          |
        | FAVORITES     |
        | MY ACTIVITY   |
        | ANNOUNCEMENTS |
        | WORKFLOWS     |

  # @wip  #ac2, ac6
    Scenario:User should be able to add and remove fields and restore the default fields
      When user click add field linktext
      And user see default selected fields and nonselected fields
      When user click and select nonselected fields
      Then user verify adding new fields
      When user click selected fields
      Then user verify removing fields
      When user click restore default filter link
      Then user see default selected fields and nonselected fields

     @wip #ac2, ac6
      Scenario:User should be able to  restore the default fields by removing fields
        When user click add field linktext
        When user click and select nonselected fields
        And user clicks the x sign near the fields input boxes
        Then user see default selected fields and nonselected fields

      #ac3
    Scenario:User should be able to search by specifying the Date,





#    4. User should be able to search by selecting single or multiple types,
#    5. User should be able to save the filter.

#    7. User should be able to reset filters to default.