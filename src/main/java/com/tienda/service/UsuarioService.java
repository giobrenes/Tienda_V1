package com.tienda.service;

import com.tienda.domain.Usuario;
import java.util.List;


public interface UsuarioService {
    // Se obtiene un listado de usuarios en un List
    public List<Usuario> getUsuarios();
    
    // Se obtiene un Usuario, ápartir del id de un usuario
    public Usuario getUsuario(Usuario usuario);
    
    //Se obtiene u nUsuario, a partir del username de un usuario
    public Usuario getUsuarioPorUsername (String username);
    
    // se obtiene un Usuario, a partir del username y el password de un usuario
    public Usuario getUsuarioPorUsernameYPassword(String username, String password);
    
    //se obtiene un Uuario a partir del username y el password de un usuario
    public Usuario getUsuarioPorUsernameoCorreo (String username, String correo);
    
    //Se valida si existe un Usuario considerando el username
    public boolean existeUsuarioPorUsernameOCorreo (String username, String correo);
    
    // se inserta un nuevo usuario si el id del usuario esta vacio
    //Se actualiza un usuario si el id del usuario no esta vacio
    public void save(Usuario usuario, boolean crearRoldUser);
    
    //se elimina el usuario que tiene el id pasado por parametro
    public void delete(Usuario usuario);

    
    
}
