package leverton.common.action;

import leverton.common.context.IWebPageContext;
import leverton.common.utils.ScenarioDataStore;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by AnkitNigam on 07/04/2018.
 */

@Component
public class AbstractBaseAction {
    @Autowired
    protected IWebPageContext context;
    protected WebDriverWait wait;
    protected WebDriverWait shortWait;
    @Getter @Setter
    protected static String mainWindow;
    @Autowired
    protected ScenarioDataStore scenarioDataStore;

    @PostConstruct
    private void setWait(){
        this.wait = context.getWait();
    }
}
