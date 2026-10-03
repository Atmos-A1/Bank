package Account;

public class Account {
    private int balance;
    private String pin;

    public Account(String pin) {
        this.pin = pin;
    }

    public int checkBalance(String userPin) {
        validate(userPin);
        return  balance;
    }

    private void validate(String userPin) {
        if(!pin.equals(userPin)){
            throw  new IllegalArgumentException("Invalid user pin");
        }
    }

    public void deposit(int amount) {
        isValid(amount);
        balance += amount;
    }

    private void isValid(int amount) {
        if(amount <= 0)throw  new IllegalArgumentException("Invalid amount");
    }

    public void withdraw(int amount) {
        isValid(amount);
        validateWithdraw(amount);
        balance -= amount;
    }

    private void validateWithdraw(int amount) {
        if(amount > balance)throw  new IllegalArgumentException("Invalid amount");
    }
}
