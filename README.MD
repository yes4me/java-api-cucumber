# API Test Framework

## Preface
---

* Purpose: API testing on Windows
* Author: Thomas Nguyen
* Date started: 2017/02/02

## Table of contents
---

This document will show you how to:

0. [Introduction](#Introduction)
1. [Prerequisites](#Prerequisites)
2. [Overview of packages](#Overview-of-packages)
3. [Setup](#Setup)
4. [Running the program](#Running-the-program)
5. [Uninstall](#Uninstall)
6. [Known bugs](#Known-bugs)
7. [Other notes](#Other-notes)
8. [Lexicon](#Lexicon)
9. [Sources](#Sources)

## Introduction
---

Hello,

Thank you for having a look at my API framework written in Java. You can download the latest code at my [repository](https://github.com/yes4me). Feel free to comment. Nobody can improve without feedback. Thank you in advance. 

Sincerely,

Thomas Nguyen, thomas.ejob@gmail.com
https://www.linkedin.com/in/thomasquang
Personal projects code: https://github.com/yes4me

## Prerequisites
---

* Windows 8.1

## Overview of packages (defined in pom.xml)
---

1. Plugins: do not trigger any compilation
    * maven-compiler-plugin: to compile the sources of the project
    * maven-surefire-plugin: to generate reports in txt and xml formats
    * [WIP] cucumber-reporting: to generate reports in pretty graphics
2. Dependencies: JAR files added to the classpath while compiling
    * cucumber-java: to run Cucumber
    * cucumber-java8: to use lambda expression, which simplify writing code  
    * cucumber-TestNG: to run TestNG tests on cucumber
    * TestNG: to run TestNG tests on the browser
    * rest-assured: to test and validate REST services
    * json-path: to read JSON documents
    * json-schema-validator: to validate JSON documents
3. Optional Dependencies:
    * log4j-core and log4j-api: to generate log files

## Setup
---

1. Java SDK
    * install [Java SDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html) 
    * Search for "Edit the System Environment Variables"":
        * System Variables/JAVA_HOME **is** "C:\Program Files\Java\jdk1.8.0_45"
        * System Variables/PATH **contains** "%JAVA_HOME%\bin"
    * Console command: `java -version`
    * Result: Display on the console 'java version "1.8.0_45"'
2. install Intellij IDEA
    * Plugins: Cucumber for Java
    * Build, Execution, Deployment > Compiler > Java Compiler: Target bytecode version = 1.8
3. get the source code
    * install the package: git
    * `git clone <url>`
4. Download and install the [Binary zip archive](https://maven.apache.org/download.cgi) of maven apache
    * Search for "Edit the System Environment Variables"":
        * System Variables/MAVEN_HOME **is** "C:\Program Files\apache-maven-3.3.9"
        * System Variables/PATH **contains** "%MAVEN_HOME%\bin"
    * Console command: `mvn -version`
    * Result: Display on the console 'Apache Maven 3.3.9 ...'
5. Create the file: src\main\java\com\thomas\config\config.properties
    API_URL_WEATHER=http://api.openweathermap.org/data/2.5/weather
    API_KEY_WEATHER=[insert your key]

## Running the program
---

1. Run Java code: src\main\java\com\thomas\HelloWorld.java
2. Run src\test\java\features\test_cucumber from IntelliJ
3. Run src\test\java\features\test_cucumber8 from IntelliJ
4. Run src\test\java\tmp_tests\WeatherRestTest from IntelliJ
5. Run src\test\java\features\rest_weather from IntelliJ

## Uninstall
---

* Uninstall IntelliJ
* delete the source folder

## Known bugs
---

Error messages:

* Load error: undefined path variables. MAVEN_REPOSITORY is undefined => You opened the project using WebStorm instead of IntelliJ 

## Other notes
---

Shortcuts for Intellij IDEA:

1. General
    * CTRL + / = comment
2. Features:
    * Alt + Return = create step definition for the selected feature
    * CTRL + left click = Read the corresponding step definition
    * CTRL + Alt + L = fix indentations
3. Classes:
    * ALT + Insert = auto generate codes (ex: constructor)

src/main/resources/log4g2.xml for saving the log into a file named after the current time:

```
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="WARN">
<Properties>
    <Property name="logPath">logs</Property>
</Properties>
<Appenders>
    <Console name="Console" target="SYSTEM_OUT">
        <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
    </Console>
    <RollingFile name="fileLogger" fileName="${logPath}/myLog.log" filePattern="${logPath}/myLog.log">
        <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        <Policies>
            <OnStartupTriggeringPolicy/>
        </Policies>
    </RollingFile>
</Appenders>
<Loggers>
    <Root level="trace">
        <AppenderRef ref="Console"/>
        <AppenderRef ref="fileLogger"/>
    </Root>
</Loggers>
</Configuration>
```

## Lexicon
---

## Sources
---

* Download:

    * [git](https://git-scm.com/)
    * [Java Development Kit (JDK)/Java SE](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
    * [Official Selenium HQ Drivers](http://www.seleniumhq.org/download/)
    * [Maven repository](https://mvnrepository.com/)
    * [TestNG](http://TestNG.org/doc/download.html)

* References:

    * [Java: Automate WebServices Rest API (testing) using Java](https://www.udemy.com/automate-webservices-rest-api-testing-using-java/learn/v4/content)

* Others:

    * [Java SE 8 API Documentation](https://docs.oracle.com/javase/8/docs/api/)
    * [JSON viewer](http://www.jsoneditoronline.org/)
    * [Regex](https://regex101.com/)
