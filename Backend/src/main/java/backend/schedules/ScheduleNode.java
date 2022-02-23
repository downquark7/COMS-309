package backend.schedules;

import backend.classes.ClassData;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.sql.Time;

@Entity
public class ScheduleNode
{
    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    private ClassData classData;

    private Time time;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public ClassData getClassData()
    {
        return classData;
    }

    public void setClassData(ClassData classData)
    {
        this.classData = classData;
    }

    public Time getTime()
    {
        return time;
    }

    public void setTime(Time time)
    {
        this.time = time;
    }
}
