package com.capacitacionfull.TareaBack.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.capacitacionfull.TareaBack.Entity.Usuario;
import com.capacitacionfull.TareaBack.Repository.UsuarioRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    
    private final UsuarioRepo usuariorepo;

    public List<Usuario> mayoresDe18() {
        return usuariorepo.findAll()
            .stream()
            .filter(u -> u.getEdad() > 18)
            .collect(Collectors.toList());
    }

    public List<String> obtenerNombres() {
        return usuariorepo.findAll()
            .stream()
            .map(Usuario::getNombre)
            .collect(Collectors.toList());
    }

    public List<String> ordenarNombres() {
        return usuariorepo.findAll()
            .stream()
            .map(Usuario::getNombre)
            .sorted()
            .collect(Collectors.toList());
    }

    public long contarMayoresDeEdad() {
        return usuariorepo.findAll()
            .stream()
            .filter(u -> u.getEdad() >= 18)
            .count();
    }
}
