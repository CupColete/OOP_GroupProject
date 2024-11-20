package hk.edu.polyu.comp.comp2021.cvfs.model;

public class NewDocCommand implements command {
    private CVFS cvfs;
    private String name;
    private String type;
    private String content;

    public NewDocCommand(CVFS cvfs, String name, String type, String content) {
        this.cvfs = cvfs;
        this.name = name;
        this.type = type;
        this.content = content;
    }

    @Override
    public void redo() {
        cvfs.newDocument(name, type, content);
    }

    @Override
    public void undo() {
        cvfs.deleteFile(name);
    }
}