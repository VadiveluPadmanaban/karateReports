Feature: Sample Karate API Automation

Scenario: Get all states of a country
Given url 'http://services.groupkt.com/state/get/IND/all'
When method get
Then status 200
