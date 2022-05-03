package backend.schedules;

import backend.classes.ClassData;
import backend.classes.Section;
import backend.users.User;

import java.util.ArrayList;
import java.util.List;

/***
 * Helper class for sending the schedule to the frontend. It filters out extra sections in the list of classes.
 */
public class ScheduleOutputHelper
{
    public int id;
    public String name;
    public User user;
    public List<ClassData> classes;

    public ScheduleOutputHelper(Schedule schedule)
    {
        this.user = schedule.getUser();
        this.name = schedule.getName();
        this.id = schedule.getId();

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

    public ScheduleOutputHelper() {

    }
}
