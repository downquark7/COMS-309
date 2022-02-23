package backend.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ClassData
{
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String instructor;
    private String department;
    private String number;

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

    public String getInstructor()
    {
        return instructor;
    }

    public void setInstructor(String instructor)
    {
        this.instructor = instructor;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }
}
