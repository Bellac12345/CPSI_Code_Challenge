package com.cpsi.salary.entity;

public abstract class Employee {

    protected String name, role;
    protected Float rate,hours;

    Employee(String name,  Float rate, Float hours,String role){
        this.name=name;
        this.rate=rate;
        this.hours=hours;
        this.role=role;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Float getHours() {
        return hours;
    }

    public void setHours(Float hours) {
        this.hours = hours;
    }


    public abstract Float getSalary();
}
