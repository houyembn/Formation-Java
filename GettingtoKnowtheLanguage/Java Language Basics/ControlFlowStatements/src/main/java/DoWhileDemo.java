class DoWhileDemo {
    public static void main(String[] args){
        int count = 1;
        do {
            System.out.println("Count is: " + count);
            count++;
        } while (count < 11);
    }
}

//The DoWhileDemo uses a do-while loop to print the count from 1 to 10. The loop runs at least once, and then continues as long as the condition count < 11 is true.