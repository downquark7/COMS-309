package main.demo1;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class TestUnit
{
    private String name;

    public TestUnit()
    {

    }

    public TestUnit(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return this.name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName()
    {
        this.name = name;
    }
}
