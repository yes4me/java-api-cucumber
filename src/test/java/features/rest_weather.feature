@weather
Feature: Test the free weather Rest server
  Documentation: http://openweathermap.org/current

  Scenario Outline: [Test#3.1] Test the weather REST server HTTP Status
    Given user connects to the weather REST server using the parameters:
      | APPID | <api_key> |
      | q     | <city>    |
    Then checks HTTP status "<status>" (weather REST server)

    Examples:
      | city   | api_key   | status | http_definitions |
      | London | [API_KEY] | 200    | ok               |
      | London |           | 401    | Unauthorized     |
      | London | abc       | 401    | Unauthorized     |
      |        | [API_KEY] | 502    | Bad Gateway      |

  Scenario Outline: [Test#3.2] Test the weather REST server coordinates
    Given user connects to the weather REST server using the parameters:
      | APPID | [API_KEY] |
      | q     | London    |
    Then checks JSON "<path>" to be "<result>" (weather REST server)

    Examples:
      | path      | result |
      | coord.lat | 51.51  |
      | coord.lon | -0.13  |
      #| weather[0].description | light rain | ==> get the info from the DB

  Scenario Outline: [Test#3.3] Test the weather REST server location
    Given user connects to the weather REST server using the parameters:
      | APPID | [API_KEY] |
      | lat   | 51.51     |
      | lon   | -0.13     |
    Then checks JSON "<path>" to be "<result>" (weather REST server)

    Examples:
      | path | result |
      | name | London |

  Scenario Outline: [Test#3.4] Test the weather REST server response time
    Given user connects to the weather REST server using the parameters:
      | APPID | <api_key> |
      | q     | <city>    |
    Then checks response time to be less than "<time>" ms (weather REST server)

    Examples:
      | city   | time |
      | London | 1500 |
      | Paris  | 500  |
