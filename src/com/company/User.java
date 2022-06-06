package com.company;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class User {
    private String name = null;
    private double hkd = 0;
    private double usd = 0;
    private double cny = 0;
    private List<Transaction> transactions = new ArrayList<>();
    private Queue<Long> withdrawalQueue = new LinkedList<>();


    //Constructor and getter/setter methods
    public User() {

    }

    public User(String name, double hkd, double usd, double cny) {
        this.name = name;
        this.hkd = hkd;
        this.usd = usd;
        this.cny = cny;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHkd() {
        return hkd;
    }

    public void setHkd(double hkd) {
        this.hkd = hkd;
    }

    public double getUsd() {
        return usd;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    public double getCny() {
        return cny;
    }

    public void setCny(double cny) {
        this.cny = cny;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }


    // Functions
    @Override
    public String toString() {
        return "Balance{" +
                "name='" + name + '\'' +
                ", HKD Account=" + hkd +
                ", USD Account=" + usd +
                ", CNY Account" + cny +
                '}';
    }

    //record every transaction
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    //Check if the operations are frequent.
    public boolean timeVerification() {
        //count and time limit  (5 times per 300 seconds(5 min))
        int countLimit = 5;
        int timeLimit = 300;
        //timestamp 毫秒
        Long now = System.currentTimeMillis();
        int length = withdrawalQueue.size();

        if (length >= countLimit) {
            for (int i = 0; i < length; i++) {
                Long temp = withdrawalQueue.peek();
                Long duration = (now - temp) / 1000;
                if (duration > timeLimit)
                    withdrawalQueue.poll();
                else break;
            }
            if (withdrawalQueue.size() >= countLimit)
                return false;
        }
        withdrawalQueue.offer(now);
        return true;
    }


}
