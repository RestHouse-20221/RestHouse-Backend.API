package com.rest.resthouse.meeting.mapping;

import com.rest.resthouse.meeting.domain.model.Meeting;
import com.rest.resthouse.meeting.resource.MeetingResource;
import com.rest.resthouse.meeting.resource.SaveMeetingResource;
import com.rest.resthouse.meeting.resource.UpdateMeetingResource;
import com.rest.resthouse.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class MeetingMapper {

    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public MeetingResource toResource(Meeting model) {
        return mapper.map(model, MeetingResource.class);
    }

    public Page<MeetingResource> modelListPage(List<Meeting> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, MeetingResource.class), pageable, modelList.size());
    }

    public Meeting toModel(SaveMeetingResource resource) {
        return mapper.map(resource, Meeting.class);
    }

    public Meeting toModel(UpdateMeetingResource resource) {
        return mapper.map(resource, Meeting.class);
    }

}
