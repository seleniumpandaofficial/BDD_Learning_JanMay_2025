package runner_files;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src\\test\\resources\\feature_files", 
        glue = "step_definitions",
        tags = "@ValidCredentials",
        plugin = {"pretty", "html:target\\site\\cucumber-html", "json:target\\cucumber1.json"},
        publish = true
       )

public class Runner_TestNG extends AbstractTestNGCucumberTests {

}
