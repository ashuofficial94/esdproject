package com.project.bean;


import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Courses")
public class Courses implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer course_id;

    @Column(nullable = false, unique = true)
    private String course_code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Integer term;

    @Column(nullable = false)
    private Integer credits;

    @Column(nullable = false)
    private int capacity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course_id")
    private List<CourseDomain> courseDomainList = new ArrayList<CourseDomain>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course_id")
    private List<StudentCourses> studentCoursesList = new ArrayList<StudentCourses>();

    private String description;

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    @JsonbTransient
    public List<StudentCourses> getStudentCoursesList() {
        return studentCoursesList;
    }

    @JsonbTransient
    public List<CourseDomain> getCourseDomainList() {
        return courseDomainList;
    }

    public Courses() {
    }

    public Courses(String course_code, String name, Integer year, Integer term, Integer credits, int capacity) {
        this.course_code = course_code;
        this.name = name;
        this.year = year;
        this.term = term;
        this.credits = credits;
        this.capacity = capacity;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
