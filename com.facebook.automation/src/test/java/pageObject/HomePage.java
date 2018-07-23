package pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends AbstractPage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    // **********************************************************************************************************************
    //Login elements.
    // **********************************************************************************************************************

    @FindBy(how = How.ID, using = "email")
    @CacheLookup
    public WebElement login;

    @FindBy(how = How.ID, using = "pass")
    @CacheLookup
    public WebElement password;

    @FindBy(how = How.CSS, using = "input[value=\"Entrar\"][type=\"submit\"]")
    @CacheLookup
    public WebElement loginbutton;

    // **********************************************************************************************************************
    // POST elements.
    // **********************************************************************************************************************

    @FindBy(how = How.XPATH, using = "//*[@id=\"navItem_100002054849465\"]/a/div/span")
    @CacheLookup
    public WebElement user_text_xpath;


    // **********************************************************************************************************************
    // Default elements.
    // **********************************************************************************************************************

    @FindBy(how = How.CSS, using = "div.linkWrap.noCount")
    @CacheLookup
    public WebElement user_text_css;


    // **********************************************************************************************************************
    // TimeLine elements.
    // **********************************************************************************************************************

    @FindBy(how = How.CSS, using = "#fb-timeline-cover-name")
    @CacheLookup
    public WebElement user_name_css;

    @FindBy(how = How.CSS, using = "form[action*=\"ajax/updatestatus\"] textarea[name=\"xhpc_message\"]")
    @CacheLookup
    public WebElement fieldText;

    @FindBy(how = How.CSS, using = "#feedx_sprouts_container div[data-testid=\"status-attachment-mentions-input\"]")
    @CacheLookup
    public WebElement fieldTextAfter;

    @FindBy(how = How.CSS, using = "div[data-click=\"home_icon\"] a")
    @CacheLookup
    public WebElement pageHome;

    @FindBy(how = How.CSS, using = "button[data-testid=\"react-composer-post-button\"]")
    @CacheLookup
    public WebElement buttonPost;

    @FindBy(how = How.XPATH, using = "(.//a[contains(@class,'UFILikeLink')])[1]")
    @CacheLookup
    public WebElement likePost;

    // **********************************************************************************************************************
    //Settings elements.
    // **********************************************************************************************************************

    @FindBy(how = How.ID, using = "userNavigationLabel")
    @CacheLookup
    public WebElement navigation_label_id;

    @FindBy(how = How.CSS, using = "span form[action*=\"logout\"]")
    @CacheLookup
    public WebElement sair;

}
