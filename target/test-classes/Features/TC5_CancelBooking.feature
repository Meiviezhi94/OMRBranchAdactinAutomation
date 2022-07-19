Feature: Verifying Adactin Cancel Booking with different scenarios

  Background: 
    Given User is on the Adactin page
    When User should perform login "<userName>" and "<password>"
    Then User should verify after login "Hello Sundarvadivel!"

  @CancelBooking
  Scenario Outline: Verifing Adactin Cancel Booking Hotel
    When User should search hotel using all fields "<Location>","<Hotels>","<Room Type>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>"and"<Children per Room>"
    Then User should verify navigate to select hotel page with message "Select Hotel"
    And User should select Hotel
    Then User should verify message after Select Hotel as "Book A Hotel"
    And User should Book Hotel "<First Name>","<Last Name>"and"<Billing Address>"
      | Credit_Card_No   | Credit_Card_Type | Expiry_Month | Expiry_Year | CVV_Number |
      | 1234567891234567 | American Express | September    |        2022 |        456 |
      | 1234567891234568 | VISA             | October      |        2022 |        789 |
      | 1234567891234569 | Master Card      | November     |        2022 |        963 |
      | 1234567891234560 | Other            | December     |        2022 |        147 |
    Then User should verify the message in Booking confirmation page as "Booking Confirmation"
    And User should cancel the Order Id
    Then User should verify Booked Itinerary page after cancel booking with message as "The booking has been cancelled."

    Examples: 
      | userName      | password | Location | Hotels       | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room | First Name | Last Name | Billing Address |
      | Sundarvadivel | Meioviya | Brisbane | Hotel Hervey | Standard  | 2 - Two         | 03/07/2022    | 04/07/2022     | 2 - Two         | 1 - One           | Mei        | Vizhi     | Chennai         |
	
  Scenario Outline: Verifing Adactin Cancel Booking Hotel by using Order Id
    And User should cancel the "<Order_Id>"
    Then User should verify Booked Itinerary page after cancel booking with message as "The booking has been cancelled."

    Examples: 
      | userName      | password | Order_Id   |
      | Sundarvadivel | Meioviya | N64ILSG930 |
