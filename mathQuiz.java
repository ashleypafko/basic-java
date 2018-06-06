import java.io.PrintStream;
import java.util.Scanner;


public class Task3 {
    
    public static void main(String[] args) {
        
        // Display the header of the table 
        System.out.println("Main Menu");
        // Display table 
        System.out.printf("%-1d%-2s%-10s\n", 1, ":", "Addition");
        System.out.printf("%-1d%-2s%-10s\n", 2, ":", "Subtraction");
        System.out.printf("%-1d%-2s%-10s\n", 3, ":", "Multiplication");
        System.out.printf("%-1d%-2s%-10s\n", 4, ":", "Division");
        System.out.printf("%-1d%-2s%-10s\n", 5, ":", "Exit");

        // Create Scanner 
        Scanner input = new Scanner(System.in);
        
        // Get and store input
        System.out.println("Enter a number: ");
        int  x = input.nextInt();
        
        // Execute test
        while (x != 5) {

            // Addition
            if (x == 1) {
                // Generate two random numbers
                int a = (int)(Math.random() * 10);
                int b = (int)(Math.random() * 10);
                // Ask user the question
                System.out.print("What is " + a + " + " + b + "? ");
                int y = input.nextInt();
                int answer = a + b;
                // Check the answer
                if (y == answer) {
                    System.out.println("Correct");
                } else if (y != answer) {
                    System.out.println("Your answer is wrong. The correct "
                        + "answer is " + answer);
                    }
            }
            
            // Subtraction
            if (x == 2) {
                // Generate two random numbers
                int a = (int)(Math.random() * 10);
                int b = (int)(Math.random() * 10);       
                // Swap values if necessary
                if (a > b) {
                    // Ask user the question
                    System.out.print("What is " + a + " - " + b + "? ");
                    int y = input.nextInt();
                    int answer = a - b;
                    // Check the answer
                    if (y == answer) {
                        System.out.println("Correct");
                    } else if (y != answer) {
                    System.out.println("Your answer is wrong. The correct "
                        + "answer is " + answer);
                    }
                } else if (b > a) {
                    int temp = a;
                    a = b;
                    b = temp;
                    // Ask user the question
                    System.out.print("What is " + a + " - " + b + "? ");
                    int y = input.nextInt();
                    int answer = a - b;
                    // Check the answer
                    if (y == answer) {
                        System.out.println("Correct");
                    } else if (y != answer) {
                    System.out.println("Your answer is wrong. The correct "
                        + "answer is " + answer);
                    }
                }    
            }
            
            // Multiplication
            if (x == 3) {
                // Generate two random numbers
                int a = (int)(Math.random() * 10);
                int b = (int)(Math.random() * 10);
                // Ask user the question
                System.out.print("What is " + a + " * " + b + "? ");
                int y = input.nextInt();
                int answer = a * b;
                // Check the answer
                if (y == answer) {
                    System.out.println("Correct");
                } else if (y != answer) {
                    System.out.println("Your answer is wrong. The correct "
                        + "answer is " + answer);
                    }
            }
                        
            // Division
            if (x == 4) {
                // Generate two random numbers
                int a = (int)(Math.random() * 10);
                int b = 1 + (int)(Math.random() * 10);
                // Ask user the question
                System.out.print("What is " + a + " / " + b + "? ");
                int y = input.nextInt();
                int answer = a / b;
                // Check the answer
                if (y == answer) {
                    System.out.println("Correct");
                } else if (y != answer) {
                    System.out.println("Your answer is wrong. The correct "
                        + "answer is " + answer);
                    }
            }
            // Exit Program
            if (x == 5) {
                break;
        }
           
            // Display new table 
            System.out.println("Main Menu");
            System.out.printf("%-1d%-2s%-10s\n", 1, ":", "Addition");
            System.out.printf("%-1d%-2s%-10s\n", 2, ":", "Subtraction");
            System.out.printf("%-1d%-2s%-10s\n", 3, ":", "Multiplication");
            System.out.printf("%-1d%-2s%-10s\n", 4, ":", "Division");
            System.out.printf("%-1d%-2s%-10s\n", 5, ":", "Exit");

            // Get and store new input
            System.out.println("Enter a number: ");
            x = input.nextInt();
        }
    }
}
