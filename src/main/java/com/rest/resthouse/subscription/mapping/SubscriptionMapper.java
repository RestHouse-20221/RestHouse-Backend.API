package com.rest.resthouse.subscription.mapping;

import com.rest.resthouse.subscription.domain.model.Subscription;
import com.rest.resthouse.subscription.resource.SubscriptionResource;
import com.rest.resthouse.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class SubscriptionMapper {

    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public SubscriptionResource toResource(Subscription model) {
        return mapper.map(model, SubscriptionResource.class);
    }

    public Page<SubscriptionResource> modelListPage(List<Subscription> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, SubscriptionResource.class), pageable, modelList.size());
    }
}
