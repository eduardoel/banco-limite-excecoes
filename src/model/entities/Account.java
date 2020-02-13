package model.entities;

import model.exception.DomainException;

public class Account {
    
    private Integer number;
    private String holder; //Titular
    private Double balance; //Saldo
    private Double withdrawLimit; //Limite Para retirada
    
    public Account() {
    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }
    //amount = montante
    public void deposit(Double amount) {
        balance += amount;
    }
    
    public void withdraw(Double amount) {
        if (amount > withdrawLimit) {
            throw new DomainException("The amount exceeds withdraw limit"); //O valor excede o limite de retirada
        }
        if (amount > balance) {
            throw new DomainException("Not enoug balance"); //Saldo insuficiente
        }
        balance -= amount;
    }
}
