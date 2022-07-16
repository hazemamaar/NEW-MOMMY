package com.android.newmommy.model;

public class WeekModel {
    String recommendation;
    String changes;
    String development;

    public WeekModel(String recommendation, String changes, String development) {
        this.recommendation = recommendation;
        this.changes = changes;
        this.development = development;
    }

    public WeekModel() {

    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getChanges() {
        return changes;
    }

    public void setChanges(String changes) {
        this.changes = changes;
    }

    public String getDevelopment() {
        return development;
    }

    public void setDevelopment(String development) {
        this.development = development;
    }
}
