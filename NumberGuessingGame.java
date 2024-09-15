
import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of subjects
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        // Array to store marks for each subject
        int[] marks = new int[numberOfSubjects];
        int totalMarks = 0;

        // Input marks for each subject
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.printf("Enter marks for subject %d (out of 100): ", i + 1);
            int mark = scanner.nextInt();
            
            // Validate that the marks are within the valid range
            while (mark < 0 || mark > 100) {
                System.out.println("Invalid input. Marks should be between 0 and 100.");
                System.out.printf("Re-enter marks for subject %d (out of 100): ", i + 1);
                mark = scanner.nextInt();
            }
            
            marks[i] = mark;
            totalMarks += mark;
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        // Determine the grade
        String grade;
        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Display results
        System.out.printf("\nTotal Marks: %d\n", totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.printf("Grade: %s\n", grade);

        scanner.close();
    }
}
