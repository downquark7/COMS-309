package backend.users;

import backend.schedules.Schedule;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User
{
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String authenticationMethod;
    private String authenticationData;

    @OneToOne
    private UserContact userContact;

    @OneToMany
    private List<Schedule> schedules;

    public User()
    {
        schedules = new ArrayList<>();
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getAuthenticationMethod()
    {
        return authenticationMethod;
    }

    public void setAuthenticationMethod(String authenticationMethod)
    {
        this.authenticationMethod = authenticationMethod;
    }

    public String getAuthenticationData()
    {
        return authenticationData;
    }

    public void setAuthenticationData(String authenticationData)
    {
        this.authenticationData = authenticationData;
    }

    public List<Schedule> getSchedules()
    {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules)
    {
        this.schedules = schedules;
    }

    public void addSchedule(Schedule schedule)
    {
        schedules.add(schedule);
    }

    public UserContact getUserContact()
    {
        return userContact;
    }

    public void setUserContact(UserContact userContact)
    {
        this.userContact = userContact;
    }
}
