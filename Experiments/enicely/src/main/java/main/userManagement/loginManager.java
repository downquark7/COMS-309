package main.userManagement;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    userRepository userRepository;

    @GetMapping("/onlineUsers")
    public HashMap<Integer, userData> getOnlineUsers()
    {
        return onlineUsers;
    }

    @PostMapping("/login")
    public userData loginUser(@RequestBody loginData data)
    {

//        //temporary ig
//        userData user = new userData();
//        user.setId(id);
//        user.setUsername(data.getUsername());
//        user.setAuthenticationMethod(data.getAuthenticationMethod());
//        user.setAuthenticationData(data.getAuthenticationData());

        userData user = userRepository.findByUsername(data.getUsername());
        if (user != null)
        {

            if (!user.getAuthenticationMethod().equals(data.getAuthenticationMethod()))
                return null;
            if (!user.getAuthenticationData().equals(data.getAuthenticationData()))
                return null;

        } else
        {
            return null;
        }

        return user;
    }
}
