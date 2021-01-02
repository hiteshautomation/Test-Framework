@KiwiSaverCalculator
Feature: To check kiwi saver retirement calculator information icons and its message

  #Background: User is Logged In
  #Given I launch the website on "<browserName>"
  @smoke @regression @prod @dev
  Scenario Outline: To ensure the presence of information icon for all fields in Kiwi saver retirement calculator
  Given launch browser "<Browser>"
  Given I am on application home page
  When I check for the presence of "<navigationOption>" option
  When I hover over "<navigationOption>"
  And I check "KiwiSaver calculators" button is displayed
  And I click on "KiwiSaver calculators" button
  And I check  "Retirement calculator" page is opened
  And I check "Click here to get started." button is displayed
  And I click on "Click here to get started." button
  And I check "KiwiSaver Retirement calculator" page is opened
  Then I see information icon for all fields for KiwiSaver Retirement Calculator
  
  Examples:
  | Browser | navigationOption |
  | firefox  | KiwiSaver        |
  | Chrome  | KiwiSaver        |
  
  ##########################################################################################################################
  @smoke @regression @prod @dev
  Scenario Outline: To calculate the projected kiwi saver balance for retirement for different employment status
    Given launch browser "<Browser>"
    Given I am on application home page
    When I check for the presence of "<navigationOption>" option
    When I hover over "<navigationOption>"
    And I check "KiwiSaver calculators" button is displayed
    And I click on "KiwiSaver calculators" button
    And I check  "Retirement calculator" page is opened
    And I check "Click here to get started." button is displayed
    And I click on "Click here to get started." button
    And I check "KiwiSaver Retirement calculator" page is opened
    When I enter "<Employment Status>"and "<Current Age>" and "<Salary>" and "<Member Contribution Rate>" and "<Current KS Balance>" and "<Voluntary contribution>" and "<Frequency>" and "<Profile>" and "<Saving Goal amount>"
    And I click on view your kiwisaver retirement projections button
    Then I check the project balance at retirement

    Examples: 
      | Browser | navigationOption | Employment Status | Current Age | Salary | Member Contribution Rate | Current KS Balance | Voluntary contribution | Frequency   | Profile      | Saving Goal amount |
    	| firefox  | KiwiSaver        | Employed          |          30 |  82000 | 4%                       |                    |                        |             | Defensive    |                    |
     	| firefox  | KiwiSaver        | Self-employed     |          45 |        |                          |             100000 |                     90 | Fortnightly | Conservative |             290000 |
      | firefox  | KiwiSaver        | Not employed      |          55 |        |                          |             140000 |                     10 | Annually    | Balanced     |             200000 |
 			| Chrome   | KiwiSaver        | Employed          |          30 |  82000 | 4%                       |                    |                        |             | Defensive    |                    |
      | Chrome   | KiwiSaver        | Self-employed     |          45 |        |                          |             100000 |                     90 | Fortnightly | Conservative |             290000 |
      | Chrome   | KiwiSaver        | Not employed      |          55 |        |                          |             140000 |                     10 | Annually    | Balanced     |             200000 |