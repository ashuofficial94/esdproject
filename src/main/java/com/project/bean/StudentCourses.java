package com.project.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Student_Courses")
public class StudentCourses implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Students student_id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Courses course_id;

    @ManyToOne
    @JoinColumn(name = "grade_id")
    private Grades grade_id;

    public StudentCourses() {
    }

    public StudentCourses(Students student_id, Courses course_id, Grades grade_id) {
        this.student_id = student_id;
        this.course_id = course_id;
        this.grade_id = grade_id;
    }

    public Integer getId() {
        return id;
    }

    public Students getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Students student_id) {
        this.student_id = student_id;
    }

    public Courses getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Courses course_id) {
        this.course_id = course_id;
    }

    public Grades getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(Grades grade_id) {
        this.grade_id = grade_id;
    }
}
