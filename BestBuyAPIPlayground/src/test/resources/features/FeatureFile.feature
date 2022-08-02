Feature: Get list of services

#@SERVICEAPI
Scenario: list of services
	Given url
	When http request for list of services
	Then http response for list of services
	

  #@SERVICEAPI
  Scenario: Create a service within Best Buy API Playground
  	Given url
    When http request for creation of service
    Then http response for creation of service

  #@PRODUCTAPI
  Scenario: the list of products within Best Buy API Playground
  	Given url
    When http request for list of products
    Then http response for list of products
    
 #@PRODUCTAPI
  Scenario: Create a product within Best Buy API Playground
  	Given url
    When http request for creation of product
    Then http response for creation of product
    
#@MULTIPLEPRODUCTSAPI
#Scenario Outline: Create multiple products within Best Buy API Playground
    #Given   I provide the new product information name <name> type <type> price < price> shipping < shipping> upc <upc> description <description> manufacturer <manufacturer> model <model> url <url> image <image>
    #When I send request for the new product creation
    #Then a new product is created within Best Buy API Playground
#
    #Examples: 
      #| name |type | price | shipping| upc | description | manufacturer | model | url | image |
#			| value |value| value | value | value | value | value | value | value | value |
 #| value |value| value | value | value | value | value | value | value | value |
 #| value |value| value | value | value | value | value | value | value | value |
 #
 
 