Feature: Verifying Adactin Book A Hotel page with different scenarios

  Background: 
    Given User is on the Adactin page
    When User should perform login "<userName>" and "<password>"
    Then User should verify after login "Hello Sundarvadivel!"
    When User should search hotel using all fields "<Location>","<Hotels>","<Room Type>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>"and"<Children per Room>"
    Then User should verify navigate to select hotel page with message "Select Hotel"
    And User should select Hotel
    Then User should verify message after Select Hotel as "Book A Hotel"

  Scenario Outline: Verifing Adactin Book A Hotel by enter all fields
    And User should Book Hotel "<First Name>","<Last Name>"and"<Billing Address>"
      | Credit_Card_No   | Credit_Card_Type | Expiry_Month | Expiry_Year | CVV_Number |
      | 1234567891234567 | American Express | September    |        2022 |        456 |
      | 1234567891234568 | VISA             | October      |        2022 |        789 |
      | 1234567891234569 | Master Card      | November     |        2022 |        963 |
      | 1234567891234560 | Other            | December     |        2022 |        147 |
    Then User should verify the message in Booking confirmation page as "Booking Confirmation"

    Examples: 
      | userName      | password | Location | Hotels       | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room | First Name | Last Name | Billing Address |
      | Sundarvadivel | Meioviya | Brisbane | Hotel Hervey | Standard  | 2 - Two         | 03/07/2022    | 04/07/2022     | 2 - Two         | 1 - One           | Mei        | Vizhi     | Chennai         |

  @BookHotel
  Scenario Outline: Verifing Adactin Book A Hotel without enter any fields
    And User should click Book Now without enter any fields
    Then User should verify Book A Hotel page with error message "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month"and"Please Enter your Credit Card CVV Number"

    Examples: 
      | userName      | password | Location | Hotels       | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room |
      | Sundarvadivel | Meioviya | Brisbane | Hotel Hervey | Standard  | 2 - Two         | 03/07/2022    | 04/07/2022     | 2 - Two         | 1 - One           |
