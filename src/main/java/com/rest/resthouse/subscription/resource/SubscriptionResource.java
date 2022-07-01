package com.rest.resthouse.subscription.resource;

import com.rest.resthouse.shared.domain.model.AuditModel;

public class SubscriptionResource extends AuditModel {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    private Long id;
    private String name;
    private String description;

}
