package facebook.com.facebook.automation;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pageObject.LogOutPage;
import pageObject.LoginPage;
import useful.Browsers;
import pageObject.Token;
import pageObject.timelinePage;
import java.io.IOException;


public class StepsDefinitionNew {
	
	LoginPage loginPage;
	LogOutPage logOutPage;
	WebDriver driver;
	timelinePage timeline_Page;
	
	@Given("^the \"([^\"]*)\" and navigate to the web site facebook$")
	public void navigate_web_site(String browser) throws Throwable {
		// Types of browsers Chrome, Firefox and IE, set in feature.
		driver = (WebDriver) Browsers.setBrowser(browser);
	}

	@Given("^navigate to the web site \"([^\"]*)\"$")
	public void navigate_to_web_site(String site) throws Throwable {
		// Types of browsers Chrome, Firefox and IE, set in feature.
		driver.navigate().to(site);
	}

	@Given("^Make the \"([^\"]*)\"$")
	public void Login(String email) throws Throwable {
		
		// Doing Login
		loginPage = new LoginPage(driver);
		loginPage.login(email).
				password().loginbutton();
	}

	@When("^Validate the \"([^\"]*)\" in Main menu$")
	public void validate_Main_menu(String user_name) throws Throwable {
		// Validate the Login
		loginPage = new LoginPage(driver);
		loginPage.validate_login(user_name);
	}

	@Then("^Make the logout on facebook and validate the text \"([^\"]*)\"\\.$")
	public void logoutAndValidate(String text) throws Throwable {
		
		logOutPage = new LogOutPage(driver);
		logOutPage.logout().validate_logOut(text);
		driver.quit();
	}

	@When("^Write a new POST with content \"([^\"]*)\"$")
	public void addNewPosting(String text) throws Throwable {

		timeline_Page = new timelinePage(driver);
		timeline_Page.escreverText(text);
		timeline_Page = new timelinePage(driver);
		timeline_Page.clickButtonPost().validatePost(text);

	}

	@When("^Get new token$")
	public void get_new_token() throws Throwable {

		Token token = new Token( driver );
		token.setToken();

	}

	@When("^Close browser$")
	public void close_browser() throws Throwable {

		driver.quit();
	}

	@Then("^Deletar a nova postagem no facebook e validar a exclusao \"([^\"]*)\"\\.$")
	public void deletePost(String text) throws Throwable {

		timeline_Page = new timelinePage(driver);
		timeline_Page.deletePost(text);

	}

	@After
	public void tearDown(Scenario scenario) throws IOException {

		try{
		    // if the scenario fails, it will take a picture.
	        if (scenario.isFailed()) {
	                final byte[] screenshot = ((TakesScreenshot) driver)
	                        .getScreenshotAs(OutputType.BYTES);
	                scenario.embed(screenshot, "image/png");
		            }

		}finally {

			/// close the browser.
			//driver.close();
	  	}

  }
}