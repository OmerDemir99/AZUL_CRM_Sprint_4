
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


  @wip22
  #4. User should be able to add quotes.
  Scenario: User should be able to add quotes
    And User click add quotes
    And user write sentences in quotes
    And user click sendButton
    Then user verify adding new quotes



  #5. User should be able to add tags in message.
  #6. User should be able to remove tags before sending the message