package com.example.enicely;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class TestUnit
{
    private String name;

    public TestUnit(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return this.name;
    }
}
