package com.example.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by Balaji on 1/3/18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AreaWisePopulation {
    List<Population> records;

    public List<Population> getRecords() {
        return records;
    }

    public void setRecords(List<Population> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "AreaWisePopulation{" +
                "records=" + records +
                '}';
    }
}
