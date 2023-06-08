import java.text.NumberFormat;

public class FutureValue {    
    private double monthlyInvestment;
    private double interestRate;
    private int years;
    
    public FutureValue(double monthlyInvestment, double interestRate, int years)  {
        this.monthlyInvestment = monthlyInvestment;
        this.interestRate = interestRate;
        this.years = years;        
    }

    public double getFutureValue() {
        int months = years * 12;
        double monthlyInterestRate = interestRate / 12 / 100;
        double futureValue = 0;
        for (int i = 1; i <= months; i++) {
            futureValue =
                (futureValue + monthlyInvestment) *
                (1 + monthlyInterestRate);
        }
        return futureValue;
    }
    
    public String getMonthlyInvestmentFormatted() {
        return NumberFormat.getCurrencyInstance()
                           .format(monthlyInvestment);
    }        

    public String getInterestRateFormatted() {
        var percent = NumberFormat.getPercentInstance();
        percent.setMinimumFractionDigits(1);
        return percent.format(interestRate/100);
    }
    
    public int getYears() {
        return this.years;
    }
    
    public String getFutureValueFormatted() {
        return NumberFormat.getCurrencyInstance()
                           .format(getFutureValue());
    }    
}