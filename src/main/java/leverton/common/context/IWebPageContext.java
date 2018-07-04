package leverton.common.context;

import cucumber.api.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

/**
 * Created by AnkitNigam on 07/04/2018.
 */
public interface IWebPageContext {
    By getElementLocator(String var1);
    WebDriver getRealDriver();
    WebDriverWait getWait();
}
