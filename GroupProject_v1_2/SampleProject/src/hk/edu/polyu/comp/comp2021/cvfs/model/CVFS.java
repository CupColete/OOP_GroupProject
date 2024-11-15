package hk.edu.polyu.comp.comp2021.cvfs.model;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class CVFS {
    private Disk disk;
    private Directory workDirectory;
    public CVFS(){
        this.disk =null;
        this.workDictonary =null;
    }

    //新建盘，默认路径是root
    public void createDisk(int maxsize){
        this.disk = new Disk(maxsize);
        this.workDictonary = new Directory("root");
    }
    //新建目录
    public void createWorkDirectory(String name){
        Directory dir = new Directory(name);
        if(this.disk.canAddFile(dir)){
            workDirectory.addFile(dir);
        }else{
            throw new RuntimeException("Disk is full");
        }
    }

    //删除文件/目录
    public void deleteFile(String name){
        File file = workDirectory.getFile(name);
        if(file != null){
            workDirectory.removeFile(name);
            disk.removeFile(name);
        }else{
            throw new RuntimeException("File not found");
        }
    }

    //改文件名
    public void rename(String OldName, String NewName){
        File file = workDirectory.getFile(OldName);
        if(file != null){
            file.setName(NewName);
        }else{
            throw new RuntimeException("File not found");
        }
    }

    //改目录名
}

class Disk {
    //硬盘：最大容量，和当前储存
    //Hash Map储存file
    private final int maxSize;
    private int currentSize;
    private final Map<String, File> files;

    public Disk(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        this.files = new HashMap<>();
    }

    //判断是否能够装入文件
    public boolean canAddFile(File file) {
        return currentSize + file.getSize() <= maxSize;
    }

    //把文件放进Hashmap
    public void addFile(File file) {
        if (canAddFile(file)) {
            files.put(file.getName(), file);
            currentSize += file.getSize();
        } else {
            throw new RuntimeException("Disk is full");
        }
    }

    //移除文件
    public void removeFile(String fileName) {
        File file = files.remove(fileName);
        if (file != null) {
            currentSize -= file.getSize();
        }
    }

    //获取文件
    public File getFile(String fileName) {
        return files.get(fileName);
    }

    //获取容量
    public int getMaxSize() {
        return maxSize;
    }

    //获取当前储存
    public int getCurrentSize() {
        return currentSize;
    }

    //获取当前文件目录
    public Map<String, File> getFiles() {
        return files;
    }
}

abstract class File {
    protected String name;
    public File(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int getSize();
}
//文件：type，content
class Document extends File {
    private final String type;
    private final String content;

    public Document(String name, String type, String content) {
        super(name);
        this.type = type;
        this.content = content;
    }

    @Override
    public int getSize() {
        return 40 + content.length() * 2;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}

//Directory，一个Map就是一个目录
class Directory extends File {
    private final Map<String, File> files;

    public Directory(String name) {
        super(name);
        this.files = new HashMap<>();
    }

    @Override
    public int getSize() {
        return 40 + files.values().stream().mapToInt(File::getSize).sum();
    }
    public void addFile(File file) {
        files.put(file.getName(), file);
    }
    public void removeFile(String fileName) {
        files.remove(fileName);
    }
    public File getFile(String fileName) {
        return files.get(fileName);
    }
    public Map<String, File> getFiles() {
        return files;
    }
}