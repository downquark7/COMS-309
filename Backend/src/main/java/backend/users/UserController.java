package backend.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class UserController
{
//    private HashMap<Integer, User> onlineUsers = new HashMap<>();

    @Autowired
    UserRepository userRepository;

    @PostMapping("/user/create")
    public User createUser(@RequestBody User user)
    {
        if (!userRepository.existsByUsername(user.getUsername()))
            userRepository.save(user);
        else
            return null;
        return user;
    }
}
