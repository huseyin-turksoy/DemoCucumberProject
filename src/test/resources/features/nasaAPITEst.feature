@regression
Feature: APItest_AssertGetRequest_200
  #Method_Scenario_ExpectedResult
  @api
  Scenario: User sends api call to end point and asserts response
    When User user sends get request to given "endPoint"
    When User asserts the response returns 200
