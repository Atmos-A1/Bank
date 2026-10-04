package Bank;

import Account.Account;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private final List<Account> accounts = new ArrayList<>();

    public int getNumberOfCustomers() {
        return accounts.size();
    }

    public int createAccount(String pin) {
        Account account = new Account(pin);
        accounts.add(account);
        return accounts.size();
    }


    public int checkBalance(int accountNumber, String pin) {
        Account account = findAccount(accountNumber);
        return account.checkBalance(pin);

    }

    private Account findAccount(int accountNumber){
        validateAccountNumber(accountNumber < 1 || accountNumber > accounts.size(), "Account number not found");
        return accounts.get(accountNumber - 1);
    }

    public void deposit(int accountNumber, int amount) {
        Account account = findAccount(accountNumber);
        account.deposit(amount);
    }

    public void withdraw(int accountNumber, int amount, String pin) {
        Account account = findAccount(accountNumber);
        account.withdraw(amount, pin);
    }

    public void transfer(int senderAccount, int receiverAccount, int amount, String pin) {
        Account sourceAccount = findAccount(senderAccount);
        Account targetAccount = findAccount(receiverAccount);
        validateAccountNumber(sourceAccount == targetAccount, "cannot transfer to the same account");
        sourceAccount.withdraw(amount, pin);
        targetAccount.deposit(amount);
    }

    private static void validateAccountNumber(boolean sourceAccount, String message) {
        if (sourceAccount) {
            throw new IllegalArgumentException(message);
        }
    }
}
