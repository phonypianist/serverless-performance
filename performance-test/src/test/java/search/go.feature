Feature: search-go

  Background:
    * url BASE_URL

  Scenario: search-go
   Given path 'search-go/' + LIST_SIZE
    When method get
    Then status 200
       * print response

