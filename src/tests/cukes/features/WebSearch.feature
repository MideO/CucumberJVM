Feature: Navigation to cucumber-jvm homepage

  Scenario Outline: User can navigate to cucumber-jvm homepage via different search enginve
    Given I navigate "<search page url>"
    When I search for "cucumber-jvm"
    And  I click on the first link containing "cucumber-jvm"
    Then I am redirected to the "cucumber-jvm" github page
    Examples:
      | search page url |
      | http://www.google.com      |
      | http://www.bing.com        |

