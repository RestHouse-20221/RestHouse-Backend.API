package com.rest.resthouse.subscription.controller;

import com.rest.resthouse.subscription.domain.service.SubscriptionService;
import com.rest.resthouse.subscription.mapping.SubscriptionMapper;
import com.rest.resthouse.subscription.resource.SubscriptionResource;
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
@RequestMapping("/api/subscription-plan")
public class SubscriptionsController {
    private final SubscriptionService subscriptionService;
    private final SubscriptionMapper mapper;

    public SubscriptionsController(SubscriptionService subscriptionService, SubscriptionMapper mapper) {
        this.subscriptionService = subscriptionService;
        this.mapper = mapper;
    }
    @Operation(summary="Get Subscriptions of a subscription plan", description = "Get All Subscriptions by Pages", tags={"Subscription"})

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<SubscriptionResource> getAllSubscriptions(@ParameterObject Pageable pageable){
        return mapper.modelListPage(subscriptionService.getAllSubscriptions(),pageable).getContent();
    }
    @Operation(summary="Get Subscription of a subscription plan", description = "Get Subscription with determinate value", tags={"Subscription"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Subscription created", content = @Content(mediaType = "application/json"))
    })


    @GetMapping("{subscriptionId}")
    @PreAuthorize("hasRole('USER')")
    public SubscriptionResource getSubscriptionById(@PathVariable Long subscriptionId) {
        return mapper.toResource(subscriptionService.getSubscriptionById(subscriptionId));
    }

    @Operation(summary="Delete Subscriptions", description = "Delete Subscription by Id", tags={"Subscription"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Subscription deleted", content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("{subscriptionId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> deleteSubscription(@PathVariable Long subscriptionId){
        return subscriptionService.deleteSubscription(subscriptionId);
    }
}
