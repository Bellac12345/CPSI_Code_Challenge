package com.cpsi.salary.entity;

public class PartTimeEmp extends Employee {
    public PartTimeEmp(String name, Float rate, Float hours, String role) {
        super(name, rate, hours, role);
    }

    @Override
    public Float getSalary() {

        return this.hours*this.rate;
    }
}
