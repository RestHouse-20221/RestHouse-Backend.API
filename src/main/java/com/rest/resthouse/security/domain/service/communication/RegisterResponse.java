package com.rest.resthouse.security.domain.service.communication;

import com.rest.resthouse.security.resource.UserResource;
import com.rest.resthouse.shared.domain.service.communication.BaseResponse;

public class RegisterResponse extends BaseResponse<UserResource> {
    public RegisterResponse(String message) {
        super(message);
    }

    public RegisterResponse(UserResource resource) {
        super(resource);
    }
}