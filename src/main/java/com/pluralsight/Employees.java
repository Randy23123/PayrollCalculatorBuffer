package com.pluralsight;

public class Employees {
    private long employeeId;
    private String name;
    private double hoursWorked;
    private double payRate;
    public Employees(long employeeId, String name, double hoursWorked, double payRate){
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    //getters
    public long getEmployeeId() {
        return this.employeeId;
    }
    public String getName() {
        return this.name;
    }
    public double getHoursWorked() {
        return this.hoursWorked;
    }
    public double getPayRate() {
        return this.payRate;
    }

    //setters
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    //method
    public double grossPay(){
        double grossPay = 0.0;
        if (this.getHoursWorked() <= 40){
            grossPay = this.getHoursWorked() * this.getPayRate();
        }
        else{
            grossPay = this.getPayRate() * 40;
            grossPay += ((this.getHoursWorked() - 40) * (this.getPayRate() * 1.5));
        }
        return grossPay;
    }
}
