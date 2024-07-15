package ru.topacademy.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {


    // Проверяет, что нельзя добавить сумму, превышающую максимальный баланс
    @Test
    public void shouldNotAddAboveMaxBalance() {
        SavingAccount account = new SavingAccount(9000, 1000, 10000, 5);

        boolean result = account.add(2000);

        Assertions.assertFalse(result);
    }

    @Test
    public void shouldNotAddAboveMaxBalanceUnchanged() {
        SavingAccount account = new SavingAccount(9000, 1000, 10000, 5);

        account.add(2000);

        Assertions.assertEquals(9000, account.getBalance());
    }

    // Проверяет, что нельзя оплатить сумму, превышающую баланс
    @Test
    public void shouldNotPayAboveBalance() {
        SavingAccount account = new SavingAccount(1000, 100, 10000, 5);

        boolean result = account.pay(1500);

        Assertions.assertFalse(result);
    }

    @Test
    public void shouldNotPayAboveBalanceUnchanged() {
        SavingAccount account = new SavingAccount(1000, 100, 10000, 5);

        account.pay(1500);

        Assertions.assertEquals(1000, account.getBalance());
    }

    // Проверяет, что нельзя создать аккаунт с отрицательной процентной ставкой
    @Test
    public void shouldNotCreateWithNegativeRate() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(2000, 1000, 10000, -5);
        });

        Assertions.assertEquals("Накопительная ставка не может быть отрицательной, а у вас: -5", exception.getMessage());
    }

    // Проверяет, что нельзя создать аккаунт с минимальным балансом, превышающим максимальный баланс
    @Test
    public void shouldNotCreateWithMinHigherThanMax() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(2000, 10000, 1000, 5);
        });

        Assertions.assertEquals("Минимальный баланс не может быть больше максимального, а у вас: 10000 > 1000", exception.getMessage());
    }

    // Проверяет, что нельзя создать аккаунт с начальным балансом, меньшим минимального баланса
    @Test
    public void shouldNotCreateInitialLessThanMin() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(500, 1000, 10000, 5);
        });

        Assertions.assertEquals("Начальный баланс не может быть меньше минимального баланса, а у вас: 500", exception.getMessage());
    }

    // Проверяет, что нельзя создать аккаунт с начальным балансом, превышающим максимальный баланс
    @Test
    public void shouldNotCreateInitialHigherThanMax() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(15000, 1000, 10000, 5);
        });

        Assertions.assertEquals("Начальный баланс не может быть больше максимального баланса, а у вас: 15000", exception.getMessage());
    }

     @Test
    public void testMinBalanceNegative() {
        // Проверяет, что конструктор выбрасывает IllegalArgumentException для отрицательного минимального баланса
        IllegalArgumentException thrown = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    SavingAccount account = new SavingAccount(1000, -10, 5000, 5);
                },
                "Ожидалось IllegalArgumentException для отрицательного минимального баланса"
        );

        // Проверяет, что сообщение об ошибке совпадает с ожидаемым
        Assertions.assertEquals(
                "Минимальный баланс не может быть отрицательным, а у вас: -10",
                thrown.getMessage(),
                "Сообщение об ошибке должно совпадать"
        );
    }

    @Test
    // Проверяет, что метод возвращает false, если сумма отрицательная
    public void testPayAmountNegative() {
        SavingAccount account = new SavingAccount(1000, 100, 5000, 5);

        Assertions.assertFalse(account.pay(-100), "Ожидалось false для отрицательной суммы");
    }

    @Test
    // Проверяет, что метод возвращает false, если сумма равна нулю
    public void testPayAmountZero() {
        SavingAccount account = new SavingAccount(1000, 100, 5000, 5);

        Assertions.assertFalse(account.pay(0), "Ожидалось false для суммы, равной нулю");
    }

    @Test
    public void testYearChange() {
        // Проверяет, что метод yearChange правильно рассчитывает годовое изменение баланса
        SavingAccount account = new SavingAccount(1000, 100, 5000, 5);
        int expectedYearChange = (1000 * 5) / 100;
        Assertions.assertEquals(expectedYearChange, account.yearChange(), "Метод yearChange должен правильно рассчитывать годовое изменение баланса.");
    }

    @Test
    public void testGetMinBalance() {
        // Проверяет, что метод getMinBalance возвращает правильное значение минимального баланса
        SavingAccount account = new SavingAccount(1000, 100, 5000, 5);
        Assertions.assertEquals(100, account.getMinBalance(), "Метод getMinBalance должен возвращать правильное значение минимального баланса.");
    }

    @Test
    public void testGetMaxBalance() {
        // Проверяет, что метод getMaxBalance возвращает правильное значение максимального баланса
        SavingAccount account = new SavingAccount(1000, 100, 5000, 5);
        Assertions.assertEquals(5000, account.getMaxBalance(), "Метод getMaxBalance должен возвращать правильное значение максимального баланса.");
    }

    @Test
    // Проверяет, что баланс уменьшается на сумму оплаты
    public void testPayReducesBalance() {
        SavingAccount account = new SavingAccount(1000, 100, 5000, 5);
        account.pay(200);
        Assertions.assertEquals(800, account.getBalance(), "Баланс должен уменьшиться на сумму оплаты.");
    }

    @Test
    // Проверяет, что метод возвращает true при успешной оплате
    public void testPayReturnsTrue() {
        SavingAccount account = new SavingAccount(1000, 100, 5000, 5);
        boolean result = account.pay(200);
        Assertions.assertTrue(result, "Метод должен вернуть true при успешной оплате.");
    }

    @Test
    // Проверяет, что метод возвращает false при добавлении отрицательной суммы
    public void testAddReturnsFalseForNegativeAmount() {
        SavingAccount account = new SavingAccount(1000, 100, 5000, 5);
        boolean result = account.add(-200);
        Assertions.assertFalse(result, "Метод должен вернуть false при добавлении отрицательной суммы.");
    }

    @Test
    // Проверяет, что баланс увеличивается на сумму добавления
    public void testAddIncreasesBalance() {
        SavingAccount account = new SavingAccount(1000, 100, 5000, 5);
        account.add(200);
        Assertions.assertEquals(1200, account.getBalance(), "Баланс должен увеличиться на сумму добавления.");
    }

    @Test
    // Проверяет, что метод возвращает true при успешном добавлении
    public void testAddReturnsTrue() {
        SavingAccount account = new SavingAccount(1000, 100, 5000, 5);
        boolean result = account.add(200);
        Assertions.assertTrue(result, "Метод должен вернуть true при успешном добавлении.");
    }
}
