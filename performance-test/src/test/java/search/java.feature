Feature: search-java

  Background:
    * url BASE_URL

  Scenario: search-java
   Given path 'search-java/' + LIST_SIZE
    When method get
    Then status 200
       * print response

