package hk.edu.polyu.comp.comp2021.cvfs.controller;

import hk.edu.polyu.comp.comp2021.cvfs.model.CVFS;

public class CommandHandler {
    private CVFS cvfs;

    public CommandHandler() {
        this.cvfs = new CVFS();
    }

    public void handleCommand(String command) {
        String[] parts = command.split(" ");
        switch (parts[0]) {
            case "newDisk":
                try {
                    cvfs.newDisk(Integer.parseInt(parts[1]));
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid arguments");
                }
                break;
            case "newDoc":
                try {
                    cvfs.NewDocument(parts[1], parts[2], parts[3]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid arguments");
                }
                break;
            case "newDir":
                try {
                    cvfs.NewDirectory(parts[1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid arguments");
                }
                break;
            case "delete":
                try {
                    cvfs.DeleteFile(parts[1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid arguments");
                }
                break;
            case "rename":
                try {
                    cvfs.RenameFile(parts[1], parts[2]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid arguments");
                }
                break;
            case "changeDir":
                try {
                    cvfs.ChangeDirectory(parts[1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid arguments");
                }
                break;
            case "list":
                cvfs.listFiles();
                break;
            case "rList":
                cvfs.rListFiles();
                break;
            case "save":
                try {
                    cvfs.saveDisk(parts[1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid arguments");
                }
                break;
            case "load":
                try {
                    cvfs.loadDisk(parts[1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid arguments");
                }
                break;
            case "quit":
                cvfs.quit();
                break;
            case "newSimpleCri":
                try {
                    cvfs.NewSimpleCri(parts[1],parts[2],parts[3],parts[4] );
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid arguments");
                } catch (IllegalArgumentException e) {
                    System.out.println("Cri name can only be 2 English letters");
                }
                break;
            case "newNegation":
                try {
                    cvfs.NewNegation(parts[1], parts[2]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid arguments");
                }
                break;
            case "newBinaryCri":
                try {
                    cvfs.newBinaryCri(parts[1], parts[2], parts[3], parts[4]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid arguments");
                }
                break;
            case "printAllCriteria":
                cvfs.printAllCriteria();
                break;
            case "search":
                try {
                    cvfs.search(parts[1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid arguments");
                }
                break;
            case "rSearch":
                try {
                    cvfs.rSearch(parts[1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid arguments");
                }
                break;
            case "undo":
                cvfs.undo();
                break;
            case "redo":
                cvfs.redo();
                break;
            default:
                System.out.println("Unknown command");
        }
    }
}