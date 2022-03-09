package volley;

import com.fasterxml.jackson.core.JsonProcessingException;

import junit.framework.TestCase;

import java.io.IOException;

public class ClassControllerTest extends TestCase {

    public void testGetAClass() throws IOException {
        ClassController classController = new ClassController();
        ClassData classData = classController.getAClass();
        assertEquals(classData.getClassNumber(), "102");
//        assertEquals(1, 1);
    }
}