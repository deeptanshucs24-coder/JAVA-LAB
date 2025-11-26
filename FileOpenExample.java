
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileOpenExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter filename: ");
        String filename = input.nextLine();

        try {
            File file = new File(filename);
            Scanner reader = new Scanner(file);

            System.out.println("File contents:");
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }

            reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }
}
