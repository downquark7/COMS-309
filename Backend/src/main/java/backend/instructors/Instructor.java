package backend.instructors;

import backend.classes.ClassData;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/***
 * instructor database entity class
 */
@Entity
public class Instructor
{
    @Id
    @GeneratedValue
    private int id;

    private String instrName;

    @ManyToMany
    private List<ClassData> classes = new ArrayList<>();

    public Instructor(String instrName)
    {
        this.instrName = instrName;
    }

    public Instructor()
    {

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getInstrName()
    {
        return instrName;
    }

    public void setInstrName(String instrName)
    {
        this.instrName = instrName;
    }

    public List<ClassData> getClasses()
    {
        return classes;
    }

    public void setClasses(List<ClassData> classes)
    {
        this.classes = classes;
    }

    public void addClass(ClassData classData)
    {
        if (!classes.contains(classData))
            classes.add(classData);
    }

    public void removeClass(ClassData classData)
    {
        classes.remove(classData);
    }
}
