Feature: API Testing with cucumber rest assured on https://reqres.in/
  Scenario: verify get request single user
    Given set GET request for end point "api/users/2"
    When send GET request
    Then response code should be 200
    And response should contain "janet.weaver@reqres.in"

  Scenario: Verify POST request new user
    Given set POST request for endpoint "api/users"
    And request body :
    """
    {
    "name": "morpheus",
    "job": "leader"
    }
    """
    When  send Post request
    Then response code should be 201
    And response should contain "morpheus"