@Booking_API
Feature: Testing API for Booking Creation, Getting details, updation and deletion

  #Test case 1
  @Create_Booking
  Scenario: Creates a new booking in the API
    Given Creating booking using user details

  #Test case 2
  @GetBooking
  Scenario: Returns a specific booking based upon the booking id provided
    Given User get the created details

  #Test case 3
  @GetBookingIds
  Scenario: Returns the ids of all the bookings that exist within the API. Can take optional query strings to search and return a subset of booking ids.
    Given User gets the all the booking Ids
    Then I am getting the booking IDs with firstname "Ashwin" and the secondname "RM"

  #Test case 4
  @PartialUpdateBooking
  Scenario: Updates a current booking with a partial payload
    Given User updates the booking details with partial information with firstname and Lastname

  #Test case 5
  @DeleteBooking
  Scenario: Deletes a current booking with bookingid
    Given user deletes the content using bookingID
