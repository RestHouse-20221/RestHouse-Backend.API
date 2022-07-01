package com.rest.resthouse.meeting.controller;

import com.rest.resthouse.meeting.domain.service.ParticipantService;
import com.rest.resthouse.meeting.mapping.ParticipantMapper;
import com.rest.resthouse.meeting.resource.ParticipantResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@SecurityRequirement(name = "rest")
@RestController
@RequestMapping("/api/participants")
public class ParticipantsController {
    private final ParticipantService participantService;

    public ParticipantsController(ParticipantService participantService, ParticipantMapper mapper) {
        this.participantService = participantService;
        this.mapper = mapper;
    }

    private final ParticipantMapper mapper;
    @Operation(summary="Get Participants by determinate Meeting Id", description = "Get All Participants by Meeting Id", tags={"Participants"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Participants returned", content = @Content(mediaType = "application/json"))
    })
    @GetMapping("meetings/{meetingsId}")
    @PreAuthorize("hasRole('USER')")
    public Page<ParticipantResource> getAllParticipantsByMeetingId(@PathVariable Long meetingsId, Pageable pageable){
        return mapper.modelListPage(participantService.getAllParticipantsByMeetingId(meetingsId),pageable);
    }
    @Operation(summary="Get Participants by determinate Id and Meeting Id", description = "Get Participants by Meeting Id and Participants Id", tags={"Participants"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Participants returned", content = @Content(mediaType = "application/json"))
    })
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("{participantId}")
    @PreAuthorize("hasRole('USER')")
    public ParticipantResource getParticipantsById(@PathVariable Long participantId) {
        return mapper.toResource(participantService.getParticipantsById(participantId));
    }
}
