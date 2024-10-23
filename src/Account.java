public class Account {
    private final String accountNumber;
    private int balance;
    private final String accountHolder;

    public Account(String accountNumber, String accountHolder, int initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }
    public void deposit(int amount) throws AmountException{
        if(amount > 0 ){
            balance += amount;
            System.out.println();
            System.out.println("Deposit successfully done. " +
                    "You deposited: " + amount + " Your new balance is: " + balance);
        } else if (amount == 0) throw new AmountException();
    }
    public void withdraw(int amount) throws InsuffientBalanceException, AmountException{
        if(amount > 0 && amount < balance){
            balance -= amount;
            System.out.println();
            System.out.println("Withdraw successfully. Your new balance is: " + balance);
        }
        else if (amount > balance)
            throw new InsuffientBalanceException();
        else if (amount == 0) throw new AmountException();
    }
    public String getAccountHolder() {
        return accountHolder;
    }

    public int getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }


}
