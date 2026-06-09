package com.capacitacionfull.TareaBack.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.capacitacionfull.TareaBack.DTO.AuthRespuesta;
import com.capacitacionfull.TareaBack.DTO.LoginDTO;
import com.capacitacionfull.TareaBack.DTO.RegistroDTO;
import com.capacitacionfull.TareaBack.Service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthRespuesta> login(@Valid @RequestBody LoginDTO request) {
        return ResponseEntity.ok(authService.login(request));

        // error de credenciales incorrectas
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegistroDTO request) {
        return ResponseEntity.ok(authService.register(request));
    }
}
