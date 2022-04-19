package backend.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/***
 * user data focused rest controller for creating, managing, and logging in users and such
 */
@RestController
public class UserController
{
    private HashMap<Integer, User> onlineUsers = new HashMap<>();

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserContactRepository userContactRepository;

    /***
     * mapping to creat a user
     * @param user user object to create and add to user database
     * @return null if user exists or user if it worked
     */
    @PostMapping("/user/create")
    public User createUser(@RequestBody User user)
    {
        if (!userRepository.existsByUsername(user.getUsername()))
            userRepository.save(user);
        else
            return null;
        return user;
    }

    /***
     * manage user mapping
     * @param user updated user object, if fields are empty it is assumed that previous fields should be used
     * @return updated user object
     */
    @PutMapping("/user/manage")
    public User manageUser(@RequestBody User user)
    {
        if (user.getId() < 1)
            user.setId(userRepository.findByUsername("dq").getId());

        if (user.getSchedules().isEmpty())
            user.setSchedules(userRepository.findByUsername(user.getUsername()).getSchedules());

        if (user.getAuthenticationData() == null)
            user.setAuthenticationData(userRepository.findByUsername(user.getUsername()).getAuthenticationData());

        if (user.getAuthenticationMethod() == null)
            user.setAuthenticationMethod(userRepository.findByUsername(user.getUsername()).getAuthenticationData());

        if (user.getUserContact() != null)
        {
            userContactRepository.save(user.getUserContact());
            user.setUserContact(user.getUserContact());
        }

        userRepository.save(user);
        return user;
    }

    /***
     * user login mapping
     * @param user user object including username, authenticationData, and authenticationMethod
     * @return user object from database
     */
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

    /***
     * @return list of all online users from hashmap
     */
    @GetMapping("/onlineUsers")
    public HashMap<Integer, User> getOnlineUsers()
    {
        return onlineUsers;
    }

    /***
     * logout user
     * @param user user id needed to logout
     * @return user that was logged out or null if failed
     */
    @PostMapping("/user/logout")
    public User logout(@RequestBody User user)
    {
        User userFromHashmap = onlineUsers.get(user.getId());
        if (userFromHashmap == null)
            return null;
        onlineUsers.remove(user.getId());
        return userFromHashmap;
    }

    /***
     * get data about specific user
     * @param user user object but only needs username defined to work right now
     * @return user object including schedules and contact object
     */
    @GetMapping("/getUser/{user}")
    public User getUserByName(@PathVariable String user)
    {
        return userRepository.findByUsername(user);
    }

    /***
     * get data about specific user
     * @param user takes user id as int
     * @return user object including schedules and contact object
     */
    @GetMapping("/getUserById/{user}")
    public User getUserById(@PathVariable int user)
    {
        return userRepository.getById(user);
    }

    /***
     * get contact data about specific user
     * @param user user object but only needs username defined to work right now
     * @return user contact object
     */
    @GetMapping("/getUserContact/{user}")
    public UserContact getUserContactByName(@PathVariable String user)
    {
        return userRepository.findByUsername(user).getUserContact();
    }

    /***
     * get contact data about specific user
     * @param user takes user id as int
     * @return user contact object
     */
    @GetMapping("/getUserContactById/{user}")
    public UserContact getUserContactById(@PathVariable int user)
    {
        return userRepository.getById(user).getUserContact();
    }
}
