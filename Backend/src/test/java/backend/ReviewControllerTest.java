package backend;

import backend.reviews.Review;
import backend.users.User;
import io.restassured.parsing.Parser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReviewControllerTest
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
    public void reviewTest()
    {
        Map<String, String> review = new HashMap<>();
        review.put("username", "hax");
        review.put("classId", "6586");
        review.put("difficulty", "2.71828");
        review.put("text", "this is a good review");

        Review response = given().contentType("application/json")
                .body(review)
                .post(uri + "/review")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .as(Review.class);

        get(uri+"/reviews/MUSIC/102")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value());
    }
}