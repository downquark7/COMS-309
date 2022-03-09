package volley;

public class SectionTime {
    private int id;
    private int sectionSequenceNumber;
    private String instructionType;
    private String meetDays;
    private String instrName;
    private String buildingName;
    private String roomNum;
    private String meetDaysDisplay;
    private String meetTimeDisplay;
    private String stopTime;
    private String formattedStartTime;
    private String formattedStopTime;
    private Section section;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getSectionSequenceNumber()
    {
        return sectionSequenceNumber;
    }

    public String getInstructionType()
    {
        return instructionType;
    }

    public void setInstructionType(String instructionType)
    {
        this.instructionType = instructionType;
    }

    public String getMeetDays()
    {
        return meetDays;
    }

    public void setMeetDays(String meetDays)
    {
        this.meetDays = meetDays;
    }

    public String getInstrName()
    {
        return instrName;
    }

    public void setInstrName(String instrName)
    {
        this.instrName = instrName;
    }

    public String getBuildingName()
    {
        return buildingName;
    }

    public void setBuildingName(String buildingName)
    {
        this.buildingName = buildingName;
    }

    public String getRoomNum()
    {
        return roomNum;
    }

    public void setRoomNum(String roomNum)
    {
        this.roomNum = roomNum;
    }

    public String getMeetDaysDisplay()
    {
        return meetDaysDisplay;
    }

    public void setMeetDaysDisplay(String meetDaysDisplay)
    {
        this.meetDaysDisplay = meetDaysDisplay;
    }

    public String getMeetTimeDisplay()
    {
        return meetTimeDisplay;
    }

    public void setMeetTimeDisplay(String meetTimeDisplay)
    {
        this.meetTimeDisplay = meetTimeDisplay;
    }

    public String getStopTime()
    {
        return stopTime;
    }

    public void setStopTime(String stopTime)
    {
        this.stopTime = stopTime;
    }

    public String getFormattedStartTime()
    {
        return formattedStartTime;
    }

    public void setFormattedStartTime(String formattedStartTime)
    {
        this.formattedStartTime = formattedStartTime;
    }

    public String getFormattedStopTime()
    {
        return formattedStopTime;
    }

    public void setFormattedStopTime(String formattedStopTime)
    {
        this.formattedStopTime = formattedStopTime;
    }

    public Section getSection()
    {
        return section;
    }

    public void setSection(Section section)
    {
        this.section = section;
    }
}
