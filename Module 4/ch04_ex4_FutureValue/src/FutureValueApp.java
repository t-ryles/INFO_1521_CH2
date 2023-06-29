import java.util.Scanner;
import java.text.NumberFormat;

public class FutureValueApp {

    public static void main(String[] args) {
        System.out.println("The Future Value Calculator\n");
        
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            // get the input from the user
            System.out.print("Enter monthly investment:   ");
            double monthlyInvestment = Double.parseDouble(sc.nextLine());

            //System.out.print("Enter yearly interest rate: ");
            //double interestRate = Double.parseDouble(sc.nextLine());

            System.out.print("Enter number of years:      ");
            int years = Integer.parseInt(sc.nextLine());

//            // convert yearly values to monthly values
//            double monthlyInterestRate = interestRate / 12 / 100;
//            int months = years * 12;
//
//            // use a for loop to calculate the future value
//            double futureValue = 0.0;
//            for (int i = 1; i <= months; i++) {
//                futureValue = (futureValue + monthlyInvestment) *
//                              (1 + monthlyInterestRate);
//            }
//
//            // format the result and display it to the user
//            NumberFormat currency = NumberFormat.getCurrencyInstance();
//            System.out.println("Future value:               "
//                    + currency.format(futureValue));
//            System.out.println();

            // Number format
            NumberFormat percent = NumberFormat.getPercentInstance();
            percent.setMaximumFractionDigits(1);
            NumberFormat currency = NumberFormat.getCurrencyInstance();

            // Year column header
            System.out.printf("%-5s", "Year");

            // Percent amount
            for ( double rate = 5.0; rate < 7.0; rate += .5) {
                System.out.printf("%12s", percent.format(rate/100));
            }

            for (int year = 1; year <= years; year++) {
                System.out.printf("\n%-5s", year);

                for (double rate = 5.0; rate < 7.0; rate += .5) {
                    int months = year * 12;
                    double monthIntRate = rate / 12 / 100;

                    double futureValue = 0;
                    for (int i = 1; i < months; i++) {
                        futureValue = (futureValue + monthlyInvestment) * (1 + monthIntRate);
                    }
                    System.out.printf("%12s", currency.format(futureValue));
                }
            }

            System.out.println();

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
        } // End of while loop
        System.out.println("Bye!");
    }
}
