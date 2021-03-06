@FSW-2
Feature: Home page feature
  As a user
  I would like order a food online
  So that I want to use the food store website

  @TC_FS_001
  @author:sushil
  @smoke
  Scenario: Verify customer should be able to search hotel using search field
    Given Website is up and running
    And Search functionality is implemented
    When User enter a city name in search field
    And User click on Search button
    Then User should see list of hotels

  @TC_FS_002
  @author:sushil
  Scenario: Verify customer should be able to search hotel by pressing ENTER key
    Given Website is up and running
    And Search functionality is implemented
    When User enter a city name in search field
    And User press keyboard ENTER key
    Then User should see list of hotels


