package com.capacitacionfull.TareaBack.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        prod.setNombre(prod.getNombre());
        prod.setDescripcion(prod.getDescripcion());
        prod.setPrecio(prod.getPrecio());

        return productorepo.save(prod);
    }

    public void ActualizarProducto(Producto pq, Integer id){

    }


}
