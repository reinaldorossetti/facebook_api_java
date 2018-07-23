package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import useful.functions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AbstractPage {
	
	protected static WebDriver driver;
	
	public AbstractPage(WebDriver driver) {
		AbstractPage.driver = driver;
	}

	public LandingPage navigateToWebSite() throws IOException{

		functions config = new functions();
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.navigate().to(config.getConfig("website"));
		driver.manage().deleteAllCookies();
		return new LandingPage(driver);
	}
	
	public void closeDriver(){
		
        try {
        	// function to close the browser
            driver.close();
            driver.quit();
               
        } catch (UnreachableBrowserException e) {
        	System.out.println("cannot close browser: unreachable browser");
        }
		
	}
		
}
