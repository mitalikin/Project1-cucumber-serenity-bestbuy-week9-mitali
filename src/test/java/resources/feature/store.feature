#Feature: As a user I would like to Test different request on the bestbuy store endpoint
#
#  Scenario: Check if the store information can be accessed by users
#    When User sends a Get request to store endpoint
#    Then User must get back a valid status code 200
#
#  Scenario Outline: Create a new product & verify if the product is added
#    When I create a new store by providing information name "<name>" type "<type>"address "<address>" address2 "<address2>" city "<city>" state "<state>" zip "<zip>" lat"<lat>" lng "<lng>"hours"<hours>"
#    Then I verify that the product with "<productID>" is created
#
#
#    Examples:
#      | name      | type   | address            | address2 | city      | state | zip   | lat       | lng        | hours                                                                         |
#      | Maplewood | BigBox | 1795 County Rd D E |          | Maplewood | MN    | 55109 | 45.036556 | -93.025986 | Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8 |
#
