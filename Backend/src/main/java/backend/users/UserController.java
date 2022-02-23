package backend.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class UserController
{
    private HashMap<Integer, User> onlineUsers = new HashMap<>();

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

    @PutMapping("/user/manage")
    public User manageUser(@RequestBody User user)
    {
        userRepository.save(user);
        return user;
    }

    @PostMapping("/user/login")
    public User loginUser(@RequestBody User user)
    {
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb != null)
        {
            if (!user.getAuthenticationMethod().equals(userFromDb.getAuthenticationMethod()))
                return null;
            if (!user.getAuthenticationData().equals(userFromDb.getAuthenticationData()))
                return null;

        } else
        {
            return null;
        }

        onlineUsers.put(user.getId(), user);

        return userFromDb;
    }

    @GetMapping("/onlineUsers")
    public HashMap<Integer, User> getOnlineUsers()
    {
        return onlineUsers;
    }

    @PostMapping("/user/logout")
    public User logout(@RequestBody User user) {
        User userFromHashmap = onlineUsers.get(user.getId());
        onlineUsers.remove(user.getId());
        return userFromHashmap;
    }
}
