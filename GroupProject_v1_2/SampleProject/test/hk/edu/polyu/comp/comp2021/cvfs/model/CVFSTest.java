package hk.edu.polyu.comp.comp2021.cvfs.model;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CVFSTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private static CVFS cvfs;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testCVFSConstructor(){
        CVFS cvfs = new CVFS();

        assert true;
    }

    @Test
    public void testCVFS1(){
        CVFS cvfs1 = new CVFS();
        cvfs1.newDisk(1000);

        cvfs1.NewDirectory("directory1");
        cvfs1.NewDirectory("directory2");
        cvfs1.NewDirectory("directory3");
        cvfs1.ChangeDirectory("directory1");
        cvfs1.NewDirectory("directory1-1");
        cvfs1.ChangeDirectory("../directory2");
        cvfs1.NewDocument("doc1", ".doc", "content1");
        cvfs1.NewDocument("doc2", ".doc", "content2");
        cvfs1.NewDocument("doc3", ".doc", "content3");
        cvfs1.NewDocument("ppt1", ".pptx", "content4");

        cvfs1.RenameFile("doc1", "doc4");
        cvfs1.DeleteFile("doc2");
        cvfs1.undo();
        cvfs1.redo();


        cvfs1.NewSimpleCri("CA", "name", "contains", "doc");
        cvfs1.NewSimpleCri("CB", "name", "equal", "doc4");
        cvfs1.newBinaryCri("CC", "CA", "&&", "CB");
        cvfs1.NewNegation("CD", "CA");
        cvfs1.deleteCriterion("CB");

        cvfs1.printAllCriteria();

        cvfs1.search("CA");
        cvfs1.rSearch("CA");

        cvfs1.NewSimpleCri("AA", "size", "<", "100");
        cvfs1.search("AA");

        cvfs1.listFiles();
        cvfs1.rListFiles();

        cvfs1.saveDisk("Disks");

        assertEquals("""
                CC:(Criterion{attrName=name,op=contains,val=doc}&& Criterion{attrName=name,op=equal,val=doc4})\r
                CD:!(Criterion{attrName=name,op=contains,val=doc})\r
                IsDocument: IsDocument\r
                CA:Criterion{attrName=name,op=contains,val=doc}\r
                doc4 56\r
                doc3 56\r
                Total files: 2,Total size: 112\r
                doc4 56\r
                doc3 56\r
                Total files: 2,Total size: 112\r
                doc4 56\r
                doc3 56\r
                ppt1 56\r
                directory1-1 40\r
                Total files: 4,Total size: 208\r
                doc4  56  .doc\r
                doc3  56  .doc\r
                ppt1  56  .pptx\r
                directory1-1  40\r
                doc4  56  .doc\r
                doc3  56  .doc\r
                ppt1  56  .pptx\r
                directory1-1 40\r
                Disk and criteria saved to Disks\r
                """, outContent.toString());
    }
}
