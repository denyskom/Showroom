package com.interlink.employee;

import com.interlink.salary.SalaryType;

public abstract class Employee {
    protected final int id;
    protected String fullName;
    protected SalaryType salaryType;
    protected String post;

    public Employee(int id, String fullName, SalaryType salaryType) {
        this.id = id;
        this.fullName = fullName;
        this.salaryType = salaryType;
    }

    public String getFullName() {
        return fullName;
    }

    public SalaryType getSalaryType() {
        return salaryType;
    }

    public int getId() {
        return id;
    }

    public String getPost() {
        return post;
    }

    protected void setPost(String post) {
        this.post = post;
    }
}
