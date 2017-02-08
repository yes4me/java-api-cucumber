Feature: Test the REST server: httpbin.org
  1. Using any Util libraries of your choice (e.g. org.apache.http.client.HttpClient),
  - make a GET request to http://httpbin.org/user-agent
  - print the response body to the console.
  2. Make:
  - make a POST request with the following JSON body { “hello” : “world” } to http://httpbin.org/post
  - print the response body, HTTP status code, and all headers to the console.

  Scenario: [Test#5.1] Test the GET request of http://httpbin.org/user-agent
    Given user connects to the "http://httpbin.org/user-agent"
    Then check the HTTP status "200"
    And  print the response body

  Scenario: [Test#5.2] Test the POST request of http://httpbin.org/post
    Given user connects to "http://httpbin.org/post" using with body "{'hello':'world'}"
    Then check the HTTP status "200"
    And  print the response body
    And  print the response HTTP status code
    And  print the response headers
