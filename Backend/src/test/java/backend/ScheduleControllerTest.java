package backend;

import backend.schedules.Schedule;
import backend.schedules.ScheduleOutputHelper;
import backend.users.User;
import io.restassured.parsing.Parser;
import org.junit.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.defaultParser;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.get;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ScheduleControllerTest
{

    @LocalServerPort
    private int port;

    private String uri;

    private User testUser;

    private void init()
    {
        uri = "http://localhost:" + port;
        defaultParser = Parser.JSON;
    }

    private String testScheduleName = "test schedule 325";

    @Before
    public void generateTestUser() {
        init();

        User user = new User();
        user.setUsername("testUser325");
        user.setAuthenticationData("password123");
        user.setAuthenticationMethod("plaintext");

        testUser = given().contentType("application/json")
                .body(user)
                .when()
                .post(uri + "/user/create")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .as(User.class);
    }

    @After
    public void deleteTestUser() {
        given().contentType("application/json")
                .body(testUser)
                .when()
                .delete(uri + "/user")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void scheduleTests()
    {
        Map<String, Object> request = new HashMap<>();
        Map<String, String> user = new HashMap<>();
        user.put("username", testUser.getUsername());
        request.put("user", user);
        request.put("name", testScheduleName);
        request.put("sections", new int[]{5560});

        ScheduleOutputHelper output = given().contentType("application/json")
                .body(request)
                .post(uri + "/schedule")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .as(ScheduleOutputHelper.class);

        get(uri+"/schedules/byUserId/"+testUser.getId())
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value());

        get(uri+"/schedule/byId/"+output.id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value());
    }
}