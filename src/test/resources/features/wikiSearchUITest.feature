Feature: Wiki search functionality test case
  @wiki
  Scenario: User searches a word then assort it
    Given User navigates to "url"
    When User searches "BaNaNa" in search box
    And User asserts searched "banana" is shown