import java.util.Scanner;

public class GCDApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the first number: ");
        int firstNumber = Integer.parseInt(sc.nextLine());

        System.out.print("Enter the second number: ");
        int secondNumber = Integer.parseInt(sc.nextLine());

        System.out.println("Iterative GCD...");
        int result = iterGCD(firstNumber, secondNumber);
        System.out.println(result);

        System.out.println("Recursive GCD...");
        result = recGCD(firstNumber, secondNumber);
        System.out.println(result);
        System.out.println();
    }    

    // iterative
    public static int iterGCD(int a, int b) {
        System.out.println("Iterative solution here...");

        while(b != 0) {
            int val = b;
            b = a % b;
            a = val;
         }
        return a;
    }

    // recursive
    public static int recGCD(int a, int b) {
        System.out.println("Recursive solution here...");


        return 0;
    }
}