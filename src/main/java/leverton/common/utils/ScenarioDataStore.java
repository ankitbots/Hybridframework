package leverton.common.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AnkitNigam on 07/04/2018.
 */
@Component
public class ScenarioDataStore {
    private static Map<String, Object> scenarioDataStore;
    public ScenarioDataStore() {
        scenarioDataStore = new HashMap<>();
    }
    public static void put(String key, Object value){
        scenarioDataStore.put(key, value);
    }
    public static Object get(String key){
        return scenarioDataStore.get(key);
    }
}
