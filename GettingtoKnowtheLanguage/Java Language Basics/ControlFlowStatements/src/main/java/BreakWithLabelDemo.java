//searching for the number 12 in a 2D array and prints its position (row, column) if found. If not found, it prints a message saying the number isn't in the array.
class BreakWithLabelDemo {
    public static void main(String[] args) {

        int[][] arrayOfInts = {
                {  32,   87,    3, 589 },
                {  12, 1076, 2000,   8 },
                { 622,  127,   77, 955 }
        };
        int searchfor = 12;

        int i;
        int j = 0;
        boolean foundIt = false;

        search:
        for (i = 0; i < arrayOfInts.length; i++) {
            for (j = 0; j < arrayOfInts[i].length;
                 j++) {
                if (arrayOfInts[i][j] == searchfor) {
                    foundIt = true;
                    break search;
                }
            }
        }

        if (foundIt) {
            System.out.println("Found " + searchfor + " at " + i + ", " + j);
        } else {
            System.out.println(searchfor + " not in the array");
        }
    }
}

//ligne et colonne