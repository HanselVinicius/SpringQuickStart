package com.vh.springquickstart.entrypoint;

import com.vh.springquickstart.core.usecase.AuthenticateUseCase;
import com.vh.springquickstart.core.usecase.RegisterUserUseCase;
import com.vh.springquickstart.entrypoint.dto.AuthDto;
import com.vh.springquickstart.entrypoint.dto.RegistrationDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    @Autowired
    private AuthenticateUseCase authenticateUseCase;

    @Autowired
    private RegisterUserUseCase registerUserUseCase;

    @PostMapping("/authenticate")
    @Operation(description = "Endpoint to execute authentication of an user")
    public ResponseEntity authenticate(@RequestBody @Valid AuthDto authDto){
        var token = authenticateUseCase.authenticate(authDto.username(),authDto.password());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    @Operation(description = "Endpoint to execute registration of an user")
    public ResponseEntity register(@RequestBody @Valid RegistrationDto authDto){
        registerUserUseCase.register(authDto.username(),authDto.password());
        return ResponseEntity.ok().build();
    }



}
