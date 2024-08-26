package com.tienda.service.impl;

import com.tienda.dao.Categoriadao;
import com.tienda.domain.Categoria;
import com.tienda.service.CategoriaService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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