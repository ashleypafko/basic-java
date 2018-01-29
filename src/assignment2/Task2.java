// Ashley Pafko 101210828
// SEIS 601
// Assignment Two, Task One
// Wednesday, September 20th, 2017
package assignment2;
// This program prompts the user to enter the day, month, and year of their 
// birthday. The program then displays the age of the person is the form of 
// years and months and days.
// For simplicity, this program assumes:
// 1 year = 365 days
// 1 month = 30 days

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        // Obtain the total milliseconds since Jan 1, 1970
        long totalMilliseconds = System.currentTimeMillis();
         
        // Obtain the total seconds
        long totalSeconds = totalMilliseconds / 1000;

        // Obtain the total minutes
        long totalMinutes = totalSeconds / 60;

        // Obtain total hours 
        long totalHours = totalMinutes / 60;
  
        // Obtain total days 
        long totalDays = totalHours / 24;
        
        // Add the days before Jan 1, 1970
        long currentDay = totalDays + (1970 * 365);
        long currentYear = currentDay / 365;

        // Obtain birthday from user input
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the year you were born (ex: 1995):");
        int  birthYear = input.nextInt();
        long userYear = currentYear - birthYear;
        
        System.out.println("Enter the month you were born (ex: 03):");
        int birthMonth = input.nextInt();
        
        System.out.println("Enter the day you were born (ex: 16):");
        int birthDay = input.nextInt();
        
        // Compute how many days the user has been alive 
        long daysAlive = (birthDay + (birthMonth * 30) + (userYear * 365));
        
        // find user age in the form of years, months, and days
        long ageYears = daysAlive / 365;
        int yearsR = (int) (daysAlive % 365);
        int ageMonths = yearsR / 12;
        int monthsR = yearsR%12;
        int ageDays = 30 - monthsR;
       
        //Display age of user
        System.out.println("You are " + ageYears + " years, " + ageMonths 
                + " months, and " + ageDays + " days old!");

    }
}
