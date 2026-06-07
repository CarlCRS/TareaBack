package com.capacitacionfull.TareaBack.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capacitacionfull.TareaBack.Config.GlobalExcepcion;
import com.capacitacionfull.TareaBack.DTO.ProductoDTO;
import com.capacitacionfull.TareaBack.Entity.Producto;
import com.capacitacionfull.TareaBack.Service.ProductoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoservice;


    @GetMapping
    public ResponseEntity<List<Producto>> getallProductos(){
        return ResponseEntity.ok(productoservice.getAllProductos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Integer id){
        Producto prod = productoservice.getProductoById(id)
            .orElseThrow(() -> new GlobalExcepcion("Producto no encontrado con id: " + id));
        return ResponseEntity.ok(prod);
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto (@Validated @RequestBody ProductoDTO dto) {
        Producto prod = new Producto();
        prod.setNombre(dto.getNombre());
        prod.setDescripcion(dto.getDescripcion());
        prod.setPrecio(dto.getPrecio());

        productoservice.guardarProducto(prod);
        return ResponseEntity.status(HttpStatus.OK).body(prod);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id, @Validated @RequestBody ProductoDTO dto) {
        Producto prodActualizado = productoservice.actualizarProducto(id,dto);
        return ResponseEntity.ok(prodActualizado);
    }

    @PatchMapping("/{id}")
     public ResponseEntity<Producto> actualizarProductoXid(@PathVariable Integer id, @Validated @RequestBody ProductoDTO dto) {
        Producto prodActualizado = productoservice.actualizarProducto(id,dto);
        return ResponseEntity.ok(prodActualizado);
    }

    @DeleteMapping("/{id}")
        public ResponseEntity<Producto> eliminarProducto(@PathVariable Integer id) {
            Producto prodEliminado = productoservice.eliminarProducto(id);
            return ResponseEntity.ok(prodEliminado);
        }

}
