import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.time.chrono.Chronology;
import java.time.chrono.HijrahChronology;
import java.time.chrono.IsoChronology;
import java.time.chrono.JapaneseChronology;
import java.time.chrono.MinguoChronology;
import java.time.chrono.ThaiBuddhistChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DecimalStyle;
import java.time.format.FormatStyle;
import java.util.Locale;

public class NonISOBasedDate {

    /**
     * Converts a LocalDate (ISO) value to a ChronoLocalDate date
     * using the provided Chronology, and then formats the
     * ChronoLocalDate to a String using a DateTimeFormatter with a
     * SHORT pattern based on the Chronology and the current Locale.
     *
     * @param localDate - the ISO date to convert and format.
     * @param chrono - an optional Chronology. If null, then IsoChronology is used.
     */
    public static String toString(LocalDate localDate, Chronology chrono) {
        if (localDate != null) {
            Locale locale = Locale.getDefault(Locale.Category.FORMAT);
            if (chrono == null) {
                chrono = IsoChronology.INSTANCE;
            }
            try {
                return DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
                        .withLocale(locale)
                        .withChronology(chrono)
                        .withDecimalStyle(DecimalStyle.of(locale))
                        .format(chrono.date(localDate));
            } catch (DateTimeException ex) {
                System.err.println("Error: " + ex);
                return "";
            }
        } else {
            return "";
        }
    }


        public static void main(String[] args) {
            LocalDate date = LocalDate.of(1996, Month.OCTOBER, 29);

            // Print using Japanese Chronology
            System.out.println("Japanese Chronology: " + NonISOBasedDate.toString(date, JapaneseChronology.INSTANCE));

            // Convert using different non-ISO chronologies
            System.out.printf("Minguo Chronology: %s%n", NonISOBasedDate.toString(date, MinguoChronology.INSTANCE));
            System.out.printf("Thai Buddhist Chronology: %s%n", NonISOBasedDate.toString(date, ThaiBuddhistChronology.INSTANCE));
            System.out.printf("Hijrah Chronology: %s%n", NonISOBasedDate.toString(date, HijrahChronology.INSTANCE));

    }   }
