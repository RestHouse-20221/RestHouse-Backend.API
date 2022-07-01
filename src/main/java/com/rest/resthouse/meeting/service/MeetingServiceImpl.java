package com.rest.resthouse.meeting.service;

import com.rest.resthouse.meeting.domain.model.Meeting;
import com.rest.resthouse.meeting.domain.repository.MeetingRepository;
import com.rest.resthouse.meeting.domain.service.MeetingService;
import com.rest.resthouse.shared.exception.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class MeetingServiceImpl implements MeetingService {
    private static final String ENTITY = "Meeting";
    @Autowired
    private MeetingRepository meetingRepository;

    public Page<Meeting> getAllMeetings(Pageable pageable) {

        return meetingRepository.findAll( pageable);
    }

    @Override
    public List<Meeting> getAllMeetings() {
        return meetingRepository.findAll();
    }

    @Override
    public Meeting getMeetingById(Long meetingId) {
        return meetingRepository.findById(meetingId)
                .orElseThrow(() -> new ResourceNotFoundException("Meeting", "Id", meetingId));
    }

    @Override
    public Meeting getMeetingByName(String name) {
        return meetingRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Meeting", "Name", name));
    }

    @Override
    public Meeting createMeeting(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    @Override
    public Meeting updateMeeting(Long meetingId, Meeting meetingRequest) {
        Meeting meeting = meetingRepository.findById(meetingId)
                .orElseThrow(() -> new ResourceNotFoundException("Meeting", "Id", meetingId));
        meeting.setName(meetingRequest.getName());
        meeting.setYear(meetingRequest.getYear());
        return meetingRepository.save(meeting);
    }

    @Override
    public ResponseEntity<?> deleteMeeting(Long meetingId) {
        Meeting meeting = meetingRepository.findById(meetingId)
                .orElseThrow(() -> new ResourceNotFoundException("Meeting", "Id", meetingId));
        meetingRepository.delete(meeting);
        return ResponseEntity.ok().build();
    }
}
