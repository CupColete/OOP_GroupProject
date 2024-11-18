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
                cvfs.newDocument(parts[1], parts[2], parts[3]);
                break;
            case "newDir":
                cvfs.newDirectory(parts[1]);
                break;
            case "delete":
                cvfs.deleteFile(parts[1]);
                break;
            case "rename":
                cvfs.renameFile(parts[1], parts[2]);
                break;
            case "changeDir":
                cvfs.changeDirectory(parts[1]);
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
            default:
                System.out.println("Unknown command");
        }
    }
}