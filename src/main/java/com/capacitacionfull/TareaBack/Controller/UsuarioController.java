package com.capacitacionfull.TareaBack.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capacitacionfull.TareaBack.Entity.Usuario;
import com.capacitacionfull.TareaBack.Service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping("/mayores-18")
    public ResponseEntity<List<Usuario>> mayoresDe18() {
        return ResponseEntity.ok(usuarioService.mayoresDe18());
    }

    @GetMapping("/nombres")
    public ResponseEntity<List<String>> obtenerNombres() {
        return ResponseEntity.ok(usuarioService.obtenerNombres());
    }

    @GetMapping("/nombres-ordenados")
    public ResponseEntity<List<String>> ordenarNombres() {
        return ResponseEntity.ok(usuarioService.ordenarNombres());
    }

    @GetMapping("/contar-mayores")
    public ResponseEntity<Long> contarMayoresDeEdad() {
        return ResponseEntity.ok(usuarioService.contarMayoresDeEdad());
    }
}
