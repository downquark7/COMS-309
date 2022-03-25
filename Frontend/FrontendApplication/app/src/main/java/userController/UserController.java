package userController;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

import classController.Config;

public class UserController {
    public static User getUserByName(String username) throws IOException {
        URL url = new URL(Config.baseURL + "/getUser/" + username);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(url, User.class);
    }

    public static User getUserById(int id) throws IOException {
        URL url = new URL(Config.baseURL + "/getUserById/" + id);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(url, User.class);
    }

    public static User getUserById(String id) throws IOException {
        URL url = new URL(Config.baseURL + "/getUserById/" + id);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(url, User.class);
    }
}
