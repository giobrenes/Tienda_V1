package com.tienda.service.impl;

import com.tienda.dao.Productodao;
import com.tienda.domain.Producto;
import com.tienda.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {
    
    @Autowired
    private Productodao Productodao;

    @Override
    @Transactional(readOnly=true)
    public List<Producto> getProductos(boolean activos) {
        
        var lista=Productodao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly=true)
    public Producto getProducto(Producto producto){
     return Productodao.findById(producto.getIdProducto()).orElse(null);   
    }
    
    @Override
    @Transactional
    public void save(Producto producto){
     Productodao.save(producto); // Guardar o modificar el ID
    }
    
    @Override
    @Transactional
    public void delete(Producto producto){
    Productodao.delete(producto); // Eliminar o modificar el ID
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup){
    return Productodao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Producto> metodoJPQL(@Param("precioInf")double precioInf, @Param("precioSup") double precioSup){
    return Productodao.metodoJPQL(precioInf, precioSup);
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<Producto> metodoNativo(@Param("precioInf")double precioInf, @Param("precioSup") double precioSup){
    return Productodao.metodoNativo(precioInf, precioSup);
    }
}