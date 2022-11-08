Feature: Login function


  # You can use this step (Given...) as Background in your individual feature file.
  # Just copy-paste it. If you want to run your scenarios against different user type,
  # it will be enough to change only parameterize word. But be sure you use exactly same word between the parentheses.
  Scenario: Users should be able to login with valid credentials ( hr - helpdesk - marketing )
    Given users should login with valid credentials as "marketing"