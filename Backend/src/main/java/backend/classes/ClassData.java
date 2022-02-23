package backend.classes;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClassData
{
    @Id
    private int id;

    private String semesterCode;
    private String semseterYear;
    private String deptCode;
    private String classNumber;
    private String departmentTitle;
    private String classTitle;
    private String classComments;
    private String classPreReqs;

    //TODO: add sections later

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getSemesterCode()
    {
        return semesterCode;
    }

    public void setSemesterCode(String semesterCode)
    {
        this.semesterCode = semesterCode;
    }

    public String getSemseterYear()
    {
        return semseterYear;
    }

    public void setSemseterYear(String semseterYear)
    {
        this.semseterYear = semseterYear;
    }

    public String getDeptCode()
    {
        return deptCode;
    }

    public void setDeptCode(String deptCode)
    {
        this.deptCode = deptCode;
    }

    public String getClassNumber()
    {
        return classNumber;
    }

    public void setClassNumber(String classNumber)
    {
        this.classNumber = classNumber;
    }

    public String getDepartmentTitle()
    {
        return departmentTitle;
    }

    public void setDepartmentTitle(String departmentTitle)
    {
        this.departmentTitle = departmentTitle;
    }

    public String getClassTitle()
    {
        return classTitle;
    }

    public void setClassTitle(String classTitle)
    {
        this.classTitle = classTitle;
    }

    public String getClassComments()
    {
        return classComments;
    }

    public void setClassComments(String classComments)
    {
        this.classComments = classComments;
    }

    public String getClassPreReqs()
    {
        return classPreReqs;
    }

    public void setClassPreReqs(String classPreReqs)
    {
        this.classPreReqs = classPreReqs;
    }
}
