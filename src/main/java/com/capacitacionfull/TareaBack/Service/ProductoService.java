package com.capacitacionfull.TareaBack.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capacitacionfull.TareaBack.Config.GlobalExcepcion;
import com.capacitacionfull.TareaBack.DTO.ProductoDTO;
import com.capacitacionfull.TareaBack.Entity.Producto;
import com.capacitacionfull.TareaBack.Repository.ProductoRepo;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepo productorepo;

    public List<Producto> getAllProductos(){
        return productorepo.findAll();
    }

    public Optional<Producto> getProductoById(Integer id){
        return productorepo.findById(id);
    }

    public Producto guardarProducto(Producto prod){
        return productorepo.save(prod);
    }

    public Producto actualizarProducto(Integer id, ProductoDTO dto){
         Producto prod = productorepo.findById(id)
            .orElseThrow(() -> new GlobalExcepcion("Producto no encontrado con id: " + id));

        if (dto.getNombre() != null)
            prod.setNombre(dto.getNombre());
        if (dto.getDescripcion() != null)
            prod.setDescripcion(dto.getDescripcion());
        if (dto.getPrecio() != null)
            prod.setPrecio(dto.getPrecio());

        return productorepo.save(prod);
    }

    public Producto eliminarProducto(Integer id){
        Producto prod = productorepo.findById(id)
            .orElseThrow(() -> new GlobalExcepcion("Producto no encontrado con id: " + id));
        productorepo.delete(prod);
        return prod;
    }


}
