public class AmountException extends Exception{
    public AmountException(){
        super("Amount cannot be zero or less.");
    }
}
