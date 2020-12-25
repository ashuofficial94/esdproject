package com.project.bean;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Students")
public class Students implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer student_id;

    @Column(nullable = false, unique = true)
    private String roll_number;

    @Column(nullable = false)
    private String first_name;

    private String last_name;

    @Column(nullable = false, unique = true)
    private String email;

    private String photograph_path;

    @Column(nullable = false, columnDefinition = "float default 0.0")
    private Float cgpa;

    @Column(nullable = false)
    private Integer total_credits;

    private Integer graduation_year;

    @ManyToOne
    @JoinColumn(name="domain")
    private Domains domain;

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public void setStudentCoursesList(List<StudentCourses> studentCoursesList) {
        this.studentCoursesList = studentCoursesList;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student_id")
    private List<StudentCourses> studentCoursesList = new ArrayList<StudentCourses>();

    public Integer getStudent_id() { return student_id; }

    @JsonbTransient
    public List<StudentCourses> getStudentCoursesList() {
        return studentCoursesList;
    }

    public Students() {
    }

    public Students(String roll_number, String first_name, String email, Float cgpa, Integer total_credits) {
        this.roll_number = roll_number;
        this.first_name = first_name;
        this.email = email;
        this.cgpa = cgpa;
        this.total_credits = total_credits;
    }

    public Students(String roll_number, String first_name, String last_name, String email, String photograph_path, Float cgpa, Integer total_credits, Integer graduation_year) {
        this.roll_number = roll_number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.photograph_path = photograph_path;
        this.cgpa = cgpa;
        this.total_credits = total_credits;
        this.graduation_year = graduation_year;
    }

    public String getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotograph_path() {
        return photograph_path;
    }

    public void setPhotograph_path(String photograph_path) {
        this.photograph_path = photograph_path;
    }

    public Float getCgpa() {
        return cgpa;
    }

    public void setCgpa(Float cgpa) {
        this.cgpa = cgpa;
    }

    public Integer getTotal_credits() {
        return total_credits;
    }

    public void setTotal_credits(Integer total_credits) {
        this.total_credits = total_credits;
    }

    public Integer getGraduation_year() {
        return graduation_year;
    }

    public void setGraduation_year(Integer graduation_year) {
        this.graduation_year = graduation_year;
    }

    public Domains getDomain() {
        return domain;
    }

    public void setDomain(Domains domain) {
        this.domain = domain;
    }
}
