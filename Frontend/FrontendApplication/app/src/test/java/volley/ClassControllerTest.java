package volley;

import junit.framework.TestCase;

import java.io.IOException;

import controller.ClassController;
import controller.ClassData;
import controller.DepartmentCodes;

public class ClassControllerTest extends TestCase {

    public void testGetAClass() throws IOException {
        ClassController classController = new ClassController();
        ClassData classData = classController.getAClass("MUSIC","102");
        assertEquals(classData.getClassNumber(), "102");
//        assertEquals(1, 1);
    }
}