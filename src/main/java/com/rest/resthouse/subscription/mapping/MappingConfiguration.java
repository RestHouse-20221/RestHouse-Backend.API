package com.rest.resthouse.subscription.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("fitgroupSubscriptionMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public SubscriptionMapper subscriptionMapper() {
        return new SubscriptionMapper();
    }

}