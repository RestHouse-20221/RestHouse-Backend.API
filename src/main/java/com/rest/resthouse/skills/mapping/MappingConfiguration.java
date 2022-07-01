package com.rest.resthouse.skills.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("resthouseSkillMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public SkillMapper skillMapper() {
        return new SkillMapper();
    }

}