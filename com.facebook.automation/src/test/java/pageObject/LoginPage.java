package pageObject;

import com.google.common.collect.ImmutableMap;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import useful.functions;

import java.util.Map;

public class LoginPage extends AbstractPage {

    public LoginPage(WebDriver driver) {
        super( driver );
    }

    public final HomePage loginContainer = PageFactory.initElements( driver, HomePage.class );

    // delay set on properties file.
    public functions functions = new functions();
    private String password = functions.getConfig( "password" );
    private String senha;

    Map<String, Object> map = ImmutableMap.of(
            "login", "#login_form input#email",
            "password", "#pass",
            "button", "#loginbutton",
            "menu", "fb-timeline-cover-name"
    );

    public LoginPage login(String email) throws InterruptedException {

        try {
            System.out.println( email );
            WebElement inputBox = (WebElement) functions.find_element( By.cssSelector( (String) map.get( "login" ) ) );
            String textInsideInputBox = inputBox.getText();

            if (textInsideInputBox.isEmpty()) {
                loginContainer.login.sendKeys( email );
            } else {
                loginContainer.login.clear();
                loginContainer.login.sendKeys( email );
            }
        } catch (Exception e) {
            // Em caso de erro faz uma segunda tentativa.
            driver.navigate().refresh();
            functions.alertConfirm();
            System.out.println( "Error in login try again" );
            functions.sendKeys( By.cssSelector( (String) map.get( "login" ) ), email );
        }
        return new LoginPage( driver );
    }

    public LoginPage password() throws Throwable {

        senha = functions.verifiedPassword( password );

        try {
            loginContainer.password.sendKeys( senha );
        } catch (Exception e) {
            functions.alertConfirm();
            System.out.println( "Error in login try again" );
            functions.sendKeys( By.cssSelector( (String) map.get( "password" ) ), senha );
        }
        return new LoginPage( driver );

    }

    public LoginPage loginbutton() throws Throwable {

        try {
            loginContainer.loginbutton.click();

            // try again if error in click default.
        } catch (Exception e) {
            System.out.println( "error in loginbutton" );
            functions.searchAndClick( By.cssSelector( (String) map.get( "button" ) ) );
        }
        return new LoginPage( driver );
    }


    public LoginPage validate_login(String user_name) throws Exception {

        driver.switchTo().defaultContent();
        String user_name_site = null;
        System.out.println( "Step getText User" );

        try {
            user_name_site = loginContainer.user_text_css.getText();
            loginContainer.pageHome.click();
        } catch (Exception e) {
            user_name_site = functions.refleshPage( By.id( (String) map.get( "menu" ) ) );
        }

        System.out.println( "user logado: " + user_name_site );
        Assert.assertEquals( user_name, user_name_site );
        return new LoginPage( driver );

    }

    public String getSenha() {
        return senha;
    }


    public void setSenha(String senha) {
        this.senha = senha;
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
}
