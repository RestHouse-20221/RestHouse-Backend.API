package com.rest.resthouse.meeting.domain.repository;

import com.rest.resthouse.meeting.domain.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    Optional<Meeting> findByName(String name);
}
