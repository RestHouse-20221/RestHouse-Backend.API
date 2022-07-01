package com.rest.resthouse.meeting.mapping;

import com.rest.resthouse.meeting.domain.model.Participant;
import com.rest.resthouse.meeting.resource.ParticipantResource;
import com.rest.resthouse.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ParticipantMapper {

    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public ParticipantResource toResource(Participant model) {
        return mapper.map(model, ParticipantResource.class);
    }

    public Page<ParticipantResource> modelListPage(List<Participant> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ParticipantResource.class), pageable, modelList.size());
    }


}
