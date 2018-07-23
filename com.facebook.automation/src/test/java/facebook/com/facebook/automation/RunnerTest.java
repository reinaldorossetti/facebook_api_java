package facebook.com.facebook.automation;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

// Run All Tests.

@RunWith(Cucumber.class)
@CucumberOptions(
	// path to feature.
	features = "resource/",
	
	// the plugin will generate the report in html and json to integration continues.
	plugin = {
			"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
	        "json:target/cucumber.json" } )

public class RunnerTest {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("resource/report.xml"));

	}
}