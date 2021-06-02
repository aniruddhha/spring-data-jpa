package com.ani.orm.ormdetails.xml;

public class Employee {

    /*
    * Steps for connecting to DB using jdbc
    *  - put jdbc driver in class path
    *  - provide required properties -> url, username and password
    *  - test the connection inside your java app
    *  - creating statement or prepared statements
    *
    * -----------------------------------------------------------------------
    *
    * - Classes -> configuration, retrieval, connection pooling
    * - Security against attacks -> SQL Injection -> https://owasp.org/www-project-top-ten/
    * - Optimized SQLs
    * - Visualization
    * - Transaction mgmt -> ACID
    * - Session Mgmt
    * - Thread Mgmt
    * - Object to Relation/Entity Mapping - vice versa
    ** */
    private Long id;
    private String firstName;
    private String lastName;
    private int salary;

    public Employee() {
    }

    public Employee(Long id, String firstName, String lastName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
