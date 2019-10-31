/**
 * Problem Set 4.
 * 
 * It's time to put your skills to the test. This problem set focuses on using
 * iterative control structures. The `main` method is done for you. Lines 30-39
 * trigger each of the predefined methods, which you can think of as self-contained
 * executable pieces of logic. Write your code for each exercise in the
 * corresponding method.
 * 
 * The specifications for each exercise are outlined below. Your job is to write
 * lines of code to produce answers to my questions. Each exercise requires that
 * you ask the user to enter one or more values. Your code must meet the
 * requirements set forth in this section (as well as the *Deliverables* section).
 * 
 * Work through these exercises on your own. Experiment, make mistakes, ask
 * questions, and fix your mistakes. It's the only way to get good at programming.
 */

import java.util.Scanner;

public class ProblemSet4 {
    
    private static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        ProblemSet4 ps = new ProblemSet4();
        
        // comment out or uncomment as needed
        
        //ps.sum();
        //ps.reverse();
        //ps.digits();
        //ps.average();
        //ps.prime();
        // ps.fibonacci();
        // ps.factors();
         ps.mario();
        // ps.luigi();
        // ps.credit();
                
        in.close();
    }
    
    /*
     * Exercise 1.
     * 
     * Prompt the user to enter two integers. The first integer is a lower bound, and
     * the second integer is an upper bound.
     * 
     * Compute the sum of all even integers between the lower and upper bounds,
     * including the bounds themselves.
     */
    
    public void sum() {
        int lowBound;
        int upBound;
        int sum = 0;
        System.out.print("\n");
        do{
            System.out.print("Lower Bound: ");
            lowBound = in.nextInt();

            System.out.print("Upper Bound: ");
            upBound = in.nextInt();

        }while(upBound < lowBound);
        
        for(int x = upBound; x >= lowBound; x--){
            if(x % 2 == 0){
                sum += x;
            }
        }

        System.out.printf("\n%,d\n", sum);
    }
    
    /*
     * Exercise 2.
     * 
     * Prompt the user to enter a positive integer. Print the digits of this integer
     * in reverse order.
     */
    
    public void reverse() {
        int num = 0;

        do{
            System.out.print("\nPositive integer: ");
            num = in.nextInt();
        }while(num <= 0);

        String number = String.valueOf(num);
        char ind;
        System.out.print("\n");

        for(int x = (number.length()- 1); x >= 0 ; x--){
            ind = number.charAt(x);
            System.out.print(ind);
            if(x > 0){
                System.out.print(", ");
            }else{
                System.out.print(".\n");
            }
        }
    }
    
    /*
     * Exercise 3.
     * 
     * Prompt the user to enter a positive integer. Compute the sum of all of the odd
     * digits in the integer.
     */
    
    public void digits() {
        int input;
        int sum = 0;
        do{
            System.out.print("Positive integer: ");
            input = in.nextInt();            
        }while(input <= 0);

        String intToStr = String.valueOf(input);
        char indexNum; //number of the index
        int oddNum;
        
        for(int x = 0; x <= (intToStr.length()-1); x++){   
            indexNum = intToStr.charAt(x);
            oddNum = Character.getNumericValue(indexNum);      
            if(oddNum % 2 == 1){
                sum += oddNum;
            }
        }
        System.out.print("\n" + sum + ".");
    }
    
    /*
     * Exercise 4.
     * 
     * Prompt the user to enter a series of non-negative integers. When the user
     * enters a negative integer, you can assume he or she is done entering values.
     * What is the average of the values entered?
     */
    
    public void average() {
        int input;
        int counter = 0;
        double sum = 0;
        do{
            System.out.print("Non-negative integer: ");
            input = in.nextInt();
            if(input > 0){
                counter++;           
                sum += input;
            }    
        }while(input > 0);

        double avg = sum/counter; 
        System.out.printf("\n%,.2f\n", avg);
    }
    
    /*
     * Exercise 5.
     * 
     * Prompt the user to enter a non-negative integer. Is this number prime?
     */
    
    public void prime() {
            int num;
            do{
                System.out.print("Non-negative integer: ");
                num = in.nextInt();
            }while(num < 0);

            boolean test = false;
            for(int i = 2; i <= num/2; i++){
                if(num % i == 0){
                    test = true;
                    break;
                }
            }
            if(!test){
                System.out.print("\nPrime.\n");
            }else{
                System.out.print("\nNot Prime.\n");
            } 
    }
    
    /*
     * Exercise 6.
     * 
     * Prompt the user to enter a positive integer in the range [1, 92]. If the
     * integer the user enters is called n, what is the nth Fibonacci number?
     */
    
    public void fibonacci() {
        int num;
        int preNum = 0;
        int currentNum = 1;
        int nextNum = 1;

            do{
                System.out.print("Postive integer: ");
                num = in.nextInt();
            }while(num < 1 || num > 92);

            for(int x = 1; x < num; x++){
                nextNum = currentNum + preNum;
                preNum = currentNum;
                currentNum = nextNum;
            }
            System.out.printf("\n%d.\n", nextNum);
    }
    
    /*
     * Exercise 7.
     * 
     * Prompt the user to enter a positive integer. What are its factors?
     */
    
    public void factors() {
        int input;

        do{
            System.out.print("Positive integer: ");
            input = in.nextInt();
        }while(input < 1);

        System.out.printf("\n1, %d",input);

        for(int i = 2; i <= input/i; i++){
            if(input % i == 0){
                System.out.printf(", %d, %d",i, input/i);
            }
        }
        System.out.print(".\n");
    }
    
    /*
     * Exercise 8.
     * 
     * Prompt the user to enter an integer between 1 and 24 (inclusive). Print a Super
     * Mario-style half-pyramid of the specified height.
     */
    
    public void mario() {        
        int height; 
        int space = 0;

        do{
            System.out.print("\nHeight: " );
            height = in.nextInt();
        }while(height < 1 || height > 24);

        System.out.print("\n");

        for(int x = 1; x <= height; x++){

            for(int y = height - x; y > 0; y--){
                System.out.print(" ");
                space++;
            }
            for(int z = (height + 1) - space; z > 0; z--){
                System.out.print("#");
            }

            System.out.print("\n");
            space = 0;
        }

    }
    
    /*
     * Exercise 9.
     * 
     * Prompt the user to enter an odd integer between 1 and 24 (inclusive). Print a
     * Super Mario-style full pyramid of the specified height.
     */
    
    public void luigi() {
        int height;
        int space = 0;
        int hash = 0;
        
        do{
            System.out.print("Height: ");
            height = in.nextInt();
        }while(height < 1 || height > 24);

        for(int x = 1; x <= height; x++){
            
            for(int y = height - x; y > 0; y--){
                System.out.print(" ");
                space++;
            }

            for(int z = (height + 1) - space; z > 0; z--){
                System.out.print("#");
                hash++;
            }

            System.out.print(" ");

            for(int a = 0; a < hash; a++){
                System.out.print("#");
            }

            System.out.print("\n");
            space = 0;
            hash = 0;
        }

    }
    
    /*
     * Exercise 10.
     * 
     * Prompt the user to enter a credit card number (not a real one!). According to
     * Luhn's algorithm, is the credit card number valid?
     */
    
    public void credit() {
        
    }
}