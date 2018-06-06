public class Student {
    
    // Data fields
    private String lastName = "";
    private String firstName = "";
    private int test1 = 0;
    private int test2 = 0;
    private int test3 = 0;
    private double totalAvg = 0;
    private String letterGrade = "";
    
    // Constructors
    private Student() {}
    
    private Student(String newLastName, String newFirstName) {
        lastName = newLastName;
        firstName = newFirstName;
    }
    
    // Methods
    public int getTest1() {
        return test1;
    }
    
    public int setTest1(int testScore) {
        test1 = testScore;
        return test1;
    }
    
    public int getTest2() {
        return test2;
    }
    
    public int setTest2(int testScore) {
        test2 = testScore;
        return test2;
    }
    
    public int getTest3() {
        return test3;
    }
    
    public int setTest3(int testScore) {
        test3 = testScore;
        return test3;
    }
     
    public double setAvg(double newAvg) {
            return totalAvg = newAvg;
    }
    
    public double getAvg() {
        return totalAvg;
    }
    
    public String setGrade(String grade) {
            letterGrade = grade;
            return letterGrade;
    }
    
    public String getGrade() {
        return letterGrade;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getFirstName() {
        return firstName;
    }

    
    public static void main(String[] args) {

        // Array that holds the last names
        String[] lastNames = {"Sal1", "Sal2", "Sal3", "Sal4", "Sal5", "Sal6", 
        "Sal7", "Sal8", "Sal9", "Sal10"};
        
        // Array that holds the first names
        String[] firstNames = {"Has1", "Has2", "Has3", "Has4", "Has5", "Has6", 
        "Has7", "Has8", "Has9", "Has10"};
        
        // Array that holds Test 1 scores
        int[] test1Scores = {96, 73, 89, 83, 31, 77, 92, 87, 85, 45};
        
        // Array that holds Test 2 scores
        int[] test2Scores = {73, 89, 70, 63, 52, 87, 61, 83, 94, 97};
        
        // Array that holds Final Test scores
        int[] testFinalScores = {85, 69, 71, 30, 50, 94, 80, 91, 72, 67};
   
        // Create Array of Student objects 
        Student[] studentArray = new Student[10];
        
        for (int i = 0; i < studentArray.length; i++) {
            // declare variables and
            // Recieve all the student's information 
            String newLastName = lastNames[i];
            String newFirstName = firstNames[i];
            int newTest1 = test1Scores[i]; 
            int newTest2 = test2Scores[i];
            int newTest3 = testFinalScores[i];
            
            // Array of Students 
            studentArray[i] = new Student(newLastName, newFirstName);
            
            //Assign the information 
            studentArray[i].setTest1(newTest1);
            studentArray[i].setTest2(newTest2);
            studentArray[i].setTest3(newTest3);
            studentArray[i].setTest2(newTest2);
        }
        
        // Calls method to set the averages of each student 
        studentAvg(studentArray);

        // Calls method to calculate and print averages of all tests and class
        System.out.println();
        testAverage(studentArray);
        
        // Calls method to set the Letter grades of each student       
        letterGrade(studentArray);
        
        // Calls method to find student with highest average
        highestAverage(studentArray);
        
        // Calls method to find student with lowest average
        lowestAverage(studentArray);

        // Display entire class statistics
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.printf("%-10s%-10s%-10d%-10d%-10d%-10f%-10s\n", 
                    studentArray[i].getLastName(), 
                    studentArray[i].getFirstName(),
                    studentArray[i].getTest1(),
                    studentArray[i].getTest2(),
                    studentArray[i].getTest3(),
                    studentArray[i].getAvg(),
                    studentArray[i].getGrade());
        }      
    }
    
    public static void studentAvg(Student[] students) {
        for (int i = 0; i < 10; i++){
            double testFinal = (double)(students[i].getTest3() * .45);
            double test1 = 0;
            double test2 = 0;
            if (students[i].getTest1() >= students[i].getTest2()) {
                test1 = (double) (students[i].getTest1() * .30);
                test2 = (double) (students[i].getTest2() * .25);
            } else { 
                test2 = (double) (students[i].getTest1() * .30);
                test1 = (double) (students[i].getTest2() * .25);
            }
            
            double avg= 0;
            avg = test1 + test2 + testFinal;
            students[i].setAvg(avg);
        }
    }
    
    public static void letterGrade(Student[] students) {
        
        for (int i = 0; i < 10; i++){
            int score = 0;
            score = (int) students[i].getAvg();
            String grade = "";
            switch (score/10) {
                case 9 : grade = "A"; students[i].setGrade(grade); break;
                case 8 : grade = "B"; students[i].setGrade(grade); break;
                case 7 : grade = "C"; students[i].setGrade(grade); break;
                case 6 : grade = "D"; students[i].setGrade(grade); break;
                default : grade = "F"; students[i].setGrade(grade); break;
            }  
        }
    }
    
    public static void testAverage(Student[] students) {
        // Average for Test 1
        int sum1 = 0;
        for (int i = 0; i < 10; i++) {
            sum1 += students[i].getTest1();
        }
        System.out.println("The average for Test 1 is: " + sum1 / 10);
 
        // Average for Test 2
        int sum2 = 0;
        for (int i = 0; i < 10; i++) {
            sum2 += students[i].getTest2();
        }
        System.out.println("The average for Test 2 is: " + sum2 / 10);
        
        // Average for Test 3
        int sum3 = 0;
        for (int i = 0; i < 10; i++) {
            sum3 += students[i].getTest3();
        }
        System.out.println("The average for the Final Test is: " + sum3 / 10);
        
        // Class Average
        double sum4 = 0;
        for (int i = 0; i < 10; i++) {
            sum4 += students[i].getAvg();
        }
        System.out.println("The class average is: " + sum4 / 10);
    }
    
    public static void highestAverage(Student[] students) {
        double max = students[0].getAvg();
        int index = 0;
        for (int i = 1; i < 10; i++) {
            if (students[i].getAvg() > max) {
                max = students[i].getAvg();
                index = i;
            }
        }
        System.out.println("Highest Average: " + students[index].getLastName() + 
                " , " + students[index].getFirstName() + " , " + 
                students[index].getTest1() + " , " + 
                students[index].getTest2() + " , " + 
                students[index].getTest3() + " , " + students[index].getAvg() +
                " , " + students[index].getGrade());
    }
    
    public static void lowestAverage(Student[] students) {
        double min = students[0].getAvg();
        int index = 0;
        for (int i = 1; i < 10; i++) {
            if (students[i].getAvg() < min) {
                min = students[i].getAvg();
                index = i;
            }
        }
        System.out.println("Lowest Average: " + students[index].getLastName() + 
                " , " + students[index].getFirstName() + " , " + 
                students[index].getTest1() + " , " + 
                students[index].getTest2() + " , " + 
                students[index].getTest3() + " , " + students[index].getAvg() +
                " , " + students[index].getGrade());
    }
}
