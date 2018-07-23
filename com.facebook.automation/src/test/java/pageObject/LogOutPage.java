package pageObject;

import com.google.common.collect.ImmutableMap;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import useful.functions;

import java.util.Map;

public class LogOutPage extends AbstractPage {

    public LogOutPage(WebDriver driver) {
        super(driver);
    }

    public final HomePage ContainerElements = PageFactory.initElements(driver, HomePage.class);

    // delay set on properties file.
    public functions functions = new functions();
    public String delay_w = functions.getConfig("delay_wait");

    Map<String, String> map = ImmutableMap.of(
            "navigation_label_id", "#userNavigationLabel",
            "sair", "form[action*=\"logout/?button_name=logout\"]",
            "button", "#loginbutton",
            "menu", "fb-timeline-cover-name"
    );

    public LogOutPage logout() throws InterruptedException {

        System.out.println("Doing LogOut!");

        try {
            // Open menu Log Out
            ContainerElements.navigation_label_id.click();
            functions.searchAndClick(By.cssSelector(map.get("sair")));

        } catch (Exception e) {
            System.out.println("Error not found element, try again!");
            functions.searchAndClick(By.cssSelector(map.get("navigation_label_id")));
            functions.searchAndClick(By.cssSelector(map.get("sair")));
        }

        return new LogOutPage(driver);

    }

    public LogOutPage validate_logOut(String text) throws Throwable {

        driver.switchTo().defaultContent();
        ContainerElements.loginbutton.isDisplayed();
        String product_title = driver.getTitle();
        System.out.println("title: " + product_title);
        Boolean Test;

        if (product_title.contains(text)) {
            System.out.println("Result OK: " + product_title);
            Test = true;

        } else {
            System.out.println("\nResult Failed - Expected:" + text + "\nResult:" + product_title);
            System.out.print("\n ******* Assert Falhou!!! ********\n");
            Test = false;
        }
        Assert.assertTrue(Test);
        return new LogOutPage(driver);

    }
}
