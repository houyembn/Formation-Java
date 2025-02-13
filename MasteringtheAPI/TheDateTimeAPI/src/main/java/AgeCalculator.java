import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class AgeCalculator {
    //calculating the age assuming that you were born on January 1, 1960
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1960, Month.JANUARY, 1);

        java.time.Period p = java.time.Period.between(birthday, today);
        long p2 = ChronoUnit.DAYS.between(birthday, today);

        System.out.println("You are " + p.getYears() + " years, " + p.getMonths() +
                " months, and " + p.getDays() +
                " days old. (" + p2 + " days total)");


        //To calculate how long it is until your next birthday
        LocalDate birth = LocalDate.of(1960, Month.JANUARY, 1);

        LocalDate nextBDay = birth.withYear(today.getYear());

// If your birthday has occurred this year already, add 1 to the year.
        if (nextBDay.isBefore(today) || nextBDay.isEqual(today)) {
            nextBDay = nextBDay.plusYears(1);
        }

        Period pp = Period.between(today, nextBDay);
        long pp2 = ChronoUnit.DAYS.between(today, nextBDay);
        System.out.println("There are " + pp.getMonths() + " months, and " +
                pp.getDays() + " days until your next birthday. (" +
                pp2 + " total)");

    }
}

