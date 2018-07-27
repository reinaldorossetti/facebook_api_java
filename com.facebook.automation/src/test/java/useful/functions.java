package useful;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.AbstractPage;

import javax.swing.*;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;

import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class functions extends AbstractPage {

    private Boolean True;

    public functions() {
        super( driver );
    }

    // delay set on properties file.
    public String delay_s = getConfig( "sleep" );
    public String seconds_value = getConfig( "delay_wait" );
    public int delay_sleep = Integer.parseInt( delay_s );
    public int seconds = Integer.parseInt( seconds_value );
    WebDriverWait wait = new WebDriverWait( driver, seconds );
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    Actions action = new Actions( driver );

    public boolean sendKeys(By locator, String text) throws InterruptedException {
        Boolean test = false;
        try {

            WebElement myDynamicElement = wait.until( (Function<? super WebDriver, WebElement>) presenceOfElementLocated( locator ) );
            myDynamicElement.sendKeys( text );
            test = true;

        } catch (Exception e) {

            System.out.println( "Element not found!" );

        }
        return test;
    }

    public WebElement find_element(By locator) {

        WebDriverWait wait = new WebDriverWait( driver, seconds );
        WebElement element = null;
        try {
            element = wait.until( (Function<? super WebDriver, WebElement>) presenceOfElementLocated( locator ) );

        } catch (Exception e) {
            System.out.println( "\nElement not found! " + e );
        }
        return element;
    }

    public String getConfig(String name) {

        InputStream inputStream = null;
        String value = null;
        try {
            Properties prop = new Properties();
            String propFileName = "conf.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream( propFileName );

            if (inputStream != null) {
                prop.load( inputStream );
            } else {
                throw new FileNotFoundException( "property file '" + propFileName + "' not found in the classpath" );
            }

            // get the property value and print it out
            value = prop.getProperty( name );


        } catch (Exception e) {
            System.out.println( "Exception: " + e.getMessage() );
        }
        return value;
    }

    public void setPropertiesKey(String publicKey) throws IOException, URISyntaxException {

        InputStream inputStream = null;
        Properties prop = new Properties();
        String propFileName = "conf.properties";

        inputStream = getClass().getClassLoader().getResourceAsStream( propFileName );

        if (inputStream != null) {
            prop.load( inputStream );
            inputStream.close();
        } else {
            throw new FileNotFoundException( "property file '" + propFileName + "' not found in the classpath" );
        }

        prop.setProperty( "publicKey", publicKey );
        URL url = getClass().getClassLoader().getResource( propFileName );
        prop.store( new FileOutputStream( new File( url.toURI() ) ), null );

    }

    public static String alertConfirm() {


        String alertText = "";
        try {
            Alert alert = driver.switchTo().alert();
            alertText = alert.getText();
            alert.dismiss();
            // or accept as below
            //alert.accept();

        } catch (NoAlertPresentException nape) {
            // nothing to do, because we only want to close it when pop up
            System.out.println( "Alert not found!" );

        }
        return alertText;

    }

    public String getText(By locator) {

        String product_text = "Not Found";
        WebDriverWait wait = new WebDriverWait( driver, seconds );
        WebElement search = null;
        try {

            search = wait.until( (Function<? super WebDriver, WebElement>) presenceOfElementLocated( locator ) );
            product_text = search.getText();
            System.out.println( "\nText: " + product_text );

        } catch (Exception e) {
            System.out.println( "\nElement not found! " + e );
        }
        return product_text;
    }

    public String getValue(By locator) {

        String product_text = "Not Found";
        WebDriverWait wait = new WebDriverWait( driver, seconds );
        WebElement search = null;
        try {
            Thread.sleep( 1000 ); // wait to update value.
            search = wait.until( (Function<? super WebDriver, WebElement>) visibilityOfElementLocated( locator ) );
            product_text = search.getAttribute( "value" );
            System.out.println( "\nValue: " + product_text );

        } catch (Exception e) {
            System.out.println( "\nElement not found! " + e );
        }
        return product_text;
    }

    public String verifiedPassword(String senha) {

        if (StringUtils.isNullOrBlank( senha )) {
            System.out.println( "senha em branco: " + senha );
            JPasswordField pf = new JPasswordField();
            int okCxl = JOptionPane.showConfirmDialog( null, pf, "Enter Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE );

            if (okCxl == JOptionPane.OK_OPTION) {
                senha = new String( pf.getPassword() );
            }
        }
        return senha;
    }

    public void movetoelement(By locator) {

        //to do add wait dynamic.
        System.out.println( locator );
        try {
            Actions actions = new Actions( driver );
            WebElement element = driver.findElement( locator );
            actions.moveToElement( element );
            actions.perform();

        } catch (Exception e) {

            System.out.println( "Element not Found! " + e );
        }
    }


    public static class StringUtils {

        // Checks the string is null or empty or only have blanks
        public static boolean isNullOrBlank(String s) {
            return (s == null || s.trim().equals( "" ));
        }

        // Checks the string is null or empty
        public static boolean isNullOrEmpty(String s) {
            return (s == null || s.equals( "" ));
        }
    }

    public boolean searchAndClick(By locator) {

        boolean Product = false;
        WebDriverWait wait = new WebDriverWait( driver, 30 );
        WebElement search = null;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        try {
            search = wait.until( (Function<? super WebDriver, WebElement>) presenceOfElementLocated( locator ) );
            //click one element javascript
            executor.executeScript( "arguments[0].click();", search );
            Product = true;

        } catch (Exception e) {
            alertConfirm();
            System.out.println( "searchAndClick - Visible Element not found" );
            search = driver.findElement( locator );
            executor.executeScript( "arguments[0].click();", search );
        }
        untilJqueryIsDone();
        return Product;
    }

    public boolean visibleClick(By locator) throws InterruptedException {
        System.out.println( "visibleClick()" );
        boolean Product = false;
        WebElement search = null;
        untilJqueryIsDone();
        Thread.sleep( 500 ); // wait 0.5s not to fast this case.
        try {
            search = wait.until( (Function<? super WebDriver, WebElement>) visibilityOfElementLocated( locator ) );
            //click one element javascript
            executor.executeScript( "arguments[0].click();", search );
            Product = true;

        } catch (Exception e) {
            System.out.println( "visibleClick - Visible Element not found" );
            search = driver.findElement( locator );
            executor.executeScript( "arguments[0].click();", search );
        }
        untilJqueryIsDone();
        return Product;
    }

    public String refleshPage(By locator) throws InterruptedException {

        String text = "Element not found";
        WebDriverWait wait = new WebDriverWait( driver, seconds );

        try {
            driver.navigate().refresh();
            driver.switchTo().alert().accept();
            text = wait.until( (Function<? super WebDriver, WebElement>) presenceOfElementLocated( locator ) ).getText();

        } catch (Exception e) {
            // try again
            System.out.println( "Element not found, try again!" );
            driver.navigate().refresh();
            alertConfirm();
            text = wait.until( (Function<? super WebDriver, WebElement>) presenceOfElementLocated( locator ) ).getText();

        }
        return text;
    }

    public Boolean deletePost(By locator, String text) throws InterruptedException {

        System.out.println( locator );
        untilJqueryIsDone();
        List<WebElement> AllSearchResults = driver.findElements( locator );

        //System.out.println(AllSearchResults);

        for (WebElement eachResult : AllSearchResults) {
            try {

                WebElement text_elem = (WebElement) executor.executeScript( "return arguments[0].querySelector('.userContent p');", eachResult );
                System.out.println( text_elem + "\n" );

                if (text_elem.getText().equalsIgnoreCase( text )) {
                    WebElement elem01 = eachResult.findElement( By.cssSelector( "a[data-testid=\"post_chevron_button\"]" ) );
                    ((JavascriptExecutor) driver).executeScript( "arguments[0].scrollIntoView();", elem01 );
                    Thread.sleep( 2000 ); // wait to scroll to element.
                    elem01.sendKeys( Keys.ENTER );
                    searchAndClick( By.cssSelector( "li a[data-feed-option-name=\"FeedDeleteOption\"] span" ) );
                    searchAndClick( By.cssSelector( "button.layerConfirm.uiOverlayButton" ) );
                }

            } catch (Exception e) {
                System.out.println( e.getMessage() );
                return false;
            }
        }
        return true;
    }

    public Boolean textClick(By locator, String text) throws InterruptedException {

        System.out.println( locator );
        untilJqueryIsDone();
        wait.until( presenceOfAllElementsLocatedBy( locator ) );
        List<WebElement> AllSearchResults = driver.findElements( locator );

        for (WebElement eachResult : AllSearchResults) {
            try {
                System.out.println( eachResult.getText() );
                if (eachResult.getText().equalsIgnoreCase( text )) {
                    action.moveToElement( eachResult ).click();
                    action.perform();
                    break;
                }

            } catch (Exception e) {
                System.out.println( e.getMessage() );
                return false;
            }
        }
        return true;
    }

    public static void untilJqueryIsDone(){
        until(driver, (d) ->
        {
            Boolean isJqueryCallDone = (Boolean)((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
            if (!isJqueryCallDone) System.out.println("JQuery call is in Progress");
            return isJqueryCallDone;
        });
    }

    private static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        try{
            webDriverWait.until(waitCondition);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
