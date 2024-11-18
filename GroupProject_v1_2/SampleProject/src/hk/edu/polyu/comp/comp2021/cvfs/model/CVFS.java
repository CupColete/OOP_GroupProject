package hk.edu.polyu.comp.comp2021.cvfs.model;


//CVFS本体


public class CVFS {
    private Disk currentDisk;
    private Directory currentDirectory;

    public CVFS() {
        this.currentDisk = null;
        this.currentDirectory = null;
    }
    // [REQ1] new disk
    // Command: newDisk diskSize
    public void newDisk(int diskSize) {
        this.currentDisk = new Disk(diskSize);
        this.currentDirectory = this.currentDisk.getRootDirectory();
    }

    // [REQ2] new Document
    // Command: newDoc docName docType docContent

    public void newDocument(String name, String type, String content) {
        if (currentDirectory != null) {
            currentDirectory.addFile(new Document(name, type, content));
        }
    }

     //[REQ3] new directory
    // Command: newDir dirName
    public void newDirectory(String name) {
        if (currentDirectory != null) {
            currentDirectory.addFile(new Directory(name));
        }
    }

    // [REQ4] delete file
    // Command: delete fileName
    public void deleteFile(String name) {
        if (currentDirectory != null) {
            currentDirectory.deleteFile(name);
        }
    }
    // [REQ5]  rename File
    // Command: rename oldFileName newFileName
    public void renameFile(String oldName, String newName) {
        if (currentDirectory != null) {
            currentDirectory.renameFile(oldName, newName);
        }
    }

     //[REQ6] change direcctory
     // Command: changeDir dirName
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

    //[REQ7]   List all the files (name, type, and size)
    // Command: list
    public void listFiles() {
        if (currentDirectory != null) {
            currentDirectory.listFiles();
        }
    }
    //[REQ8]extends list function and Use indentation to indicate the level of each file in directory
    // Command: rList

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
    //[REQ17] Terminate the execution of the system.
    //  Command: quit
    public void quit() {
        System.exit(0);
    }
}