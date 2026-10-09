import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Student Grade Calculator ===");

        // 1. Get the number of subjects with validation
        int numSubjects = 0;
        while (true) {
            System.out.print("Enter the number of subjects: ");
            if (scanner.hasNextInt()) {
                numSubjects = scanner.nextInt();
                if (numSubjects > 0) {
                    break;
                }
                System.out.println("❌ Please enter a number greater than 0.");
            } else {
                System.out.println("❌ Invalid input. Please enter a valid integer.");
                scanner.next(); // clear invalid input
            }
        }

        double totalMarks = 0;
        double[] marks = new double[numSubjects];

        // 2. Input marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            while (true) {
                System.out.print("Enter marks obtained in Subject " + (i + 1) + " (out of 100): ");
                if (scanner.hasNextDouble()) {
                    double mark = scanner.nextDouble();
                    if (mark >= 0 && mark <= 100) {
                        marks[i] = mark;
                        totalMarks += mark;
                        break;
                    }
                    System.out.println("❌ Marks must be between 0 and 100.");
                } else {
                    System.out.println("❌ Invalid input. Please enter a numerical value.");
                    scanner.next(); // clear invalid input
                }
            }
        }

        // 3. Calculate Average Percentage
        double averagePercentage = totalMarks / numSubjects;

        // 4. Determine Letter Grade
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else if (averagePercentage >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }

        // 5. Display Results
        System.out.println("\n=================================");
        System.out.println("          RESULTS SUMMARY        ");
        System.out.println("=================================");
        System.out.println("Total Marks Obtained : " + totalMarks + " / " + (numSubjects * 100));
        System.out.printf("Average Percentage   : %.2f%%\n", averagePercentage);
        System.out.println("Corresponding Grade  : " + grade);
        System.out.println("=================================");

        scanner.close();
    }
}

