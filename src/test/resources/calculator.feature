Feature: Calculator

  Scenario Outline: Add a few numbers
    Given I want to add "<numberOne>" to "<numberTwo>"
    When I add
    Then my answer should equal "<result>"

    Examples:
      | numberOne | numberTwo | result        |
      | 7         | 3         | Display is 10 |
      | 14        | 6         | Display is 20 |