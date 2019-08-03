Feature: search-python

  Background:
    * url BASE_URL_PLUS

  Scenario: search-python
   Given path 'search-python-np/' + LIST_SIZE
    When method get
    Then status 200
       * print response

