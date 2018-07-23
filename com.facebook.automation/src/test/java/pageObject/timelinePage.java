package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import useful.functions;


public class timelinePage extends AbstractPage {


    public timelinePage(WebDriver driver) {
        super(driver);
    }

    public HomePage containerElems = PageFactory.initElements(driver, HomePage.class);

    // delay set on properties file.
    public functions functions = new functions();

    public String textPost;

    public timelinePage escreverText(String text) throws InterruptedException {

        System.out.println(text);
        System.out.println("click field POST");

        containerElems.fieldText.click();
        containerElems.fieldTextAfter.sendKeys(text);

        return new timelinePage(driver);

    }


    public timelinePage clickButtonPost() throws InterruptedException {

        try {
            System.out.println("Click Post Button");
            HomePage containerElems = PageFactory.initElements(driver, HomePage.class);
            functions.visibleClick(By.cssSelector("button[data-testid=\"react-composer-post-button\"]"));
        } catch (Exception e) {

            System.out.println(e);

        }
        return new timelinePage(driver);

    }

    public timelinePage validatePost(String text) throws InterruptedException {

        String test;
        try {

            System.out.println("validate POST");
            test = functions.getText(By.xpath("//p[contains(text(),'" + text + "')]"));

        } catch (Exception e) {

            driver.navigate().refresh();
            functions.alertConfirm();
            System.out.println("Error to validate POST, try again");
            test = functions.getText(By.xpath("//p[contains(text(),'" + text + "')]"));

        }
        Assert.assertFalse(test == "Not Found");
        return new timelinePage(driver);

    }

    public timelinePage deletePost(String text) throws InterruptedException {

        String test;
        try {

            System.out.println("delete POST");
            functions.visibleClick(By.cssSelector("div.linkWrap.noCount"));
            functions.deletePost(By.cssSelector("div[role=\"article\"][data-time]"), text);

        } catch (Exception e) {

            driver.navigate().refresh();
            System.out.println("Error to Delete POST, try again");
            functions.deletePost(By.cssSelector("div[role=\"article\"][data-time]"), text);

        }
        functions.getText(By.xpath("//p[contains(text(),'" + text + "')]"));
        return new timelinePage(driver);

    }
}
