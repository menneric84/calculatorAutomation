Feature: Calculator

  Background: Calculator is up

  Scenario Outline: Add a few numbers
    Given I want to add "<numberOne>" to "<numberTwo>"
    When I add
    Then my answer should equal "<result>"

    Examples:
      | numberOne | numberTwo | result        |
      | 7         | 3         | Display is 10 |
      | 4         | 6         | Display is 10 |
      | 1         | 1         | Display is 2  |
      | 3         | 2         | Display is 5  |

  Scenario Outline: Subtract a few numbers
    Given I want to subtract "<numberOne>" from "<numberTwo>"
    When I subtract
    Then my answer should equal "<result>"

    Examples:
      | numberOne | numberTwo | result        |
      | 7         | 3         | Display is 4  |
      | 4         | 6         | Display is -2 |
      | 8         | 2         | Display is 6  |

