@jsonserver
Feature: Test the JSON server
  Steps:
  - install NodeJs
  - install json-server: npm install -g json-server
  - Command line: go to src/test/java/data/
  - Command line: json-server --watch db.json
  - Then you can run the following tests
  Documentation: https://github.com/typicode/json-server

  Scenario Outline: [Test#4.1] Test INSERT on JSON REST server
    Given user sets the Employee variables:
      | ID     | <id>     |
      | name   | <name>   |
      | salary | <salary> |
    When user inserts to the JSON REST server
    Then check for HTTP status "<status>"

    Examples:
      | id | name  | salary   | status | http_definitions                   |
      | 1  | name1 | $100,000 | 201    | Created                            |
      | 2  | name2 |          | 201    | Created                            |
      | 3  |       | $300,000 | 201    | Created                            |
      | 3  | name3 | $300,000 | 500    | Error: Insert failed; duplicate id |

  Scenario Outline: [Test#4.2] Test UPDATE on JSON REST server
    Given user sets the Employee variables:
      | ID     | <id>     |
      | name   | <name>   |
      | salary | <salary> |
    When user updates to the JSON REST server on position "<id>"
    Then check for HTTP status "<status>"

    Examples:
      | id | name   | salary   | status | http_definitions |
      | 1  | Thomas | $123,456 | 200    | Ok               |
      | 4  | XXX    | YYY      | 404    | Not found        |

  Scenario Outline: [Test#4.3] Test PATCH on JSON REST server
    Given user patches to the JSON REST server on position "<id>" using "<data>"
    Then check for HTTP status "<status>"

    Examples:
      | id | data            | status | http_definitions                |
      | 1  | {'name':'XXX'}  | 200    | Ok                              |
      | 1  | {'name2':'XXX'} | 200    | Ok                              |
      | 1  |                 | 200    | Ok                              |
      | 4  |                 | 404    | Not found                       |
      | 1  | {'name'='XXX'}  | 500    | SyntaxError: Unexpected token = |

  Scenario Outline: [Test#4.4] Test DELETE on JSON REST server
    Given user deletes data "<id>" to the JSON REST server
    Then check for HTTP status "<status>"

    Examples:
      | id | status | http_definitions |
      | 1  | 200    | Ok               |
      | 2  | 200    | Ok               |
      | 3  | 200    | Ok               |
      | 1  | 404    | Not found        |
