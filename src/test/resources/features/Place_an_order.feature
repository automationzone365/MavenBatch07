@Regression
Feature: Place an order
  Scenario Outline: Placing an order for a product
    Given I'm a user on the Demo web shop home page
      |planittest78@gmail.com|123456|
    When I add a product "<Product_name>" with quantity "<Quantity>" to the cart
    Then I should see "<Success_msg>"
    And I'm on the checkout page
    When I provide billing details
      | firstname | lastname | email               | company     | country   | city      | Address1     | Address2     | zip   | Phone      |
      | demo      | user1    | demouser1@gmail.com | democompany | Australia | Hyderabad | TestAddress1 | TestAddress2 | 52345 | 8554534344 |


    Examples:
      | Product_name                      | Quantity | Success_msg                                      |
      | Build your own expensive computer | 2        | The product has been added to your shopping cart|
