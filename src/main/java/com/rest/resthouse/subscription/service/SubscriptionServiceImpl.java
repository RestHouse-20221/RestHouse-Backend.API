package com.rest.resthouse.subscription.service;

import com.rest.resthouse.subscription.domain.model.Subscription;
import com.rest.resthouse.subscription.domain.repository.SubscriptionRepository;
import com.rest.resthouse.subscription.domain.service.SubscriptionService;
import com.rest.resthouse.shared.exception.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private static final String ENTITY = "Subscription";
    @Autowired
    private SubscriptionRepository subscriptionRepository;
    
    @Override
    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    @Override
    public Subscription getSubscriptionById(Long subscriptionId) {
        return subscriptionRepository.findById(subscriptionId)
                .orElseThrow(()-> new ResourceNotFoundException("Subscription","Id",subscriptionId));
    }

    @Override
    public ResponseEntity<?> deleteSubscription(Long subscriptionId) {
        Subscription subscription = subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new ResourceNotFoundException("Subscription", "Id", subscriptionId));
        subscriptionRepository.delete(subscription);
        return ResponseEntity.ok().build();
    }
}
