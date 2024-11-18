package hk.edu.polyu.comp.comp2021.cvfs.command;

import hk.edu.polyu.comp.comp2021.cvfs.model.CVFS;

public class NewSimpleCriCommand implements command {
    private CVFS cvfs;
    private String criName;
    private String attrName;
    private String op;
    private String val;

    public NewSimpleCriCommand(CVFS cvfs, String criName, String attrName, String op, String val) {
        this.cvfs = cvfs;
        this.criName = criName;
        this.attrName = attrName;
        this.op = op;
        this.val = val;
    }

    @Override
    public void redo() {
        cvfs.newCri(criName, attrName, op, val);
    }

    @Override
    public void undo() {
        cvfs.deleteCriterion(criName);
    }
}