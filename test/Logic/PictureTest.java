package Logic;

import Logic.TestData.TestPictureData;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pytel
 */
public class PictureTest {
    
    public static TestPictureData[] pictures = TestData.pictures;
    
    public PictureTest() {
    }
    
    public Picture loadPicture (File picturePath) {
        Picture p = null;
        try {
            p = new Picture(picturePath);
        } catch (FileNotFoundException e) {
            System.out.format("ERROR: %s\n", e);
        } catch (IOException ex) {
            System.out.format("ERROR: %s\n", ex);
        }
        return p;
    }
    
    @Test
    public void createPicture() {
        Picture p = null;
        for (TestPictureData picture : pictures) {
            p = loadPicture(picture.picturePath);
        }
        assertNotNull(p);
    }
    
    @Test
    public void createPicture_InvalidFile() {
        File path = new File(System.getProperty("user.dir") + "/Data/");
        String name = "notAPicture";
        String format = ".ppm";
        File picturePath = new File(path, name + format);
        Picture p = loadPicture(picturePath);
        assert p == null : "Konstruktor does not work.";
    }
    
    @Test
    public void createPicture_ValidFile() {
        Picture p;
        for (TestPictureData picture : pictures) {
            try {
                //System.out.format("%s\n", picturePath.getAbsolutePath());
                p = new Picture(picture.picturePath);
            } catch (FileNotFoundException e) {
                System.out.format("ERROR: %s\n", e);
                assert false : "Konstruktor does not work.";
            } catch (IOException ex) {
                System.out.format("ERROR: %s\n", ex);
            }
        }
    }
    
    @Test
    public void createPictureAndGetName() {
        Picture p;
        for (TestPictureData picture : pictures) {
            p = loadPicture(picture.picturePath);
            assertNotNull(p);
            //System.out.format("Picture name: %s\n", picture.name);
            assert p.getName().compareTo(picture.name) == 0 : "Invalid name: " + p.getName() + " != " + picture.name;
        }
    }
    
    @Test
    public void createPictureAndGetFormat() {
        Picture p;
        for (TestPictureData picture : pictures) {
            p = loadPicture(picture.picturePath);
            assertNotNull(p);
            assert p.getFormat().compareTo(picture.format) == 0 : "Invalid name: " + p.getFormat() + " != " + picture.format;
        }
    }
    
    @Test
    public void createPictureAndGetSize() {
        Picture p;
        for (TestPictureData picture : pictures) {
            p = loadPicture(picture.picturePath);
            assertNotNull(p);
            assert p.getHeight() == picture.height: "Invalid name: " + p.getHeight() + " != " + picture.height;
            assert p.getwidth() == picture.width: "Invalid name: " + p.getwidth() + " != " + picture.width;
        }
    }

    /**
     * Test of main method, of class Picture.
     */
    @Test
    public void testMain() {
    }
    
}
