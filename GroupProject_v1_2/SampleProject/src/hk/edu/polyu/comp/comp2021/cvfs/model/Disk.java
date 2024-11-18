package hk.edu.polyu.comp.comp2021.cvfs.model;

//硬盘，初始化有最大容积，和根目录“root”， 可以获取根目录
public class Disk {
    private int maxSize;
    private Directory rootDirectory;

    public Disk(int maxSize) {
        this.maxSize = maxSize;
        this.rootDirectory = new Directory("root");
    }

    public Directory getRootDirectory() {
        return rootDirectory;
    }
}