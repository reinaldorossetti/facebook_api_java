package useful;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageObject.AbstractPage;
import pageObject.LandingPage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Browsers extends AbstractPage {

	
	public Browsers(WebDriver driver) {
		super(driver);
	}


	public static WebDriver setBrowser(String Browser) throws IOException, InterruptedException{
		
		// Testes feitos no Firefox e Chrome
		
		if(Browser.equalsIgnoreCase("Chrome"))
		{
			// only works with new driver 2.40
			System.setProperty("webdriver.chrome.driver", "/drivers/chromedriver.exe");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("start-maximized");
			options.addArguments("disable-infobars");
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			
		} else if (Browser.equalsIgnoreCase("Firefox"))
		{
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile testprofile = profile.getProfile("reiload");
			testprofile.setPreference("dom.webnotifications.enabled", false);
			DesiredCapabilities dc = DesiredCapabilities.firefox();
			dc.setCapability(FirefoxDriver.PROFILE, testprofile);
			FirefoxOptions opt = new FirefoxOptions();
			opt.merge(dc);
			driver =  new FirefoxDriver(opt);
			
		} 

		else if (Browser.equalsIgnoreCase("IE"))
		{
			driver = new InternetExplorerDriver();
		}
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.navigateToWebSite();
		return driver;
		
	}
	
		
	}
