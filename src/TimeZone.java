import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Taron on 04/10/17.
 */
public class TimeZone {
    public int id;
    public String countryCode;
    public String timeZone;

    ArrayList<TimeZone> timeZoneArrayList;

    public TimeZone(){
        timeZoneArrayList = new ArrayList<>();
    }

    public TimeZone(int id, String timeZone, String countryCode) {
        this.id = id;
        this.timeZone = timeZone;
        this.countryCode = countryCode;
        timeZoneArrayList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public void createTimeZones() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("D:\\projects\\TimeZones\\src\\TimeZone.csv"));
        while (scanner.hasNext()){
            String[] strings = scanner.nextLine().split(",");
            for (int i = 0;i < strings.length; i++){
                for (int j = 0; j < strings[i].length(); j++){
                    if (strings[i].charAt(j) == '"')
                        strings[i] = strings[i].replace('"',' ').trim();
                }
            }
            timeZoneArrayList.add(new TimeZone(Integer.parseInt(strings[0]),strings[2],strings[1]));
        }
    }

    public void start() throws FileNotFoundException {
        createTimeZones();
        sortingByIndex();
    }

    public void sortingByIndex(){
        boolean correctIndex = true;
        System.out.println("Enter index for sorting.");
        System.out.println("0 sorting by country code, 1 sorting by time zone.");
        Scanner scanner = new Scanner(System.in);
        int sortingIndex = scanner.nextInt();
        switch (sortingIndex){
            case 0:
                System.out.println("Sorting by country code.");
                Collections.sort(timeZoneArrayList,new SortingByCountryCode());
                break;
            case 1:
                System.out.println("Sorting by time zone.");
                Collections.sort(timeZoneArrayList,new SortingByTimeZone());
                break;
            default:
                correctIndex = false;
                System.out.println("Fault index for sorting.");
                break;
        }
        if (correctIndex){
            for (TimeZone element : timeZoneArrayList)
                System.out.println(element);
        }
    }

    @Override
    public String toString() {
        return String.format("Id: %d, country code: %s, time zone: %s.",id,countryCode,timeZone);
    }
}
