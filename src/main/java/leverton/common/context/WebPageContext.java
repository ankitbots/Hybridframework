package leverton.common.context;

import leverton.common.contants.Constants;
import leverton.common.driver.BrowserDriver;
import leverton.common.repository.DataNotFoundInRepoExecption;
import leverton.common.repository.PageElement;
import leverton.common.repository.RepositoryContext;
import cucumber.api.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Created by AnkitNigam on 07/04/2018.
 */
@Component
public class WebPageContext implements IWebPageContext {
    private static final Logger logger = LoggerFactory.getLogger(WebPageContext.class);

    @Autowired
    private RepositoryContext repository;
    private static WebDriverWait wait;
    private static WebDriverWait shortWait;
    private static String parentHandle;


    @Override
    public By getElementLocator(String elementName) {
        By locElement = null;
        try {
            PageElement element = this.repository.getElement(elementName);
            locElement = this.getLocator(element);
        } catch (DataNotFoundInRepoExecption dataNotFoundInRepoExecption) {
            dataNotFoundInRepoExecption.printStackTrace();
        }finally {
            return locElement;
        }
    }

    @Override
    public WebDriver getRealDriver() {
        return BrowserDriver.getDriver();
    }

    @Override
    public WebDriverWait getWait() {
        if (wait==null){
            wait = new WebDriverWait(BrowserDriver.getDriver(), Constants.WAIT_TIMEOUT);
        }
        return wait;
    }

    private By getLocator(PageElement element) throws DataNotFoundInRepoExecption {
        logger.debug("Locating element: " + element);
        if (element.getLocatorType().equalsIgnoreCase("name")){return By.name(element.getLocator());}
        else if (element.getLocatorType().equalsIgnoreCase("id")){return By.id(element.getLocator());}
        else if (element.getLocatorType().equalsIgnoreCase("xpath")){return By.xpath(element.getLocator());}
        else if (element.getLocatorType().equalsIgnoreCase("className")){return By.className(element.getLocator());}
        else if (element.getLocatorType().equalsIgnoreCase("partialLinkText")){return By.partialLinkText(element.getLocator());}
        else if (element.getLocatorType().equalsIgnoreCase("css")){return By.cssSelector(element.getLocator());}
        else {throw new DataNotFoundInRepoExecption("Locator not found for webelement " + element);}
    }
}
