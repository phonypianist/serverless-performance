Feature: search-python

  Background:
    * url BASE_URL

  Scenario: search-python
   Given path 'search-python/' + LIST_SIZE
    When method get
    Then status 200
       * print response

