public class Application {
    public static void main(String[] args) {
        int i;
        double balance;
        // Instantiates 2 objects to SavingsAccount
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);

        // modify interest rate to 4%
        saver1.modifyInterestRate(0.04);

        // Printing balance of saver 1 for each month
        System.out.println("Balance of Saver 1 with 4% Interest Rate");
        for(i = 0; i < 12; i++) {
            balance = saver1.calculateMonthlyInterest();
            System.out.print("Month " + (i + 1));
            System.out.printf(" $%.2f\n", balance);
        }

        // Printing balance of saver 2 for each month
        System.out.println("\nBalance of Saver 2 with 4% Interest Rate");
        for(i = 0; i < 12; i++) {
            balance = saver2.calculateMonthlyInterest();
            System.out.print("Month " + (i + 1));
            System.out.printf(" $%.2f\n", balance);
        }

        // modify interest rate to 5%
        saver1.modifyInterestRate(0.05);
        saver2.modifyInterestRate(0.05);

        // Printing the balance of saver 1 and 2 for the next month
        System.out.println("\nInterest Rate of 5%");
        System.out.printf("Saver 1's balance for the next month is $%.2f", saver1.calculateMonthlyInterest());
        System.out.printf("\nSaver 2's balance for the next month is $%.2f", saver2.calculateMonthlyInterest());

    }
}

