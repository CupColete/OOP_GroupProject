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
                cvfs.newDisk(Integer.parseInt(parts[1]));
                break;
            case "newDoc":
                cvfs.NewDocument(parts[1], parts[2], parts[3]);
                break;
            case "newDir":
                cvfs.NewDirectory(parts[1]);
                break;
            case "delete":
                cvfs.DeleteFile(parts[1]);
                break;
            case "rename":
                cvfs.RenameFile(parts[1], parts[2]);
                break;
            case "changeDir":
                cvfs.ChangeDirectory(parts[1]);
                break;
            case "list":
                cvfs.listFiles();
                break;
            case "rList":
                cvfs.rListFiles();
                break;
            case "save":
                cvfs.saveDisk(parts[1]);
                break;
            case "load":
                cvfs.loadDisk(parts[1]);
                break;
            case "quit":
                cvfs.quit();
                break;
            case "newSimpleCri":
                cvfs.NewSimpleCri(parts[1],parts[2],parts[3],parts[4] );
                break;
            case "newNegation":
                cvfs.NewNegation(parts[1], parts[2]);
                break;
            case "newBinaryCri":
                cvfs.newBinaryCri(parts[1], parts[2], parts[3], parts[4]);
                break;
            case "printAllCriteria":
                cvfs.printAllCriteria();
                break;
            case "search":
                cvfs.search(parts[1]);
                break;
            case "rSearch":
                cvfs.rSearch(parts[1]);
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