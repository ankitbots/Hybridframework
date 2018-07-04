package leverton.common.action;

import leverton.common.contants.Constants;
import leverton.common.driver.BrowserDriver;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by AnkitNigam on 6/15/2018.
 */
@Component
public class NavigateAction {
    private static final Logger logger = LoggerFactory.getLogger(NavigateAction.class);

    //Open URL in browser
    public boolean navigateToPage(String url){
        boolean flag = false;
        try{
            WebDriver driver = BrowserDriver.getDriver();
            logger.info("Application URL: " + url);
            driver.get(url);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Constants.NAVIGATION_WAIT_TIMEOUT, TimeUnit.SECONDS);
            flag = true;
        }catch (Exception ex){
            logger.error("Error in navigating to URL: "+ url);
            logger.error(ex.getMessage());
            ex.printStackTrace();
        }finally {
            return flag;
        }
    }
}
