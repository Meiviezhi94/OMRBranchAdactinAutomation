Feature: Verifying Adactin select Hotel Page with different scenarios

  Background: 
    Given User is on the Adactin page
    When User should perform login "<userName>" and "<password>"
    Then User should verify after login "Hello Sundarvadivel!"
    When User should search hotel using all fields "<Location>","<Hotels>","<Room Type>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>"and"<Children per Room>"
    Then User should verify navigate to select hotel page with message "Select Hotel"

  @SelectHotel
  Scenario Outline: Verifing Adactin select hotel page by select Hotel
    And User should select Hotel
    Then User should verify message after Select Hotel as "Book A Hotel"

    Examples: 
      | userName      | password | Location | Hotels       | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room |
      | Sundarvadivel | Meioviya | Brisbane | Hotel Hervey | Standard  | 2 - Two         | 03/07/2022    | 04/07/2022     | 2 - Two         | 1 - One           |

  Scenario Outline: Verifing Adactin select hotel page by without select data
    And User should click continue without select any Hotel
    Then User should verify select Hotel page error message "Please Select a Hotel"

    Examples: 
      | userName      | password | Location | Hotels       | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room |
      | Sundarvadivel | Meioviya | Brisbane | Hotel Hervey | Standard  | 2 - Two         | 03/07/2022    | 04/07/2022     | 2 - Two         | 1 - One           |
