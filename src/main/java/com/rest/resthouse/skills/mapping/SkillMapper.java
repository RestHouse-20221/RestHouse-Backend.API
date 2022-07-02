package com.rest.resthouse.skills.mapping;

import com.rest.resthouse.skills.domain.model.model.Skill;
import com.rest.resthouse.skills.resource.SkillResource;
import com.rest.resthouse.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class SkillMapper {

    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public SkillResource toResource(Skill model) {
        return mapper.map(model, SkillResource.class);
    }

    public Page<SkillResource> modelListPage(List<Skill> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, SkillResource.class), pageable, modelList.size());
    }
}
