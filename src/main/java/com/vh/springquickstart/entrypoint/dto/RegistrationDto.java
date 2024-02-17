package com.vh.springquickstart.entrypoint.dto;

import jakarta.validation.constraints.Email;

public record RegistrationDto(
        @Email
        String username,
        String password
) {
}
