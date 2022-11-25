Feature: AZUL-1592 As a user, I should be able to interact with employees on the posts

  Background: Login
    Given users should login with valid credentials as "hr"

@smoke
  #AC1-TC1
  @AC1TC1 @kg @smoke
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
    Then Users should be able to see the reply comment on the post

  @AC3TC1 @kg
  Scenario: User should be able to like his/her own comment.
    When Users click the comment button on the post that employee posted
    And Users write a comment on the opening comment box
    And Users click the send button
    And Users see their written comment on the post
    When Users click the like button under their own comment
    Then Users should be able to see the like icon next to their own comment is being displayed

  @AC3TC2 @kg
  Scenario: User should be able to reply his/her own comment.
    When Users click the comment button on the post that employee posted
    And Users write a comment on the opening comment box
    And Users click the send button
    And Users see their written comment on the post
    And Users click the reply button under their own comment
    And Users write a reply comment to their own comment by clicking reply button under their own comment
    And Users click the send button
    Then Users should be able to see the own reply comment on the post

    @AC4TC1 @kg
    Scenario: After making a comment user should be able to "view comment", "copy link", "edit", "delete" and "create task"
    by clicking more
      When Users click the comment button on the post that employee posted
      And Users write a comment on the opening comment box
      And Users click the send button
      And Users see their written comment on the post
      And Users click the more button under their own comment
      And Users click the copy link button;
      And Users should be able to see the link is copied.

  @AC5TC1 @kg
  Scenario: User should be able to see the reviewers' names and visit their profiles by clicking on reviewers' name
    When Users click the username on the post
    And Users navigate to the profile page of the user
    Then Users should be able to see the name of the user on the page


  @AC6TC1 @kg
  Scenario: User should be able to add others' posts to favorites by clicking on the Star icon.
    When Users click the add favorites button on top right of the post
    And Users go to the their own profile page by clicking their username button on right top of the page
    And Users click My Profile button on the opening menu and navigate to profile page
    And Users navigate to Control Panel by clicking control panel button
    And Users click Settings button on Control Panel
    And Users click Bookmarks button on Settings Panel
    Then Users should be able to see the list of their own favorites that they added before



























