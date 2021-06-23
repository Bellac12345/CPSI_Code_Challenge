package com.cpsi.salary.entity;

public class FullTimeEmp extends Employee{
    public FullTimeEmp(String name,  Float rate, Float hours,String role) {
        super(name, rate, hours, role);
    }

    @Override
    public Float getSalary() {
        if(this.hours*this.rate>50000){
            return Float.valueOf(50000);
        }
        return this.hours*this.rate;
    }

}
