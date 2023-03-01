package com.example.demo.entity;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "tasklist")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "priorityid")
    private Integer priorityId;

    @Column
    private String description;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public Task() {};
    public Task(Integer id, Integer priorityId, String description, Date date) {
        this.id = id;
        this.priorityId = priorityId;
        this.description = description;
        this.date = date;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    public void setPriorityId(Integer priorityId) {
        this.priorityId = priorityId;
    }
    public Integer getPriorityId() {
        return priorityId;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }
}
