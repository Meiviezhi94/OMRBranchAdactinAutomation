
Feature: Verifying Adactin Login Hotel details

  Background: 
    Given User is on the Adactin page
	@Login
  Scenario Outline: Verifing Adactin hotel login with valid credentials
    When User should perform login "<userName>" and "<password>"
    Then User should verify after login "Hello Sundarvadivel!"

    Examples: 
      | userName      | password |
      | Sundarvadivel | Meioviya |

  Scenario Outline: Verifing Adactin hotel login with valid credentials using enter key
    When User should perform login "<userName>" and "<password>" with enter key
    Then User should verify after login "Hello Sundarvadivel!"

    Examples: 
      | userName      | password |
      | Sundarvadivel | Meioviya |
	
  Scenario Outline: Verifing Adactin hotel login with invalid credentials
    When User should perform login "<userName>" and "<password>"
    Then User should verify after login error message contains "Invalid Login details or Your Password might have expired."

    Examples: 
      | userName  | password |
      | Meiviezhi | Meioviya |
