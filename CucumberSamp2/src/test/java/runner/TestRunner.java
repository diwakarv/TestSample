package runner;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/java/feature/test.feature"
,glue= {"seleniumgluecode"},

//plugin = {"pretty", "html:target/htmlreports"},
plugin = { "pretty",
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/richexten.html",
		"html:target/htmlreport/test.html","json:target/cucumber-reportst/9.json"}, 
monochrome = true
        )



public class TestRunner {

}