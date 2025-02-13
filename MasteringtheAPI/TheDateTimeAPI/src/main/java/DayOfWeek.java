import java.time.*;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class DayOfWeek {
    public static void main(String[] args) {
        // printing the day
        /*System.out.printf("%s%n", DayOfWeek.MONDAY.plus(3));

        DayOfWeek dow = DayOfWeek.MONDAY;
        Locale locale = Locale.getDefault();
        System.out.println(dow.getDisplayName(TextStyle.FULL, locale));
        System.out.println(dow.getDisplayName(TextStyle.NARROW, locale));
        System.out.println(dow.getDisplayName(TextStyle.SHORT, locale));*/




        // printing the Month
        System.out.printf("%d%n", Month.FEBRUARY.maxLength());

        Month month = Month.AUGUST;
        Locale local = Locale.getDefault();
        System.out.println(month.getDisplayName(TextStyle.FULL, local));
        System.out.println(month.getDisplayName(TextStyle.NARROW, local));
        System.out.println(month.getDisplayName(TextStyle.SHORT, local));


       //The LocalDate Class: TemporalAdjuster to retrieve the first Wednesday after a specific date.
       /* LocalDate date = LocalDate.of(2000, Month.NOVEMBER, 20);
        TemporalAdjuster adj = TemporalAdjusters.next(DayOfWeek.WEDNESDAY);
        LocalDate nextWed = date.with(adj);
        System.out.printf("For the date of %s, the next Wednesday is %s.%n",
                date, nextWed);*/


        //The YearMonth Class : print information about the month FEBRUARY
        YearMonth date = YearMonth.now();
        System.out.printf("%s: %d%n", date, date.lengthOfMonth());

        YearMonth date2 = YearMonth.of(2010, Month.FEBRUARY);
        System.out.printf("%s: %d%n", date2, date2.lengthOfMonth());

        YearMonth date3 = YearMonth.of(2012, Month.FEBRUARY);
        System.out.printf("%s: %d%n", date3, date3.lengthOfMonth());


        //The MonthDay Class: using the isValidYear() method to determine if February 29 is valid for the year 2010.
        MonthDay dat = MonthDay.of(Month.FEBRUARY, 29);
        boolean validLeapYear = dat.isValidYear(2010);


        //The Year Class : using the isLeap() method to determine if the given year is a leap year.
        boolean validLeap = Year.of(2012).isLeap();

        //This class is used to represent date (month-day-year) together with time (hour-minute-second-nanosecond)
        System.out.printf("now: %s%n", LocalDateTime.now());

        System.out.printf("Apr 15, 1994 @ 11:30am: %s%n",
                LocalDateTime.of(1994, Month.APRIL, 15, 11, 30));

        System.out.printf("now (from Instant): %s%n",
                LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()));

        System.out.printf("6 months from now: %s%n",
                LocalDateTime.now().plusMonths(6));

        System.out.printf("6 months ago: %s%n",
                LocalDateTime.now().minusMonths(6));













    }
}
