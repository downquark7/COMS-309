package backend.classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Section
{
    @Id
    private int id;
    private String sectionID;
    private String openseats;
    private String creditLow;
    private String creditHigh;
    private String deliveryTypeDisplay;

    @OneToMany
    private List<SectionTime> sectionTimes;

    @ManyToOne
    @JsonIgnore
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
