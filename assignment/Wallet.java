public class Wallet {
    private final String walletId;
    private double balance;

    public Wallet(String walletId, double initialBalance) {
        this.walletId = walletId;
        this.balance = Math.max(0.0, initialBalance);
    }

    public String getWalletId() {
        return walletId;
    }

    public double getBalance() {
        return balance;
    }

    public void addFunds(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}