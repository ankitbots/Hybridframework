package leverton.bdd;

import cucumber.api.java.en.Given;
import leverton.common.action.GetAction;
import leverton.common.utils.ScenarioDataStore;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by AnkitNigam on 7/4/2018.
 */
public class GetActionSteps {

    @Autowired
    private GetAction getAction;

    @Given("^User able to get \"([^\"]*)\"$")
    public void getActionStep(String endPoint) throws Exception {
        boolean flag = false;
        String jsonString = null;
        try{
            jsonString = getAction.getResponse(endPoint);
            ScenarioDataStore.put("RESPONSE_STRING",jsonString);
            flag = !StringUtils.isEmpty(jsonString) ? true: false;
            Assert.assertTrue("Unable to get valid response for request: " + endPoint , flag);
        }catch (AssertionError assertionError){
            throw new Exception("GET operation failed", assertionError);
        }catch (Exception ex){
            throw new Exception("Error GET operation", ex);
        }
    }
}
