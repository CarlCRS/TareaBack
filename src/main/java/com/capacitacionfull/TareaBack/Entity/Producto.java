package com.capacitacionfull.TareaBack.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Producto {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre del producto no puede estar vacío")
    private String nombre;
    @NotBlank(message = "La descripcion del producto no puede estar vacío")
    private String descripcion;
    @NotNull(message = "El precio no puede ser null")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor a cero")
    private Double precio;
}
