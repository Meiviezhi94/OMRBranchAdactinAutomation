
Feature: Verifying Adactin Search Hotel with different scenarios
	
  Background: 
    Given User is on the Adactin page
    When User should perform login "<userName>" and "<password>"
    Then User should verify after login "Hello Sundarvadivel!"
	@SearchHotel
  Scenario Outline: Verifing Adactin search hotel page by select all fields
    When User should search hotel using all fields "<Location>","<Hotels>","<Room Type>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>"and"<Children per Room>"
    Then User should verify navigate to select hotel page with message "Select Hotel"

    Examples: 
      | userName      | password | Location | Hotels       | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room |
      | Sundarvadivel | Meioviya | Brisbane | Hotel Hervey | Standard  | 2 - Two         | 03/07/2022    | 04/07/2022     | 2 - Two         | 1 - One           |
	
  Scenario Outline: Verifing Adactin search hotel page by select mandatory fields
    When User should search hotel using mandatory fields "<Location>","<Number of Rooms>","<Check In Date>","<Check Out Date>"and"<Adults per Room>"
    Then User should verify navigate to select hotel page with message "Select Hotel"

    Examples: 
      | userName      | password | Location | Number of Rooms | Check In Date | Check Out Date | Adults per Room |
      | Sundarvadivel | Meioviya | Brisbane | 2 - Two         | 03/07/2022    | 04/07/2022     | 2 - Two         |
	
  Scenario Outline: Verifing Adactin search hotel page by select all fields with invalid data
    When User should search hotel using all fields "<Location>","<Hotels>","<Room Type>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>"and"<Children per Room>"
    Then User should verify Search Hotel page with error message "Check-In Date shall be before than Check-Out Date","Check-Out Date shall be after than Check-In Date"

    Examples: 
      | userName      | password | Location | Hotels       | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room |
      | Sundarvadivel | Meioviya | Brisbane | Hotel Hervey | Standard  | 2 - Two         | 03/07/2023    | 04/07/2022     | 2 - Two         | 1 - One           |
	
  Scenario Outline: Verifing Adactin search hotel page without enter any fields click search
    When User should search hotel without enter any fields
    Then User should verify Search Hotel page with error message "Please Select a Location"

    Examples: 
      | userName      | password |
      | Sundarvadivel | Meioviya |
