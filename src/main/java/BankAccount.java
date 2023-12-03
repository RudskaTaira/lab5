import java.math.BigDecimal;

public class BankAccount {
    private static int accountNumber = 0;
    private int ID;
    private String accountName;
    private BigDecimal balance = new BigDecimal("0.0");

    public BankAccount(String accountName,BigDecimal initialDeposit) {
        this.accountName = accountName;
        this.balance=initialDeposit;
        ID=++accountNumber;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) throws NegativeAmountException {

        if (balance.compareTo(amount) < 0)
        {
            throw new NegativeAmountException("U have insufficient funds on the card");
        } else {
            balance = balance.subtract(amount);
        }

    }

    public BigDecimal getBalance() {
        return balance;
    }
    public int getAccountNumber()
    {
        return ID;
    }
    public String getAccountSummary() {
        String str =accountName+" "+ID+" "+balance ;
        return str;
    }
}
