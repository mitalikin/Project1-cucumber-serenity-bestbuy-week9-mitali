Feature: As a user I would like to Test different request on the bestbuy product endpoint

  Scenario: I read all products data from application
    Given I am on homepage of products endpoint
    When I send GET request to the product endpoint
    Then I must get valid response code 200

    Scenario Outline:create a new product & verify if product is added
      When  I create a new product by providing information name"<name>"type"<type>"price"<price>"shipping"<shipping>"upc"<upc>"description"<description>"manufacturer"<manufacturer>"model"<model>"url"<url>"image"<image>"
      Then I verify that the product is created with "<productID>"


      Examples:
        |name  |type|price|shipping|upc|description|manufacturer|model|url|image|productID|
        |Duracell  |Hardgood|6|26|0123456889|Compatible with select electronic devices; AAA size; DURALOCK Power Preserve technology; 4-pack|Duracell|MN2400B4Z|//www.bestbuy.com/site/duracell-aaa-batteries-4-pack/43900.p?id=1051384074145&skuId=43900&cmp=RMXCC|http://img.bbystatic.com/BestBuy_US/images/products/4390/43900_sa.jpg||

