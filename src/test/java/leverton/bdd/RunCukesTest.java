package leverton.bdd;

/**
 * Created by AnkitNigam on 07/04/2018.
 */

import leverton.common.driver.BrowserDriver;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.apache.log4j.PropertyConfigurator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.nio.file.Paths;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/leverton/bdd/"},
        glue = {"leverton.bdd"},
        plugin = { "pretty","html:target/cucumber-html-report", "json:target/cucumber.json" }
)

public class RunCukesTest {
    @BeforeClass
    public static void setup(){
        PropertyConfigurator.configure(Paths.get(".") + "/src/log4j.properties");
    }

    @AfterClass
    public static void teardown() {
        BrowserDriver.getDriver().close();
    }
}
