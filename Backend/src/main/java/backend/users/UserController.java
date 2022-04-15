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

    @Autowired
    UserContactRepository userContactRepository;

    @PostMapping("/user/create")
    public User createUser(@RequestBody User user) throws Exception
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
        if (user.getSchedules().isEmpty())
            user.setSchedules(userRepository.getById(user.getId()).getSchedules());
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
    public User logout(@RequestBody User user)
    {
        User userFromHashmap = onlineUsers.get(user.getId());
        if (userFromHashmap == null)
            return null;
        onlineUsers.remove(user.getId());
        return userFromHashmap;
    }

    @GetMapping("/getUser/{user}")
    public User getUserByName(@PathVariable String user) {
        return userRepository.findByUsername(user);
    }

    @GetMapping("/getUserById/{user}")
    public User getUserById(@PathVariable int user) {
        return userRepository.getById(user);
    }

    @GetMapping("/getUserContact/{user}")
    public UserContact getUserContactByName(@PathVariable String user) {
        return userRepository.findByUsername(user).getUserContact();
    }

    @GetMapping("/getUserContactById/{user}")
    public UserContact getUserContactById(@PathVariable int user) {
        return userRepository.getById(user).getUserContact();
    }
}
