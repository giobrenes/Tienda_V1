
package com.tienda.service.impl;

import com.tienda.dao.RolDao;
import com.tienda.dao.UsuarioDao;
import com.tienda.domain.Rol;
import com.tienda.domain.Usuario;
import com.tienda.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private RolDao rolDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios(){
    return usuarioDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuario(Usuario usuario){
    return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsername(String username){
    return usuarioDao.findByUsername(username);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsernameYPassword(String username, String password){
    return usuarioDao.findByUsernameAndPassword(username, password);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsernameoCorreo(String username, String correo){
    return usuarioDao.findByUsernameOrCorreo(username, correo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public boolean existeUsuarioPorUsernameOCorreo(String username, String correo){
    return usuarioDao.existsByUsernameOrCorreo(username, correo);
    }
    
    @Override
    @Transactional
    public void save(Usuario usuario, boolean crearRolUser){ //Donde Se guarda el usuaro nuevo
        usuario=usuarioDao.save(usuario);
        if (crearRolUser){//si se esta creando el usuario, se crea el rol por defecto "User"
            Rol rol = new Rol();
            rol.setNombre("ROLE_USER");
            rol.setIdUsuario(usuario.getIdUsuario());
            rolDao.save(rol);
        }
    }
    
    @Transactional
    public void detele(Usuario usuario){
     usuarioDao.delete(usuario);
    }

    @Override
    public void delete(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void save(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
