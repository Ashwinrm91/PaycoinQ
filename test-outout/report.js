$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Unzer_API.feature");
formatter.feature({
  "line": 2,
  "name": "Testing API for creation, updation, deletion of users",
  "description": "",
  "id": "testing-api-for-creation,-updation,-deletion-of-users",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@User_API"
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
  "name": "Creating users",
  "description": "",
  "id": "testing-api-for-creation,-updation,-deletion-of-users;creating-users",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@Create_User"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "Creating users using details",
  "keyword": "Given "
});
formatter.match({
  "location": "ApiMethods.PostRequest()"
});
formatter.result({
  "duration": 3418328600,
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
  "name": "Getting the list of users",
  "description": "",
  "id": "testing-api-for-creation,-updation,-deletion-of-users;getting-the-list-of-users",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 10,
      "name": "@List_User"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "Displaying the list of users",
  "keyword": "Given "
});
formatter.match({
  "location": "ApiMethods.GetRequest()"
});
formatter.result({
  "duration": 587529500,
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
  "name": "Updating the user details",
  "description": "",
  "id": "testing-api-for-creation,-updation,-deletion-of-users;updating-the-user-details",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 15,
      "name": "@update"
    }
  ]
});
formatter.step({
  "line": 17,
  "name": "User updates the username and email",
  "keyword": "Given "
});
formatter.match({
  "location": "ApiMethods.PutRequest()"
});
formatter.result({
  "duration": 541755100,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "Duplicate user(Negative scenario)",
  "description": "",
  "id": "testing-api-for-creation,-updation,-deletion-of-users;duplicate-user(negative-scenario)",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 19,
      "name": "@duplicate"
    }
  ]
});
formatter.step({
  "line": 21,
  "name": "User trying to create same user",
  "keyword": "Given "
});
formatter.step({
  "line": 22,
  "name": "Creating the user with password less than 8 letters",
  "keyword": "Given "
});
formatter.match({
  "location": "ApiMethods.negativeScenario()"
});
formatter.result({
  "duration": 590009100,
  "status": "passed"
});
formatter.match({
  "location": "ApiMethods.negativeScenario1()"
});
formatter.result({
  "duration": 520887500,
  "status": "passed"
});
formatter.scenario({
  "line": 26,
  "name": "Deleting the user",
  "description": "",
  "id": "testing-api-for-creation,-updation,-deletion-of-users;deleting-the-user",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 25,
      "name": "@Delete_User"
    }
  ]
});
formatter.step({
  "line": 27,
  "name": "Deletion of user",
  "keyword": "Given "
});
formatter.match({
  "location": "ApiMethods.DeleteRequest()"
});
formatter.result({
  "duration": 518865200,
  "status": "passed"
});
});