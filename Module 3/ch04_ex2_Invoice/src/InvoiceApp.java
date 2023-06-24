import java.text.NumberFormat;
import java.util.Objects;
import java.util.Scanner;

public class InvoiceApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice = "y";

        double subtotal = 0;
        double discountPercent = 0;
        while (!choice.equalsIgnoreCase("n")) {
            // get the input from the user
            System.out.print("Enter customer type (r/c/t): ");
            String customerType = sc.nextLine();

            System.out.print("Enter subtotal:   ");
            subtotal = Double.parseDouble(sc.nextLine());

            // get the discount percent
//            discountPercent = switch (customerType) {
//                case "r", "R" -> {
//                    if /*(subtotal >= 250)*/ (subtotal >= 500) {
//                        //yield .2;
//                        yield .3;
//                    } else if /*(subtotal >= 100)*/ (subtotal > 250 && subtotal < 500) {
//                        //yield .1;
//                        yield .25;
//                    } else {
//                        yield 0.0;
//                    }
//                }
//
//                case "t", "T" -> {
//                    if (subtotal >= 500) {
//                        yield .4;
//                    } else if (subtotal < 500) {
//                        yield .5;
//                    } else {
//                        yield .0;
//                    }
//                }
//
//                case "c", "C" -> .2;
//                default -> .2;

                //In scope
            if (customerType.equals("r") || customerType.equals("R")){
                if (subtotal >= 500) {
                    discountPercent = .3;
                } else if (subtotal > 250 && subtotal < 500) {
                    discountPercent = .25;
                } else discountPercent = 0.0;

            } else if(customerType.equals("t") || customerType.equals("T")) {
                if(subtotal >= 500) {
                    discountPercent = .4;
                } else discountPercent = .5;

            } else if (customerType.equals("c") || customerType.equals("C")) {
                discountPercent = .2;
            } else {
                discountPercent = .2;
            };

            // calculate the discount amount and round to 2 decimals
            double discountAmount = subtotal * discountPercent;
            discountAmount = Math.ceil(discountAmount * 100) / 100;

            // calculate the total
            double total = subtotal - discountAmount;

            // format and display the results
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            NumberFormat percent = NumberFormat.getPercentInstance();
            System.out.println(
                    "Discount percent: " + percent.format(discountPercent) + "\n"
                            + "Discount amount:  " + currency.format(discountAmount) + "\n"
                            + "Total:            " + currency.format(total) + "\n");

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
        }
    }
}
