package classController;

import java.util.List;

public class ClassData {
    private int id;

    private String semesterCode;
    private String semesterYear;
    private String deptCode;
    private String classNumber;
    private String departmentTitle;
    private String classTitle;
    private String classComments;
    private String classPreReqs;
    private String description;
    private Double difficulty;
    private List<Section> sections;
    private List<Instructor> instructorList;
    private List<Review> reviews;

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



    @Override
    public String toString()
    {
        return getClassTitle();
    }
}
