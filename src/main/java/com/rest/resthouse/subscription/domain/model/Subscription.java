package com.rest.resthouse.subscription.domain.model;

import com.rest.resthouse.shared.domain.model.AuditModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="subscriptions")
public class Subscription extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;
    @NotNull
    private String description;

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


}
