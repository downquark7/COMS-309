package volley;

import java.util.List;

public class Section {
    private int id;
    private String sectionID;
    private String openseats;
    private String creditLow;
    private String creditHigh;
    private String deliveryTypeDisplay;

    private List<SectionTime> sectionTimes;
    private ClassData classData;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getSectionID()
    {
        return sectionID;
    }

    public void setSectionID(String sectionID)
    {
        this.sectionID = sectionID;
    }

    public String getOpenseats()
    {
        return openseats;
    }

    public void setOpenseats(String openseats)
    {
        this.openseats = openseats;
    }

    public String getCreditLow()
    {
        return creditLow;
    }

    public void setCreditLow(String creditLow)
    {
        this.creditLow = creditLow;
    }

    public String getCreditHigh()
    {
        return creditHigh;
    }

    public void setCreditHigh(String creditHigh)
    {
        this.creditHigh = creditHigh;
    }

    public String getDeliveryTypeDisplay()
    {
        return deliveryTypeDisplay;
    }

    public void setDeliveryTypeDisplay(String deliveryTypeDisplay)
    {
        this.deliveryTypeDisplay = deliveryTypeDisplay;
    }

    public List<SectionTime> getSectionTimes()
    {
        return sectionTimes;
    }

    public void setSectionTimes(List<SectionTime> sectionTimes)
    {
        this.sectionTimes = sectionTimes;
    }

    public ClassData getClassData()
    {
        return classData;
    }

    public void setClassData(ClassData classData)
    {
        this.classData = classData;
    }
}
