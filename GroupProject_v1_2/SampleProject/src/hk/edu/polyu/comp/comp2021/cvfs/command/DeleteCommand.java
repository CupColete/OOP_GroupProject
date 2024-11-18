package hk.edu.polyu.comp.comp2021.cvfs.command;

import hk.edu.polyu.comp.comp2021.cvfs.model.CVFS;
import hk.edu.polyu.comp.comp2021.cvfs.model.Directory;
import hk.edu.polyu.comp.comp2021.cvfs.model.Document;
import hk.edu.polyu.comp.comp2021.cvfs.model.File;

public class DeleteCommand implements command {
    private CVFS cvfs;
    private String name;
    private File file;

    public DeleteCommand(CVFS cvfs, String name) {
        this.cvfs = cvfs;
        this.name = name;
        this.file = cvfs.getCurrentDirectory().getFile(name);
    }

    @Override
    public void redo() {
        cvfs.deleteFile(name);
    }

    @Override
    public void undo() {
        if (file instanceof Document) {
            cvfs.newDocument(file.getName(), ((Document) file).getType(), ((Document) file).getContent());
        } else if (file instanceof Directory) {
            cvfs.newDirectory(file.getName());
        }
    }
}