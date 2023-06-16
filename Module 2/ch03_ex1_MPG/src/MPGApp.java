import java.util.Scanner;
import java.text.NumberFormat;

public class MPGApp {

    public static void main(String[] args) {
        System.out.println("Welcome to the Miles Per Gallon calculator");
        System.out.println();  // print a blank line
        
        Scanner sc = new Scanner(System.in);
        String input;
        
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            System.out.print("Enter miles driven: ");
            input = sc.nextLine();
            double miles = Double.parseDouble(input);
            
            System.out.print("Enter gallons of gas used: ");
            input = sc.nextLine();
            double gallons = Double.parseDouble(input);

            //Untouched formatted mpg value
            double mpg = miles/gallons;
            //System.out.println(mpg);
            System.out.printf("Miles per gallon is " + mpg + ".\n");

            //Math.round mpg formatted value
            double mpgRounded = ( double ) Math.round( miles/gallons * 100) / 100 ;
            System.out.printf("Miles per gallon is " + mpgRounded + ".\n");

            //NumberFormat mpg value
            NumberFormat num =  NumberFormat.getNumberInstance();
            num.setMaximumFractionDigits(2);
            String mpgString = num.format(mpg);
            System.out.printf("Miles per gallon is " + mpgString + ".");

            System.out.println(); 
            
            System.out.print("Calculate another MPG? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
        }
    }
    
}
