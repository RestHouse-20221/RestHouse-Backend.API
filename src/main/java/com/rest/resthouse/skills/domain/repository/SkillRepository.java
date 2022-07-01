package com.rest.resthouse.skills.domain.repository;

import com.rest.resthouse.skills.domain.model.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    Optional<Skill> findByName(String name);
}
