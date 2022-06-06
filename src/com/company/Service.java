package com.company;
import com.company.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class Service {

    //record transaction information
    public Transaction record(String currency, String operation, String amount) {
        Date date_tran = new Date();
        String date = date_tran.toString();
        Transaction record = new Transaction(date, currency, operation, amount);
        return record;
    }

    //deposit  ---- Operation A
    public void deposit(String username, String currency, double money, String operation) {
        for (User user : Database.account) {
            if (user.getName().equals(username)) {
                switch (currency) {
                    case "hkd":
                        double hkd = user.getHkd();
                        user.setHkd(new BigDecimal(hkd + money).setScale(3, RoundingMode.HALF_UP).doubleValue());
                        break;
                    case "usd":
                        double usd = user.getUsd();
                        user.setUsd(new BigDecimal(usd + money).setScale(3, RoundingMode.HALF_UP).doubleValue());
                        break;
                    //你可以有任意数量的case语句
                    case "cny":
                        double cny = user.getCny();
                        user.setCny(new BigDecimal(cny + money).setScale(3, RoundingMode.HALF_UP).doubleValue());
                        break;
                    default:
                        System.out.println("Currency does not exist.");
                        return;
                }
                user.addTransaction(record(currency, operation, "+ " + money));
                return;
            }
        }
        System.out.println("The user '" + username + "' does not exist");
    }

    //withdrawal  ---- Operation B
    public boolean withdrawal(String username, String currency, double money, String operation) {
        for (User user : Database.account) {
            if (user.getName().equals(username)) {
                if(user.timeVerification()) {
                    User osl = Database.account.get(0);
                    //Set accuracy
                    double operateMoney = new BigDecimal(1.01 * money).setScale(3, RoundingMode.HALF_UP).doubleValue();
                    double handleFee = new BigDecimal(0.01 * money).setScale(3, RoundingMode.HALF_UP).doubleValue();
                    //choose currency
                    switch (currency) {
                        case "hkd":
                            double hkd = user.getHkd();
                            if (hkd < operateMoney) {
                                System.out.println("Insufficient Balance");
                                return false;
                            } else {
                                user.setHkd(new BigDecimal(hkd - operateMoney).setScale(3, RoundingMode.HALF_UP).doubleValue());
                                double hkdOsl = osl.getHkd();
                                osl.setHkd(new BigDecimal(hkdOsl + handleFee).setScale(3, RoundingMode.HALF_UP).doubleValue());
                            }
                            break;

                        case "usd":
                            double usd = user.getUsd();
                            if (usd < operateMoney) {
                                System.out.println("Insufficient Balance");
                                return false;
                            } else {
                                user.setUsd(new BigDecimal(usd - operateMoney).setScale(3, RoundingMode.HALF_UP).doubleValue());
                                double usdOsl = osl.getUsd();
                                osl.setUsd(new BigDecimal(usdOsl + handleFee).setScale(3, RoundingMode.HALF_UP).doubleValue());
                            }
                            break;

                        case "cny":
                            double cny = user.getCny();
                            if (cny < operateMoney) {
                                System.out.println("Insufficient Balance");
                                return false;
                            } else {
                                user.setCny(new BigDecimal(cny - operateMoney).setScale(3, RoundingMode.HALF_UP).doubleValue());
                                double cnyOsl = osl.getCny();
                                osl.setCny(new BigDecimal(cnyOsl + handleFee).setScale(3, RoundingMode.HALF_UP).doubleValue());
                            }
                            break;
                        default:
                            System.out.println("Currency does not exist.");
                            return false;
                    }
                    osl.addTransaction(record(currency, "Handling fee", "+ " + handleFee));
                    user.addTransaction(record(currency, operation, "- " + money));
                    user.addTransaction(record(currency, "Handling fee", "- " + handleFee));
                    return true;
                }else
                    System.out.println("Frequent operations, please wait for a while.");
                return false;
            }
        }
        System.out.println("The user '" + username + "' does not exist");
        return false;
    }

    //transfer  ---- Operation C
    public void transfer(String username_in, String username_out, String currency, double money) {
        boolean tag = withdrawal(username_out, currency, money, "Transfer Out");
        if (tag) {
            deposit(username_in, currency, money, "Transfer In");
        }else
            System.out.println("Operation Failed.");

    }

    //打印账户信息 print account  ---- Operation D
    public void printAccount(String name) {
        for (User user : Database.account) {
            if (user.getName().equals(name)) {
                System.out.println(name + "'s Account");
                System.out.println(user.toString());
                return;
            }
        }
        System.out.println("The user '" + name + "' does not exist");
    }

    //打印流水 print transaction records  ---- Operation E
    public void printTransaction(String name) {
        for (User user : Database.account) {
            if (user.getName().equals(name)) {
                System.out.println(name + "'s Transaction Records");
                for (Transaction transaction : user.getTransactions())
                    System.out.println(transaction.toString());
                return;
            }
        }
        System.out.println("The user '" + name + "' does not exist");
    }

    //create a user  ---- Operation F
    public void create(String name, double hkd, double usd, double cny) {
        for (User user : Database.account) {
            if (user.getName().equals(name)) {
                System.out.println("This username already exists");
                return;
            }
        }
        User user = new User(name, hkd, usd, cny);
        Database.account.add(user);
    }



}
