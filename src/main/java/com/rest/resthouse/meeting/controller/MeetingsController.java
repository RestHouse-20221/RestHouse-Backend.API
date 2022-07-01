package com.rest.resthouse.meeting.controller;
import com.rest.resthouse.meeting.domain.service.MeetingService;
import com.rest.resthouse.meeting.mapping.MeetingMapper;
import com.rest.resthouse.meeting.resource.MeetingResource;
import com.rest.resthouse.meeting.resource.SaveMeetingResource;
import com.rest.resthouse.meeting.resource.UpdateMeetingResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@SecurityRequirement(name = "rest")
@RestController
@RequestMapping("/api/meetings")
public class MeetingsController {

    private final MeetingService meetingService;
    private final MeetingMapper mapper;

    public MeetingsController(MeetingService meetingService, MeetingMapper mapper) {
        this.meetingService = meetingService;
        this.mapper = mapper;
    }

    @Operation(summary="Get Meetings", description = "Get All Meetings by Pages", tags={"Participants"})

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public Page<MeetingResource> getAllMeetings(@ParameterObject Pageable pageable){
        return mapper.modelListPage(meetingService.getAllMeetings(),pageable);
    }
    @Operation(summary="Post Meetings", description = "Post Meeting with determinate value", tags={"Participants"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Meeting created", content = @Content(mediaType = "application/json"))
    })
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<MeetingResource> createMeeting(@Valid @RequestBody SaveMeetingResource resource){
        return new ResponseEntity<>(mapper.toResource(meetingService.createMeeting(mapper.toModel(resource))), HttpStatus.CREATED);
    }
    @Operation(summary="Modify Meetings", description = "Modify Meeting with determinate value", tags={"Participants"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Meeting modified", content = @Content(mediaType = "application/json"))
    })


    @GetMapping("{meetingId}")
    @PreAuthorize("hasRole('USER')")
    public MeetingResource getMeetingById(@PathVariable Long meetingId) {
        return mapper.toResource(meetingService.getMeetingById(meetingId));
    }
    @Operation(tags={"Participants"})
    @PutMapping("{meetingId}")
    @PreAuthorize("hasRole('USER')")
    public MeetingResource updateMeeting(@PathVariable Long meetingId, @Valid @RequestBody UpdateMeetingResource resource){
        return mapper.toResource(meetingService.updateMeeting(meetingId,mapper.toModel(resource)));
    }
    @Operation(summary="Delete Meetings", description = "Delete Meeting by Id", tags={"Meetings"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Meeting deleted", content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("{meetingId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> deleteMeeting(@PathVariable Long meetingId){
        return meetingService.deleteMeeting(meetingId);
    }

}