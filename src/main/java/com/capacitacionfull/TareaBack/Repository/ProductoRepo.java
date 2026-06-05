package com.capacitacionfull.TareaBack.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capacitacionfull.TareaBack.Entity.Producto;

public interface ProductoRepo extends JpaRepository<Producto, Integer> {

    
}
