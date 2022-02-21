package main.userManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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

    @GetMapping("/users")
    public List<userData> allUsers() {
        return userRepository.findAll();
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

        onlineUsers.put(user.getId(), user);

        return user;
    }

    @DeleteMapping("/id/{id}")
    public userData delete(@PathVariable int id)
    {
        userData user = userRepository.findById(id);
        userRepository.delete(user);
        return user;
    }
}
