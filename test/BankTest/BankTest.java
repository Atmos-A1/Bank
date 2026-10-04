package BankTest;

import Bank.Bank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankTest {

    private Bank bank;

    @BeforeEach

    public void setUp(){
        bank = new Bank();
    }

    @Test

    public void test_that_a_new_bank_has_zero_accounts(){
        bank.getNumberOfCustomers();
        assertEquals(0, bank.getNumberOfCustomers());
    }

    @Test

    public void test_that_when_an_account_can_be_created_and_number_of_accounts_increases(){
        bank.getNumberOfCustomers();
        assertEquals(0, bank.getNumberOfCustomers());
        bank.createAccount("1457");
        assertEquals(1, bank.getNumberOfCustomers());
    }

    @Test

    public void test_that_two_accounts_can_be_created_and_number_of_accounts_increases(){
        assertEquals(0, bank.getNumberOfCustomers());
        bank.createAccount("1457");
        assertEquals(1, bank.getNumberOfCustomers());
        bank.createAccount("1459");
        assertEquals(2, bank.getNumberOfCustomers());
    }

    @Test
    public void test_that_an_account_can_be_deposited_in_after_creation(){
        bank.getNumberOfCustomers();
        assertEquals(0, bank.getNumberOfCustomers());
        bank.createAccount("1457");
        assertEquals(0, bank.checkBalance(1,"1457"));
    }

    @Test

    public void test_that_a_non_existing_account_cannot_be_accessed(){
        assertEquals(0, bank.getNumberOfCustomers());
        bank.createAccount("1459");
        assertEquals(1, bank.getNumberOfCustomers());
        assertThrows(IllegalArgumentException.class, () -> bank.checkBalance(0,"1459"));
    }

    @Test

    public void test_that_an_account_balance_cannot_be_accessed_with_the_wrong_pin(){
        assertEquals(0, bank.getNumberOfCustomers());
        bank.createAccount("1457");
        assertThrows(IllegalArgumentException.class, () -> bank.checkBalance(1,"1458"));
    }

    @Test

    public void test_that_an_account_that_exists_can_be_deposited_into(){
        assertEquals(0, bank.getNumberOfCustomers());
        bank.createAccount("1457");
        bank.deposit(1, 5_000);
        assertEquals(5_000, bank.checkBalance(1,"1457"));
    }

    @Test

    public void test_that_an_account_that_exists_can_be_deposited_into_after_creation_and_withdrawn_from(){
        assertEquals(0, bank.getNumberOfCustomers());
        bank.createAccount("1457");
        bank.deposit(1, 5_000);
        assertEquals(5_000, bank.checkBalance(1,"1457"));
        bank.withdraw(1,2_000, "1457");
        assertEquals(3_000,  bank.checkBalance(1,"1457"));
    }
}