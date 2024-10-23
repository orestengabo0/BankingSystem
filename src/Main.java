import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to Bank Management System.");
        System.out.println("============================================");
        System.out.println("Take a look at our menu and take action.");
        while(running){
            System.out.println();
            System.out.println("1. Create Account.");
            System.out.println("2. Deposit.");
            System.out.println("3. Withdraw.");
            System.out.println("4. Check Balance.");
            System.out.println("5. List All Accounts.");
            System.out.println("6. Exit.");

            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();
            switch (input){
                case "1":
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    if(bank.findAccount(accountNumber) != null)
                        System.out.println("Account already exists. enter a different account number.");
                    else {
                        System.out.print("Enter your names: ");
                        String names = scanner.nextLine();
                        System.out.print("Enter your initial deposit: ");
                        int depositAmount = scanner.nextInt();
                        scanner.nextLine();
                        try{
                            bank.createAccount(accountNumber, names, depositAmount);
                        }catch (InvalidAccountNumberException ex){
                            System.out.println(ex.getMessage());
                        }
                    }
                    break;
                case "2":
                    System.out.print("Enter account number: ");
                    String accNumber = scanner.nextLine();
                    Account depositAccount = bank.findAccount(accNumber);
                    if(depositAccount != null){
                        System.out.print("Enter amount to deposit: ");
                        int depAmount = scanner.nextInt();
                        scanner.nextLine();
                        try{
                            depositAccount.deposit(depAmount);
                        }catch (AmountException ex){
                            System.out.println(ex.getMessage());
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case "3":
                    System.out.print("Enter account number: ");
                    String accNum = scanner.nextLine();
                    Account withdrawAccount = bank.findAccount(accNum);
                    if(withdrawAccount != null){
                        System.out.print("Enter amount to withdraw: ");
                        int withdrawAmount = scanner.nextInt();
                        scanner.nextLine();
                        try{
                            withdrawAccount.withdraw(withdrawAmount);
                        }catch(InsuffientBalanceException | AmountException ex){
                            System.out.println(ex.getMessage());
                        }
                    } else {
                        System.out.println();
                        System.out.println("Account not found.");
                    }
                    break;
                case "4":
                    System.out.print("Enter account number: ");
                    String accountNum = scanner.nextLine();
                    Account account = bank.findAccount(accountNum);
                    if(account != null){
                        System.out.println();
                        System.out.println("Your balance is: " + account.getBalance());
                        System.out.println();
                    } else {
                        System.out.println();
                        System.out.println("Account not found.");
                    }
                    break;
                case "5":
                    System.out.println("List of all bank accounts: ");
                    System.out.println("======================================");
                    bank.listAccounts();
                    break;
                case "6":
                    System.out.println("Exiting program.....");
                    running = false;
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid choice... Please enter a valid choice.");
            }
        }
    }
}
