//searching for a specific number (12 in this case) within an array. If the number is found, it prints the index where it was found; if not, it prints that the number isn't in the array. The break exits the loop as soon as the number is found.
class BreakDemo {
    public static void main(String[] args) {

        int[] arrayOfInts =
                { 32, 87, 3, 589,
                        12, 1076, 2000,
                        8, 622, 127 };
        int searchfor = 12;

        int i;
        boolean foundIt = false;

        for (i = 0; i < arrayOfInts.length; i++) {
            if (arrayOfInts[i] == searchfor) {
                foundIt = true;
                break;
            }
        }

        if (foundIt) {
            System.out.println("Found " + searchfor + " at index " + i);
        } else {
            System.out.println(searchfor + " not in the array");
        }
    }
}
