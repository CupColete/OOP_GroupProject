package hk.edu.polyu.comp.comp2021.cvfs.model;

import java.util.HashMap;
import java.util.Map;

public class Directory extends File {
    private Map<String, File> files;
    private Directory parent;

    public Directory(String name) {
        super(name);
        this.files = new HashMap<>();
        this.parent = null;
    }

    public void addFile(File file) {
        files.put(file.getName(), file);
        if (file instanceof Directory) {
            ((Directory) file).setParent(this);
        }
    }

    public void deleteFile(String name) {
        files.remove(name);
    }

    public void renameFile(String oldName, String newName) {
        File file = files.get(oldName);
        if (file != null) {
            file.setName(newName);
            files.remove(oldName);
            files.put(newName, file);
        }
    }

    public File getFile(String name) {
        return files.get(name);
    }

    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public void listFiles() {
        for (File file : files.values()) {
            System.out.println(file.getName() + " " + file.getSize());
        }
    }

    public void rListFiles() {
        rListFiles(0);
    }

    private void rListFiles(int level) {
        for (File file : files.values()) {
            for (int i = 0; i < level; i++) {
                System.out.print("  ");
            }
            System.out.println(file.getName() + " " + file.getSize());
            if (file instanceof Directory) {
                ((Directory) file).rListFiles(level + 1);
            }
        }
    }

    @Override
    public int getSize() {
        int totalSize = 40;
        for (File file : files.values()) {
            totalSize += file.getSize();
        }
        return totalSize;
    }
}