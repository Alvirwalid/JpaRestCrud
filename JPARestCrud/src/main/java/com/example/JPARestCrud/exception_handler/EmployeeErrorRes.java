package com.example.JPARestCrud.exception_handler;

public class EmployeeErrorRes {
    private  int status;
    private  String message;
    private  String timeStemp;

    public EmployeeErrorRes() {

    }

    public EmployeeErrorRes(int status, String message, String timeStemp) {
        this.status = status;
        this.message = message;
        this.timeStemp = timeStemp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getTimeStemp() {
        return timeStemp;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimeStemp(String timeStemp) {
        this.timeStemp = timeStemp;
    }

    @Override
    public String toString() {
        return "EmployeeErrorRes{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", timeStemp='" + timeStemp + '\'' +
                '}';
    }
}
