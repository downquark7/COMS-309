package backend.classes;

import backend.instructors.Instructor;
import backend.reviews.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/***
 * class database entity class
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ClassData
{
    @Id
    private int id;

    private String semesterCode;
    private String semesterYear;
    private String deptCode;
    private String classNumber;
    private String departmentTitle;
    private String classTitle;

    @Column(columnDefinition = "TEXT")
    private String classComments;
    private String classPreReqs;

    @OneToMany
    private List<Section> sections;

    @Column(columnDefinition = "TEXT")
    private String description;

    private double difficulty;

    @JsonIgnore
    @ManyToMany
    private List<Instructor> instructorList = new ArrayList<>();

    @OneToMany
    private List<Review> reviews = new ArrayList<>();

    public ClassData()
    {
        sections = new ArrayList<>();
    }

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

    public String getSemesterYear()
    {
        return semesterYear;
    }

    public void setSemesterYear(String semesterYear)
    {
        this.semesterYear = semesterYear;
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

    public List<Section> getSections()
    {
        return sections;
    }

    public void setSections(List<Section> sections)
    {
        this.sections = sections;
    }

    public List<Instructor> getInstructorList()
    {
        return instructorList;
    }

    public void setInstructorList(List<Instructor> instructorList)
    {
        this.instructorList = instructorList;
    }

    public void addInstructor(Instructor instructor)
    {
        instructorList.add(instructor);
    }

    public void removeInstructor(Instructor instructor)
    {
        instructorList.remove(instructor);
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public double getDifficulty()
    {
        return difficulty;
    }

    public void setDifficulty(double difficulty)
    {
        this.difficulty = difficulty;
    }

    public List<Review> getReviews()
    {
        return reviews;
    }

    public void addReview(Review review)
    {
        reviews.add(review);
        updateDifficulty();
    }

    public void removeReview(Review review)
    {
        reviews.remove(review);
        updateDifficulty();
    }

    public void setReviews(List<Review> reviews)
    {
        this.reviews = reviews;
        updateDifficulty();
    }

    private void updateDifficulty() {
        double sum = 0;
        for (Review r : reviews)
        {
            sum += r.getDifficulty();
        }
        if (!reviews.isEmpty())
            setDifficulty(sum / reviews.size());
    }
}
