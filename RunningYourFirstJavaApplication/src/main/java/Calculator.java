//The average method calculates the average of an array, returning 0 if empty.
public class Calculator {

    public static double average(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        double avg = (double) sum / numbers.length;
        return avg;
    }
}

