Feature: Add to Cart Feature

  Scenario: Search for a product and add to cart verify results
    Given I open the amazon home page
    When I search for cards
    Then I should see non-empty product names and prices and counts match
    When I open the first product from results
    Then The cart should contain that product