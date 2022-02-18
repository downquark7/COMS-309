package main.userManagement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Random;

@RestController
public class loginManager
{
    private HashMap<Integer, userData> onlineUsers = new HashMap<>();

    @GetMapping("/onlineUsers")
    public HashMap<Integer, userData> getOnlineUsers() {
        return onlineUsers;
    }

    @PostMapping("/login")
    public userData loginUser(@RequestBody loginData data) {
        Integer id = new Random().nextInt();

        //temporary ig
        userData user = new userData();
        user.setId(id);
        user.setUsername(data.getUsername());
        user.setAuthenticationMethod(data.getAuthenticationMethod());
        user.setAuthenticationData(data.getAuthenticationData());

        onlineUsers.put(id, user);
        return user;
    }
}
