package backend;

import backend.users.User;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.springframework.util.SocketUtils;

import static io.restassured.RestAssured.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTests
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
    public void createUser()
    {
        User user = new User();
        user.setUsername(testUser.getUsername());

        Assert.isTrue(
                given().contentType("application/json")
                        .body(user)
                        .when()
                        .post(uri + "/user/create")
                        .then()
                        .extract()
                        .asString().isEmpty(), "duplicate should fail");
    }

    @Test
    public void manageUser()
    {
        User user = new User();
        user.setUsername("testUser325");

        given().contentType("application/json")
                .body(user)
                .when()
                .put(uri + "/user/manage")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void loginUser()
    {
        User user = new User();
        user.setUsername("testUser325");

        Assert.isTrue(given().contentType("application/json")
                .body(user)
                .when()
                .post(uri + "/user/login")
                .then()
                .extract()
                .asString().isEmpty(), "login should fail with no password");


        user.setAuthenticationMethod(testUser.getAuthenticationMethod());
        user.setAuthenticationData(testUser.getAuthenticationData());
        given().contentType("application/json")
                .body(user)
                .when()
                .post(uri + "/user/login")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void getOnlineUsers()
    {
        get(uri + "/onlineUsers")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void logout()
    {
        User user = new User();
        user.setUsername("testUser325");
        user.setAuthenticationMethod(testUser.getAuthenticationMethod());
        user.setAuthenticationData(testUser.getAuthenticationData());
        //need to login to logout
        user = given().contentType("application/json")
                .body(user)
                .when()
                .post(uri + "/user/login")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .as(User.class);

        given().contentType("application/json")
                .body(user)
                .when()
                .post(uri + "/user/logout")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value());

        user.setId(-42);//no user will have this id
        Assert.isTrue(
                given().contentType("application/json")
                        .body(user)
                        .when()
                        .post(uri + "/user/logout")
                        .then()
                        .extract()
                        .asString().isEmpty(), "unknown user should fail");
    }

    @Test
    public void getUserByName()
    {
        get(uri + "/getUser/"+testUser.getUsername())
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void getUserById()
    {
        get(uri + "/getUserById/"+ testUser.getId())
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void getUserContactByName()
    {
        get(uri + "/getUserContact/"+testUser.getUsername())
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void getUserContactById()
    {
        get(uri + "/getUserContactById/"+testUser.getId())
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value());
    }
}
