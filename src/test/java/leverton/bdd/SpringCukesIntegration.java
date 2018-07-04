package leverton.bdd;

/**
 * Created by AnkitNigam on 07/04/2018.
 */

import leverton.common.Application;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = Application.class)
@ComponentScan(basePackages = {"leverton.common"})
@ContextConfiguration
public class SpringCukesIntegration {
}
