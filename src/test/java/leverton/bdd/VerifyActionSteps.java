package leverton.bdd;

import leverton.common.action.VerifyAction;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by AnkitNigam on 07/04/2018.
 */
public class VerifyActionSteps {

    @Autowired
    private VerifyAction verifyAction;

    @Given("^\"([^\"]*)\" is displaying")
    public void verifyObjectExistsActionStep(String name) throws Exception {
        boolean flag = false;
        try {
            //Verify object available on page
            flag = verifyAction.verifyObjectExists(name);
            Assert.assertTrue("Unable to find the object: " + name, flag);
        } catch (AssertionError assertionError) {
            throw new Exception("Object not available", assertionError);
        } catch (Exception ex) {
            throw new Exception("Error in finding object: " + name, ex);
        }
    }


    @Then("^\"([^\"]*)\" as \"([^\"]*)\" displaying$")
    public void verifyTextDisplayingActionStep(String name, String value) throws Exception {
        boolean flag = false;
        try {
            flag = verifyAction.verifyTextDisplayingAction(name, value);
            Assert.assertTrue("Unable to find the find text: " + value, flag);
        } catch (AssertionError assertionError) {
            throw new Exception("Text not available", assertionError);
        } catch (Exception ex) {
            throw new Exception("Error in finding text: " + value, ex);
        }
    }

    @Then("^\"([^\"]*)\" as \"([^\"]*)\" available is response$")
    public void verifyValueAvailable(String query, String value) throws Exception {
        boolean flag = false;
        try {
            flag = verifyAction.verifyValueAvailableInJSONUsingJSONPathAction(query, value);
            Assert.assertTrue("Unable to find the find text: " + value, flag);
        } catch (AssertionError assertionError) {
            throw new Exception("Text " + value +" not available in response", assertionError);
        } catch (Exception ex) {
            throw new Exception("Error in finding text: " + value, ex);
        }
    }
}

