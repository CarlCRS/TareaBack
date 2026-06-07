package com.capacitacionfull.TareaBack.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capacitacionfull.TareaBack.Entity.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByCorreo(String correo);
    boolean existsByCorreo(String correo);
}
