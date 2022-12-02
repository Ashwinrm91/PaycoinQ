package runner;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\asrm\\Documents\\PaycoinQ\\Paycoinq\\src\\test\\java\\features", //the path of the feature files
		glue={"stepDefinitions"}, //the path of the step definition files
//		plugin= {"pretty","html:target/cucmber-reports"},
		format= {"pretty","html:test-output", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"}, //to generate different types of reporting
		monochrome = true, //display the console output in a proper readable format
		strict = true, //it will check if any step is not defined in step definition file
		dryRun = false, //to check the mapping is proper between feature file and step def file
		tags = {"@Booking_API"}
		)
public class TestRunner {

}
