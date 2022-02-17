package main.userManagement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class loginManager
{
    private HashMap<String, loginData> onlineUsers = new HashMap<>();

    @GetMapping("/onlineUsers")
    public HashMap<String, loginData> getOnlineUsers() {
        return onlineUsers;
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody loginData data) {
        onlineUsers.put(data.getUsername(), data);
        return data.getUsername();
    }
}
