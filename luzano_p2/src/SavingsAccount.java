/*
    This program the balance of 2 savers
    with specified savings balance and
    interest rate
 */
public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    // Constructor method
    public SavingsAccount(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    // Calculates monthly interest then add it to sanvings balance
    public double calculateMonthlyInterest() {
        double monthly;
        monthly = (this.savingsBalance * annualInterestRate) / 12;
        return this.savingsBalance += monthly;
    }

    // Assigns new interst rate to annual interest rate
    public static void modifyInterestRate(double newInterest) {

        annualInterestRate = newInterest;
    }

}
