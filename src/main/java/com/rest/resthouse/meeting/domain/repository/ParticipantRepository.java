package com.rest.resthouse.meeting.domain.repository;

import com.rest.resthouse.meeting.domain.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ParticipantRepository extends JpaRepository<Participant,Long> {
    List<Participant> findByMeetingId(Long meetingId);

}
