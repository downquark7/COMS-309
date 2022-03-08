package backend.schedules;

import backend.classes.ClassData;
import backend.classes.Section;
import backend.users.User;

import java.util.ArrayList;
import java.util.List;

public class ScheduleOutputHelper
{
    public String name;
    public User user;
    public List<ClassData> classes;

    public ScheduleOutputHelper(Schedule schedule)
    {
        this.user = schedule.getUser();
        this.name = schedule.getName();

        List<ClassData> list = new ArrayList<>();
        for (Section s : schedule.getList())
        {
            ClassData classData = s.getClassData();
            List<Section> sectionList = new ArrayList<>();
            sectionList.add(s);
            classData.setSections(sectionList);
            list.add(classData);
        }
        this.classes = list;
    }
}
