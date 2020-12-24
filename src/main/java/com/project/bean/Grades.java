package com.project.bean;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Grades")
public class Grades implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer grade_id;

    @Column(unique = true)
    private Character letter_grade;

    @Column(nullable = false)
    private Integer grade_points;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grade_id")
    private List<StudentCourses> studentCoursesList = new ArrayList<StudentCourses>();

    private String comments;

    @JsonbTransient
    public List<StudentCourses> getStudentCoursesList() {
        return studentCoursesList;
    }

    public Grades(Character letter_grade, Integer grade_points) {
        this.letter_grade = letter_grade;
        this.grade_points = grade_points;
    }

    public void setLetter_grade(Character letter_grade) {
        this.letter_grade = letter_grade;
    }

    public void setGrade_points(Integer grade_points) {
        this.grade_points = grade_points;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getGrade_id() {
        return grade_id;
    }

    public Character getLetter_grade() {
        return letter_grade;
    }

    public Integer getGrade_points() {
        return grade_points;
    }

    public String getComments() {
        return comments;
    }

    public Grades() {
    }
}
