Feature: Search the product on Dashboard and grab productName
	
  Scenario: Search product on SearchPage and Validate it on the Cart Page
    Given Open the Dashboard by navigating to amazon website
    When Search the iPhone on dashboard page 
    Then Grab the text of the iPhone from dashboard page
    And Click on the product
    Then Validate that product page opened or not
    And Click on add to cart button and click on cart button again
    Then Validate that Add to cart page opened or not
    And Grab the text of the iPhone from cart page
    Then Assert that text grabbed from dashboard page and cart page should be same
    

  