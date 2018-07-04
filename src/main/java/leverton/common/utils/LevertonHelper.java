package leverton.common.utils;

import leverton.common.action.AbstractBaseAction;
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
public class LevertonHelper extends AbstractBaseAction {
    private static Logger logger = LoggerFactory.getLogger(LevertonHelper.class);

    //
    public List<Integer> getAutoAppRegistrationValues(String name){
        List<WebElement> elements = null;
        List<Integer> filteredValues = new LinkedList<>();
        try{
            logger.debug("Fetch all objects: " + name );
            elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(context.getElementLocator(name)));
            for (WebElement element: elements) {
                if (name.equalsIgnoreCase("FirstRegistration")) {
                    //Fetch year for the string
                    filteredValues.add(Integer.parseInt(element.getText().trim().replace("•\n", "")));
                }else if(name.equalsIgnoreCase("CarPrice")) {
                    //Fetch price for the string
                    filteredValues.add(Integer.parseInt(element.getText().replace(".", "").replace(" €", "").trim()));
                }
            }
        }catch (TimeoutException ex){
            logger.error("TimeoutException - Object not found: " + name);
        }catch (Exception e){
            logger.error("Error in fetching " + name + " and storing in the list");
            e.printStackTrace();
        }finally {
            return filteredValues;
        }
    }
}
