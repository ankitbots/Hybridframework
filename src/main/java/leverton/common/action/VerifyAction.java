package leverton.common.action;

import leverton.common.contants.Constants;
import leverton.common.utils.JSONParser;
import leverton.common.utils.ScenarioDataStore;
import leverton.common.utils.SortHelper;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by AnkitNigam on 07/04/2018.
 */

@Component
public class VerifyAction extends AbstractBaseAction {
    private static final Logger logger = LoggerFactory.getLogger(VerifyAction.class);

    public boolean verifyObjectExists(String name){
        boolean flag = false;
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(context.getElementLocator(name)));
            logger.info("Object found: " + name);
            flag = true;
        }catch (TimeoutException e){
            logger.error("TimeoutException - Object not found: " + name);
        }catch (Exception ex){
            logger.error("Error in finding object " + name);
        }finally {
            return flag;
        }
    }


    public boolean verifyTextDisplayingAction(String name, String expectedValue) {
        boolean flag = false;
        String actualValue = null;
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(context.getElementLocator(name)));
            logger.info("Textbox found: " + name);
            actualValue = element.getText().trim();
            if (actualValue.equals(expectedValue)){
                logger.debug("Expected text found");
                flag = true;
            }else {
                logger.info("Expected text not found on the page");
                flag = false;
            }
        }catch (TimeoutException e){
            logger.error("TimeoutException - Object not found: " + name);
        }catch (Exception ex){
            logger.error("Error in finding object " + name);
        }finally {
            return flag;
        }
    }

    public boolean verifyValueAvailableInJSONUsingJSONPathAction(String query, String value) {
        boolean flag = false;
        try {
            logger.info("Finding '" + query + "' as '" + value + "' in response");
            String jsonString = (String) ScenarioDataStore.get("RESPONSE_STRING");
            String jsonPath = null;
            String actualValue =  null;

            if (!StringUtils.isEmpty(jsonString)){

                if (query.equalsIgnoreCase("Country")){
                    jsonPath = String.format(Constants.JSONPATH_COUNTRY_NAME,value.trim());
                }else {
                    logger.debug("JSON path not found in the constants list");
                    flag = false;
                }

                if (!StringUtils.isEmpty(jsonPath)){
                    flag = JSONParser.isValueExistInJson(jsonString,jsonPath);
                }

            }else {
                logger.info("JSON string cannot be empty");
                flag = false;
            }
        }catch (Exception ex){
            logger.error("Error in finding value in JSON response");
            ex.printStackTrace();
        }finally {
            return flag;
        }
    }
}
