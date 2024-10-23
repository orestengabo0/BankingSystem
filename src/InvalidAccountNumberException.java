public class InvalidAccountNumberException extends Exception{
    public InvalidAccountNumberException(){
        super("Account Number already exists choose another one.");
    }
}
