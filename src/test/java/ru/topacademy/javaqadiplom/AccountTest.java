package ru.topacademy.javaqadiplom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account();
        account.setBalance(100);
        account.setRate(5);
    }

    @Test
    void testPay_SuccessfulPayment() {
        boolean result = account.pay(50);
        Assertions.assertTrue(result);
    }

    @Test
    void testPay_InsufficientFunds() {
        boolean result = account.pay(150);
        Assertions.assertFalse(result);
    }

    @Test
    void testPay_BalanceUpdated() {
        account.pay(50);
        Assertions.assertEquals(50, account.getBalance());
    }

    @Test
    void testAdd_SuccessfulDeposit() {
        boolean result = account.add(50);
        Assertions.assertTrue(result);
    }

    @Test
    void testAdd_InvalidAmount() {
        boolean result = account.add(-50);
        Assertions.assertFalse(result);
    }

    @Test
    void testAdd_BalanceUpdated() {
        account.add(50);
        Assertions.assertEquals(150, account.getBalance());
    }

    @Test
    void testYearChange() {
        int yearChange = account.yearChange();
        Assertions.assertEquals(0, yearChange);
    }

    @Test
    void testGetBalance() {
        int balance = account.getBalance();
        Assertions.assertEquals(100, balance);
    }

    @Test
    void testGetRate() {
        int rate = account.getRate();
        Assertions.assertEquals(5, rate);
    }

    @Test
    void testSetRate() {
        account.setRate(10);
        Assertions.assertEquals(10, account.getRate());
    }
}
