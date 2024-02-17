package com.vh.springquickstart.entrypoint.dto;

import jakarta.validation.constraints.Email;

public record AuthDto(
        @Email
        String username,
        String password) {


}
