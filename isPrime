import java.util.Scanner;

public class Rectangle {
    
    public static void main(String[] args) {
        
        // Create Scanner 
        Scanner input = new Scanner(System.in);
        
        // Get and store input
        System.out.println("Enter a number: ");
        int  a = input.nextInt();
        
        // Check if number is prime or not
        if (isPrime(a) == false) {
            System.out.println("Number is not prime.");
        } else {
            System.out.println("Number is prime.");
        }
        
    }
    
    // Method to check if a number is prime 
    public static boolean isPrime (int n) {
        boolean prime = true;
        int i = 2;
            while (prime != false && i <= n) {
                if (n % 2 == 0) {
                    prime = false;
                    break;
                } else {
                    prime = true;
                    i++;
                }
            }
            
        // Exception for number 2
        if (n == 2) {
            prime = true;
        }
        return prime;
    }
}
