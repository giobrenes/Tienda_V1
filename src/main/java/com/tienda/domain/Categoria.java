
package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable; 
import lombok.Data;


//Especificar que es una capa de datos
@Data

//Voy a tener una entidad enlazada con esta clase de Java
@Entity

//Especifica a cual table(entidad)
@Table(name="categoria")

public class Categoria implements Serializable {
  //autoincremento en Java MySQL
  private static final long serialVersionUID=1L;
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id_categoria")
  
  private long idCategoria;
  private String descripcion;
  private String rutaImagen;
  private boolean activo;
  
  public Categoria() {  
  }       
     
     public Categoria(String categoria, boolean activo) {         
         this.descripcion = categoria;         
         this.activo = activo;     
     }
  
}
