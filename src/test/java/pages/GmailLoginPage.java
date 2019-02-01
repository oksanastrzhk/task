package pages;

import business_objects.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains locators required during login
 */
public class GmailLoginPage extends BasePage {


    @FindBy(xpath = "//*[@id='identifierId']")
    public WebElement emailField;

    @FindBy(css = "#identifierNext > content > span")
    public WebElement nextButton;

    @FindBy(css = "input[type='password']")
    public WebElement passwordField;

    @FindBy(css = "#passwordNext > content > span")
    public WebElement nextButtonPassword;


    public GmailLoginPage(WebDriver driver) {
        super( driver );
    }

    public void loginToAccount(User user) {
        System.out.println( "Starting the login process." );
        emailField.clear();
        emailField.sendKeys( user.getLogin() );
        WebDriverWait wait = new WebDriverWait( driver, 5 );
        wait.until( ExpectedConditions.elementToBeClickable( nextButton ) );
        nextButton.click();
        wait.until( ExpectedConditions.visibilityOf( passwordField ) );
        passwordField.clear();
        passwordField.sendKeys( user.getPassword() );
        wait.until( ExpectedConditions.elementToBeClickable( nextButtonPassword ) );
        nextButtonPassword.click();
    }
}
