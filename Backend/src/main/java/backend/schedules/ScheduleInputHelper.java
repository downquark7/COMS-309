package backend.schedules;

import backend.users.User;

import java.util.List;

/***
 * helper class for creating a new schedule and assigning them to a user
 */
public class ScheduleInputHelper
{
    public int id;
    public String name;
    public User user;
    public List<Integer> sections;
}
