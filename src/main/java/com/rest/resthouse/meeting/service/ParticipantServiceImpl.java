package com.rest.resthouse.meeting.service;

import com.rest.resthouse.meeting.domain.model.Participant;
import com.rest.resthouse.meeting.domain.repository.ParticipantRepository;
import com.rest.resthouse.meeting.domain.service.ParticipantService;
import com.rest.resthouse.shared.exception.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantServiceImpl implements ParticipantService {
    private static final String ENTITY = "Participant";

    @Autowired
    private ParticipantRepository participantRepository;



    @Override
    public List<Participant> getAllParticipantsByMeetingId(Long meetingId) {
        return participantRepository.findByMeetingId(meetingId);
    }

    @Override
    public Participant getParticipantsById(Long participantId) {
        return participantRepository.findById(participantId)
                .orElseThrow(() -> new ResourceNotFoundException("Participant not found with Id " + participantId));
    }


}