package com.rest.resthouse.meeting.resource;

import com.rest.resthouse.shared.domain.model.AuditModel;

public class MeetingResource extends AuditModel {
    private Long id;
    private String name;
    private Integer year;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}