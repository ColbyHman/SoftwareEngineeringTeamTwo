//import org.junit.jupiter.api.Test;
//import java.awt.*;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class Tests {
//
//    MapsTest mapsTest = new MapsTest();
//
//    @Test
//    public void testProcessString(){
//        String output = mapsTest.processString("Johnston Hall, 220 West Locust St.\n", true);
//        assertEquals("Johnston+Hall,+220+West+Locust+St.+Bethlehem,+PA+18018", output);
//    }
//
//    @Test
//    public void testCreateImage(){
//        try {
//            mapsTest.createImage();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        File testFile = new File("resources/image.png");
//
//        assertTrue(testFile.canRead());
//    }
//
//    @Test
//    public void testGenerateLocationList(){
//        ArrayList<String[]> locations = null;
//
//        try {
//            locations = mapsTest.generateLocationList();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        assertTrue(locations != null);
//    }
//
//}
