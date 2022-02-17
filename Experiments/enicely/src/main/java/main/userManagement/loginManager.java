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
    //TODO: replace hashmap value with userData class once implemented
    private HashMap<Integer, String> onlineUsers = new HashMap<>();

    @GetMapping("/onlineUsers")
    public HashMap<Integer, String> getOnlineUsers() {
        return onlineUsers;
    }

    @PostMapping("/login")
    public Integer loginUser(@RequestBody loginData data) {
        Integer id = new Random().nextInt();
        onlineUsers.put(id, data.getUsername());
        return id;
    }
}
