Feature: Test the Cucumber page
  Test if cucumber works in a Java framework
  If this doesn't work, edit the configuration, and glue to "step_definitions"

  @Test
  Scenario: [Test#1.1] Testing cucumber (Java)
    Given user tests classic expression (using "Java")
    And user enters the following info (classic way)
      | username | thomas |
      | password | nguyen |
    And user enters the email address as "thomas_ejob"

  Scenario: [Test#1.2] Testing cucumber (Java)
    Given user tests classic expression (using "Java")
