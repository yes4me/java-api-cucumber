Feature: Test the weather
  Documentation: http://openweathermap.org/current

  Scenario Outline: [Test#3.1] Test the weather HTTP Status
    Given user connects to the weather API using the parameters:
      | APPID | <api_key> |
      | q     | <city>    |
    Then check for HTTP status "<status>"

    Examples:
      | city   | api_key   | status | http_definitions |
      | London | [API_KEY] | 200    | ok               |
      | London |           | 401    | Unauthorized     |
      | London | abc       | 401    | Unauthorized     |
      |        | [API_KEY] | 502    | Bad Gateway      |

  Scenario Outline: [Test#3.2] Test the weather API output coordinates
    Given user connects to the weather API using the parameters:
      | APPID | [API_KEY] |
      | q     | London    |
    And user use the following JSON path: "<path>"
    Then check for output "<result>"

    Examples:
      | path                   | result     |
      | coord.lat              | 51.51      |
      | coord.lon              | -0.13      |
      #| weather[0].description | light rain | ==> get the info from the DB

  Scenario Outline: [Test#3.3] Test the weather API output location
    Given user connects to the weather API using the parameters:
      | APPID | [API_KEY] |
      | lat   | 51.51     |
      | lon   | -0.13     |
    And user use the following JSON path: "<path>"
    Then check for output "<result>"

    Examples:
      | path | result |
      | name | London |
