package tests;

import business_objects.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GmailLoginPage;
import pages.GmailPage;

public class GmailTest extends BaseTest {

    private User validUser = new User( "testoksanastarazhok@gmail.com", "password12345",
            "test", "test" );

    private String gmailAdress = "https://accounts.google.com/ServiceLogin?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1#identifier";
    private String logoutURL = "https://accounts.google.com/Logout?hl=ru&continue=https://mail.google.com/mail&service=mail&timeStmp=1548971023&secTok=.AG5fkS-_tz15y-pI_yDX7KrV-WG0ingMzw";


    @Test(priority = -2, description = "Perform login to e-mail gmail.com and check that we are inside of test mail.")
    public void login() {
        driver.get( gmailAdress );
        GmailLoginPage gmailLoginPage = new GmailLoginPage( driver );
        gmailLoginPage.loginToAccount( validUser );
        String expectedTitle = "Gmail";
        Assert.assertEquals( driver.getTitle(), expectedTitle );

    }

    @Test( priority = -1, description = "Write a letter to yourself and verify mail.")
    public void sendMail() {
        GmailPage gmailPage = new GmailPage( driver );
        gmailPage.send( validUser );
        Assert.assertEquals( gmailPage.mailRecipient.getAttribute( "email" ), validUser.getLogin() );

    }

    @Test( description = "Remove from the list of incoming mail and check removal.")
    public void deleteMails() {
        driver.get(gmailAdress );
        GmailPage gmailPage = new GmailPage( driver );
        gmailPage.delete();
        String expectedAttribute = "Входящие";
        Assert.assertEquals( gmailPage.inboxLink.getAttribute( "aria-label" ), expectedAttribute );
        driver.get( logoutURL );
    }

}
