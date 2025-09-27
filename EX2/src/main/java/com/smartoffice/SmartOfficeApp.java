package com.smartoffice;

import com.smartoffice.command.CommandInvoker;

import java.util.Scanner;

public class SmartOfficeApp {
    public static void main(String[] args) {
        System.out.println("Welcome to Smart Office Facility!");
        CommandInvoker invoker = new CommandInvoker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("cmd> ");
            String input = scanner.nextLine();
            if (input.trim().equalsIgnoreCase("exit")) {
                System.out.println("Exiting Smart Office. Goodbye!");
                break;
            }
            invoker.executeCommand(input);
        }
        scanner.close();
    }
}