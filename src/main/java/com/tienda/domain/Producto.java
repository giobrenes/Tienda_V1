package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

//Especificar que es una capa de datos
@Data

//Voy a tener una entidad enlazada con esta clase de Java
@Entity

//Especifica a cual table(entidad)
@Table(name = "producto")

public class Producto implements Serializable {
    //autoincremento en Java MySQL

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")

    private Long idProducto;
    private String detalle;
    private int existencias;
    private double precio;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;
   
    //private long idCategoria;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    Categoria categoria;
    
    
    
    public Producto() {
    }

    public Producto(String producto, boolean activo) {
        this.descripcion = producto;
        this.activo = activo;
    }

}
