import CIE.*;
import SEE.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        // Arrays of objects
        External[] students = new External[n];
        Internals[] studentInternals = new Internals[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Entering details for Student " + (i + 1) + " ---");
            students[i] = new External();
            studentInternals[i] = new Internals();

            // Personal Details
            System.out.print("Enter USN: ");
            String usn = sc.next();
            System.out.print("Enter Name: ");
            String name = sc.next();
            System.out.print("Enter Semester: ");
            int sem = sc.nextInt();
            students[i].getPersonal(usn, name, sem);

            // Internal Marks
            int[] iMarks = new int[5];
            System.out.println("Enter Internal Marks for 5 courses:");
            for (int j = 0; j < 5; j++) iMarks[j] = sc.nextInt();
            studentInternals[i].getInternals(iMarks);

            // SEE Marks
            int[] sMarks = new int[5];
            System.out.println("Enter SEE Marks (out of 100) for 5 courses:");
            for (int j = 0; j < 5; j++) sMarks[j] = sc.nextInt();
            students[i].getExternal(sMarks);
        }

        // Display Final Marks
        System.out.println("\nFinal Marks of Students (Internal + SEE/2):");
        for (int i = 0; i < n; i++) {
            System.out.println("\nUSN: " + students[i].usn + " | Name: " + students[i].name);
            for (int j = 0; j < 5; j++) {
                double finalMark = studentInternals[i].internalMarks[j] + (students[i].seeMarks[j] / 2.0);
                System.out.println("Course " + (j + 1) + ": " + finalMark);
            }
        }
        sc.close();
    }
}