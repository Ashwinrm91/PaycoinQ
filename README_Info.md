# PaycoinQ

Cucumber BDD Framework --- Restappured API Automation

Why this framework and Features of Framework:

The framework is created in such a way where each line in the feature file is mapped to the Java and rest api methods.

This framework can be understandable even by a non-technical person. This can be extended to UI automation, Fetching DB data, and providing excellent reports.

Each feature file is annotated with Cucumber tags we run whichever test we want just by placing the tag in runner class

***************************************
How to run the framework?

Clone the project from Git Hub --> Import it to any IDE as a maven project --> Go to Runner Package src/main/java -- TestRunner.java --> Right-click then Run as Junit

****************************************
Framework structure 

Runner package
Src/main/java - Where the runner class is stored we can give the tags and path of the feature file which we want to run

Step Def Package
Src/main/java - Where the API methods written for the Post,Get,Patch and Delete methods and HTTP methods for code resuabilty

Utils

Src/main/Utils - Where Class for reading a property is created which is extended in different class

Feature file

Src/test/java/Feature - Where feature files are written for different use cases

SRC

The property file is stored having a common URL and post and patch request

************************************************
Junit Reports
Test outout - Basic Junit report

***********************************************

Pom.xml - Where all maven dependencies are stored

****************************************
Scenarios covered

1) Creating the booking data
2) Get the user booking details with booking ID
3) Get all the booking id and getting the booking infromation by firstname and the lastname
4) Partially updating the user details
5) Deleting the created data

Pros - Easy to get the data with all the API methods in a fraction of seconds. 
Cons - I don't find any cons

****************************************
