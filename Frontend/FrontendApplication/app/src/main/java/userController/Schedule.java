package userController;

import java.util.ArrayList;
import java.util.List;

import classController.Section;
import classController.SectionTime;

public class Schedule
{
    private int id;

    private String name;
    private User user;

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
