Feature: search-js

  Background:
    * url BASE_URL

  Scenario: search-js
   Given path 'search-js/' + LIST_SIZE
    When method get
    Then status 200
       * print response

