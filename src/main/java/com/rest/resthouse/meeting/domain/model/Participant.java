package com.rest.resthouse.meeting.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rest.resthouse.shared.domain.model.AuditModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "participants")
public class Participant extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private Long date;

    @NotNull
    private Long month;

    @NotNull
    private Long year;

    @NotNull
    private Long duration;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name ="meeting_id", nullable=false)
    @JsonIgnore
    private Meeting meeting;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getMonth() {
        return month;
    }

    public void setMonth(Long month) {
        this.month = month;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }


}
