package ru.topacademy.javaqadiplom;

public class Account {
    protected int balance;
    protected int rate;

    public boolean pay(int amount) {
        if (amount <= balance) {
            balance -=amount; // Вычитаем сумму с баланса
        return true; // Платеж успешен
        }
        return false; // Недостаточно средств для платежа
    }

    public boolean add(int amount) {
        if (amount > 0) {
            balance += amount; // Увеличиваем баланс на сумму amount
            return true; // Операция пополнения успешна
        }
        return false;
    }

    public int yearChange() {
        return 0;
    }

    public int getBalance() {
        return balance;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
