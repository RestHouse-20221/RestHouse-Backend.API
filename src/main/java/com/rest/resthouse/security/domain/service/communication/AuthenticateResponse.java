package com.rest.resthouse.security.domain.service.communication;

import com.rest.resthouse.security.resource.AuthenticateResource;
import com.rest.resthouse.shared.domain.service.communication.BaseResponse;

public class AuthenticateResponse extends BaseResponse<AuthenticateResource> {
    public AuthenticateResponse(String message) {
        super(message);
    }

    public AuthenticateResponse(AuthenticateResource resource) {
        super(resource);
    }
}