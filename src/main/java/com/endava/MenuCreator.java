package com.endava;

import javafx.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

public class MenuCreator {

    private ConnectionHandler connectionHandler;
    private Scanner scanner;
    private Logger log = LoggerFactory.getLogger(MenuCreator.class);
    private static final String MENU = "\nChoose your beverage: \n"
                                        + "1. Americano\n"
                                        + "2. Cappucino\n"
                                        + "3. Macchiato\n"
                                        + "4. Espresso\n"
                                        + "0. Exit";

    public MenuCreator(ConnectionHandler con, Scanner scanner) {
        this.connectionHandler = con;
        this.scanner = scanner;
    }

    private int cashMenu(Scanner sc, int balance) {
        String answer;

        do {
            System.out.println("\nInsert money");
            balance += sc.nextInt();
            System.out.println("Insert more? yes/no");
            sc.nextLine();
            answer = sc.nextLine();
        } while (answer.equals("yes"));

        return balance;
    }

    public void choiceMenu() throws SQLException {
        HashMap<Enum, Integer> values = new HashMap<>();
        String request = "select * from banking.ingredients";

        ResultSet rs = connectionHandler.get(request);
        try {
            while (rs.next()) {
                values.put(Ingredients.valueOf(rs.getString(1)), rs.getInt(2));
            }
        } catch (IllegalArgumentException e) {
            log.error("Unknown ingredient: \\\"{}\\\"", rs.getString(1));
        }
        int choice;
        int sugarChoice = 0;
        int balance = cashMenu(scanner, 0);

        do {
            System.out.println(MENU);
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

    private void output(HashMap<Enum, Integer> values, Coffee cup) throws SQLException {
        String request = "update banking.ingredients set quantity = ? where ingredient = ?";

        connectionHandler.update(request, values);
        try {
            System.out.println(cup + "\nHere's your coffee. Have a nice day!");
        } catch (NullPointerException e) {
            System.out.println("Not enough money");
        }
    }

}
