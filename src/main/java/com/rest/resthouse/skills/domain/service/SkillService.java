package com.rest.resthouse.skills.domain.service;

import com.rest.resthouse.skills.domain.model.model.Skill;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SkillService {
    List<Skill> getAllSkills();
    Skill getSkillById(Long skillId);
    ResponseEntity<?> deleteSkill(Long skillId);
}
