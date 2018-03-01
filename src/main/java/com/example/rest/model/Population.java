package com.example.rest.model;

/**
 * Created by Balaji on 1/3/18.
 */
public class Population {
    private String state_ut;
    private int worker_population_ratio_wpr_;

    public String getState_ut() {
        return state_ut;
    }

    public void setState_ut(String state_ut) {
        this.state_ut = state_ut;
    }

    public int getWorker_population_ratio_wpr_() {
        return worker_population_ratio_wpr_;
    }

    public void setWorker_population_ratio_wpr_(int worker_population_ratio_wpr_) {
        this.worker_population_ratio_wpr_ = worker_population_ratio_wpr_;
    }

    @Override
    public String toString() {
        return "Population{" +
                "state_ut='" + state_ut + '\'' +
                ", worker_population_ratio_wpr_=" + worker_population_ratio_wpr_ +
                '}';
    }
}
