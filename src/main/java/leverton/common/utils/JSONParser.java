package leverton.common.utils;

import io.restassured.path.json.JsonPath;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by AnkitNigam on 7/4/2018.
 */
public class JSONParser {
    private static final Logger logger = LoggerFactory.getLogger(JSONParser.class);
    public static String getValueFromJSON(String jsonString, String jsonPath){
        String value = null;
        try{
            value = JsonPath.from(jsonString).get(jsonPath).toString().replace("[","").replace("]","");
            logger.debug(value + " found in JSON");
        }catch (Exception ex){
            logger.debug("Error in finding value in JSON response");
            ex.printStackTrace();
        }finally {
            return value;
        }
    }

    public static boolean isValueExistInJson(String jsonString, String jsonPath){
        boolean flag = false;
        logger.debug("Checking if path value exist in JSON string");
        try{
            if (!StringUtils.isEmpty(getValueFromJSON(jsonString, jsonPath))){
                logger.debug("Value available in JSON string");
                flag = true;
            }else {
                logger.debug("Value not found in JSON string");
            }
        }catch (Exception ex){
            logger.debug("Error in finding value in JSON response");
            ex.printStackTrace();
        }finally {
            return flag;
        }
    }
}
