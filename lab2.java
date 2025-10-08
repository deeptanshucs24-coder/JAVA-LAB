import java.util.Scanner;

class Student {
    String usn;
    String name;
    int[] credits;
    int[] marks;

    // Constructor
    Student(String usn, String name, int[] credits, int[] marks) {
        this.usn = usn;
        this.name = name;
        this.credits = credits;
        this.marks = marks;
    }

    // Method to calculate grade point based on marks
    int getGradePoint(int marks) {
        if (marks >= 90)
            return 10;
        else if (marks >= 80)
            return 9;
        else if (marks >= 70)
            return 8;
        else if (marks >= 60)
            return 7;
        else if (marks >= 50)
            return 6;
        else if (marks >= 45)
            return 5;
        else if (marks >= 40)
            return 4;
        else
            return 0;
    }

    // Method to calculate SGPA
    double calculateSGPA() {
        int totalCredits = 0;
        int totalCreditPoints = 0;

        for (int i = 0; i < marks.length; i++) {
            int gradePoint = getGradePoint(marks[i]);
            totalCreditPoints += gradePoint * credits[i];
            totalCredits += credits[i];
        }

        return (double) totalCreditPoints / totalCredits;
    }

    // Display details
    void display() {
        System.out.println("\n--- Student Details ---");
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        System.out.println("SGPA: " + String.format("%.2f", calculateSGPA()));
    }
}

public class lab2 {
    // ✅ Correct main method signature and class name
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student USN: ");
        String usn = sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();

        int[] credits = new int[n];
        int[] marks = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter credits for subject " + (i + 1) + ": ");
            credits[i] = sc.nextInt();
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }

        Student s = new Student(usn, name, credits, marks);
        s.display();

        sc.close();
    }
}
