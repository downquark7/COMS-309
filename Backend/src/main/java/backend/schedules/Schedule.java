package backend.schedules;

import backend.classes.Section;
import backend.classes.SectionRepository;
import backend.classes.SectionTime;
import backend.users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Schedule
{
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @JsonIgnore
    @ManyToOne
    private User user;

    @OneToMany
    private List<Section> list;

    public void addSection(Section section)
    {
        list.add(section);
    }

    public void removeSection(Section section)
    {
        list.remove(section);
    }

    public Schedule() {
        list = new ArrayList<>();
    }

    public List<SectionTime> getAllTimes() {
        List<SectionTime> timesList = new ArrayList<>();
        for(Section s : list)
            for(SectionTime st : s.getSectionTimes())
                timesList.add(st);

        return timesList;
    }

    public List<Section> getList()
    {
        return list;
    }

    public void setList(List<Section> list)
    {
        this.list = list;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
