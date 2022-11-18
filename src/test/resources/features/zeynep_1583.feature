
Feature:  user, I should be able to add link, insert video, mention, quote, add tag in message.

  Background: User in the home page
    Given users should login with valid credentials as "hr"
    When user click Message field

    #1 ac User should be able to add mentions about only department employees.

  Scenario:User should be able to add mentions about only department employees

    And user click Mention button at the bottom of message area
    And user see and click  employee and department
    Then user dont see add new employee area


  @wip22

  #2. User should be able to attach link to specified text.
  Scenario: User should be able to attach link to specified text.
    And User click linkAttach button at the bottom of message area
    And user write "<text>" message
    And user write "<linkURL>"
    Then user click sendButton

  #3. User should be able to insert YouTube and Vimeo video.
  #4. User should be able to add quotes.
  #5. User should be able to add tags in message.
  #6. User should be able to remove tags before sending the message