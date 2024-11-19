package hk.edu.polyu.comp.comp2021.cvfs.model.command;

import hk.edu.polyu.comp.comp2021.cvfs.model.CVFS;

public class RenameCommand implements command {
    private CVFS cvfs;
    private String oldName;
    private String newName;

    public RenameCommand(CVFS cvfs, String oldName, String newName) {
        this.cvfs = cvfs;
        this.oldName = oldName;
        this.newName = newName;
    }

    @Override
    public void redo() {
        cvfs.renameFile(oldName, newName);
    }

    @Override
    public void undo() {
        cvfs.renameFile(newName, oldName);
    }
}