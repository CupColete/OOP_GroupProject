package hk.edu.polyu.comp.comp2021.cvfs.model;

public class NewDirCommand implements command {
    private CVFS cvfs;
    private String name;

    public NewDirCommand(CVFS cvfs, String name) {
        this.cvfs = cvfs;
        this.name = name;
    }

    @Override
    public void redo() {
        cvfs.newDirectory(name);
    }

    @Override
    public void undo() {
        cvfs.deleteFile(name);
    }
}