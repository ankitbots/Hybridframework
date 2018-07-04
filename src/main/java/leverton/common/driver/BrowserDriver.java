package leverton.common.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Paths;

/**
 * Created by AnkitNigam on 07/04/2018.
 */
public class BrowserDriver {
    private static final Logger logger = LoggerFactory.getLogger(BrowserDriver.class);
    private static WebDriver driver = null;

    private BrowserDriver() {
    }

    public static WebDriver getDriver(){
        if(driver==null){
            try {
                //Launch Chrome browser
                if (System.getProperty("browser").contains("chrome")) {
                    logger.info("Launching Chrome browser ");
                    System.setProperty("webdriver.chrome.driver", Paths.get(".").toAbsolutePath().normalize().toString() + "/drivers/chromedriver/chromedriver.exe");
                    driver = new ChromeDriver();
                } //Launch Firefox browser
                else if (System.getProperty("browser").contains("firefox")) {
                    logger.info("Launching FireFox browser ");
                    System.setProperty("webdriver.gecko.driver", Paths.get(".").toAbsolutePath().normalize().toString() + "/drivers/geckodriver/geckodriver.exe");
                    driver = new FirefoxDriver();
                } //Launch IE browser
                else {
                    logger.info("Launching IE browser ");
                    System.setProperty("webdriver.ie.driver", Paths.get(".").toAbsolutePath().normalize().toString() + "/drivers/iedriver/IEDriverServer.exe");
                    DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                    //Disable protection mode
                    capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                    InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions(capabilities);
                    driver = new InternetExplorerDriver(internetExplorerOptions);
                }
            }catch (Exception ex){
                logger.error("Error in launching browser");
                ex.printStackTrace();
            }
        }
        return driver;
    }
}
