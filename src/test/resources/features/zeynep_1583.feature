
Feature:  user, I should be able to add link, insert video, mention, quote, add tag in message.

    Background: User in the home page
    Given users should login with valid credentials as "hr"
    When user click Message field

    #1 ac User should be able to add mentions about only department employees.

  Scenario:User should be able to add mentions about only department employees

    And user click Mention button at the bottom of message area
    And user see and click  employee and department
    Then user dont see add new employee area




  #2. User should be able to attach link to specified text.
  Scenario: User should be able to attach link to specified text.
    And User click linkAttach button at the bottom of message area
    And user write "<text>" message
    And user write "<linkURL>"
    Then user click sendButton

  #3. User should be able to insert YouTube and Vimeo video.
  Scenario: User should be able to insert YouTube and Vimeo video.
    And User click insert video link
    And user write URL link of video
    And User verify not take any errorMessage after write URL
    Then user click saveButton



   #4. User should be able to add quotes
  Scenario Outline: User should be able to add quotes

    When User clicks Quote Text button
    When User enters a "<Quote>" in yellow quote ribbonn
    When User clicks Send button at Messages Tabb
    Then User sees the "<Quote>" in Activity Stream


    Examples: The quotes are as following
      | Quote                                                                       |
      | As you know, madness is like gravity...all it takes is a little push.'      |
      | Education is the most powerful weapon which you can use to change the world |



