package com.project.bean;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Course_Domain")
public class CourseDomain implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="domain_id")
    private Domains domain_id;

    @ManyToOne
    @JoinColumn(name="course_id")
    private Courses course_id;

    public Integer getId() {
        return id;
    }

    public CourseDomain() {
    }

    public Domains getDomain_id() {
        return domain_id;
    }

    public void setDomain_id(Domains domain_id) {
        this.domain_id = domain_id;
    }

    public Courses getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Courses course_id) {
        this.course_id = course_id;
    }

    public CourseDomain(Domains domain_id, Courses course_id) {
        this.domain_id = domain_id;
        this.course_id = course_id;
    }
}
