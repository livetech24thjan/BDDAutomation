package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src\\test\\resources\\features\\regression",
		glue="steps",
		stepNotifications=true,
		tags="@wip2704",
		dryRun=false)
public class RegRunner {

}










