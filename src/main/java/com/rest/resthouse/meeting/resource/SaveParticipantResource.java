package com.rest.resthouse.meeting.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SaveParticipantResource {
    @NotNull
    private Long date;
    @NotBlank
    @NotNull
    private Long  month;
    @NotBlank
    @NotNull
    private Long  year;
    @NotBlank
    @NotNull
    private Long  duration;


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


}