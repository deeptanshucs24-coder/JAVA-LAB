import mypackage.Addition;

public class MainClass {
    public static void main(String[] args) {
        Addition obj = new Addition();
        int result = obj.add(10, 20);
        System.out.println("The sum of two numbers is: " + result);
    }
}
