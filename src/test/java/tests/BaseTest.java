package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * This class setup and tear down a driver.
 */
public class BaseTest {
    public static WebDriver driver;

    @BeforeClass
    public void setup() {

        System.setProperty( "webdriver.ie.driver",
                "src/test/resources/drivers/IEDriverServer.exe" );


        InternetExplorerOptions options = new InternetExplorerOptions();
        options.setCapability( InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
                true );
        options.setCapability( InternetExplorerDriver.IGNORE_ZOOM_SETTING, true );
        options.setCapability( InternetExplorerDriver.IGNORE_ZOOM_SETTING, true );
        driver = new InternetExplorerDriver( options );
        System.out.println( "Driver is configured" );

    }

    @AfterClass
    public void tearDown() {

        driver.quit();
        System.out.println( "Return initial configuration back" );

    }


}
