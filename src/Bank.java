import java.text.DecimalFormat;
/**
 * The Bank class represents a Bank. A Bank is a money storage mechanism with
 * money and methods to manipulate money.
 */

public class Bank {
    private DecimalFormat dc1 = new DecimalFormat("#.00");
    private double money;
    /**
     * Constructor for the Bank class.
     * This creates a new instance of the bank with the initial deposit.
     * @param initialDeposit  represents how much money the user starts out with.
     */
    public Bank(double initialDeposit) {
        money = initialDeposit;
    }
    /**
     * deposit method for the Person class. This method will return nothing
     * and only manipulate the money value by adding/depositing the
     * @param depositValue which is used when the user sells a Pokémon.
     */
    public void deposit(double depositValue) {
        money += depositValue;
    }
    /**
     * withdraw method for the Person class. This method will return nothing
     * and only manipulate the money value by deducting the
     * @param cardCost which is used when the user draws cards.
     * The cost per card is set in main.
     */
    public void withdraw(double cardCost) {
        money -= cardCost;
    }
    /**
     * The getBank method will help fetch all the money currently held in the bank.
     * There are no parameters
     * @return a double representing the money held at the bank
     */
    public double getBank() { return Double.parseDouble(dc1.format(money)); }
}
