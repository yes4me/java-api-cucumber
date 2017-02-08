@ebates
Feature: Test the REST server: httpbin.org
  1. Using the HttpClient and any Util libraries of your choice (e.g. org.apache.http.client.HttpClient),
  - make a GET request to http://httpbin.org/user-agent
  - print the response body to the console.
  2. Make:
  - a POST request with the following JSON body { “hello” : “world” } to http://httpbin.org/post
  - print the response body, status code and all headers to the console.

  Scenario: [Test#5.1] Test the GET request of httpbin.org
    Given user connects to the "http://httpbin.org/user-agent"
    Then print the response

  Scenario: [Test#5.2] Test the POST request of httpbin.org
    Given user connects to "http://httpbin.org/user-agent" using with body "{\\“hello\\”:\\“world\\”}"
    Then print the response
