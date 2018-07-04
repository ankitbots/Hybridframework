Feature: Verify country details in RestCountries API

  @API_FindCountry
  Scenario Outline: Verify Country available in RestCountries API
    Given User able to get "All_Countries"
    Then "Country" as "<Country>" available is response

    Examples:-
    |Country|
    |Germany|
    |India  |
    |Israel |