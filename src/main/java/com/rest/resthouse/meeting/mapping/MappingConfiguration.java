package com.rest.resthouse.meeting.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("resthouseMeetingMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public MeetingMapper meetingMapper() {
        return new MeetingMapper();
    }
    @Bean
    public ParticipantMapper participantMapper() {
        return new ParticipantMapper();
    }

}
