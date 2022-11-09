Feature: As a user, I should be able to send messages by clicking on Message tab under Active Stream.

  Background: User is already logged in.
    Given users should login with valid credentials as "helpdesk"

    Scenario: User should be able to send a message by filling in the mandatory fields.
      When User clicks MESSAGE module
      And User writes message into Message box
      Then User clicks SEND button
