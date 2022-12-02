$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Restful_Booker.feature");
formatter.feature({
  "line": 2,
  "name": "Testing API for Booking Creation, Getting details, updation and deletion",
  "description": "",
  "id": "testing-api-for-booking-creation,-getting-details,-updation-and-deletion",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Booking_API"
    }
  ]
});
formatter.scenario({
  "comments": [
    {
      "line": 4,
      "value": "#Test case 1"
    }
  ],
  "line": 6,
  "name": "Creates a new booking in the API",
  "description": "",
  "id": "testing-api-for-booking-creation,-getting-details,-updation-and-deletion;creates-a-new-booking-in-the-api",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@Create_Booking"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "Creating booking using user details",
  "keyword": "Given "
});
formatter.match({
  "location": "ApiMethods.createUser()"
});
formatter.result({
  "duration": 5477730200,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 9,
      "value": "#Test case 2"
    }
  ],
  "line": 11,
  "name": "Returns a specific booking based upon the booking id provided",
  "description": "",
  "id": "testing-api-for-booking-creation,-getting-details,-updation-and-deletion;returns-a-specific-booking-based-upon-the-booking-id-provided",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 10,
      "name": "@GetBooking"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "User get the created details",
  "keyword": "Given "
});
formatter.match({
  "location": "ApiMethods.get_Particular_User_With_Bookingid()"
});
formatter.result({
  "duration": 1766836900,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 14,
      "value": "#Test case 3"
    }
  ],
  "line": 16,
  "name": "Returns the ids of all the bookings that exist within the API. Can take optional query strings to search and return a subset of booking ids.",
  "description": "",
  "id": "testing-api-for-booking-creation,-getting-details,-updation-and-deletion;returns-the-ids-of-all-the-bookings-that-exist-within-the-api.-can-take-optional-query-strings-to-search-and-return-a-subset-of-booking-ids.",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 15,
      "name": "@GetBookingIds"
    }
  ]
});
formatter.step({
  "line": 17,
  "name": "User gets the all the booking Ids",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "I am getting the booking IDs with firstname \"Ashwin\" and the secondname \"RM\"",
  "keyword": "Then "
});
formatter.match({
  "location": "ApiMethods.gets_all_User()"
});
formatter.result({
  "duration": 3292753200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Ashwin",
      "offset": 45
    },
    {
      "val": "RM",
      "offset": 73
    }
  ],
  "location": "ApiMethods.filtering_the_user(String,String)"
});
formatter.result({
  "duration": 1819905900,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 20,
      "value": "#Test case 4"
    }
  ],
  "line": 22,
  "name": "Updates a current booking with a partial payload",
  "description": "",
  "id": "testing-api-for-booking-creation,-getting-details,-updation-and-deletion;updates-a-current-booking-with-a-partial-payload",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 21,
      "name": "@PartialUpdateBooking"
    }
  ]
});
formatter.step({
  "line": 23,
  "name": "User updates the booking details with partial information with firstname and Lastname",
  "keyword": "Given "
});
formatter.match({
  "location": "ApiMethods.partially_updates_the_User_data()"
});
formatter.result({
  "duration": 2075989300,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 25,
      "value": "#Test case 5"
    }
  ],
  "line": 27,
  "name": "Deletes a current booking with bookingid",
  "description": "",
  "id": "testing-api-for-booking-creation,-getting-details,-updation-and-deletion;deletes-a-current-booking-with-bookingid",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 26,
      "name": "@DeleteBooking"
    }
  ]
});
formatter.step({
  "line": 28,
  "name": "user deletes the content using bookingID",
  "keyword": "Given "
});
formatter.match({
  "location": "ApiMethods.deleting_the_User_data()"
});
formatter.result({
  "duration": 1647158900,
  "status": "passed"
});
});