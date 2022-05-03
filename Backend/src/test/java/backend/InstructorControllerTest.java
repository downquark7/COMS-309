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

import static io.restassured.RestAssured.defaultParser;
import static io.restassured.RestAssured.get;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InstructorControllerTest
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
    public void instructorClasses()
    {
        get(uri + "/instructorClasses/RODDE JAMES F")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void allInstructors()
    {
        get(uri + "/allInstructors")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value());
    }
}