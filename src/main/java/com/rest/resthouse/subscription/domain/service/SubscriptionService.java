package com.rest.resthouse.subscription.domain.service;

import com.rest.resthouse.subscription.domain.model.Subscription;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SubscriptionService {
    List<Subscription> getAllSubscriptions();
    Subscription getSubscriptionById(Long subscriptionId);
    ResponseEntity<?> deleteSubscription(Long subscriptionId);
}
