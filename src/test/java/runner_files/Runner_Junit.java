package runner_files;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		         features = "src\\test\\resources\\feature_files", 
		         glue = "step_definitions",
		         tags = "@LoginFunctionality",
		         plugin = {"pretty", "html:target\\site\\cucumber-html", "json:target\\cucumber1.json"},
		         publish = true
		        )

public class Runner_Junit {

}
