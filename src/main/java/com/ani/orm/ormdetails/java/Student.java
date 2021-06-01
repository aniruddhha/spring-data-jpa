package com.ani.orm.ormdetails.java;

import javax.persistence.*;

@Entity
@Table(name = "dt_std")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stdId;

    @Column(name = "student_name", unique = true)
    private String stdNm;

    @Column(name = "student_age")
    private Integer age;

    public Student() {
    }

    public Student(Long stdId, String stdNm, Integer age) {
        this.stdId = stdId;
        this.stdNm = stdNm;
        this.age = age;
    }

    public Long getStdId() {
        return stdId;
    }

    public void setStdId(Long stdId) {
        this.stdId = stdId;
    }

    public String getStdNm() {
        return stdNm;
    }

    public void setStdNm(String stdNm) {
        this.stdNm = stdNm;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stdId=" + stdId +
                ", stdNm='" + stdNm + '\'' +
                ", age=" + age +
                '}';
    }
}
