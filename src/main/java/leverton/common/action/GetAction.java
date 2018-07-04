package leverton.common.action;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import leverton.common.contants.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;




/**
 * Created by AnkitNigam on 7/4/2018.
 */
@Component
public class GetAction {
    private static final Logger logger = LoggerFactory.getLogger(GetAction.class);

    public String getResponse(String endPoint) {
        logger.info("GET the response for " + endPoint);
        String baseUrl = System.getProperty("apiURL");
        String jsonString = null;
        Response response = null;
        try {
            if (!StringUtils.isEmpty(baseUrl)) {

                //Finding endpoint based on the value passed in test case
                if (endPoint.equalsIgnoreCase("All_Countries")) {
                    endPoint = Constants.ALLCOUNTRIES;
                } else {
                    logger.info("Endpoint: " + endPoint + " not found in Contants list");
                    endPoint = null;
                }

                if (!StringUtils.isEmpty(endPoint)) {
                    //Concatenate base url with endpoint
                    String url = baseUrl + endPoint;
                    response = given()
                            .get(url);
                    if (response.statusCode() == HttpStatus.SC_OK) {
                        logger.debug("Response successfully fetched");
                        jsonString = response.getBody().asString();
                    } else if (response.statusCode() == HttpStatus.SC_BAD_REQUEST) {
                        logger.debug("Bad request");
                    } else {
                        logger.info("Request failed with status code: " + response.statusCode());
                    }
                }


            } else {
                logger.debug("Base url cannot be blank");
            }

        } catch (Exception ex) {
            logger.debug("Error in GET response");
            ex.printStackTrace();

        } finally {
            return jsonString;
        }
    }
}
