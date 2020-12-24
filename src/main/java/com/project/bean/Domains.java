package com.project.bean;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Domains",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"batch", "program"})})

public class Domains implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer domain_id;

    @Column(nullable = false)
    private String program;

    @Column(nullable = false)
    private int batch;

    @Column(nullable = false)
    private int capacity;

    private String qualification;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "domain")
    private List<Students> students;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "domain_id")
    private List<CourseDomain> courseDomainList = new ArrayList<CourseDomain>();

    public Domains() {
    }

    public Domains(String program, int batch, int capacity) {
        this.program = program;
        this.batch = batch;
        this.capacity = capacity;
    }

    public Domains(String program, int batch, int capacity, String qualification) {
        this.program = program;
        this.batch = batch;
        this.capacity = capacity;
        this.qualification = qualification;
    }

    public Integer getDomain_id() {
        return domain_id;
    }

    public void setDomain_id(Integer domain_id) {
        this.domain_id = domain_id;
    }

    @JsonbTransient
    public List<CourseDomain> getCourseDomainList() {
        return courseDomainList;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @JsonbTransient
    public List<Students> getStudents() {
        return students;
    }
}
