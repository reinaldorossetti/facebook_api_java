package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import useful.Configuration;
import useful.functions;

import java.io.IOException;
import java.net.URISyntaxException;


public class Token  extends AbstractPage{

    public Token(WebDriver driver) {
        super( driver );
    }

    Configuration conf = new Configuration();

    public functions functions = new functions();

    public Token setToken() throws InterruptedException, IOException, URISyntaxException {

         functions.textClick(By.cssSelector("a[role=\"button\"] span"), "Obter token");
         functions.textClick(By.cssSelector("ul[role=\"menu\"] a[role=\"menuitem\"]"), "Obter token de acesso do usuário");
         functions.searchAndClick(By.cssSelector("button[type=\"submit\"][role=\"button\"]"));
         String token_new = functions.getValue(By.cssSelector("input[placeholder*='Obter token'][type=\"text\"]"));
         conf.setPropertiesToken(token_new);
        return new Token(driver);

    }
}
