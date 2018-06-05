Feature: the user can manage his profile data
  Scenario: the user can log in and see his profile
    When the user has valid credentials
    And the user logs in
    Then the user can query his profile
   Scenario: the user can edit his profile
     When the user has valid credentials
     And the user logs in
     And the user has queried his profile
     Then the user can edit his profile
     And see the changes