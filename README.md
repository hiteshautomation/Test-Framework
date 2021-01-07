# Automation Assignment

An automation framework for automation tests/scripts catering the following acceptance criteria


# What is this repository for?

This repo is used to maintain the assignment Automation Framework.

# Background:

Cucumber feature has been designed to cater the acceptance criteria for both user stories with cucumber tags features.For instance, scenarios have been tagged 
with smoke and prod tags to achieve environment or test phase specific execution. Scenarios in feature file also have been designed in a such way that both scearnio will run
in sequence on both chrome and firefox browers.

# Acceptance criteria

# Test User Story 1

Priority: Major
As a Product Owner

- I want that while using the KiwiSaver Retirement Calculator all fields in the calculator have got the information icon present so that the user is able to get a clear
understanding of what needs to be entered in the field.

# Test User Story 2
Priority: Major

As a Product Owner

I want that the KiwiSaver Retirement Calculator users are able to calculate what their KiwiSaver projected balance would be at retirement so that the users are able to 
plan their investments better.

Acceptance Criteria

- User whose Current age is 30 is Employed @ a Salary 82000 p/a, contributes to KiwiSaver @ 4% and chooses a Defensive risk profile can calculate his projected balances at retirement.

- User whose current aged 45 is Self-employed, current KiwiSaver balance is $100000, voluntary contributes $90 fortnightly and chooses Conservative risk profile with saving goals requirement of $290000 can calculate his projected balances at retirement.

- User whose current aged 55 is not employed, current KiwiSaver balance is $140000, voluntary contributes $10 annually and chooses Balanced risk profile with saving goals requirement of $200000 is able to calculate his projected balances at retirement.

# Built with

Java, Maven, Cucumber, Extent Report, TestNG, log4j,Eclipse,Jenkins

# Prerequisites

- Since test scripts are created in apache maven project, so maven should be installed and configured in local system on which the tests are going to be executed.
- TestNG framework should be configured in Eclipse
- Cucumber should be configured in Eclipse

# Logging

Log4j API is used to capture the logs such as selenium or any other logs. 

# Versioning and central repository

GitHub is used as central repository and for versioning.

# Script Execution:

Scenarios enlisted in feature file can be run with the following two approaches:

***Approach 1- On Local System:***

Navigate to project root directory (where pom.xml is located) and run **mvn clean install -Dcucumber.filter.tags="@smoke and @prod** to run a cucumber scenarios tagged with “smoke” and “prod”. 

**OR**

Navigate to **src/test/resources/runner/testng.xml**, right click on it and choose Run as-->TestNG Suite

***Approach 2 - CI/CD integration- Jenkins:***

The execution has also been achieved through CI/CD jobs as well with an implementation of polling mechanism integrated with git commits/push. 
As soon as there is a commit/or push to git repository,the job will run automatically with out any interference.


# Reporting 

- Extent Reporting framework is used to create interactive and detailed reports for the tests.Once the scripts are executed, refresh the project either in eclipse or directory level and navigate to ***report*** folder and expand. Right click the report and open in “web browser” to view the execution results in graphical report. 
Reports for both browsers with execution date and timings have been generated.

- On Jenkins server, link with the name of ***Smoke Execution Report*** will be generated once the job is over to view the execution status.

# Download a Framework

[Repository link](https://github.com/hiteshautomation/Test-Framework.git).

# Framework Architecture

- src/test/resources/Feature_KSRetirementCalculator - all the cucumber features files (files .feature ext) goes here.
- src/test/java/com/cucumber/stepDef - all step defintions under this package for feature steps.
- src/test/java/com/cucumber/runner - runner class is placed under this to run scripts on local system
- src/main/java/com/cucumber/baseSteps/steps - contains a base class (to set up framework or initilize web driver) and to be inherited by other classes.
- src/main/java/com/cucumber/extent- Contains classes in relation with extent reporting
- src/main/java/com/cucumber/page- contains classses specific to related pages with related locators and methods.
- src/main/java/com/cucumber/utils- contains utility classes in lieu of generic wrapper methods
- src/main/resouces/runner- contains testng.xml to configure test case execution enviornment
- src/test/resources/logs- contains text file to gather logs
- src/test/resources/properties- contains properties to define framework properties such as app url
- com.cucumber.assignment/reports- contains test execution extent report

# References: Execution videos for both approaches have shared on email.

# Author
Hitesh Ghai 

