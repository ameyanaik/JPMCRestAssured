package cucumber.steps;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
features = "src/test/java/cucumber/features/test.feature", //the path of the feature files
glue={"cucumber.steps"}, //the path of the step definition files
plugin= {"pretty:target/cucumber-pretty.txt",
        "html:target/cucumber-html-report.html",
        "json:target/cucumber.json",
        "rerun:target/rerun.txt"
        }, //to generate different types of reporting
monochrome = true //display the console output in a proper readable format
//strict = true, //it will check if any step is not defined in step definition file
//dryRun = false //to check the mapping is proper between feature file and step definition file
)
public class CucumberTestNGRunner extends AbstractTestNGCucumberTests{

}
