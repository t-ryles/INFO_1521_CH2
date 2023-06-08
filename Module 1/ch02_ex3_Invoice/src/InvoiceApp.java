import java.util.Scanner;

public class InvoiceApp {

    public static <Int> void main(String[] args) {
        // welcome the user to the program
        System.out.println("Welcome to the Invoice Total Calculator");
        System.out.println();  // print a blank line

        // create a Scanner object named sc
        Scanner sc = new Scanner(System.in);

        // perform invoice calculations until choice isn't equal to "y" or "Y"
        String choice = "y";
        int invoiceCount = 0;
        double invoiceAverage = 0.00;
        double averageDiscount = 0.00;

        while (choice.equalsIgnoreCase("y")) {
            // get the invoice subtotal from the user
            System.out.print("Enter subtotal:   ");
            String input = sc.nextLine();
            double subtotal = Double.parseDouble(input);

            // calculate the discount amount and total
            double discountPercent;
            if (subtotal >= 200) {
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
        if (choice.equalsIgnoreCase("N")) {
            String nMessage = "Number of invoices: " + invoiceCount + "\n"
                            + "Average invoice:  " + invoiceAverage + "\n"
                            + "Average discount:    " + averageDiscount + "\n";

            System.out.println(nMessage);
        }
    }
}