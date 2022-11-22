Feature: AZUL-1592 As a user, I should be able to interact with employees on the posts

  Background: Login
    Given users should login with valid credentials as "hr"


  #AC1-TC1
  @AC1TC1 @kg
  Scenario:Users should be able to make a comment other employees' posts.
    When Users click the comment button on the post that employee posted
    And Users write a comment on the opening comment box
    And Users click the send button
    Then Users should be able to see the written comment on the post


  #AC1-TC2
  @AC1TC2 @kg
  Scenario:User should be able to like other employees' posts.
    When Users click the like button on the post that employee posted
    Then Users should be able to see the like icon


  #AC1-TC3
  @AC1TC3 @kg
  Scenario:User should be able to like other employees' posts.
    When Users mouse hover the like button on the post that employee posted
    And Users see the like emoji images
    And Users click the kiss emoji image
    Then Users should be able to see the kiss emoji icon is activated and is displayed on the page.


  #AC1-TC4
  @AC1TC4 @kg
  Scenario:User should be able to unfollow other employees' posts.
    When Users click the unfollow button on the post that employee posted
    Then Users should be able to see the post of whom he-she unfollowed is disappeared on the page


  @AC2TC1 @kg
  Scenario: User should be able to like other reviewers' comments.
    When Users click the like button under the comments posted by reviewers.
    Then Users should be able to see the like icon is being activated and displayed.


  @AC2TC2 @kg
  Scenario: User should be able to make comments on all other reviewers' comments.
    When Users click the reply button under the comments posted by reviewers.
    And Users write a reply comment under a comment on the opening box
    And Users click the send button
    Then Users should be able to see the written comment on the post

  @AC3TC1 @kg
  Scenario: User should be able to like his/her own comment.
    When Users click the like button under their own comment
    Then Users should be able to see the like icon next to their own comment is being displayed

  @AC3TC2
  Scenario: User should be able to replay his/her own comment.
    When Users click the reply button under his/her own comment
    And Users write a reply comment to their own comment by clicking reply button under their own comment
    And Users click the send button
    Then Users should be able to see the written comment on the post













