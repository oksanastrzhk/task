package pages;

import business_objects.User;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains locators to configure and send emails
 */
public class GmailPage extends BasePage {

    WebDriverWait wait = new WebDriverWait( driver, 5 );
    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    public WebElement writeButton;

    @FindBy(css = ".vO")
    public WebElement recipientMailAddressField;

    @FindBy(name = "subjectbox")
    public WebElement mailSubjectField;

    @FindBy(css = ".Am.Al.editable.LW-avf")
    public WebElement mailBodyField;

    @FindBy(css = ".T-I.J-J5-Ji.aoO.T-I-atl.L3")
    public WebElement sendMailButton;

    @FindBy(css= "a[href='https://mail.google.com/mail/#inbox']")
    public WebElement inboxLink;

    @FindBy(xpath = "//*[contains(@href,'https://mail.google.com/mail/#sent')]")
    public WebElement sentLink;

    @FindBy(css = "span[role='checkbox']")
    public WebElement selectAllCheckbox;

    @FindBy(css = "span[name='я']")
    public WebElement mailRecipient;

    @FindBy(css = "div[data-tooltip='Удалить']")
    public WebElement deleteAllMails;


    public GmailPage(WebDriver driver) {
        super( driver );
    }

    public void send(User user) {

        wait.until( ExpectedConditions.elementToBeClickable( writeButton ) );
        writeButton.click();
        recipientMailAddressField.click();
        recipientMailAddressField.sendKeys( user.getLogin().substring( 0, 2 ) );
        recipientMailAddressField.sendKeys( Keys.ENTER );
        mailSubjectField.click();
        mailSubjectField.sendKeys( user.getMessageTitle() );
        mailBodyField.click();
        mailBodyField.sendKeys( user.getMessageBody() );
        sendMailButton.click();
        wait.until( ExpectedConditions.elementToBeClickable( sentLink ) );
        sentLink.click();
    }

    public void delete() {
        inboxLink.click();
        selectAllCheckbox.click();
        deleteAllMails.click();
    }


}
