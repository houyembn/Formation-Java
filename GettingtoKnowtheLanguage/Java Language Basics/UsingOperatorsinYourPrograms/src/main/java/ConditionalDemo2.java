class ConditionalDemo2 {

    public static void main(String[] args){
        int value1 = 1;
        int value2 = 2;
        int result;
        boolean someCondition = true;
        result = someCondition ? value1 : value2;

        System.out.println(result);
    }
}

// using the ternary operator (? :) to assign value1 to result if someCondition is true, otherwise assigns value2, and then prints the result.