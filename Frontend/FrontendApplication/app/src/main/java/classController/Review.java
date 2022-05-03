package classController;

public class Review
{
    private int id;

    private int classId;

    private String username;

    private ClassData classData;

    private double difficulty;

    private String text;

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

    public double getDifficulty()
    {
        return difficulty;
    }

    public void setDifficulty(double difficulty)
    {
        this.difficulty = difficulty;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public int getClassId()
    {
        return classId;
    }

    public void setClassId(int classId)
    {
        this.classId = classId;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }
}
