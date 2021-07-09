Feature: My first feature
  we are waiting for this feature from long time

  Scenario: Verify my first scenario
    Given I have a pre-condition
    When I perform some action
    Then I should some result

  Scenario Outline: eating
    Given there are <start> cucumbers
    When I eat <eat> cucumbers
    Then I should have <left> cucumbers

    Examples:
      | start | eat | left |
      | 12    | 5   | 7    |
      | 20    | 2   | 18   |
      | 30    | 2   | 28   |

  Scenario Outline: My dummy scenario
    Given I have a session today
    When I start session link <link>
    And I join the session
    Then I should see session is started successfully

    Examples:
      | link        |
      | pqr-xyz-myk |
      | mqr-xyz-zzz |

  Scenario: Verify search functionality
    Given website is up and running
    When I open a website in browser
    And I enter a city name as "Mumbai"
    When I hit enter key from keyboard
    Then I should see list of hotels for "Mumbai"










