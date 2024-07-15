package ru.topacademy.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void shouldNotCreateAccountWithNegativeBalance() {
        SavingAccount account = new SavingAccount(
                -2_000,
                -1_000,
                10_000,
                5
        );

        Assertions.assertEquals(2_000, account.getBalance());
    }


    @Test

    public void balanceNotChangeWhenPayFails(){
        SavingAccount account = new SavingAccount(1000, 100, 10000,5);

        account.pay(5000);

        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void yearChangeTest(){
        SavingAccount account = new SavingAccount(-1000,100,10000,15);

        int expected = 150;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }


}
