package com.cumulative.timer.cumulative.timer.model;

public class ResponseObject {

    String fiveMinutes;
    String tenMinutes;
    String thirtyMinutes;

    public String getFiveMinutes() {
        return fiveMinutes;
    }

    public void setFiveMinutes(String fiveMinutes) {
        this.fiveMinutes = fiveMinutes;
    }

    public String getTenMinutes() {
        return tenMinutes;
    }

    public void setTenMinutes(String tenMinutes) {
        this.tenMinutes = tenMinutes;
    }

    public String getThirtyMinutes() {
        return thirtyMinutes;
    }

    public void setThirtyMinutes(String thirtyMinutes) {
        this.thirtyMinutes = thirtyMinutes;
    }

    @Override
    public String toString() {
        return "ResponseObject{" +
                "fiveMinutes='" + fiveMinutes + '\'' +
                ", tenMinutes='" + tenMinutes + '\'' +
                ", thirtyMinutes='" + thirtyMinutes + '\'' +
                '}';
    }
}
