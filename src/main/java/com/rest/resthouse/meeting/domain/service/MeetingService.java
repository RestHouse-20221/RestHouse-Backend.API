package com.rest.resthouse.meeting.domain.service;

import com.rest.resthouse.meeting.domain.model.Meeting;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MeetingService {
    Page<Meeting> getAllMeetings(Pageable pageable);
    List<Meeting> getAllMeetings();
    Meeting getMeetingById(Long meetingId);
    Meeting getMeetingByName(String name);
    Meeting createMeeting(Meeting meeting);
    Meeting updateMeeting(Long meetingId, Meeting meetingRequest);
    ResponseEntity<?> deleteMeeting(Long meetingId);

}
