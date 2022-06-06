package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //Menu
        Service service = new Service();
        System.out.println("Operation List:");
        System.out.println("A. Deposit");
        System.out.println("B. Withdrawal");
        System.out.println("C. Transfer");
        System.out.println("D. Check Balance");
        System.out.println("E. Check Transaction");
        System.out.println("F. Create an Account");
        System.out.println("G. Quit");


        Scanner input = new Scanner(System.in);
        String operation = "";
        do {
            //basic information
            System.out.println("Choose an operation:");
            operation = input.next();

            switch (operation) {
                case "A": {
                    System.out.println("----------This is a DEPOSIT operation----------");
                    System.out.println("User's Name: ");
                    String username = input.next();
                    System.out.println("Currency: ");
                    String currency = input.next();
                    System.out.println("Amount: ");
                    double money = input.nextDouble();
                    input.nextLine();
                    service.deposit(username, currency, money, "Deposit");
                    break;
                }
                case "B": {
                    System.out.println("----------This is a WITHDRAWAL operation----------");
                    System.out.println("User's Name: ");
                    String username = input.next();
                    System.out.println("Currency: ");
                    String currency = input.next();
                    System.out.println("Amount: ");
                    double money = input.nextDouble();
                    input.nextLine();
                    service.withdrawal(username, currency, money, "Withdrawal");
                    break;
                }
                case "C": {  //Beneficiary 收款人   remitter 汇款人
                    System.out.println("----------This is a TRANSFER operation----------");
                    System.out.println("Beneficiary's Name: ");
                    String username_in = input.next();
                    System.out.println("Remitter's Name: ");
                    String username_out = input.next();
                    System.out.println("Currency: ");
                    String currency = input.next();
                    System.out.println("Amount: ");
                    double money = input.nextDouble();
                    service.transfer(username_in, username_out, currency, money);
                    break;
                }
                case "D": {
                    System.out.println("----------This is a ACCOUNT DISPLAY operation----------");
                    System.out.println("User's Name: ");
                    String username = input.next();
                    service.printAccount(username);
                    break;
                }
                case "E": {
                    System.out.println("----------This is a TRANSACTION DISPLAY operation----------");
                    System.out.println("User's Name: ");
                    String username = input.next();
                    service.printTransaction(username);
                    break;
                }
                case "F": {
                    System.out.println("----------This is a CREAT ACCOUNT operation----------");
                    System.out.println("User's Name: ");
                    String username = input.next();
                    System.out.println("HKD Account: ");
                    double hkd = input.nextDouble();
                    //input.nextLine();
                    System.out.println("USD Account: ");
                    double usd = input.nextDouble();
                    //input.nextLine();
                    System.out.println("CNY Account: ");
                    double cny = input.nextDouble();
                    //input.nextLine();
                    service.create(username, hkd, usd, cny);
                    break;
                }
                case "G":
                    System.out.println("----------This is a QUIT operation----------");
                    break;
                default:
                    System.out.println("----------A WRONG OPTION!----------");
                    break;
            }
        } while (! operation.equals("G"));
        System.out.println("==========Thank you!==========");
    }
}
