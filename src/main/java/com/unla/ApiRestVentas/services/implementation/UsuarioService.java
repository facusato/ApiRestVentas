package com.unla.ApiRestVentas.services.implementation;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.ApiRestVentas.entities.Usuario;
import com.unla.ApiRestVentas.repositories.IUsuarioRepository;



@Service("usuarioService")
public class UsuarioService {
	
    @Autowired
    @Qualifier("usuarioRepository")
    IUsuarioRepository usuarioRepository;

    public ArrayList<Usuario> obtenerUsuarios(){
        return (ArrayList<Usuario>) usuarioRepository.findAll();
    }

    public Usuario guardarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public boolean eliminarUsuario(Long id) {
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

	public Optional<Usuario> obtenerPorEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
}