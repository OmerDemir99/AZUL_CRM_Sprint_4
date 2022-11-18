Feature: AZUL-1592 As a user, I should be able to interact with employees on the posts

  Background: Login
    Given users should login with valid credentials as "hr"

  #AC1-TC1
  @AC1TC1
  Scenario:Users should be able to make a comment other employees' posts.
    When Users click the comment button on the post that employee posted
    And Users write a comment on the opening comment box
    And Users click the send button
    Then Users should be able to see the written comment on the post

  #AC1-TC2

  Scenario:User should be able to like other employees' posts.
    When Users click the like button on the post that employee posted
    Then Users should be able to see the like icon

  #AC1-TC3

  Scenario:User should be able to like other employees' posts.
    When Users mouse hover the like button on the post that employee posted
    And Users see the like emoji images
    And Users click the kiss emoji image
    Then Users should be able to see the kiss emoji icon is activated and is displayed on the page.


  #AC1-TC4

  Scenario:User should be able to unfollow other employees' posts.
    When Users click the unfollow button on the post that employee posted
    Then Users should be able to see the post of whom he-she unfollowed is disappeared on the page










