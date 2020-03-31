package org.tanberg.oving9;

public interface Account {

    void deposit(double amount) throws IllegalArgumentException;

    void withdraw(double amount) throws IllegalArgumentException, IllegalStateException;

    double getBalance();
}
