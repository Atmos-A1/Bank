package AccountTest;


import Account.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class testAccount {

    private Account account;

    private String userPin;

    @BeforeEach
    public void setUp(){
        account = new Account(userPin = "1457");
    }

    @Test
    public void test_that_the_account_created_is_empty_and_the_balance_is_zero(){
        String inputedPin = "1457";
        account.checkBalance(inputedPin);
        assertEquals(0, account.checkBalance(inputedPin));
    }

    @Test

    public void test_that_the_account_does_not_show_the_balance_if_pin_is_incorrect(){
        String inputedPin = "1456";
        assertThrows(IllegalArgumentException.class, () -> account.checkBalance(inputedPin));
    }

    @Test

    public void test_that_when_I_deposit_5k_the_balance_changes(){
        String inputedPin = "1457";
        assertEquals(0, account.checkBalance(inputedPin));
        account.deposit(5_000);
        assertEquals(5_000, account.checkBalance(inputedPin));
    }

    @Test

    public void test_that_if_i_deposit_negative_amounts_no_deposit_happens(){
        String inputedPin = "1457";
        account.deposit(5_000);
        assertEquals(5_000, account.checkBalance(inputedPin));
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-5_000));
    }

    @Test

    public void test_that_deposit_of_zero_amounts_to_no_deposit(){
        account.deposit(4_000);
        assertEquals(4_000, account.checkBalance("1457"));
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
    }

    @Test

    public void test_that_deposit_of_correct_amount_twice_changes_the_balance(){
        String inputedPin = "1457";
        account.deposit(4_000);
        assertEquals(4_000, account.checkBalance(inputedPin));
        account.deposit(4_000);
        assertEquals(8_000, account.checkBalance(inputedPin));
    }

    @Test

    public void test_that_I_deposit_5k_and_withdraw_2k_successfully(){
        String inputedPin = "1457";
        account.deposit(5_000);
        assertEquals(5_000, account.checkBalance(inputedPin));
        account.withdraw(2_000);
        assertEquals(3_000, account.checkBalance(inputedPin));
    }

    @Test

    public void test_that_I_deposit_5k_and_withdraw_6k_unsuccessfully(){
        String inputedPin = "1457";
        account.checkBalance(inputedPin);
        account.deposit(5_000);
        assertEquals(5_000, account.checkBalance(inputedPin));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(6_000));
    }

    @Test

    public void test_that_I_deposit_5k_and_withdraw_5k_successfully(){
        String inputedPin = "1457";
        account.checkBalance(inputedPin);
        account.deposit(5_000);
        assertEquals(5_000, account.checkBalance(inputedPin));
        account.withdraw(5_000);
        assertEquals(0, account.checkBalance(inputedPin));
    }

    @Test

    public void test_that_withdrarwal_of_zero_is_not_successful(){
        String inputedPin = "1457";
        account.checkBalance(inputedPin);
        account.deposit(5_000);
        assertEquals(5_000, account.checkBalance(inputedPin));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0));
    }

    @Test

    public void test_that_withdrawal_of_a_negative_amount_is_unsuccessful(){
        String inputedPin = "1457";
        account.deposit(5_000);
        assertEquals(5_000, account.checkBalance(inputedPin));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-5_000));
    }

}
