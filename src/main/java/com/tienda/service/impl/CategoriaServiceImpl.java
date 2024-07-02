package com.tienda.service.impl;

import com.tienda.dao.Categoriadao;
import com.tienda.domain.Categoria;
import com.tienda.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    
    @Autowired
    private Categoriadao Categoriadao;

    @Override
    @Transactional(readOnly=true)
    public List<Categoria> getCategorias(boolean activos) {
        var lista=Categoriadao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly=true)
    public Categoria getCategoria(Categoria categoria){
     return Categoriadao.findById(categoria.getIdCategoria()).orElse(null);   
    }
    
    @Override
    @Transactional
    public void save(Categoria categoria){
     Categoriadao.save(categoria); // Guardar o modificar el ID
    }
    
    @Override
    @Transactional
    public void delete(Categoria categoria){
    Categoriadao.delete(categoria); // Eliminar o modificar el ID
    }
    
    

}