Feature: Product Search on Amazon
  Scenario: Search returns non-empty results
    Given I open the amazon home page
    When I search for cards
    Then I should see non-empty product names and prices and counts match
