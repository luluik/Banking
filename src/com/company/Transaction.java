package com.company;

public class Transaction {
    String date;
    String currency;
    String operation;
    String amount;

    public Transaction(String date, String currency, String operation, String amount) {
        this.date = date;
        this.currency = currency;
        this.operation = operation;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date='" + date + '\'' +
                ", currency='" + currency + '\'' +
                ", operation='" + operation + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
