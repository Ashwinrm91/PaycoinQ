@User_API
Feature: Testing API for creation, updation, deletion of users

#Test case 1
@Create_User
Scenario: Creating users
Given Creating users using details

#Test case 2
@List_User
Scenario: Getting the list of users
Given Displaying the list of users

#Test case 3
@update
Scenario: Updating the user details
Given User updates the username and email

#Test case 4
@duplicate
Scenario: Duplicate user(Negative scenario)
Given User trying to create same user
Given Creating the user with password less than 8 letters


#Test case 5
@Delete_User
Scenario: Deleting the user
Given Deletion of user