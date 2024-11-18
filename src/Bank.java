import java.text.DecimalFormat;

public class Bank {
    DecimalFormat dc1 = new DecimalFormat("#.00");
    double money;
    public Bank(double initialDeposit) {
        money = initialDeposit;
    }
    public void deposit(double depositValue) {
        money += depositValue;
    }
    public void withdraw(double cardCost) {
        money -= cardCost;
    }
    public String getBank() {
        return "You have $" + money + ", Keep winning!";
    }

}
