package ru.topacademy.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    
    @Test
    public void testCreditAccountCreationWithZeroRate() {
        // Проверяет, что объект CreditAccount создается без исключений при нулевой процентной ставке.
        Assertions.assertDoesNotThrow(() -> new CreditAccount(1000, 5000, 0));
    }


    @Test
    // Метод pay должен возвращать false.
    public void testPayExceedingCreditLimitReturnsFalse() {
        CreditAccount account = new CreditAccount(1000, 5000, 10);
        boolean actual = account.pay(7000);
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    // Баланс не  должен изменятся.
    public void testPayExceedingCreditLimitBalanceUnchanged() {
        CreditAccount account = new CreditAccount(1000, 5000, 10);
        account.pay(7000);
        int actual = account.getBalance();
        int expected = 1000;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    // Метод add должен возвращать true при успешном добавлении суммы к балансу счета.
    public void testAddAmountToBalanceReturnsTrue() {
        CreditAccount account = new CreditAccount(1000, 5000, 10);
        boolean actual = account.add(500);
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    // Баланс должен увеличиватся на сумму добавления.
    public void testAddAmountToBalance() {
        CreditAccount account = new CreditAccount(1000, 5000, 10);
        account.add(500);
        int actual = account.getBalance();
        int expected = 1500;

        Assertions.assertEquals(expected, actual);
    }

    @Test
     // Метод yearChange должен возвращать 0 для положительного баланса при любой ставке.
    public void testYearChangeWithPositiveBalance() {
        CreditAccount account = new CreditAccount(200, 5000, 15);
        int actual = account.yearChange();
        int expected = 0;

        Assertions.assertEquals(expected, actual, "Метод yearChange должен возвращать 0 для положительного баланса при любой ставке");
    }
}
