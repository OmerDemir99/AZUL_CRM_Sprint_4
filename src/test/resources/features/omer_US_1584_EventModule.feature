
  Feature: "Event" module on the Home page
    AZUL-1584 (US04): As a user, I should be able to create events
                      by clicking on Event tab under Activity Stream.

    Background: Login
      Given users should login with valid credentials as "hr"


      Scenario: Event module
        Then users click event button