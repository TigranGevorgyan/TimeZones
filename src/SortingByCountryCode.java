import java.util.Comparator;

/**
 * Created by Taron on 04/10/17.
 */
public class SortingByCountryCode implements Comparator<TimeZone> {
    @Override
    public int compare(TimeZone o1, TimeZone o2) {
        return o1.countryCode.compareTo(o2.countryCode);
    }
}
