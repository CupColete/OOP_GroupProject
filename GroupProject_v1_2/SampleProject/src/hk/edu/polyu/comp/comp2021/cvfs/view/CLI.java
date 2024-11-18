package hk.edu.polyu.comp.comp2021.cvfs.view;

import hk.edu.polyu.comp.comp2021.cvfs.controller.CommandHandler;

import java.util.Scanner;

public class CLI {
    private CommandHandler commandHandler;

    public CLI() {
        this.commandHandler = new CommandHandler();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            commandHandler.handleCommand(command);
        }
    }
}