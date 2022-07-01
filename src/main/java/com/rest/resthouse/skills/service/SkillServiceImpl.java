package com.rest.resthouse.skills.service;

import com.rest.resthouse.skills.domain.model.model.Skill;
import com.rest.resthouse.skills.domain.repository.SkillRepository;
import com.rest.resthouse.skills.domain.service.SkillService;
import com.rest.resthouse.shared.exception.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {
    private static final String ENTITY = "Skill";
    @Autowired
    private SkillRepository skillRepository;
    
    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    @Override
    public Skill getSkillById(Long skillId) {
        return skillRepository.findById(skillId)
                .orElseThrow(()-> new ResourceNotFoundException("Skill","Id",skillId));
    }

    @Override
    public ResponseEntity<?> deleteSkill(Long skillId) {
        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new ResourceNotFoundException("Skill", "Id", skillId));
        skillRepository.delete(skill);
        return ResponseEntity.ok().build();
    }
}
