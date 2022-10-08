Feature: I want to test the Home page of the application

Scenario: Gets the Title of the page
					Given User is on the Home page
					When User gets the title of the page
					Then The page title should be "Helix - Laboratory Information System"