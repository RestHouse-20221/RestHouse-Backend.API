package com.rest.resthouse.security.domain.service;

import com.rest.resthouse.security.domain.model.entity.Role;

import java.util.List;

public interface RoleService {

    void seed();

    List<Role> getAll();
}