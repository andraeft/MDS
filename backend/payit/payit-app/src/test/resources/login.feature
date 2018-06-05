Feature: the user can login
  Scenario: the client can login when the client has valid credentials
    When the client has credentials
    And the client calls log in
    Then the response code is 200
    And the cookie is set
  Scenario: the client fails to log in with invalid credentials
    When the client has invalid credentials
    And the client calls log in
    Then the response code is 401