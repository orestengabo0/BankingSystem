import java.util.ArrayList;

public class Bank {
    private final ArrayList<Account> accounts;
    public Bank(){
        accounts = new ArrayList<>();
    }
    public void createAccount(String accountNumber, String accountHolder, int initialDeposit)
            throws InvalidAccountNumberException{
        for (var account : accounts){
            if(account.getAccountNumber().equals(accountNumber))
                throw new InvalidAccountNumberException();
        }
        Account newAccount = new Account(accountNumber, accountHolder, initialDeposit);
        accounts.add(newAccount);
        System.out.println("Account created successfully.");
    }
    public Account findAccount(String accountNumber){
        for(Account account : accounts){
            if (account.getAccountNumber().equals(accountNumber))
                return account;
        }
        return null;
    }
    public void listAccounts(){
        for (Account account : accounts){
            System.out.printf("| Account number: %s | Account holder: %s | Account Balance: %d |\n",
                    account.getAccountNumber(), account.getAccountHolder(), account.getBalance());
        }
    }
}
