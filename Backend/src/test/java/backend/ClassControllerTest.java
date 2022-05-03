package backend;

import backend.users.User;
import io.restassured.parsing.Parser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClassControllerTest
{
    @LocalServerPort
    private int port;

    private String uri;

    @Before
    public void init()
    {
        uri = "http://localhost:" + port;
        defaultParser = Parser.JSON;
    }

    @Test
    public void getAllClasses()
    {
        Assert.hasLength(get(uri + "/classes")
                .asString(), "works if classes exist");
    }

    @Test
    public void getAllClassesByDepartment()
    {
        Assert.hasLength(get(uri + "/classes/MUSIC")
                .asString(), "works if classes exist");
    }

    @Test
    public void getSpecificClass()
    {
        Assert.hasLength(get(uri + "/class/MUSIC/102")
                .asString(), "works if class exist");
    }
}