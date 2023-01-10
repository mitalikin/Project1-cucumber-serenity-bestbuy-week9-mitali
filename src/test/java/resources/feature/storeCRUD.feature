#Feature: Product Information
#
#  As a user I want to test product Information
#
#  Scenario Outline: CRUD Test
#    Given Store Information is running
#    When  I create a new store by providing information name "<name>" type "<type>"address "<address>" address2 "<address2>" city "<city>" state "<state>" zip "<zip>" lat"<lat>" lng "<lng>"hours"<hours>"
#    Then I verify that the store is created with "<storeID>"
#    And I update the store with information storeID "<storeID>" "<name>" type "<type>"address "<address>" address2 "<address2>" city "<city>" state "<state>" zip "<zip>" lat"<lat>" lng "<lng>"hours"<hours>"
#    And The store with storeID "<storeID>" is updated successfully
#    And I delete the store that created with storeID "<storeID>"
#    Then The store deleted successfully from the store information
#    Examples:
#      | name      | type   | address            | address2 | city      | state | zip   | lat       | lng        | hours                                                                         | storeID |
#      | Maplewood | BigBox | 1795 County Rd D E |          | Maplewood | MN    | 55109 | 45.036556 | -93.025986 | Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8 |         |
#
