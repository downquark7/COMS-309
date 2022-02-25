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
    public Object createUser(@RequestBody User user) throws Exception
    {
        if (!userRepository.existsByUsername(user.getUsername()))
            userRepository.save(user);
        else
            return "Error: username already exists";
        return user;
    }
//
//    @PutMapping("/user/manage")
//    public User manageUser(@RequestBody User user)
//    {
//        userRepository.save(user);
//        return user;
//    }

    @PostMapping("/user/login")
    public Object loginUser(@RequestBody User user)
    {
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb != null)
        {
            if (!user.getAuthenticationMethod().equals(userFromDb.getAuthenticationMethod()))
                return "Login error: username or password not found";
            if (!user.getAuthenticationData().equals(userFromDb.getAuthenticationData()))
                return "Login error: username or password not found";

        } else
        {
            return "Login error: username or password not found";
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
    public Object logout(@RequestBody User user)
    {
        User userFromHashmap = onlineUsers.get(user.getId());
        if (userFromHashmap == null)
            return "Error: user not found";
        onlineUsers.remove(user.getId());
        return userFromHashmap;
    }
}
