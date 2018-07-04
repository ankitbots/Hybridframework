package leverton.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;

/**
 * Created by AnkitNigam on 07/04/2018.
 */
public class SortHelper {
    private static final Logger logger = LoggerFactory.getLogger(SortHelper.class);
    public static <T extends Comparable<? super T>> boolean isSorted(List<T> list, String order) {
        if (list.size() != 0) {
            Iterator<T> it = list.iterator();
            T prev = null;
            while (it.hasNext()) {
                T item = it.next();
                if (order.equalsIgnoreCase("DESC")) {
                    if (prev != null && prev.compareTo(item) < 0) {
                        logger.info("Sorting failed");
                        logger.info("Previous: " + prev + " Current: " + item);
                        return false;
                    }
                } else if (order.equalsIgnoreCase("ASC")) {
                    if (prev != null && prev.compareTo(item) > 0) {
                        logger.info("Sorting failed");
                        logger.info("Previous: " + prev + " Current: " + item);
                        return false;
                    }
                }
                prev = item;
            }
        } else {
            throw new NullPointerException();
        }
        return true;
    }
}
