package hk.edu.polyu.comp.comp2021.cvfs.model;

public class ChangeDirCommand implements command {
    private CVFS cvfs;
    private String dirName;
    private Directory previousDirectory;

    public ChangeDirCommand(CVFS cvfs, String dirName) {
        this.cvfs = cvfs;
        this.dirName = dirName;
        this.previousDirectory = cvfs.getCurrentDirectory();
    }

    @Override
    public void redo() {cvfs.changeDirectory(dirName);}

    @Override
    public void undo() {
        cvfs.changeDirectory(dirName);
    }
}