package com.endava;

import javafx.util.Pair;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

public class MenuCreator {

    private ConnectionHandler connectionHandler;
    private Scanner scanner;

    public MenuCreator(ConnectionHandler con, Scanner scanner) {
        this.connectionHandler = con;
        this.scanner = scanner;
    }

    private int cashMenu(Scanner sc, int balance) {
        String answer;

        do {
            System.out.println();
            System.out.println("Insert money");
            balance += sc.nextInt();
            System.out.println("Insert more? yes/no");
            sc.nextLine();
            answer = sc.nextLine();
        } while (answer.equals("yes"));

        return balance;
    }

    public void choiceMenu() throws SQLException {
        HashMap<String, Integer> values = new HashMap<>();
        String getRequest = "select * from banking.ingredients";

        ResultSet rs = connectionHandler.get(getRequest);
        while (rs.next()) {
            values.put(rs.getString(1), rs.getInt(2));
        }
        int choice;
        int sugarChoice = 0;
        int balance = cashMenu(scanner, 0);

        do {
            System.out.println();
            System.out.println("Choose your beverage: ");
            System.out.println("1. Americano");
            System.out.println("2. Cappucino");
            System.out.println("3. Macchiato");
            System.out.println("4. Espresso");
            System.out.println("0. Exit");
            choice = scanner.nextInt();
            if (choice != 0) {
                System.out.println("How many sugar spoons do you want in your coffee?");
                sugarChoice = scanner.nextInt();
            }
//            cost += sugarChoice;

            Pair<Coffee, Integer> pair = CoffeeMaker.make(values, balance, sugarChoice, choice);
            Coffee cup = pair.getKey();
            balance = pair.getValue();

            if (choice != 0) {
                output(values, cup);
            }
        }
        while (choice != 0);
    }

    private void output(HashMap<String, Integer> values, Coffee cup) throws SQLException {
        String updateRequest = "update banking.ingredients set quantity = ? where ingredient = ?";

        connectionHandler.update(updateRequest, values);
        try {
            System.out.println(cup.toString());
            System.out.println("Here's your coffee. Have a nice day!");
        } catch (NullPointerException e) {
            System.out.println("Not enough money");
        }
    }

}
