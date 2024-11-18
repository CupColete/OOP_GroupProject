package hk.edu.polyu.comp.comp2021.cvfs.model;

public class CVFS {
    private Disk currentDisk;
    private Directory currentDirectory;

    public CVFS() {
        this.currentDisk = null;
        this.currentDirectory = null;
    }

    public void newDisk(int diskSize) {
        this.currentDisk = new Disk(diskSize);
        this.currentDirectory = this.currentDisk.getRootDirectory();
    }

    public void newDocument(String name, String type, String content) {
        if (currentDirectory != null) {
            currentDirectory.addFile(new Document(name, type, content));
        }
    }

    public void newDirectory(String name) {
        if (currentDirectory != null) {
            currentDirectory.addFile(new Directory(name));
        }
    }

    public void deleteFile(String name) {
        if (currentDirectory != null) {
            currentDirectory.deleteFile(name);
        }
    }

    public void renameFile(String oldName, String newName) {
        if (currentDirectory != null) {
            currentDirectory.renameFile(oldName, newName);
        }
    }

    public void changeDirectory(String dirName) {
        if (currentDirectory != null) {
            if (dirName.equals("..")) {
                if (currentDirectory.getParent() != null) {
                    currentDirectory = currentDirectory.getParent();
                }
            } else {
                File file = currentDirectory.getFile(dirName);
                if (file instanceof Directory) {
                    currentDirectory = (Directory) file;
                }
            }
        }
    }

    public void listFiles() {
        if (currentDirectory != null) {
            currentDirectory.listFiles();
        }
    }

    public void rListFiles() {
        if (currentDirectory != null) {
            currentDirectory.rListFiles();
        }
    }

    public void saveDisk(String path) {
        //  save disk logic
    }

    public void loadDisk(String path) {
        //  load disk logic
    }

    public void quit() {
        System.exit(0);
    }
}