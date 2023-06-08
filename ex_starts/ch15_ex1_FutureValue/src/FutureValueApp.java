public class FutureValueApp {

    public static void main(String[] args) {
        
        // display a welcome message
        System.out.println("Welcome to the Future Value Calculator");
        System.out.println();

        // perform 1 or more calculations
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {

            // get the input from the user
            System.out.println("DATA ENTRY");
            double monthlyInvestment = Console.getDouble(
                "Enter monthly investment: ", 0, 1000);
            double interestRate = Console.getDouble(
                "Enter yearly interest rate: ", 0, 30);
            int years = Console.getInt(
                "Enter number of years: ", 0, 100);
            System.out.println();

            // create FutureValue object
            FutureValue fv = new FutureValue(
                    monthlyInvestment, interestRate, years);

            // print the results
            System.out.println("FORMATTED RESULTS\n" 
              + "Monthly investment:   " + fv.getMonthlyInvestmentFormatted() + "\n"
              + "Yearly interest rate: " + fv.getInterestRateFormatted() + "\n"
              + "Number of years:      " + fv.getYears() + "\n"
              + "Future value:         " + fv.getFutureValueFormatted() + "\n");

            // see if the user wants to continue
            choice = Console.getString("Continue? (y/n): ");
            System.out.println();
        }        
    }
}