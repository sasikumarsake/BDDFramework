package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\testscripts\\regression", 
					glue="steps", 
					stepNotifications=true,
					dryRun=false,
					tags="@Regression")

public class RegressionRunner {
	

}
 