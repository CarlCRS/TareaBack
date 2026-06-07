package com.capacitacionfull.TareaBack.Service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.capacitacionfull.TareaBack.Config.GlobalExcepcion;
import com.capacitacionfull.TareaBack.DTO.AuthRespuesta;
import com.capacitacionfull.TareaBack.DTO.LoginDTO;
import com.capacitacionfull.TareaBack.DTO.RegistroDTO;
import com.capacitacionfull.TareaBack.Entity.Usuario;
import com.capacitacionfull.TareaBack.Repository.UsuarioRepo;
import com.capacitacionfull.TareaBack.Security.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepo usuarioRepo;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthRespuesta login(LoginDTO request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getCorreo(), request.getPassword())
        );
        Usuario user = usuarioRepo.findByCorreo(request.getCorreo())
            .orElseThrow(() -> new GlobalExcepcion("Usuario no encontrado"));
        return AuthRespuesta.builder().token(jwtUtil.getToken(user)).build();
    }

    public String register(RegistroDTO request) {
        if (usuarioRepo.existsByCorreo(request.getCorreo()))
            throw new GlobalExcepcion("El usuario ya existe");

        Usuario user = Usuario.builder()
                .correo(request.getCorreo())
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .edad(request.getEdad())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        usuarioRepo.save(user);
        return "Usuario registrado exitosamente";
    }
}
