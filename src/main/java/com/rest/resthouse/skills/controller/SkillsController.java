package com.rest.resthouse.skills.controller;

import com.rest.resthouse.skills.domain.service.SkillService;
import com.rest.resthouse.skills.mapping.SkillMapper;
import com.rest.resthouse.skills.resource.SkillResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SecurityRequirement(name = "rest")
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/api/skill-traveller")
public class SkillsController {
    private final SkillService skillService;
    private final SkillMapper mapper;

    public SkillsController(SkillService skillService, SkillMapper mapper) {
        this.skillService = skillService;
        this.mapper = mapper;
    }
    @Operation(summary="Get Skills of a Traveller", description = "Get Skills Foods by Pages", tags={"Skill"})

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<SkillResource> getAllSkills(@ParameterObject Pageable pageable){
        return mapper.modelListPage(skillService.getAllSkills(),pageable).getContent();
    }
    @Operation(summary="Get Skill of a Traveller", description = "Get Skill with determinate value", tags={"Skill"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Skill created", content = @Content(mediaType = "application/json"))
    })


    @GetMapping("{skillId}")
    @PreAuthorize("hasRole('USER')")
    public SkillResource getSkillById(@PathVariable Long skillId) {
        return mapper.toResource(skillService.getSkillById(skillId));
    }

    @Operation(summary="Delete Skills", description = "Delete Skill by Id", tags={"Skill"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Skill deleted", content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("{skillId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> deleteSkill(@PathVariable Long skillId){
        return skillService.deleteSkill(skillId);
    }
}
