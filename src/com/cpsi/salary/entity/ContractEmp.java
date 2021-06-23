package com.cpsi.salary.entity;

public class ContractEmp extends Employee{
    public ContractEmp(String name,  Float rate, Float hours,String role) {
        super(name, rate,hours, role);
    }

    @Override
    public Float getSalary() {
        return Float.valueOf(10000+(this.hours*this.rate));
    }
}
