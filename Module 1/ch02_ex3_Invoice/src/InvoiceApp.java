import java.util.Scanner;


/*
* Taj-Hakeem Ryles
* INFO 1521 WW
* Invoice Application
* Jayson McCune
* June 7, 2023
*/

public class InvoiceApp {

    public static void main(String[] args) {
        // welcome the user to the program
        System.out.println("Welcome to the Invoice Total Calculator");
        System.out.println();  // print a blank line

        // create a Scanner object named sc
        Scanner sc = new Scanner(System.in);

        // Initializing choice variable to Y
        String choice = "y";

        // Initializing variables for later reference
        int invoiceCount = 0;
        double invoiceAverage = 0.00;
        double averageDiscount = 0.00;

        // perform invoice calculations until choice is equal to "N" or "n"
        while (!choice.equalsIgnoreCase("N")) {
            // get the invoice subtotal from the user
            System.out.print("Enter subtotal:   ");
            String input = sc.nextLine();
            double subtotal = Double.parseDouble(input);

            // calculate the discount amount and total
            double discountPercent;
            if(subtotal >= 500){
                discountPercent = .25;
            } else if (subtotal >= 200) {
                discountPercent = .2;
            } else if (subtotal >= 100) {
                discountPercent = .1;
            } else {
                discountPercent = 0.0;
            }
            double discountAmount = subtotal * discountPercent;
            double total = subtotal - discountAmount;

            // display the discount amount and total
            String message = "Discount percent: " + discountPercent + "\n"
                           + "Discount amount:  " + discountAmount + "\n"
                           + "Invoice total:    " + total + "\n";            
            System.out.println(message);

            //Updating variable with new amounts
            invoiceCount += 1;
            invoiceAverage = (total/invoiceCount);
            averageDiscount = (discountAmount/invoiceCount);

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
        }
        //Displaying information when N is entered
        if (choice.equalsIgnoreCase("N")) {
            String nMessage = "Number of invoices: " + invoiceCount + "\n"
                            + "Average invoice:    " + invoiceAverage + "\n"
                            + "Average discount:   " + averageDiscount + "\n";

            System.out.println(nMessage);
        }
    }
}