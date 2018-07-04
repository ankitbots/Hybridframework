package leverton.common.contants;

/**
 * Created by AnkitNigam on 07/04/2018.
 */
public class Constants {
    //General constants
    public static final long WAIT_TIMEOUT = 60;
    public static final long STALE_ELEMENT_WAIT_TIMEOUT = 60;
    public static final long NAVIGATION_WAIT_TIMEOUT = 30 ;

    //API endpoints
    public static final String ALLCOUNTRIES = "/rest/v1";


    //JSONPATH
    public static final String JSONPATH_COUNTRY_NAME = "name.findAll{a->a=='%s'}";
}
