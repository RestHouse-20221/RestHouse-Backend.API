package com.rest.resthouse.meeting.domain.service;

import com.rest.resthouse.meeting.domain.model.Participant;

import java.util.List;
public interface ParticipantService {
    List<Participant> getAllParticipantsByMeetingId(Long meetingId);
    Participant getParticipantsById(Long participantId);
}
