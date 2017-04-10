import java.util.Comparator;

/**
 * Created by Taron on 04/10/17.
 */
public class SortingByTimeZone implements Comparator<TimeZone> {
    @Override
    public int compare(TimeZone o1, TimeZone o2) {
        return o1.timeZone.compareTo(o2.timeZone);
    }
}
